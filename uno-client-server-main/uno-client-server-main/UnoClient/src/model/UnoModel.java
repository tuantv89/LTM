package model;

import controller.UnoDeck;
import java.io.Serializable;
import java.util.ArrayList;

public final class UnoModel implements Serializable {
    private final int numCardBegin = 7;
    
    private PlayerModel[] players;
    private PlayerModel currentPlayer;
    private UnoDeck deck;
    private int currentPlayerIndex = 0;
    private int numPlayers = 0;
    private boolean reverse = false;
    private boolean cantPlay = false;
    private boolean determineColor = false;
    
    public UnoModel(){ 
    }
   
    public void startGame(ArrayList<PlayerModel> listPlayer){
        deck = new UnoDeck();
        deck.discardFirstCard();
        this.numPlayers = listPlayer.size();
        players = new PlayerModel[numPlayers];
        
        // add player 
        int i = 0;
        for (PlayerModel j: listPlayer){
            players[i] = j;
            players[i].setHand(new ArrayList<>());
            setCurrentPlayer(players[i]);
            draw(numCardBegin);
            
            i++;
        }
        
        setCurrentPlayer(players[0]);
    }
    
    public void draw(int cards){
        for (int i = 0; i < cards; i++)
            currentPlayer.addCard(deck.draw());
    }
    
    public void discard(Card card){
        if (card instanceof CardNumber){
            compareNumbers((CardNumber)card);
        } 
        else if (card instanceof CardWild){
            discardCard(card);
            determineColor = true;
            nextPlayer();
        }
        else if (card instanceof CardWildDraw){
            discardCard(card);
            determineColor = true;
            nextPlayer();
            draw(4);
            nextPlayer();
        } 
        else {
            compareColors(card);
        }
    }
    
     public void nextPlayer(){
        if (!reverse){
            currentPlayerIndex++;
            
            if (currentPlayerIndex > (numPlayers - 1))
                currentPlayerIndex = 0;
             
            setCurrentPlayer(players[currentPlayerIndex]);
        }
        else {
            currentPlayerIndex--;
            
            if (currentPlayerIndex < 0)
                currentPlayerIndex = numPlayers - 1;
            
            setCurrentPlayer(players[currentPlayerIndex]); 
        }
    }
    
    public void compareNumbers(CardNumber card){
        Card topOfPile = deck.getTopOfDiscardPile();
        
        if (topOfPile instanceof CardNumber){
            if ((card.getNumber() == ((CardNumber)topOfPile).getNumber()) 
                    || (card.getColor().equals(topOfPile.getColor()))){
                discardCard(card);
                nextPlayer();
            }
            else {
                cantPlay = true;
            }
        }
        else {
            if (card.getColor().equals(topOfPile.getColor())){
                discardCard(card);
                nextPlayer();
            } 
            else {
                cantPlay = true;
            }
        }
    }
    
    public void compareColors(Card card){
        Card topOfPile = deck.getTopOfDiscardPile();
        
        if (card.getColor().equals(topOfPile.getColor())){
            if (card instanceof CardReverse){
                reverse = !reverse;
                discardCard(card);
                
                if (numPlayers >= 3)
                    nextPlayer();
            } 
            else if (card instanceof CardSkip){
                discardCard(card);
                nextPlayer();
                nextPlayer();
            }
            else if (card instanceof CardDraw){
                discardCard(card);
                nextPlayer();
                draw(2);
                nextPlayer();
            }
        }
        else if (card instanceof CardReverse && topOfPile instanceof CardReverse){
            reverse = !reverse;
            discardCard(card);
            nextPlayer();
        } 
        else if (card instanceof CardSkip && topOfPile instanceof CardSkip){
            discardCard(card);
            nextPlayer();
            nextPlayer();
        }
        else if (card instanceof CardDraw && topOfPile instanceof CardDraw){
            discardCard(card);
            nextPlayer();
            draw(2);
            nextPlayer();
        }
        else {
            cantPlay = true;
        }
    }
    
    public void discardCard(Card card){
        deck.setTopOfDiscardPile(card);
        currentPlayer.removeCard(card);
    }
    
    public void setCurrentPlayer(PlayerModel player){
        currentPlayer = player;
    }
    
    public PlayerModel getCurrentPlayer(){
        return currentPlayer;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }
    
    public PlayerModel[] getPlayers(){
        return players;
    }
    
    public void setPlayer(PlayerModel[] players) {
        this.players = players;
    }
    
    public int getCurrentPlayerIndex(){
        return currentPlayerIndex;
    }
    
    public void setCurrentPlayerIndex(){
        this.currentPlayerIndex = 0;
    }
    
    public boolean UNO(){
        return currentPlayer.getHandSize() == 1;
    }
    
    public Card getTopOfDeck(){
        return deck.getTopOfDiscardPile();
    }
    
    public boolean getWildCardPopUp(){
        return determineColor;
    }
    
    public void setWildCardPopUp(){
        this.determineColor = false;
    }
    
    public boolean getCantPlay(){
        return cantPlay;
    }
    
    public void setCantPlay(){
        cantPlay = false;
    }
}