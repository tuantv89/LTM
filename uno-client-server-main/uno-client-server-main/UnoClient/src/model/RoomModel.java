package model;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomModel implements Serializable {    
    private int id;
    private String name;
    private int numRequest;
    private ArrayList<PlayerModel> listReadyPlayer = new ArrayList<>();
    private UnoModel unoModel;
    private ArrayList<PlayerModel> listPlayer = new ArrayList<>();
    private boolean isProgress = false;
    
    public RoomModel() {
        isProgress = false;
    }

    public RoomModel(int id, String name, int numRequest, UnoModel unoModel, 
            ArrayList<PlayerModel> listPlayer) {
        this.id = id;
        this.name = name;
        this.numRequest = numRequest;
        this.unoModel = unoModel;
        this.listPlayer = listPlayer;
        isProgress = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumRequest() {
        return numRequest;
    }

    public void setNumRequest(int numRequest) {
        this.numRequest = numRequest;
    }

    public ArrayList<PlayerModel> getListReadyPlayer() {
        return listReadyPlayer;
    }

    public void setListReadyPlayer(ArrayList<PlayerModel> listReadyPlayer) {
        this.listReadyPlayer = listReadyPlayer;
    }

    public UnoModel getUnoModel() {
        return unoModel;
    }

    public void setUnoModel(UnoModel unoModel) {
        this.unoModel = unoModel;
    }

    public ArrayList<PlayerModel> getListPlayer() {
        return listPlayer;
    }

    public void setListPlayer(ArrayList<PlayerModel> listPlayer) {
        this.listPlayer = listPlayer;
    }

    public boolean isIsProgress() {
        return isProgress;
    }

    public void setIsProgress(boolean isProgress) {
        this.isProgress = isProgress;
    }
}