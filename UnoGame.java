package uno;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class handles all game logic for the UNO game.
 * 
 * @author Derek Syrba, John Frocillo, and Adrian Harrell
 */
public class UnoGame {

	/** An arraylist of UnoCards objects to resemble the deck.*/
	private ArrayList<UnoCards> deck = createDeck();

	/** An arraylist of UnoCards objects to resemble the discard pile.*/
	private ArrayList<UnoCards> discardPile = new ArrayList<UnoCards>();

	/** The first player object to resemble a player playing the game.*/
	private Player player1 = new Player(true);

	/** The second player object to resemble a player playing the game.*/
	private Player player2 = new Player(false);

	/** The third player object to resemble a player playing the game.*/
	private Player player3 = new Player(false);

	/** The fourth player object to resemble a player playing the game.*/
	private Player player4 = new Player(false);

	/** A boolean value to keep track of the clockwise or 
	 * counterclockwise rotation of the turns.*/
	private boolean isReverse = false;
	

	/**
	 * Getter method to return the game deck.
	 * 
	 * @return the game deck.
	 */
	public ArrayList<UnoCards> getDeck() {
		return this.deck;
	}
	
	
	/**
	 * Getter method to return the game discard pile.
	 * 
	 * @return the discard pile.
	 */
	public ArrayList<UnoCards> getDiscardPile() {
		return this.discardPile;
	}
	
	
	/**
	 * Getter method to return player1.
	 * 
	 * @return player 1.
	 */
	public Player getPlayer1() {
		return this.player1;
	}
	
	
	/**
	 * Getter method to return player2.
	 * 
	 * @return player 2.
	 */
	public Player getPlayer2() {
		return this.player2;
	}
	
	
	/**
	 * Getter method to return player3.
	 * 
	 * @return player 3.
	 */
	public Player getPlayer3() {
		return this.player3;
	}
	
	
	/**
	 * Getter method to return player4.
	 * 
	 * @return player 4.
	 */
	public Player getPlayer4() {
		return this.player4;
	}

	/**
	 * Method that handles the logic for playing a card from a players
	 * hand into the discard pile.
	 * 
	 * @param player - the player object that is playing the card.
	 * 
	 * @param playedCard - the UnoCards object being played from the 
	 * player's hand.
	 */
	public void playCard(final Player player, final UnoCards playedCard) {

		if (playedCard.getIsReverse()) {	
			if (isReverse) {
				isReverse = false;
			} else {
				isReverse = true;	
			}
		}

		if (playedCard.getIsPlus2()) {

			drawCard(nextPlayer(), 2);
		}

		if (playedCard.getIsPlus4()) {

			drawCard(nextPlayer(), 4);
		}

		if (playedCard.getIsSkip()) {
			changeTurn();
		}

		//removes the card from the players deck
		player.getPlayerDeck().remove(playedCard);

		//if player plays last card, dont change the current 
		//card to avoid error
		if (player.getPlayerDeck().size() != 0) {
			nextCard(player, player.getCurrentCard(), true);

			//adds the played card to the discard pile
			discardPile.add(playedCard);
		}

		changeTurn();

	}


