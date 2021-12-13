package model;

import java.io.Serializable;

public class Card implements Serializable {
    
    String color;

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }
}
