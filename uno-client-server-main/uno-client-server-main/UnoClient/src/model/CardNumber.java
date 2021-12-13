package model;

import java.io.Serializable;

public class CardNumber extends Card implements Serializable {
    
    private int number;
    
    public CardNumber(String color, int number){
        this.color = color;
        this.number = number;
    }
    
    public int getNumber(){
        return this.number;
    }
    
}
