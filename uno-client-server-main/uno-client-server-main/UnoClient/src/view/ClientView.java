package view;

import javax.swing.JOptionPane;
import controller.ThreadClient;
import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Card;
import model.CardNumber;
import model.CardReverse;
import model.CardSkip;
import model.CardWild;
import model.CardWildDraw;
import model.PlayerModel;
import model.RoomModel;

public class ClientView extends javax.swing.JFrame {
    private final String ip = "127.0.0.1";
    private final int port = 5000;
    private Socket socket = null;
    
    public ThreadClient threadClient;
    public JLabel[] labelArray = new JLabel[26];
    public Card[] currentHand = new Card[26];
    private String namePlayer;
    
    private Point[] listPoint;
    
    public ClientView() {  
    }
    
    public ClientView(String namePlayer) {
        initComponents();
        tblListRoom.requestFocusInWindow();
        setLocationRelativeTo(null);
        
        hideMainPanel();
        showRoomPanel();
        hideStart();
        panelTypingChat.setVisible(false);
        panelShowChat.setVisible(false);
        
        setLabelArray();
        
        listPoint = getPoint();
        
        this.namePlayer = namePlayer;
        try {
            socket = new Socket(ip, port);
            
            PlayerModel playerModel = new PlayerModel(this.namePlayer);
            threadClient = new ThreadClient(socket, this, playerModel);
            threadClient.start();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        labelWelcome = new javax.swing.JLabel();
        labelStatusGame = new javax.swing.JLabel();
        help = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        start = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        mainPanel = new javax.swing.JPanel();
        btnEndTurn = new javax.swing.JButton();
        btnDraw = new javax.swing.JButton();
        currentPlayerHand = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        discardPile = new javax.swing.JPanel();
        topOfDiscardPile = new javax.swing.JLabel();
        player3 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        labelNamePlayer3 = new javax.swing.JLabel();
        labelNumLeftCardPlayer3 = new javax.swing.JLabel();
        player2 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        labelNamePlayer2 = new javax.swing.JLabel();
        labelNumLeftCardPlayer2 = new javax.swing.JLabel();
        player4 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        labelNamePlayer4 = new javax.swing.JLabel();
        labelNumLeftCardPlayer4 = new javax.swing.JLabel();
        labelCurrentColor = new javax.swing.JLabel();
        currentColorIcon = new javax.swing.JLabel();
        labelChat = new javax.swing.JLabel();
        shootingUno = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        labelCurrentPlayer = new javax.swing.JLabel();
        panelChat = new javax.swing.JLayeredPane();
        panelTypingChat = new javax.swing.JPanel();
        typingChat = new javax.swing.JTextField();
        btnSendChat = new javax.swing.JButton();
        panelShowChat = new javax.swing.JPanel();
        labelChatPlayer1 = new javax.swing.JLabel();
        labelChatPlayer3 = new javax.swing.JLabel();
        labelChatPlayer4 = new javax.swing.JLabel();
        labelChatPlayer2 = new javax.swing.JLabel();
        roomPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblListRoom = new javax.swing.JTable();
        addRoom = new javax.swing.JLabel();
        searchRoom = new javax.swing.JLabel();
        txtSearchRoom = new javax.swing.JTextField();
        labelRank = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("UNO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelWelcome.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N

        labelStatusGame.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/helpIcon.png"))); // NOI18N
        help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpMouseClicked(evt);
            }
        });

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/start.png"))); // NOI18N
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMouseClicked(evt);
            }
        });

        btnEndTurn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEndTurn.setText("Kết thúc lượt");
        btnEndTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndTurnActionPerformed(evt);
            }
        });

        btnDraw.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDraw.setText("Bốc thêm");
        btnDraw.setToolTipText("");
        btnDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrawActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel25MouseExited(evt);
            }
        });

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel26MouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout currentPlayerHandLayout = new javax.swing.GroupLayout(currentPlayerHand);
        currentPlayerHand.setLayout(currentPlayerHandLayout);
        currentPlayerHandLayout.setHorizontalGroup(
            currentPlayerHandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentPlayerHandLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(currentPlayerHandLayout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        currentPlayerHandLayout.setVerticalGroup(
            currentPlayerHandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentPlayerHandLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(currentPlayerHandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(currentPlayerHandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)
                        .addComponent(jLabel4))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(currentPlayerHandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addContainerGap())
        );

        topOfDiscardPile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue0.JPG"))); // NOI18N

        javax.swing.GroupLayout discardPileLayout = new javax.swing.GroupLayout(discardPile);
        discardPile.setLayout(discardPileLayout);
        discardPileLayout.setHorizontalGroup(
            discardPileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discardPileLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(topOfDiscardPile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        discardPileLayout.setVerticalGroup(
            discardPileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discardPileLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(topOfDiscardPile)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatarDefault.png"))); // NOI18N
        jLabel27.setText("jLabel27");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/node.jpg"))); // NOI18N
        jLabel28.setText("jLabel28");

        labelNamePlayer3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNamePlayer3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        labelNumLeftCardPlayer3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout player3Layout = new javax.swing.GroupLayout(player3);
        player3.setLayout(player3Layout);
        player3Layout.setHorizontalGroup(
            player3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player3Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(player3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumLeftCardPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(labelNamePlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        player3Layout.setVerticalGroup(
            player3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player3Layout.createSequentialGroup()
                .addGroup(player3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addGroup(player3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(labelNumLeftCardPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(labelNamePlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatarDefault.png"))); // NOI18N

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/node.jpg"))); // NOI18N
        jLabel32.setText("jLabel28");

        labelNamePlayer2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNamePlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        labelNumLeftCardPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout player2Layout = new javax.swing.GroupLayout(player2);
        player2.setLayout(player2Layout);
        player2Layout.setHorizontalGroup(
            player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player2Layout.createSequentialGroup()
                .addGroup(player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNamePlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumLeftCardPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        player2Layout.setVerticalGroup(
            player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player2Layout.createSequentialGroup()
                .addGroup(player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addGroup(player2Layout.createSequentialGroup()
                        .addGroup(player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31)
                            .addComponent(labelNumLeftCardPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNamePlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatarDefault.png"))); // NOI18N
        jLabel37.setText("jLabel27");

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/node.jpg"))); // NOI18N
        jLabel38.setText("jLabel28");

        labelNamePlayer4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNamePlayer4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        labelNumLeftCardPlayer4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout player4Layout = new javax.swing.GroupLayout(player4);
        player4.setLayout(player4Layout);
        player4Layout.setHorizontalGroup(
            player4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(player4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNamePlayer4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(player4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumLeftCardPlayer4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        player4Layout.setVerticalGroup(
            player4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player4Layout.createSequentialGroup()
                .addGroup(player4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addGroup(player4Layout.createSequentialGroup()
                        .addGroup(player4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37)
                            .addComponent(labelNumLeftCardPlayer4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNamePlayer4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelCurrentColor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        labelChat.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        labelChat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chat.png"))); // NOI18N
        labelChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelChatMouseClicked(evt);
            }
        });

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/speaker.png"))); // NOI18N
        jLabel29.setText("UNO!");

        jLabel33.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jLabel33.setText("UNO!");

        javax.swing.GroupLayout shootingUnoLayout = new javax.swing.GroupLayout(shootingUno);
        shootingUno.setLayout(shootingUnoLayout);
        shootingUnoLayout.setHorizontalGroup(
            shootingUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shootingUnoLayout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        shootingUnoLayout.setVerticalGroup(
            shootingUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shootingUnoLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(shootingUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        labelCurrentPlayer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        typingChat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typingChat.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnSendChat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSendChat.setText("Gửi");
        btnSendChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendChatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTypingChatLayout = new javax.swing.GroupLayout(panelTypingChat);
        panelTypingChat.setLayout(panelTypingChatLayout);
        panelTypingChatLayout.setHorizontalGroup(
            panelTypingChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypingChatLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(typingChat, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSendChat)
                .addContainerGap())
        );
        panelTypingChatLayout.setVerticalGroup(
            panelTypingChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypingChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTypingChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typingChat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendChat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        labelChatPlayer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelChatPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelShowChatLayout = new javax.swing.GroupLayout(panelShowChat);
        panelShowChat.setLayout(panelShowChatLayout);
        panelShowChatLayout.setHorizontalGroup(
            panelShowChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShowChatLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(labelChatPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelShowChatLayout.setVerticalGroup(
            panelShowChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShowChatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelChatPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelChat.setLayer(panelTypingChat, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelChat.setLayer(panelShowChat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelChatLayout = new javax.swing.GroupLayout(panelChat);
        panelChat.setLayout(panelChatLayout);
        panelChatLayout.setHorizontalGroup(
            panelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTypingChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(panelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelChatLayout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(panelShowChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE)))
        );
        panelChatLayout.setVerticalGroup(
            panelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelTypingChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChatLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelShowChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        labelChatPlayer3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        labelChatPlayer4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        labelChatPlayer2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(btnDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnEndTurn)
                        .addGap(240, 240, 240))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(currentPlayerHand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(shootingUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(discardPile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(labelChatPlayer4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelChatPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelChat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(player4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCurrentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(labelCurrentColor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentColorIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(player3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelChatPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(panelChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCurrentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelChat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCurrentColor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(currentColorIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelChatPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(discardPile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelChatPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(player3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelChatPlayer4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(player4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(panelChat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentPlayerHand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shootingUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEndTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        tblListRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Tên phòng", "Số lượng", "Đang có"
            }
        ));
        tblListRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListRoomMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblListRoom);

        addRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        addRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRoomMouseClicked(evt);
            }
        });

        searchRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        searchRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchRoomMouseClicked(evt);
            }
        });

        txtSearchRoom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearchRoom.setForeground(new java.awt.Color(153, 153, 153));
        txtSearchRoom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearchRoom.setText("Nhập mã phòng hoặc tên phòng cần tìm ...");
        txtSearchRoom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchRoomFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchRoomFocusLost(evt);
            }
        });

        javax.swing.GroupLayout roomPanelLayout = new javax.swing.GroupLayout(roomPanel);
        roomPanel.setLayout(roomPanelLayout);
        roomPanelLayout.setHorizontalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomPanelLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(txtSearchRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addComponent(searchRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(addRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
        );
        roomPanelLayout.setVerticalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(searchRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchRoom))
                .addContainerGap(601, Short.MAX_VALUE))
            .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomPanelLayout.createSequentialGroup()
                    .addGap(0, 63, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLayeredPane1.setLayer(mainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(roomPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(2, 2, 2)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(roomPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(roomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        labelRank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rank.png"))); // NOI18N
        labelRank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRankMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(labelStatusGame, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(labelRank, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(start)
                .addGap(24, 24, 24)
                .addComponent(help)
                .addGap(30, 30, 30)
                .addComponent(exit)
                .addGap(42, 42, 42))
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelStatusGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(help, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(labelRank, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getNamePlayer() {
        return namePlayer;
    }
    
    public void setLabelWelcome() {
        labelWelcome.setText("Xin chào, " + namePlayer + ".");
    }
    
    public void setLabelStatusGame(String label) {
        labelStatusGame.setText("Trạng thái: " + label + ".");
        labelStatusGame.setVisible(true);
    }
    
    public void hideLabelStatusGame() {
        labelStatusGame.setVisible(false);
    }
    
    public void hideStart() {
        start.setVisible(false);
    }
    
    public void showStart() {
        start.setVisible(true);
    }
    
    public void hideRank() {
        labelRank.setVisible(false);
    }
    
    public void showRank(){
        labelRank.setVisible(true);
    }
    
    public void setLabelChatPlayer1(String s) {
        labelChatPlayer1.setText(s);
    }
    
    public void setLabelChatPlayer2(String s) {
        labelChatPlayer2.setText(s);
    }
    
    public void setLabelChatPlayer3(String s) {
        labelChatPlayer3.setText(s);
    }
    
    public void setLabelChatPlayer4(String s) {
        labelChatPlayer4.setText(s);
    }

    public JLabel getLabelChatPlayer1() {
        return labelChatPlayer1;
    }

    public JLabel getLabelChatPlayer2() {
        return labelChatPlayer2;
    }

    public JLabel getLabelChatPlayer3() {
        return labelChatPlayer3;
    }

    public JLabel getLabelChatPlayer4() {
        return labelChatPlayer4;
    }

    public JLabel getLabelNamePlayer2() {
        return labelNamePlayer2;
    }

    public JLabel getLabelNamePlayer3() {
        return labelNamePlayer3;
    }

    public JLabel getLabelNamePlayer4() {
        return labelNamePlayer4;
    }

    public JPanel getPlayer2() {
        return player2;
    }

    public JPanel getPlayer3() {
        return player3;
    }

    public JPanel getPlayer4() {
        return player4;
    }

    public JPanel getPanelShowChat() {
        return panelShowChat;
    }
    
    public boolean isVisibleMainPanel() {
        return mainPanel.isVisible();
    }
    
    public boolean isVisibleRoomPanel() {
        return roomPanel.isVisible();
    }
    
    public boolean isVisibleBtnDraw() {
        return btnDraw.isVisible();
    }
    
    public boolean isVisibleBtnEndTurn() {
        return btnEndTurn.isVisible();
    }
    
    public void showMessageDialog(String title, String content, int type) {
        JOptionPane.showMessageDialog(null, content, title, type);
    }
        
    private void startMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMouseClicked
        if (!mainPanel.isVisible() && !roomPanel.isVisible())
            threadClient.pressLabelStart();
    }//GEN-LAST:event_startMouseClicked

    private void helpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseClicked
        String content = "Chào mừng bạn đến với game UNO cổ điển \n"
                + "- Luật chơi là luật UNO cổ điển. \n"                
                + "- Để bắt đầu ván chơi, hãy nhấn Sẵn sàng và chờ đủ người chơi theo phòng quy định. \n"
                + "- Click chuột vào cây cần đánh. \n";
        
        showMessageDialog("Hướng dẫn chơi", content, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpMouseClicked

    private void btnEndTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndTurnActionPerformed
        threadClient.endTurn();
    }//GEN-LAST:event_btnEndTurnActionPerformed

    private void btnDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrawActionPerformed
        threadClient.draw();
    }//GEN-LAST:event_btnDrawActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        threadClient.jLabelClicked(currentHand[1]);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        popUpCard(2);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        originalCard(2);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        threadClient.jLabelClicked(currentHand[2]);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        popUpCard(3);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        originalCard(3);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        threadClient.jLabelClicked(currentHand[4]);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        popUpCard(5);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        originalCard(5);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        threadClient.jLabelClicked(currentHand[5]);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        popUpCard(6);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        originalCard(6);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        threadClient.jLabelClicked(currentHand[6]);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        popUpCard(7);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        originalCard(7);
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        threadClient.jLabelClicked(currentHand[7]);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        popUpCard(8);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        originalCard(8);
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        threadClient.jLabelClicked(currentHand[8]);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        popUpCard(9);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        originalCard(9);
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        threadClient.jLabelClicked(currentHand[9]);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        popUpCard(10);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        originalCard(10);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        threadClient.jLabelClicked(currentHand[10]);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        popUpCard(11);
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        originalCard(11);
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        threadClient.jLabelClicked(currentHand[11]);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        popUpCard(12);
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        originalCard(12);
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        threadClient.jLabelClicked(currentHand[12]);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        popUpCard(13);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        originalCard(13);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        threadClient.jLabelClicked(currentHand[3]);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        popUpCard(4);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        originalCard(4);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        threadClient.jLabelClicked(currentHand[13]);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        popUpCard(14);
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        originalCard(14);
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        threadClient.jLabelClicked(currentHand[14]);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        popUpCard(15);
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        originalCard(15);
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        threadClient.jLabelClicked(currentHand[15]);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        popUpCard(16);
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        originalCard(16);
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        threadClient.jLabelClicked(currentHand[16]);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        popUpCard(17);
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        originalCard(17);
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        threadClient.jLabelClicked(currentHand[17]);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        popUpCard(18);
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        originalCard(18);
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        threadClient.jLabelClicked(currentHand[18]);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        popUpCard(19);
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        originalCard(19);
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        threadClient.jLabelClicked(currentHand[19]);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        popUpCard(20);
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        originalCard(20);
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        threadClient.jLabelClicked(currentHand[20]);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        popUpCard(21);
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        originalCard(21);
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        threadClient.jLabelClicked(currentHand[21]);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
        popUpCard(22);
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
        originalCard(22);
    }//GEN-LAST:event_jLabel22MouseExited

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        threadClient.jLabelClicked(currentHand[22]);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        popUpCard(23);
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        originalCard(23);
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        threadClient.jLabelClicked(currentHand[23]);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        popUpCard(24);
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        originalCard(24);
    }//GEN-LAST:event_jLabel24MouseExited

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        threadClient.jLabelClicked(currentHand[24]);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered
        popUpCard(25);
    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseExited
        originalCard(25);
    }//GEN-LAST:event_jLabel25MouseExited

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        threadClient.jLabelClicked(currentHand[25]);
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered
        popUpCard(26);
    }//GEN-LAST:event_jLabel26MouseEntered

    private void jLabel26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseExited
        originalCard(26);
    }//GEN-LAST:event_jLabel26MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        threadClient.jLabelClicked(currentHand[0]);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        popUpCard(1);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        originalCard(1);
    }//GEN-LAST:event_jLabel1MouseExited

    private void labelChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelChatMouseClicked
        panelTypingChat.setVisible(true);
        typingChat.requestFocusInWindow();
    }//GEN-LAST:event_labelChatMouseClicked

    private void btnSendChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendChatActionPerformed
        String contentChat = typingChat.getText();

        if (!contentChat.equals("")) {
            threadClient.chat(contentChat);
            typingChat.setText("");
        }

        panelTypingChat.setVisible(false);
    }//GEN-LAST:event_btnSendChatActionPerformed

    private void tblListRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListRoomMouseClicked
        int selectedRow = tblListRoom.getSelectedRow();
        DefaultTableModel tblModel = (DefaultTableModel) tblListRoom.getModel();
        
        int numRequest = (int)tblModel.getValueAt(selectedRow, 2);
        int numNow = (int)tblModel.getValueAt(selectedRow, 3);
        
        if (numNow < numRequest)
            threadClient.joinRoom((int)tblModel.getValueAt(selectedRow, 0));
        else 
            showMessageDialog("Thông báo", "Phòng đã đủ người", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_tblListRoomMouseClicked

    private void addRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRoomMouseClicked
        AddRoomView addRoomView = new AddRoomView(this, true);
        addRoomView.setVisible(true);
        
        while (addRoomView.isVisible()) {    
        }
        
        RoomModel tmp = addRoomView.getRoom();
        if (tmp.getId() == 0)
            return;
        
        DefaultTableModel tblModel = (DefaultTableModel) tblListRoom.getModel();
        ArrayList<Integer> listId = new ArrayList<>();
        int numRows = tblModel.getRowCount();
        for (int i = 0; i < numRows; i++)
            listId.add((int)tblModel.getValueAt(i, 0));
        
        if (tmp != null) {
            if (!listId.contains(tmp.getId())) {
                threadClient.addRoom(tmp);

                try{
                    Thread.sleep(1000);
                }
                catch (Exception e) {
                    System.out.println(e);
                }

                threadClient.joinRoom(tmp.getId());
            }
            else 
                showMessageDialog("Thông báo", "Mã phòng này đã tồn tại. Vui lòng tạo phòng khác.",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addRoomMouseClicked

    private void searchRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchRoomMouseClicked
        String search = txtSearchRoom.getText();  
        if (search.equals("Nhập mã phòng hoặc tên phòng cần tìm ..."))
            search = "";
        
        threadClient.searchRoom(search);
    }//GEN-LAST:event_searchRoomMouseClicked

    private void txtSearchRoomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchRoomFocusGained
        if (txtSearchRoom.getText().equals("Nhập mã phòng hoặc tên phòng cần tìm ...")) {
            txtSearchRoom.setText("");
            txtSearchRoom.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtSearchRoomFocusGained

    private void txtSearchRoomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchRoomFocusLost
        if (txtSearchRoom.getText().equals("")) {
            txtSearchRoom.setText("Nhập mã phòng hoặc tên phòng cần tìm ...");
            txtSearchRoom.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtSearchRoomFocusLost

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        if (!mainPanel.isVisible() && roomPanel.isVisible()) {
            int choice = verifyLogOut();
            
            if (choice == 0) {
                threadClient.logOut();
                dispose();
            }
        }
        else {
            int choice = verifyOutRoom();
            
            if (choice == 0) {
                showRoomPanel();
                hideMainPanel();
                hideLabelStatusGame();
                hideStart();
                showRank();

                threadClient.outRoom();
            }
        }
    }//GEN-LAST:event_exitMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        String[] tmp = {"Đồng ý", "Hủy"};
        int options = JOptionPane.showOptionDialog(this,
                            "Bạn chắc chắn muốn thoát?", "Thông báo",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, tmp, tmp[1]);
        
        if (options == 0) {
            threadClient.pressClose();
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void labelRankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRankMouseClicked
        threadClient.getRank(); 
    }//GEN-LAST:event_labelRankMouseClicked
    
    public int verifyOutRoom() {
        String[] tmp = {"Đồng ý", "Hủy"};
        int options = JOptionPane.showOptionDialog(this,
                            "Bạn chắc chắn muốn ra khỏi phòng?", "Thông báo",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, tmp, tmp[1]);
        
        return options;
    }
    
    public int verifyLogOut() {
        String[] tmp = {"Đồng ý", "Hủy"};
        int options = JOptionPane.showOptionDialog(this,
                            "Bạn chắc chắn muốn đăng xuất?", "Thông báo",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, tmp, tmp[1]);
        
        return options;
    }
    
    public void showListRoom() {
        threadClient.showListRoom();
    }
    
    public void setTableRoom(ArrayList<RoomModel> listRoom) {
        DefaultTableModel tblModel = (DefaultTableModel) tblListRoom.getModel();
        tblModel.setNumRows(0);
        
        if (listRoom != null)
            for (RoomModel i: listRoom)
                tblModel.addRow(new Object[]{i.getId(), i.getName(), 
                                    i.getNumRequest(), i.getListPlayer().size()});
    }
    
    public Point[] getPoint() {
        Point[] listPoint = new Point[26];
        for (int i = 0; i < 26; i++)
            listPoint[i] = labelArray[i].getLocation();
        
        return listPoint;
    }
    
    public void popUpCard (int index) {
        int x = listPoint[index-1].x;
        int y = listPoint[index-1].y;
        
        labelArray[index-1].setLocation(x, y-15);
    }
    
    public void originalCard (int index) {
        labelArray[index-1].setLocation(listPoint[index-1]);
    }
    
    public void setNumCardLeftPlayer2(int handSize){
        labelNumLeftCardPlayer2.setText(String.valueOf(handSize));
    }
    
    public void setNumCardLeftPlayer3 (int handSize){
        labelNumLeftCardPlayer3.setText(String.valueOf(handSize));
    }
    
    public void setNumCardLeftPlayer4 (int handSize){
        labelNumLeftCardPlayer4.setText(String.valueOf(handSize));
    }
    
    public String getNamePlayer2() {
        return labelNamePlayer2.getText();
    }
    
    public String getNamePlayer3() {
        return labelNamePlayer3.getText();
    }
    
    public String getNamePlayer4() {
        return labelNamePlayer4.getText();
    }
    
    public void setNamePlayer2(String name) {
        labelNamePlayer2.setText(name);
    }
    
    public void setNamePlayer3(String name) {
        labelNamePlayer3.setText(name);
    }
    
    public void setNamePlayer4(String name) {
        labelNamePlayer4.setText(name);
    }
    
    public void hideMainPanel(){
        this.mainPanel.setVisible(false);
    }
    
    public void showMainPanel(){
        this.mainPanel.setVisible(true);
    }
    
    public void hideRoomPanel(){
        this.roomPanel.setVisible(false);
    }
    
    public void showRoomPanel(){
        this.roomPanel.setVisible(true);
    }
    
    public void hidePanelPlayer(int numPlayer) {
        if (numPlayer == 2) {
            player3.setVisible(false);
            player4.setVisible(false);
        }
   
        if (numPlayer == 3) 
            player4.setVisible(false);
    }
    
    public void hideDrawButton(){
        this.btnDraw.setVisible(false);
        this.btnEndTurn.setVisible(true);
    }
    
    public void showDrawButton(){
        this.btnDraw.setVisible(true);
        this.btnEndTurn.setVisible(false);
    }
    
    public void hideDrawAndEndTurn() {
        this.btnDraw.setVisible(false);
        this.btnEndTurn.setVisible(false);
    }
    
    public void setCurrentPlayerLabel(String currentPlayerName){
        labelCurrentPlayer.setText("Lượt chơi của: " + currentPlayerName);
    }
    
    public void setCurrentColorLabel(String currentColor){
        labelCurrentColor.setText("Màu hiện tại:");
        
        String location = "";
        if (currentColor.equals("blue"))
            location = "colorBlue.png";
        else if (currentColor.equals("red"))
            location = "colorRed.png";
        else if (currentColor.equals("green"))
            location = "colorGreen.png";
        else if (currentColor.equals("yellow"))
            location = "colorYellow.png";
        
        if (!location.equals("")) {
            ImageIcon image = new ImageIcon(getClass().getResource("/images/" + location));
            currentColorIcon.setIcon(image);
        }
    }
    
    public void displayHandCards(){
        threadClient.displayHandCards();
    }
    
    public void clearDiscardPile(){
        topOfDiscardPile.setVisible(false);
    }
    
    public void setDiscardPile(ImageIcon Image){
        topOfDiscardPile.setIcon(Image);
    }
    
    public ImageIcon getImage(Card card){   
        ImageIcon image;
        String location = "";
        
        if (card instanceof CardNumber){
            if ("blue".equals(card.getColor())){
                switch (((CardNumber) card).getNumber()) {
                    case 0:
                        location = "Blue0.JPG";
                        break;
                    case 1:
                        location = "Blue1.JPG";
                        break;
                    case 2:
                        location = "Blue2.JPG";
                        break;
                    case 3:
                        location = "Blue3.JPG";
                        break;
                    case 4:
                        location = "Blue4.JPG";
                        break;
                    case 5:
                        location = "Blue5.JPG";
                        break;
                    case 6:
                        location = "Blue6.JPG";
                        break;
                    case 7:
                        location = "Blue7.JPG";
                        break;
                    case 8:
                        location = "Blue8.JPG";
                        break;
                    default:
                        location = "Blue9.JPG";
                        break;
                }
            } 
            else if ("green".equals(card.getColor())){
                switch (((CardNumber) card).getNumber()) {
                    case 0:
                        location = "Green0.JPG";
                        break;
                    case 1:
                        location = "Green1.JPG";
                        break;
                    case 2:
                        location = "Green2.JPG";
                        break;
                    case 3:
                        location = "Green3.JPG";
                        break;
                    case 4:
                        location = "Green4.JPG";
                        break;
                    case 5:
                        location = "Green5.JPG";
                        break;
                    case 6:
                        location = "Green6.JPG";
                        break;
                    case 7:
                        location = "Green7.JPG";
                        break;
                    case 8:
                        location = "Green8.JPG";
                        break;
                    default:
                        location = "Green9.JPG";
                        break;
                }
            } else if ("red".equals(card.getColor())){
                switch (((CardNumber) card).getNumber()) {
                    case 0:
                        location = "Red0.png";
                        break;
                    case 1:
                        location = "Red1.JPG";
                        break;
                    case 2:
                        location = "Red2.JPG";
                        break;
                    case 3:
                        location = "Red3.JPG";
                        break;
                    case 4:
                        location = "Red4.JPG";
                        break;
                    case 5:
                        location = "Red5.JPG";
                        break;
                    case 6:
                        location = "Red6.JPG";
                        break;
                    case 7:
                        location = "Red7.JPG";
                        break;
                    case 8:
                        location = "Red8.JPG";
                        break;
                    default:
                        location = "Red9.JPG";
                        break;
                }
            } else if ("yellow".equals(card.getColor())){
                switch (((CardNumber) card).getNumber()) {
                    case 0:
                        location = "Yellow0.JPG";
                        break;
                    case 1:
                        location = "Yellow1.JPG";
                        break;
                    case 2:
                        location = "Yellow2.JPG";
                        break;
                    case 3:
                        location = "Yellow3.JPG";
                        break;
                    case 4:
                        location = "Yellow4.JPG";
                        break;
                    case 5:
                        location = "Yellow5.JPG";
                        break;
                    case 6:
                        location = "Yellow6.JPG";
                        break;
                    case 7:
                        location = "Yellow7.JPG";
                        break;
                    case 8:
                        location = "Yellow8.JPG";
                        break;
                    default:
                        location = "Yellow9.JPG";
                        break;
                }
            }
        }
        else if (card instanceof CardWild){
            location = "Wild.JPG";
        } 
        else if (card instanceof CardWildDraw){
            location = "WildDraw4.JPG";
        } 
        else if (card instanceof CardSkip){
            if("blue".equals(card.getColor())){
                location = "BlueSkip.JPG";
            } else if ("green".equals(card.getColor())){
                location = "GreenSkip.JPG";
            } else if ("red".equals(card.getColor())){
                location = "RedSkip.JPG";
            } else {
                location = "YellowSkip.JPG";
            }
        } 
        else if (card instanceof CardReverse){
            if("blue".equals(card.getColor())){
                location = "BlueReverse.JPG";
            } else if ("green".equals(card.getColor())){
                location = "GreenReverse.JPG";
            } else if ("red".equals(card.getColor())){
                location = "RedReverse.JPG";
            } else {
                location = "YellowReverse.JPG";
            }
        } 
        else {
            if("blue".equals(card.getColor())){
                location = "BlueDraw2.JPG";
            } else if ("green".equals(card.getColor())){
                location = "GreenDraw2.JPG";
            } else if ("red".equals(card.getColor())){
                location = "RedDraw2.JPG";
            } else {
                location = "YellowDraw2.JPG";
            }
        }
        
        image = new ImageIcon(getClass().getResource("/images/" + location));
        return image;
    }
  
    public String chooseColor(){
        String color = "";
        
        String[] colors = {"Đỏ", "Vàng", "Xanh dương", "Xanh lá"};
        int colorOptions = JOptionPane.showOptionDialog(this,
                            "Hãy chọn 1 màu", "Thông báo",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, colors, colors[0]);

        switch (colorOptions) {
            case 0:
                color = "red";
                break;
            case 1:
                color = "yellow";
                break;
            case 2:
                color = "blue";
                break;
            default:
                color = "green";
                break;
        }
    
        
        return color;
    }

    public void setLabelArray(){
        labelArray[0] = jLabel1;
        labelArray[1] = jLabel2;
        labelArray[2] = jLabel3;
        labelArray[3] = jLabel4;
        labelArray[4] = jLabel5;
        labelArray[5] = jLabel6;
        labelArray[6] = jLabel7;
        labelArray[7] = jLabel8;
        labelArray[8] = jLabel9;
        labelArray[9] = jLabel10;
        labelArray[10] = jLabel11;
        labelArray[11] = jLabel12;
        labelArray[12] = jLabel13;
        labelArray[13] = jLabel14;
        labelArray[14] = jLabel15;
        labelArray[15] = jLabel16;
        labelArray[16] = jLabel17;
        labelArray[17] = jLabel18;
        labelArray[18] = jLabel19;
        labelArray[19] = jLabel20;
        labelArray[20] = jLabel21;
        labelArray[21] = jLabel22;
        labelArray[22] = jLabel23;
        labelArray[23] = jLabel24;
        labelArray[24] = jLabel25;
        labelArray[25] = jLabel26;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http:download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addRoom;
    private javax.swing.JButton btnDraw;
    private javax.swing.JButton btnEndTurn;
    private javax.swing.JButton btnSendChat;
    private javax.swing.JLabel currentColorIcon;
    private javax.swing.JPanel currentPlayerHand;
    private javax.swing.JPanel discardPile;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel help;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelChat;
    private javax.swing.JLabel labelChatPlayer1;
    private javax.swing.JLabel labelChatPlayer2;
    private javax.swing.JLabel labelChatPlayer3;
    private javax.swing.JLabel labelChatPlayer4;
    private javax.swing.JLabel labelCurrentColor;
    private javax.swing.JLabel labelCurrentPlayer;
    private javax.swing.JLabel labelNamePlayer2;
    private javax.swing.JLabel labelNamePlayer3;
    private javax.swing.JLabel labelNamePlayer4;
    private javax.swing.JLabel labelNumLeftCardPlayer2;
    private javax.swing.JLabel labelNumLeftCardPlayer3;
    private javax.swing.JLabel labelNumLeftCardPlayer4;
    private javax.swing.JLabel labelRank;
    private javax.swing.JLabel labelStatusGame;
    private javax.swing.JLabel labelWelcome;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLayeredPane panelChat;
    private javax.swing.JPanel panelShowChat;
    private javax.swing.JPanel panelTypingChat;
    private javax.swing.JPanel player2;
    private javax.swing.JPanel player3;
    private javax.swing.JPanel player4;
    private javax.swing.JPanel roomPanel;
    private javax.swing.JLabel searchRoom;
    private javax.swing.JPanel shootingUno;
    private javax.swing.JLabel start;
    private javax.swing.JTable tblListRoom;
    private javax.swing.JLabel topOfDiscardPile;
    private javax.swing.JTextField txtSearchRoom;
    private javax.swing.JTextField typingChat;
    // End of variables declaration//GEN-END:variables
}