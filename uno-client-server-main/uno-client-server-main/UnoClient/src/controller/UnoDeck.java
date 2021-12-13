package controller;

import java.io.Serializable;
import model.CardSkip;
import model.CardWildDraw;
import model.CardDraw;
import model.CardNumber;
import model.CardReverse;
import model.CardWild;
import model.Card;
import java.util.ArrayList;
import java.util.Stack;

public class UnoDeck implements Serializable {
    private ArrayList<Card> deck = new ArrayList<>();
    private Stack<Card> discardPile = new Stack<>();
    private int topOfDeck;
    
    private final int numberCards = 76;
    private final int drawCards = 8;
    private final int reverseCards = 8;
    private final int skipCards = 8;
    private final int wildCards = 4;
    private final int wildDrawCards = 4;
    
    private final String colorRed = "red";
    private final String colorBlue = "blue";
    private final String colorYellow = "yellow";
    private final String colorGreen = "green";
    
    public UnoDeck(){
        addNumbers();
        addDraws();
        addReverses();
        addSkips();
        addWilds();
        addWildDraws();
        
        shuffle();
        shuffle();
        
        topOfDeck = deck.size() - 1;
    }
    
    private void addNumbers() {
        addRedNumbers();
        addBlueNumbers();
        addYellowNumbers();
        addGreenNumbers();
    }
    
    private void addRedNumbers() {
        for (int j = 1; j <= 2; j++)
            for (int i = 0; i < (numberCards / 8) + 1; i++)
                deck.add(new CardNumber(colorRed, i));
    }
    
    private void addBlueNumbers() {
        for (int j = 1; j <= 2; j++)
            for (int i = 0; i < (numberCards / 8) + 1; i++) 
                deck.add(new CardNumber(colorBlue, i));
    }
    
    private void addYellowNumbers() {
        for (int j = 1; j <= 2; j++)
            for (int i = 0; i < (numberCards / 8) + 1; i++)
                deck.add(new CardNumber(colorYellow, i));
    }
    
    private void addGreenNumbers() {
        for (int j = 1; j <= 2; j++)
            for (int i = 0; i < (numberCards / 8) + 1; i++) 
                deck.add(new CardNumber(colorGreen, i));
    }
    
    private void addDraws() {
        for (int i = 0; i < drawCards / 4; i++)
            deck.add(new CardDraw(colorRed));
        
        for (int i = 0; i < drawCards / 4; i++)
            deck.add(new CardDraw(colorBlue));
        
        for (int i = 0; i < drawCards / 4; i++)
            deck.add(new CardDraw(colorYellow));
        
        for (int i = 0; i < drawCards / 4; i++)
            deck.add(new CardDraw(colorGreen));
    }
    
    private void addReverses() {
        for (int i = 0; i < reverseCards / 4; i++)
            deck.add(new CardReverse(colorRed));
        
        for (int i = 0; i < reverseCards / 4; i++)
            deck.add(new CardReverse(colorBlue));
        
        for (int i = 0; i < reverseCards / 4; i++)
            deck.add(new CardReverse(colorYellow));
        
        for (int i = 0; i < reverseCards / 4; i++)
            deck.add(new CardReverse(colorGreen));
    }
    
    private void addSkips() {
        for (int i = 0; i < skipCards / 4; i++)
            deck.add(new CardSkip(colorRed));
        
        for (int i = 0; i < skipCards / 4; i++)
            deck.add(new CardSkip(colorBlue));
        
        for (int i = 0; i < skipCards / 4; i++)
            deck.add(new CardSkip(colorYellow));
       
        for (int i = 0; i < skipCards / 4; i++)
            deck.add(new CardSkip(colorGreen));
    }
    
    private void addWilds() {
        for (int i = 0; i < wildCards; i++)
            deck.add(new CardWild());
    }
    
    private void addWildDraws() {
        for(int i = 0; i < wildDrawCards; i++)
            deck.add(new CardWildDraw());
    }
    
    private void shuffle(){
        for (Card card: deck) {
            int randomIndex = (int)(Math.random() * deck.size());
            Card temp = card;
            deck.set(deck.indexOf(card), deck.get(randomIndex));
            deck.set(deck.indexOf(deck.get(randomIndex)), temp);
        }
    }
    
    public void discardFirstCard(){
        while ((deck.get(topOfDeck) instanceof CardWild) || 
                (deck.get(topOfDeck) instanceof CardWildDraw))
            shuffle();
        
        discardPile.push(deck.get(topOfDeck));
        deck.remove(topOfDeck);
        topOfDeck--;
    }
    
    public Card draw(){
        if (deck.isEmpty()){
            for (Card card: discardPile)
                deck.add(discardPile.pop());
            
            shuffle();
            shuffle();
            
            topOfDeck = deck.size() - 1;
            discardFirstCard();
        }
        
        Card card = deck.get(topOfDeck);
        deck.remove(topOfDeck);
        topOfDeck--;
        
        return card;
    }
    
    public void discard(Card card){
        discardPile.push(card);
    }
    
    public Card getTopOfDiscardPile(){
        return discardPile.peek();
    }
    
    public void setTopOfDiscardPile(Card card){
        this.discardPile.push(card);
    }
}
