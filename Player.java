package uno;

import java.util.ArrayList;

/**
 * This class models player objects that resemble the four players in the 
 * uno game, and their hands of cards.
 * 
 * @author Derek Syrba, John Frocillo, and Adrian Harrell
 */
public class Player {

	/**A boolean value to determine whether it is the player's
	 * turn or not*/
	private boolean isPlayerTurn;
	
	/**An arraylist of UnoCards objects that resembles the players hand*/
	ArrayList<UnoCards> playerDeck = new ArrayList<UnoCards>();
	
	/**An UnoCards object that resembles the card the player is
	 * currently looking at in their hand*/
	UnoCards currentCard = null;
	
	
	/**
	 * Constructor for the player objects
	 * 
	 * @param playerTurn - a boolean value to set whether it is the
	 * player's turn or not
	 */
	Player(boolean playerTurn){
		this.setIsPlayerTurn(playerTurn);
	}
	
	
	/**
	 * A getter method to return the player's hand
	 * 
	 * @return the player's hand
	 */
	public ArrayList<UnoCards> getPlayerDeck() {
		
		return this.playerDeck;
	}
	
	
	/**
	 * A setter method to set the player's hand to an arraylist
	 * of cards
	 * 
	 * @param deck - the set of cards to put into the player's hand
	 */
	public void setPlayerDeck(ArrayList<UnoCards> deck){
		
		//copies the passed in deck to the players deck
		playerDeck = new ArrayList<UnoCards>(deck);
	}
	
	
	/**
	 * A getter method that returns the boolean value indicating if it
	 * is the player's turn
	 * 
	 * @return the isPlayerTurn instance variable indicating if it is
	 * the player's turn or not
	 */
	public boolean getIsPlayerTurn() {
		return this.isPlayerTurn;
	}
	
	
	/**
	 * A setter method to set the player's turn to true or false
	 * 
	 * @param turn - a boolean variable to set the isPlayerTurn
	 * instance variable to true or false.
	 */
	public void setIsPlayerTurn(boolean turn) {
		isPlayerTurn = turn;
	}
	
	
	/**
	 * A getter method to return the player's current card they are
	 * looking at
	 * 
	 * @return the player's current card
	 */
	public UnoCards getCurrentCard(){
		return this.currentCard;
	}
	
	
	/**
	 * A setter method to set the player's current card to a new
	 * UnoCards object
	 * 
	 * @param card - the UnoCards object to set the player's current
	 * card to
	 */
	public void setCurrentCard(UnoCards card) {
		this.currentCard = card;
	}
}
