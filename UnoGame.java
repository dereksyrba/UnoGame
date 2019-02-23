package uno;

import java.util.ArrayList;
import java.util.Collections;

public class UnoGame {


	ArrayList<UnoCards> deck = createDeck();

	ArrayList<UnoCards> discardPile = new ArrayList<UnoCards>();

	Player player1 = new Player(true);
	Player player2 = new Player(false);
	Player player3 = new Player(false);
	Player player4 = new Player(false);

	private boolean isReverse = false;

	private String winner = "";

	//used to handle the logic of playing a card from a player deck
	public void playCard(Player player, UnoCards playedCard) {

		if(playedCard.getIsReverse()) {
			if(isReverse == true)
				isReverse = false;
			else
				isReverse = true;	
		}

		if(playedCard.getIsPlus2() == true) {

			drawCard(nextPlayer(), 2);
		}

		if(playedCard.getIsPlus4() == true) {

			drawCard(nextPlayer(), 4);
		}

		if(playedCard.getIsSkip() == true) {
			changeTurn();
		}

		//removes the card from the players deck
		player.getPlayerDeck().remove(playedCard);

		//if player plays last card, dont change the current card to avoid error
		if(player.getPlayerDeck().size() != 0) {
			nextCard(player, player.getCurrentCard(), true);

			//adds the played card to the discard pile
			discardPile.add(playedCard);
		}

		changeTurn();

	}

	public boolean isValid(UnoCards currentCard, UnoCards top) {

		if(currentCard.getIsWild())
			return true;
		else if(currentCard.getCardColor().equals(top.getCardColor()))
			return true;
		else if(currentCard.getCardNumber() == top.getCardNumber())
			return true;
		else if(currentCard.getIsReverse() && top.getIsReverse())
			return true;
		else if(currentCard.getIsPlus2() && top.getIsPlus2())
			return true;
		else if(currentCard.getIsSkip() && top.getIsSkip())
			return true;
		else
			return false;
	}

	//handles the logic of drawing a card from the deck
	public void drawCard(Player player, int num) {

		for(int i = 0; i < num; i++) { 
			//draws a card from the 0 index position (top) of the deck and adds it 
			//to the players deck
			player.getPlayerDeck().add(deck.get(0));
			deck.remove(deck.get(0));
		}

		changeTurn();
	}

	//handles the turns
	public void changeTurn() {

		if(!isReverse) {

			//handles the standard counter clockwise rotation
			if(player1.getIsPlayerTurn() == true) {
				player1.setIsPlayerTurn(false);
				player2.setIsPlayerTurn(true);
			}

			else if(player2.getIsPlayerTurn() == true) {
				player2.setIsPlayerTurn(false);
				player3.setIsPlayerTurn(true);
			}

			else if(player3.getIsPlayerTurn() == true) {
				player3.setIsPlayerTurn(false);
				player4.setIsPlayerTurn(true);
			}

			else if(player4.getIsPlayerTurn() == true) {
				player4.setIsPlayerTurn(false);
				player1.setIsPlayerTurn(true);
			}
		}

		//handles the reverse order (clockwise)
		else {
			if(player1.getIsPlayerTurn() == true) {
				player1.setIsPlayerTurn(false);
				player4.setIsPlayerTurn(true);
			}

			else if(player2.getIsPlayerTurn() == true) {
				player2.setIsPlayerTurn(false);
				player1.setIsPlayerTurn(true);
			}

			else if(player3.getIsPlayerTurn() == true) {
				player3.setIsPlayerTurn(false);
				player2.setIsPlayerTurn(true);
			}

			else if(player4.getIsPlayerTurn() == true) {
				player4.setIsPlayerTurn(false);
				player3.setIsPlayerTurn(true);
			}
		}



	}

	public Player nextPlayer() {
		Player next = new Player(false);

		if(!isReverse) {

			//handles the standard counter clockwise rotation
			if(player1.getIsPlayerTurn() == true) {
				next = player2;
			}

			else if(player2.getIsPlayerTurn() == true) {
				next = player3;
			}

			else if(player3.getIsPlayerTurn() == true) {
				next = player4;
			}

			else if(player4.getIsPlayerTurn() == true) {
				next = player1;
			}
		}

		//handles the reverse order (clockwise)
		else {
			if(player1.getIsPlayerTurn() == true) {
				next = player4;
			}

			else if(player2.getIsPlayerTurn() == true) {
				next = player1;
			}

			else if(player3.getIsPlayerTurn() == true) {
				next = player2;
			}

			else if(player4.getIsPlayerTurn() == true) {
				next = player3;
			}
		}

		return next;

	}

	public Player currentPlayer(){
		Player player;

		if(player1.getIsPlayerTurn())
			player = player1;

		else if(player2.getIsPlayerTurn())
			player = player2;

		else if(player3.getIsPlayerTurn())
			player = player3;

		else
			player = player4;

		return player;
	}

	public boolean isGameOver() {

		if(player1.getPlayerDeck().size() == 0) {
			winner = "Player 1";
			return true;
		}

		else if(player2.getPlayerDeck().size() == 0) {
			winner = "Player 2";
			return true;
		}

		else if(player3.getPlayerDeck().size() == 0) {
			winner = "Player 3";
			return true;
		}

		else if(player4.getPlayerDeck().size() == 0) {
			winner = "Player 4";
			return true;
		}

		return false;
	}