	/**
	 * Method that checks if a card being played is a valid move.
	 * 
	 * @param currentCard - the player's card that is being played.
	 * 
	 * @param top - the top card of the discard pile to compare the 
	 * played card to.
	 * 
	 * @return boolean value indicating if the move is valid.
	 */
	public boolean isValid(final UnoCards currentCard, 
			final UnoCards top) {

		if (currentCard.getIsWild()) {
			return true;
		} else if (currentCard.getCardColor().equals(
				top.getCardColor())) {
			return true;
		} else if (currentCard.getCardNumber() == top.getCardNumber()) {
			return true;
		} else if (currentCard.getIsReverse() && top.getIsReverse()) {
			return true;
		} else if (currentCard.getIsPlus2() && top.getIsPlus2()) {
			return true;
		} else if (currentCard.getIsSkip() && top.getIsSkip()) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * Method that handles the logic for drawing a card from the deck.
	 * 
	 * @param player - the player object that is drawing the card.
	 * 
	 * @param num - the number of card to be drawn from the deck.
	 */
	public void drawCard(final Player player, final int num) {

		for (int i = 0; i < num; i++) { 
			//draws a card from the 0 index position (top) 
			//of the deck and adds it to the players deck
			player.getPlayerDeck().add(deck.get(0));
			deck.remove(deck.get(0));
		}

		changeTurn();
	}


	/**
	 * Method that handles the logic for changing the which player's
	 * turn it is.
	 */
	public void changeTurn() {

		if (!isReverse) {

			//handles the standard counter clockwise rotation
			if (player1.getIsPlayerTurn()) {
				player1.setIsPlayerTurn(false);
				player2.setIsPlayerTurn(true);

			} else if (player2.getIsPlayerTurn()) {
				player2.setIsPlayerTurn(false);
				player3.setIsPlayerTurn(true);

			} else if (player3.getIsPlayerTurn()) {
				player3.setIsPlayerTurn(false);
				player4.setIsPlayerTurn(true);

			} else if (player4.getIsPlayerTurn()) {
				player4.setIsPlayerTurn(false);
				player1.setIsPlayerTurn(true);
			}

			//handles the reverse order (clockwise)
		} else {

			if (player1.getIsPlayerTurn()) {
				player1.setIsPlayerTurn(false);
				player4.setIsPlayerTurn(true);

			} else if (player2.getIsPlayerTurn()) {
				player2.setIsPlayerTurn(false);
				player1.setIsPlayerTurn(true);

			} else if (player3.getIsPlayerTurn()) {
				player3.setIsPlayerTurn(false);
				player2.setIsPlayerTurn(true); 

			} else if (player4.getIsPlayerTurn()) {
				player4.setIsPlayerTurn(false);
				player3.setIsPlayerTurn(true);
			}
		}
	}


	/**
	 * Method that returns which player's turn is next.
	 * 
	 * @return next - the player who's turn is next.
	 */
	public Player nextPlayer() {
		Player next = new Player(false);

		if (!isReverse) {

			//handles the standard counter clockwise rotation
			if (player1.getIsPlayerTurn()) {
				next = player2;

			} else if (player2.getIsPlayerTurn()) {
				next = player3;

			} else if (player3.getIsPlayerTurn()) {
				next = player4;

			} else if (player4.getIsPlayerTurn()) {
				next = player1;
			}
			
			//handles the reverse order (clockwise)
		} else {
			if (player1.getIsPlayerTurn()) {
				next = player4;

			} else if (player2.getIsPlayerTurn()) {
				next = player1;

			} else if (player3.getIsPlayerTurn()) {
				next = player2;

			} else if (player4.getIsPlayerTurn()) {
				next = player3;
			}
		}

		return next;

	}


	/**
	 * Method that returns which player's turn it currently is.
	 * 
	 * @return player - the player who's turn it currently is.
	 */
	public Player currentPlayer() {
		Player player;

		if (player1.getIsPlayerTurn()) {
			player = player1;
		} else if (player2.getIsPlayerTurn()) {
			player = player2;
		} else if (player3.getIsPlayerTurn()) {
			player = player3;
		} else {
			player = player4;
		}

		return player;
	}


	/**
	 * Method that returns a boolean value indicating if the game
	 * is over or not.
	 * 
	 * @return boolean value incicating if the game is over or not.
	 */
	public boolean isGameOver() {

		if (player1.getPlayerDeck().size() == 0) {
			return true;

		} else if (player2.getPlayerDeck().size() == 0) {
			return true;

		} else if (player3.getPlayerDeck().size() == 0) {
			return true;

		} else if (player4.getPlayerDeck().size() == 0) {
			return true;
		}

		return false;
	}


	/**
	 * Method that handles the logic of looking through different cards
	 * in the player's deck.
	 * 
	 * @param player - the player object who's hand is being looked at.
	 * 
	 * @param currentCard - the current card being looked at by 
	 * the player.
	 * 
	 * @param isNext - a boolean value that indicates whether the
	 * player is moving to the card to the right or left of their
	 * current card (true for right, false for left).
	 */
	public void nextCard(final Player player, 
			final UnoCards currentCard, final boolean isNext) {

		if (isNext) {
			//if the current card is the end of the players hand, set
			//it to the 0 position
			if (player.getPlayerDeck().indexOf(currentCard) 
					== player.getPlayerDeck().size() - 1) {
				player.setCurrentCard(player.getPlayerDeck().get(0));

			} else {
				player.setCurrentCard(player.getPlayerDeck().get(
						player.getPlayerDeck().indexOf(
								currentCard) + 1));
			}

		} else {
			if (player.getPlayerDeck().indexOf(currentCard) == 0) {
				player.setCurrentCard(player.getPlayerDeck().get(
						player.getPlayerDeck().size() - 1));

			} else {
				player.setCurrentCard(player.getPlayerDeck().get(
						player.getPlayerDeck().indexOf(
								currentCard) - 1));
			}
		}

	}


	/**
	 * Method that creates all of the UnoCards objects for all 108
	 * cards in a standard uno deck, placing them into an arraylist
	 * and shuffling it.
	 * 
	 * @return deck - the arraylist that holds all of the uno cards.
	 */
	public ArrayList<UnoCards> createDeck() {
		ArrayList<UnoCards> deck = new ArrayList<UnoCards>();

		//creates all of the blue number cards
		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				UnoCards newBlue = new UnoCards(i, "blue");
				deck.add(newBlue);

			} else {
				UnoCards newBlue = new UnoCards(i, "blue");
				UnoCards newBlue2 = new UnoCards(i, "blue");
				deck.add(newBlue);
				deck.add(newBlue2);
			}
		}

