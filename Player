package uno;

import java.util.ArrayList;

public class Player {

	private boolean isPlayerTurn;
	
	ArrayList<UnoCards> playerDeck = new ArrayList<UnoCards>();
	
	UnoCards currentCard = null;
	
	//constructor
	Player(boolean playerTurn){
		this.setIsPlayerTurn(playerTurn);
	}
	
	//getter method to return the players deck
	public ArrayList<UnoCards> getPlayerDeck() {
		
		return this.playerDeck;
	}
	
	//setter method to initialize the players deck
	public void setPlayerDeck(ArrayList<UnoCards> deck){
		
		//copies the passed in deck to the players deck
		playerDeck = new ArrayList<UnoCards>(deck);
	}
	
	public boolean getIsPlayerTurn() {
		return this.isPlayerTurn;
	}
	
	public void setIsPlayerTurn(boolean turn) {
		isPlayerTurn = turn;
	}
	
	//returns the card the player is looking at
	public UnoCards getCurrentCard(){
		return this.currentCard;
	}
	
	//used to set the current card to a new one
	public void setCurrentCard(UnoCards card) {
		this.currentCard = card;
	}
}
