package controller;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Card;
import model.PlayerModel;
import model.RoomModel;
import view.ClientView;
import model.UnoModel;
import view.LoginView;
import view.RankView;

public class ThreadClient extends Thread {
    private final int numCardBegin = 7;

    private Socket socket;
    private ClientView view;
    private PlayerModel model;
    
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;
    
    private int numPlayer;
    private UnoModel unoModel;
    private RoomModel roomModel;
    private ArrayList<RoomModel> listRoom = new ArrayList();
    
    private boolean checkEndGame = false;
    private boolean isRunning = true;
    
    private HashMap<String, Integer> rank = new HashMap<>();

    public ThreadClient(Socket socket, ClientView view, PlayerModel model) {
        this.socket = socket;
        this.view = view;
        this.model = model;
    }

    @Override
    public void run() {
        try { 
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());

            showListRoom();
            updateLogin();
            while (isRunning) {
                Object receive = readFromServer();
                
                if (receive instanceof String) {
                    String receiveString = (String) receive;
                    
                    if (receiveString.equals("start game")) {
                        view.setLabelStatusGame("Đang vào ván ...");               
                        Thread.sleep(1000);
                        view.hideLabelStatusGame();
                        setupViewGame();
                    }
                    else if (receiveString.matches("end game:.+") && !checkEndGame) {
                        checkEndGame = true;
                        String playerWin = receiveString.substring(9);
                        
                        if (playerWin.equals(model.getName()))
                            view.showMessageDialog("Kết thúc ván chơi", "Bạn đã chiến thắng. Bạn có thêm 100 điểm.", 
                                    JOptionPane.INFORMATION_MESSAGE);
                        else
                            view.showMessageDialog("Kết thúc ván chơi", "Người chơi " + playerWin + " đã chiến thắng", 
                                    JOptionPane.INFORMATION_MESSAGE);
                        
                        view.hideMainPanel();
                        
                        checkEndGame = false;
                    }
                    else {
                        String[] tmp = ((String) receive).split(":", 2);
                        
                        String sender = tmp[0];
                        String content = tmp[1];

                        showChat(sender, content);
                    }
                }
                else if (receive instanceof UnoModel) {
                    unoModel = (UnoModel) receive;                    
                    roomModel.setUnoModel(unoModel);
                    
                    view.setDiscardPile(view.getImage(unoModel.getTopOfDeck()));
                    view.setCurrentColorLabel(unoModel.getTopOfDeck().getColor());
                    startTurn();
                    
                    // check xem thang chua
                    PlayerModel[] tmp = unoModel.getPlayers();
                    for (PlayerModel i: tmp)
                        if (i.getName().equals(model.getName()) && i.getHandSize() == 0)
                            sendToServer("end game:" + model.getName());
                }
                else if (receive instanceof ArrayList){
                    listRoom = (ArrayList<RoomModel>) receive;
                    view.setTableRoom(listRoom);
             
                    if (roomModel != null) {
                        for (RoomModel i: listRoom) {
                            if (i.getId() == roomModel.getId()) {
                                RoomModel tmp = roomModel;
                                
                                roomModel = i; 
                                unoModel = roomModel.getUnoModel();
                                
                                if (i.getUnoModel() != null && tmp.getUnoModel() != null)
                                    hidePlayerOutRoomAndNext(i, tmp);
                                
                                break;
                            }
                        }
                    }
                }
                else if (receive instanceof RoomModel) {
                    roomModel = (RoomModel) receive;
                    unoModel = ((RoomModel) receive).getUnoModel();
                }
                else if (receive instanceof HashMap) {
                    rank = (HashMap<String, Integer>) receive;
                    rank = sortByValue(rank);
                    showRank();
                }
             }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setupViewGame() {     
        try {
            setNamePlayer();
            view.hidePanelPlayer(numPlayer);
            setNumCardLeft();
            view.setDiscardPile(view.getImage(unoModel.getTopOfDeck()));
            view.setCurrentColorLabel(unoModel.getTopOfDeck().getColor());
            view.showMainPanel();
            startTurn();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void pressLabelStart() {
        ArrayList<PlayerModel> listReady = roomModel.getListReadyPlayer();
        
        boolean check = false;
        for (PlayerModel i: listReady)
            if (i.getName().equals(model.getName())) {
                check = true;
                
                break;
            }
        
        if (!check) {
            listReady.add(model);
            sendToServer(roomModel);

            sendToServer("ready:" + roomModel.getId());

            view.setLabelStatusGame("Xin chờ đủ người chơi");   
        }
    }
    
    public void startTurn() {
        setNumCardLeft();
        view.setCurrentPlayerLabel(unoModel.getCurrentPlayer().getName());

        if (!unoModel.getCurrentPlayer().getName().equals(model.getName())) 
            view.hideDrawAndEndTurn();
        else 
            view.showDrawButton();
        
        displayHandCards();
    }
    
    public void endTurn(){
        unoModel.nextPlayer();
        view.hideDrawAndEndTurn();
        sendToServer(unoModel);
    }
    
    public void hidePlayerOutRoomAndNext(RoomModel room1, RoomModel room2) {
        UnoModel uno1 = room1.getUnoModel();
        UnoModel uno2 = room2.getUnoModel();

        PlayerModel[] list1 = uno1.getPlayers();
        PlayerModel[] list2 = uno2.getPlayers();

        if (list1.length < list2.length) {
            ArrayList<String> name = new ArrayList<String>();

            for (PlayerModel i: list2) {
                boolean check = false;

                for (PlayerModel j: list1) 
                    if (i.getName().equals(j.getName())) {
                        check = true;

                        break;
                    }

                if (!check) {
                    name.add(i.getName());

                    break;
                }
            }   

            for (String i: name) {
                if (view.getPlayer2().isVisible() && view.getNamePlayer2().equals(i))
                    view.getPlayer2().setVisible(false);

                if (view.getPlayer3().isVisible() && view.getNamePlayer3().equals(i))
                    view.getPlayer3().setVisible(false);

                if (view.getPlayer4().isVisible() && view.getNamePlayer4().equals(i))
                    view.getPlayer4().setVisible(false);
            }
            
            startTurn();
        }
    }
    
    public boolean checkUNO(){ 
        return unoModel.UNO();
    }
    
    public void draw() {
        unoModel.draw(1);
        view.hideDrawButton();
        setNumCardLeft();
        displayHandCards();
    }
    
    public void setNumCardLeft() {
        HashMap<String, Integer> numCard = new HashMap<>();
        for (PlayerModel i: unoModel.getPlayers())
            numCard.put(i.getName(), i.getHandSize());

        numCard.remove(model.getName());
        
        if (view.getPlayer2().isVisible())
            view.setNumCardLeftPlayer2(numCard.get(view.getNamePlayer2()));
        
        if (view.getPlayer3().isVisible())
            view.setNumCardLeftPlayer3(numCard.get(view.getNamePlayer3()));
        
        if (view.getPlayer4().isVisible())
            view.setNumCardLeftPlayer4(numCard.get(view.getNamePlayer4()));
    }
        
    public void setNamePlayer() {
        sendToServer("request uno model:" + model.getName());
        
        unoModel = (UnoModel) readFromServer();
        
        PlayerModel[] tmp = unoModel.getPlayers();
        numPlayer = tmp.length;

        ArrayList<PlayerModel> tmpArray = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++)
            tmpArray.add(tmp[i]);
        
        if (numPlayer == 4) {
            ArrayList<PlayerModel> tmpArray1 = new ArrayList<>();
            tmpArray1.add(tmpArray.get(0));
            tmpArray1.add(tmpArray.get(2));
            tmpArray1.add(tmpArray.get(3));
            tmpArray1.add(tmpArray.get(1));
            
            ArrayList<PlayerModel> tmpArray2 = new ArrayList<>();
            tmpArray2.add(tmpArray.get(1));
            tmpArray2.add(tmpArray.get(3));
            tmpArray2.add(tmpArray.get(0));
            tmpArray2.add(tmpArray.get(2));

            ArrayList<PlayerModel> tmpArray3 = new ArrayList<>();
            tmpArray3.add(tmpArray.get(2));
            tmpArray3.add(tmpArray.get(0));
            tmpArray3.add(tmpArray.get(1));
            tmpArray3.add(tmpArray.get(3));

            ArrayList<PlayerModel> tmpArray4 = new ArrayList<>();
            tmpArray4.add(tmpArray.get(3));
            tmpArray4.add(tmpArray.get(1));
            tmpArray4.add(tmpArray.get(2));
            tmpArray4.add(tmpArray.get(0));
        
            if (model.getName().equals(tmpArray1.get(0).getName()))
                setNamePlayerWithArrayList(tmpArray1);
            else if (model.getName().equals(tmpArray2.get(0).getName()))
                setNamePlayerWithArrayList(tmpArray2);
            else if (model.getName().equals(tmpArray3.get(0).getName()))
                setNamePlayerWithArrayList(tmpArray3);
            else if (model.getName().equals(tmpArray4.get(0).getName()))
                setNamePlayerWithArrayList(tmpArray4);
        }
        
        if (numPlayer == 3) {
            ArrayList<PlayerModel> tmpArray2 = new ArrayList<>();
            tmpArray2.add(tmpArray.get(1));
            tmpArray2.add(tmpArray.get(2));
            tmpArray2.add(tmpArray.get(0));

            ArrayList<PlayerModel> tmpArray3 = new ArrayList<>();
            tmpArray3.add(tmpArray.get(2));
            tmpArray3.add(tmpArray.get(0));
            tmpArray3.add(tmpArray.get(1));
        
            if (model.getName().equals(tmpArray.get(0).getName()))
                setNamePlayerWithArrayList(tmpArray);
            else if (model.getName().equals(tmpArray2.get(0).getName()))
                setNamePlayerWithArrayList(tmpArray2);
            else if (model.getName().equals(tmpArray3.get(0).getName()))
                setNamePlayerWithArrayList(tmpArray3);
        }
        
        if (numPlayer == 2)
            setNamePlayerWithArrayList(tmpArray);
    }
    
    public void setNamePlayerWithArrayList (ArrayList<PlayerModel> list) {
        PlayerModel modelRemove = new PlayerModel();
        for (PlayerModel i: list)
            if (i.getName().equals(model.getName()))
                modelRemove = i;
        list.remove(modelRemove);
        
        view.setNamePlayer2(list.get(0).getName());

        if (numPlayer == 3)
            view.setNamePlayer3(list.get(1).getName());

        if (numPlayer == 4) {
            view.setNamePlayer3(list.get(1).getName());
            view.setNamePlayer4(list.get(2).getName());
        }
    }
    
    public void displayHandCards(){
        for (PlayerModel i: unoModel.getPlayers())
            if (i.getName().equals(model.getName())) {
                model = i;
                break;
            }
        
        int h = model.getHandSize();
        if (h > 25) // Handle if hand is bigger than the screen allows
            h = 25;
        
        for (int i = 0; i < h; i++){
            ImageIcon image = view.getImage(model.getHand().get(i));
            view.labelArray[i].setIcon(image);
            view.labelArray[i].setVisible(true);
            view.currentHand[i] = model.getHand().get(i);
        }
        
        for (int i = h; i < 26; i++)
            view.labelArray[i].setVisible(false);
    }
    
    public void jLabelClicked (Card card) {        
        if (unoModel.getCurrentPlayer().getName().equals(model.getName())) {
            if (invalidPlay())
                view.setDiscardPile(view.getImage(getTopOfDeck()));
            else
                view.setDiscardPile(view.getImage(card)); 
            
            discardCard(card);
        }
    }
    
    public void discardCard(Card card){
        unoModel.discard(card);
        
        if (wildCardPopUp()){
            unoModel.getTopOfDeck().setColor(view.chooseColor());
            unoModel.setWildCardPopUp();
        }
        
        if (!unoModel.getCantPlay()){
            startTurn();
            unoModel.setCantPlay();
        }
        
        sendToServer(unoModel);
    }
    
    public void showListRoom() {
        sendToServer("get list room");
    }
    
    public void addRoom(RoomModel room) {
        sendToServer(room);
        showListRoom();
    }
    
    public void joinRoom(int id) {
        for (RoomModel i: listRoom)
            if (i.getId() == id) {
                if (i.isIsProgress()) {
                    view.showMessageDialog("Thông báo", "Phòng đang chơi.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                break;
            }
        
        sendToServer("join room:" + id);
        
        view.showStart();
        view.hideRank();
        view.hideRoomPanel();

        for (RoomModel i: listRoom)
            if (i.getId() == id)
                roomModel = i;
        
        ArrayList<PlayerModel> tmp = roomModel.getListPlayer();       
        if (!tmp.contains(model))
            tmp.add(model);
        roomModel.setListPlayer(tmp);
       
        sendToServer(roomModel);
    }
    
    public void outRoom() {
        sendToServer("out room:" + roomModel.getId());
        
        ArrayList<PlayerModel> tmp = roomModel.getListPlayer(); 
        ArrayList<PlayerModel> tmpReady = roomModel.getListReadyPlayer();
        UnoModel tmpUno = unoModel;
        
        PlayerModel playerTmp = new PlayerModel();
        for (PlayerModel j: tmp)
            if (j.getName().equals(model.getName()))
                playerTmp = j;        
        tmp.remove(playerTmp);
        
        playerTmp = new PlayerModel();
        for (PlayerModel j: tmpReady)
            if (j.getName().equals(model.getName()))
                playerTmp = j;        
        tmpReady.remove(playerTmp);  
        
        roomModel.setListPlayer(tmp);
        roomModel.setListReadyPlayer(tmpReady);
        
        sendToServer(roomModel);
        
        if (roomModel.isIsProgress()) {
            if (tmp.size() == 1)
                sendToServer("end game:" + tmp.get(0).getName());
            else {
                PlayerModel[] original = tmpUno.getPlayers();
                PlayerModel[] after = new PlayerModel[original.length - 1];
                
                int i = 0;
                for (PlayerModel j: original)
                    if (!j.getName().equals(model.getName())) {
                        after[i] = j;
                        i++;
                    }

                tmpUno.setPlayer(after);
                tmpUno.setNumPlayers(after.length);
                tmpUno.setCurrentPlayer(after[tmpUno.getCurrentPlayerIndex()]);
                
                roomModel.setUnoModel(tmpUno);
                unoModel = tmpUno;

                sendToServer(roomModel);
            }
        } 
    }
    
    public void searchRoom(String s) {
        ArrayList<RoomModel> result = new ArrayList<>();

        for (RoomModel i: listRoom)
            if (String.valueOf(i.getId()).contains(s) || i.getName().contains(s))
                result.add(i);
        
        if (result.isEmpty())
            view.showMessageDialog("Thông báo", "Không tìm thấy phòng chơi thỏa mãn", 
                    JOptionPane.ERROR_MESSAGE);
        else
            view.setTableRoom(result);
    }
    
    public void logOut() {        
        try {
            sendToServer("log out:" + model.getName());
            isRunning = false;
            socket.close();
            
            LoginView loginView = new LoginView();
            loginView.setVisible(true); 
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void pressClose() {
        try {
            if (!view.isVisibleRoomPanel())
                outRoom();
            
            sendToServer("log out:" + model.getName());
            
            Thread.sleep(1000);
            isRunning = false;
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean invalidPlay(){
        return unoModel.getCantPlay();
    }
    
    public Card getTopOfDeck(){
        return unoModel.getTopOfDeck();
    }
    
    public boolean wildCardPopUp(){
        return unoModel.getWildCardPopUp();
    }
    
    public void chat(String content) {
        sendToServer(model.getName() + ":" + content);
    }
    
    public void showChat(String sender, String content) {
        try {
            if (sender.equals(model.getName())) {
                view.setLabelChatPlayer1(content);
                view.getLabelChatPlayer1().setVisible(true);
                view.getPanelShowChat().setVisible(true);
                Thread.sleep(2000);
                view.getLabelChatPlayer1().setVisible(false);
                view.getPanelShowChat().setVisible(false);
            }
            else if (sender.equals(view.getLabelNamePlayer2().getText())) {
                view.setLabelChatPlayer2(content);
                view.getLabelChatPlayer2().setVisible(true);
                Thread.sleep(2000);
                view.getLabelChatPlayer2().setVisible(false);
            }
            else if (sender.equals(view.getLabelNamePlayer3().getText())) {
                view.setLabelChatPlayer3(content);
                view.getLabelChatPlayer3().setVisible(true);
                Thread.sleep(2000);
                view.getLabelChatPlayer3().setVisible(false);
            }
            else if (sender.equals(view.getLabelNamePlayer4().getText())) {
                view.setLabelChatPlayer4(content);
                view.getLabelChatPlayer4().setVisible(true);
                Thread.sleep(2000);
                view.getLabelChatPlayer4().setVisible(false);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void getRank() {
        sendToServer("get rank: " + model.getName());
    }
    
    public void showRank() {
        RankView rankView = new RankView();
        rankView.setVisible(true);
        
        DefaultTableModel tbl = (DefaultTableModel) rankView.getTblRank().getModel();
        tbl.setNumRows(0);
        
        int rankNum = 1;
        
        for (String i: rank.keySet()) {
            tbl.addRow(new Object[]{rankNum, i, rank.get(i)});
            rankNum++;
        }
    }
    
     public HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
         // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
       
        return temp;
    }
     
     public void updateLogin() {
         sendToServer("update login:" + model.getName());
     }
    
    public void sendToServer (Object o) {
        try {
            oos.reset();
            oos.writeObject(o);
            oos.flush();
            
            System.out.println("Send: " + o);
        }
        catch (Exception e) {
            System.out.println(e + " in sendToServer ThreadClient");
        }
    }
    
    public Object readFromServer() {
        try {
            Object tmp = ois.readObject();
            System.out.println("Receive: " + tmp);
            
            return tmp;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}