		//creates all of the red number cards
		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				UnoCards newRed = new UnoCards(i, "red");
				deck.add(newRed);

			} else {
				UnoCards newRed = new UnoCards(i, "red");
				UnoCards newRed2 = new UnoCards(i, "red");
				deck.add(newRed);
				deck.add(newRed2);
			}
		}

		//creates all of the yellow number cards
		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				UnoCards newYellow = new UnoCards(i, "yellow");
				deck.add(newYellow);

			} else {
				UnoCards newYellow = new UnoCards(i, "yellow");
				UnoCards newYellow2 = new UnoCards(i, "yellow");
				deck.add(newYellow);
				deck.add(newYellow2);
			}
		}

		//creates all of the green number cards
		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				UnoCards newGreen = new UnoCards(i, "green");
				deck.add(newGreen);

			} else {
				UnoCards newGreen = new UnoCards(i, "green");
				UnoCards newGreen2 = new UnoCards(i, "green");
				deck.add(newGreen);
				deck.add(newGreen2);
			}
		}


		//creates the wild cards
		for (int i = 0; i < 8; i++) {
			//creates the 4 basic wilds
			if (i < 4) {
				UnoCards newWild = new UnoCards("white", -1, true,
						false, false, false, false);
				deck.add(newWild);

				//creates the 4 plus 4 wilds
			} else {
				UnoCards newWild = new UnoCards("white", -1, true,
						false, true, false, false);
				deck.add(newWild);
			}

		}

		//creates the blue reverse, skip, plus2 cards
		for (int i = 0; i < 2; i++) {
			UnoCards newBlueReverse = new UnoCards("blue", -2, false,
					false, false, true, false);
			UnoCards newBlueSkip = new UnoCards("blue", -3, false,
					false, false, false, true);
			UnoCards newBluePlus2 = new UnoCards("blue", -4, false,
					true, false, false, false);

			deck.add(newBlueReverse);
			deck.add(newBlueSkip);
			deck.add(newBluePlus2);
		}

		//creates the red reverse, skip, plus2 cards
		for (int i = 0; i < 2; i++) {
			UnoCards newRedReverse = new UnoCards("red", -2, false,
					false, false, true, false);
			UnoCards newRedSkip = new UnoCards("red", -3, false,
					false, false, false, true);
			UnoCards newRedPlus2 = new UnoCards("red", -4, false,
					true, false, false, false);

			deck.add(newRedReverse);
			deck.add(newRedSkip);
			deck.add(newRedPlus2);
		}

		//creates the yellow reverse, skip, plus2, and plus4 cards
		for (int i = 0; i < 2; i++) {
			UnoCards newYellowReverse = new UnoCards("yellow", -2,
					false, false, false, true, false);
			UnoCards newYellowSkip = new UnoCards("yellow", -3,
					false, false, false, false, true);
			UnoCards newYellowPlus2 = new UnoCards("yellow", -4,
					false, true, false, false, false);

			deck.add(newYellowReverse);
			deck.add(newYellowSkip);
			deck.add(newYellowPlus2);
		}

		//creates the green reverse, skip, plus2, and plus4 cards
		for (int i = 0; i < 2; i++) {
			UnoCards newGreenReverse = new UnoCards("green", -2, false,
					false, false, true, false);
			UnoCards newGreenSkip = new UnoCards("green", -3, false,
					false, false, false, true);
			UnoCards newGreenPlus2 = new UnoCards("green", -4, false,
					true, false, false, false);

			deck.add(newGreenReverse);
			deck.add(newGreenSkip);
			deck.add(newGreenPlus2);
		}

		//shuffles the deck before returning it
		shuffleDeck(deck);

		return deck;
	}


	/**
	 * Method that shuffles the arraylist that holds the uno cards.
	 * 
	 * @param deck - the arraylist that holds the UnoCards objects, 
	 * resembling the deck.
	 */
	public void shuffleDeck(final ArrayList<UnoCards> deck) {
		Collections.shuffle(deck);
	}


	/**
	 * Method that handles the logic for dealing the initial 7 cards,
	 * that start in each player's hand.
	 */
	public void dealDeck() {
		for (int i = 0; i < 7; i++) {
			player1.getPlayerDeck().add(deck.get(0));
			deck.remove(deck.get(0));
			player2.getPlayerDeck().add(deck.get(0));
			deck.remove(deck.get(0));
			player3.getPlayerDeck().add(deck.get(0));
			deck.remove(deck.get(0));
			player4.getPlayerDeck().add(deck.get(0));
			deck.remove(deck.get(0));
		}
	}


	/**
	 * Method that handles the logic for reshuffling the deck when.
	 * it runs out of cards, so players can continue drawing cards
	 */
	public void reshuffle() {

		if (deck.size() == 0) {

			//adds each card from the discard pile back into the draw
			//pile, except the last one (the card on top)
			while (discardPile.size() > 1) {
				deck.add(discardPile.get(0));
				discardPile.remove(0);
			}

			shuffleDeck(deck);
		}
	}


}