	//used to allow the player to look throught their cards
	public void nextCard(Player player, UnoCards currentCard, boolean isNext) {

		if(isNext == true) {
			//if the current card is the end of the players hand, set it to the 0 position
			if(player.getPlayerDeck().indexOf(currentCard) == player.getPlayerDeck().size() - 1) {
				player.setCurrentCard(player.getPlayerDeck().get(0));
			}
			else
				player.setCurrentCard(player.getPlayerDeck().get(player.getPlayerDeck().indexOf(currentCard) + 1));

		}

		else {
			if(player.getPlayerDeck().indexOf(currentCard) == 0) {
				player.setCurrentCard(player.getPlayerDeck().get(player.getPlayerDeck().size() - 1));
			}
			else
				player.setCurrentCard(player.getPlayerDeck().get(player.getPlayerDeck().indexOf(currentCard) - 1));
		}

	}

	public ArrayList<UnoCards> createDeck() {
		ArrayList<UnoCards> deck = new ArrayList<UnoCards>();

		//creates all of the blue number cards
		for(int i = 0; i < 10; i++) {
			if(i == 0) {
				UnoCards newBlue = new UnoCards(i, "blue");
				deck.add(newBlue);
			}
			else {
				UnoCards newBlue = new UnoCards(i, "blue");
				UnoCards newBlue2 = new UnoCards(i, "blue");
				deck.add(newBlue);
				deck.add(newBlue2);
			}
		}

		//creates all of the red number cards
		for(int i = 0; i < 10; i++) {
			if(i == 0) {
				UnoCards newRed = new UnoCards(i, "red");
				deck.add(newRed);
			}
			else {
				UnoCards newRed = new UnoCards(i, "red");
				UnoCards newRed2 = new UnoCards(i, "red");
				deck.add(newRed);
				deck.add(newRed2);
			}
		}

		//creates all of the yellow number cards
		for(int i = 0; i < 10; i++) {
			if(i == 0) {
				UnoCards newYellow = new UnoCards(i, "yellow");
				deck.add(newYellow);
			}
			else {
				UnoCards newYellow = new UnoCards(i, "yellow");
				UnoCards newYellow2 = new UnoCards(i, "yellow");
				deck.add(newYellow);
				deck.add(newYellow2);
			}
		}

		//creates all of the green number cards
		for(int i = 0; i < 10; i++) {
			if(i == 0) {
				UnoCards newGreen = new UnoCards(i, "green");
				deck.add(newGreen);
			}
			else {
				UnoCards newGreen = new UnoCards(i, "green");
				UnoCards newGreen2 = new UnoCards(i, "green");
				deck.add(newGreen);
				deck.add(newGreen2);
			}
		}


		//creates the wild cards
		for(int i = 0; i < 8; i++) {
			//creates the 4 basic wilds
			if(i < 4) {
				UnoCards newWild = new UnoCards("white", -1, true, false, false, false, false);
				deck.add(newWild);
			}

			//creates the 4 plus 4 wilds
			else {
				UnoCards newWild = new UnoCards("white", -1, true, false, true, false, false);
				deck.add(newWild);
			}

		}

		//creates the blue reverse, skip, plus2 cards
		for(int i = 0; i < 2; i++) {
			UnoCards newBlueReverse = new UnoCards("blue",-2, false, false, false, true, false);
			UnoCards newBlueSkip = new UnoCards("blue", -3, false, false, false, false, true);
			UnoCards newBluePlus2 = new UnoCards("blue", -4, false, true, false, false, false);

			deck.add(newBlueReverse);
			deck.add(newBlueSkip);
			deck.add(newBluePlus2);
		}

		//creates the red reverse, skip, plus2 cards
		for(int i = 0; i < 2; i++) {
			UnoCards newRedReverse = new UnoCards("red", -2, false, false, false, true, false);
			UnoCards newRedSkip = new UnoCards("red", -3, false, false, false, false, true);
			UnoCards newRedPlus2 = new UnoCards("red", -4, false, true, false, false, false);

			deck.add(newRedReverse);
			deck.add(newRedSkip);
			deck.add(newRedPlus2);
		}

		//creates the yellow reverse, skip, plus2, and plus4 cards
		for(int i = 0; i < 2; i++) {
			UnoCards newYellowReverse = new UnoCards("yellow", -2, false, false, false, true, false);
			UnoCards newYellowSkip = new UnoCards("yellow", -3, false, false, false, false, true);
			UnoCards newYellowPlus2 = new UnoCards("yellow", -4, false, true, false, false, false);

			deck.add(newYellowReverse);
			deck.add(newYellowSkip);
			deck.add(newYellowPlus2);
		}

		//creates the green reverse, skip, plus2, and plus4 cards
		for(int i = 0; i < 2; i++) {
			UnoCards newGreenReverse = new UnoCards("green", -2, false, false, false, true, false);
			UnoCards newGreenSkip = new UnoCards("green", -3, false, false, false, false, true);
			UnoCards newGreenPlus2 = new UnoCards("green", -4, false, true, false, false, false);

			deck.add(newGreenReverse);
			deck.add(newGreenSkip);
			deck.add(newGreenPlus2);
		}

		//shuffles the deck before returning it
		shuffleDeck(deck);

		return deck;
	}

	public void shuffleDeck(ArrayList<UnoCards> deck) {
		Collections.shuffle(deck);
	}

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

	public void reshuffle() {

		if(deck.size() == 0) {

			//adds each card from the discard pile back into the draw pile, except the last one (the card on top)
			while(discardPile.size() > 1) {
				deck.add(discardPile.get(0));
				discardPile.remove(0);
			}

			shuffleDeck(deck);
		}
	}


}



