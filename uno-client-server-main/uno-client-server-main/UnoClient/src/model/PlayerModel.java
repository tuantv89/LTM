package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerModel implements Serializable {
    private ArrayList<Card> hand = new ArrayList<>();
    private String name;

    public PlayerModel() {
    }
    
    public PlayerModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<Card> getHand(){
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    
    public void addCard(Card card){
        hand.add(card);
    }
    
    public void removeCard(Card card){
        hand.remove(card);
    }
    
    public int getHandSize(){
        return hand.size();
    }
}   
