package model;

import java.io.Serializable;

public class CardWildDraw extends Card implements Serializable {
    
    public CardWildDraw(){    
    }
    
    public void setColor(String color){
        this.color = color;
    }
}