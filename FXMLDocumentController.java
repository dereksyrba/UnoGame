/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uno;

import java.net.URL;

import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *This class is the controller for all components of the GUI,
 *containing each component's action listener and related game logic
 *to link the GUI to the UnoGame class.
 *
 * @author Derek Syrba, John Frocillo, and Adrian Harrell
 */
public class FXMLDocumentController implements Initializable {

	/**The UnoGame object to handle all of the logic in the game.*/
	private UnoGame game = new UnoGame();

	/**The button the player presses to draw a card from the deck.*/
	@FXML
	private Button drawButton;

	/**The label to show the top card of the discard pile.*/
	@FXML
	private Label discardPile;

	/**The button player 1 presses to play the current card they are
	 * viewing in their hand.*/
	@FXML
	private Button player1PlayCard;

	/**The button that shows the next card in player 1's hand.*/
	@FXML
	private Button player1Next;

	/**The button that shows the previous card in player 1's hand.*/
	@FXML
	private Button player1Prev;

	/**The button player 2 presses to play the current card they are
	 * viewing in their hand.*/
	@FXML
	private Button player2PlayCard;

	/**The button that shows the next card in player 2's hand.*/
	@FXML
	private Button player2Next;

	/**The button that shows the previous card in player 2's hand.*/
	@FXML
	private Button player2Prev;

	/**The button player 3 presses to play the current card they are
	 * viewing in their hand.*/
	@FXML
	private Button player3PlayCard;

	/**The button that shows the next card in player 3's hand.*/
	@FXML
	private Button player3Next;

	/**The button that shows the previous card in player 3's hand.*/
	@FXML
	private Button player3Prev;

	/**The button player 4 presses to play the current card they are
	 * viewing in their hand.*/
	@FXML
	private Button player4PlayCard;

	/**The button that shows the next card in player 4's hand.*/
	@FXML
	private Button player4Next;

	/**The button that shows the previous card in player 4's hand.*/
	@FXML
	private Button player4Prev;

	/**The label that shows the current card in player 1's hand.*/
	@FXML
	private Label player1Card;

	/**The label that shows the current card in player 2's hand.*/
	@FXML
	private Label player2Card;

	/**The label that shows the current card in player 3's hand.*/
	@FXML
	private Label player3Card;

	/**The label that shows the current card in player 4's hand.*/
	@FXML
	private Label player4Card;


	/**
	 * Method that acts as an action listener for the draw card button.
	 * 
	 * @param e - the drawButton being pressed.
	 */
	@FXML
	private void drawCard(final ActionEvent e) {

		game.reshuffle();

		try {
			game.drawCard(game.currentPlayer(), 1);
		} catch (IndexOutOfBoundsException x) {
			System.out.println("Error: no more cards in the deck");
		}

		displayBoard();
	}


	/**
	 * Method that acts as an action listener for player 1's next
	 * card button.
	 * 
	 * @param e - the player1Next button being pressed.
	 */
	@FXML
	private void nextCard1(final ActionEvent e) {

		game.nextCard(game.getPlayer1(), 
				game.getPlayer1().getCurrentCard(), true);
		displayBoard();
	}


	/**
	 * Method that acts as an action listener for player 1's previous
	 * card button.
	 * 
	 * @param e - the player1Prev button being pressed.
	 */
	@FXML
	private void prevCard1(final ActionEvent e) {

		game.nextCard(game.getPlayer1(), 
				game.getPlayer1().getCurrentCard(), false);
		displayBoard();
	}


	/**
	 * Method that acts as an action listener player 1's play card
	 * button.
	 * 
	 * @param e - the player1PlayCard button being pressed.
	 */
	@FXML
	private void playCard1(final ActionEvent e) {
		if (game.isValid(game.getPlayer1().getCurrentCard(), 
				game.getDiscardPile().get(game.getDiscardPile().size() - 1))) {

			if (game.getPlayer1().getCurrentCard().getIsWild()) {
				changeColor();
			}
			game.playCard(game.getPlayer1(), game.getPlayer1().getCurrentCard());

			if (game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "Player 1 Wins!");
				System.exit(0);
			}

			displayBoard();

		} else {
			JOptionPane.showMessageDialog(null, "Not a valid move");
		}

	}


	/**
	 * Method that acts as an action listener for player 2's next
	 * card button.
	 * 
	 * @param e - the player2Next button being pressed.
	 */
	@FXML
	private void nextCard2(final ActionEvent e) {
		game.nextCard(game.getPlayer2(), game.getPlayer2().getCurrentCard(), 
				true);

		displayBoard();
	}


	/**
	 * Method that acts as an action listener for player 2's previous
	 * card button.
	 * 
	 * @param e - the player2Prev button being pressed.
	 */
	@FXML
	private void prevCard2(final ActionEvent e) {
		game.nextCard(game.getPlayer2(), game.getPlayer2().getCurrentCard(), 
				false);

		displayBoard();
	}


	/**
	 * Method that acts as an action listener for player 2's play card
	 * button.
	 * 
	 * @param e - the player2PlayCard button being pressed.
	 */
	@FXML
	private void playCard2(final ActionEvent e) {
		if (game.isValid(game.getPlayer2().getCurrentCard(), 
				game.getDiscardPile().get(game.getDiscardPile().size() - 1))) {

			if (game.getPlayer2().getCurrentCard().getIsWild()) {
				changeColor();
			}

			game.playCard(game.getPlayer2(), game.getPlayer2().getCurrentCard());

			if (game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "Player 2 Wins!");
				System.exit(0);
			}

			displayBoard();

		} else {
			JOptionPane.showMessageDialog(null, "Not a valid move");
		}
	}


	/**
	 * Method that acts as an action listener for player 3's next
	 * card button.
	 * 
	 * @param e - the player3Next button being pressed.
	 */
	@FXML
	private void nextCard3(final ActionEvent e) {
		game.nextCard(game.getPlayer3(), game.getPlayer3().getCurrentCard(), true);
		displayBoard();
	}


	/**
	 * Method that acts as an action listener for player 3's previous
	 * card button.
	 * 
	 * @param e - the player3Prev button being pressed.
	 */
	@FXML
	private void prevCard3(final ActionEvent e) {
		game.nextCard(game.getPlayer3(), game.getPlayer3().getCurrentCard(), false);
		displayBoard();
	}


	/**
	 * Method that acts as an action listener for player 3's play
	 * card button.
	 * 
	 * @param e - the player3PlayCard button being pressed.
	 */
	@FXML
	private void playCard3(final ActionEvent e) {
		if (game.isValid(game.getPlayer3().getCurrentCard(), 
				game.getDiscardPile().get(game.getDiscardPile().size() - 1))) {

			if (game.getPlayer3().getCurrentCard().getIsWild()) {
				changeColor();
			}

			game.playCard(game.getPlayer3(), game.getPlayer3().getCurrentCard());

			if (game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "Player 3 Wins!");
				System.exit(0);
			}

			displayBoard();

		} else {
			JOptionPane.showMessageDialog(null, "Not a valid move");
		}
	}


	/**
	 * Method that acts as an action listener for player 4's next
	 * card button.
	 * 
	 * @param e - the player4Next button being pressed.
	 */
	@FXML
	private void nextCard4(final ActionEvent e) {
		game.nextCard(game.getPlayer4(), game.getPlayer4().getCurrentCard(), true);
		displayBoard();
	}


	/**
	 * Method that acts as an action listener for player 4's previous
	 * card button.
	 * 
	 * @param e - the player4Prev button being pressed.
	 */
	@FXML
	private void prevCard4(final ActionEvent e) {
		game.nextCard(game.getPlayer4(), game.getPlayer4().getCurrentCard(), 
				false);

		displayBoard();
	}


	/**
	 * Method that acts as an action listener for player 4's play
	 * card button.
	 * 
	 * @param e - the player4PlayCard button being pressed.
	 */
	@FXML
	private void playCard4(final ActionEvent e) {
		if (game.isValid(game.getPlayer4().getCurrentCard(), 
				game.getDiscardPile().get(game.getDiscardPile().size() - 1))) {

			if (game.getPlayer4().getCurrentCard().getIsWild()) {
				changeColor();
			}

			game.playCard(game.getPlayer4(), game.getPlayer4().getCurrentCard());

			if (game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "Player 4 Wins!");
				System.exit(0);
			}

			displayBoard();

		} else {
			JOptionPane.showMessageDialog(null, "Not a valid move");
		}
	}



	/**
	 * Method that provides a pop up window when a wild card is played
	 * so the player can select a new color.
	 */
	private void changeColor() {

		String[] a = {"red", "green", "blue", "yellow"};

		String input = (String) JOptionPane.showInputDialog(null,
				"Select A New Color:", "Wild", 
				JOptionPane.QUESTION_MESSAGE, null, a, a[0]);

		if (input == null || input.length() == 0) {
			game.currentPlayer().getCurrentCard().setCardColor("red");
		}


		//FIXME:
		if (!(input.equals(game.currentPlayer().
				getCurrentCard().getCardColor()))) {

			if (input.equals("red"))	{
				game.currentPlayer().getCurrentCard().setCardColor("red");
			}

			if (input.equals("green")) {
				game.currentPlayer().getCurrentCard().setCardColor("green");
			}

			if (input.equals("blue"))	{
				game.currentPlayer().getCurrentCard().setCardColor("blue");
			}

			if (input.equals("yellow"))	{
				game.currentPlayer().getCurrentCard().setCardColor("yellow");
			}

		} else {

			JOptionPane.showMessageDialog(null, 
					"Can't select the same color");
		}
	}


	/**
	 * Method that updates the the labels in the game display each time
	 * a button is pressed or a turn changes.
	 */
	private void displayBoard() {


		String currentCardImage = game.currentPlayer().getCurrentCard().getCardColor() + 
				game.currentPlayer().getCurrentCard().getCardNumber() + ".png";
		
		String discardPileImage = game.getDiscardPile().get(game.getDiscardPile().size()-1).getCardColor() + 
				game.getDiscardPile().get(game.getDiscardPile().size()-1).getCardNumber() + ".png";

		Image cardImage = new Image(currentCardImage);
		
		Image discardImage;
		
		Image cardBack = new Image("cardBack.png");
		
		ImageView cardBackImage1 = new ImageView(cardBack);
		ImageView cardBackImage2 = new ImageView(cardBack);
		ImageView cardBackImage3 = new ImageView(cardBack);
		
		cardBackImage1.setFitHeight(180);
		cardBackImage1.setFitWidth(121);
		
		cardBackImage2.setFitHeight(180);
		cardBackImage2.setFitWidth(121);
		
		cardBackImage3.setFitHeight(180);
		cardBackImage3.setFitWidth(121);
		
		//handles the special cases of if a wild card is put into the discard pile
		if(game.getDiscardPile().get(game.getDiscardPile().size()-1).getIsWild() && 
				!(game.getDiscardPile().get(game.getDiscardPile().size()-1).getIsPlus4())) {
			discardImage = new Image("white-1.png");
		}
		else if(game.getDiscardPile().get(game.getDiscardPile().size()-1).getIsPlus4()) {
			discardImage = new Image("black-1.png");
		}
		else {
			discardImage = new Image(discardPileImage);
		}



		if(game.currentPlayer() == game.getPlayer1()) {
			

			ImageView graphic = new ImageView(cardImage);

			graphic.setFitHeight(180);
			graphic.setFitWidth(121);

			player1Card.setGraphic(graphic);
			player2Card.setGraphic(cardBackImage1);
			player3Card.setGraphic(cardBackImage2);
			player4Card.setGraphic(cardBackImage3);
			

			player1PlayCard.setVisible(true);
			player1Next.setVisible(true);
			player1Prev.setVisible(true);

			player2PlayCard.setVisible(false);
			player2Next.setVisible(false);
			player2Prev.setVisible(false);

			player3PlayCard.setVisible(false);
			player3Next.setVisible(false);
			player3Prev.setVisible(false);

			player4PlayCard.setVisible(false);
			player4Next.setVisible(false);
			player4Prev.setVisible(false);
		}

		if(game.currentPlayer() == game.getPlayer2()) {

			ImageView graphic = new ImageView(cardImage);

			graphic.setFitHeight(180);
			graphic.setFitWidth(121);

			player1Card.setGraphic(cardBackImage1);
			player2Card.setGraphic(graphic);
			player3Card.setGraphic(cardBackImage2);
			player4Card.setGraphic(cardBackImage3);

			player1PlayCard.setVisible(false);
			player1Next.setVisible(false);
			player1Prev.setVisible(false);

			player2PlayCard.setVisible(true);
			player2Next.setVisible(true);
			player2Prev.setVisible(true);

			player3PlayCard.setVisible(false);
			player3Next.setVisible(false);
			player3Prev.setVisible(false);

			player4PlayCard.setVisible(false);
			player4Next.setVisible(false);
			player4Prev.setVisible(false);
		}

		if(game.currentPlayer() == game.getPlayer3()) {

			ImageView graphic = new ImageView(cardImage);

			graphic.setFitHeight(180);
			graphic.setFitWidth(121);

			player1Card.setGraphic(cardBackImage1);
			player2Card.setGraphic(cardBackImage2);
			player3Card.setGraphic(graphic);
			player4Card.setGraphic(cardBackImage3);
			
			player1Card.setVisible(true);
			player2Card.setVisible(true);
			player3Card.setVisible(true);
			player4Card.setVisible(true);

			player1PlayCard.setVisible(false);
			player1Next.setVisible(false);
			player1Prev.setVisible(false);

			player2PlayCard.setVisible(false);
			player2Next.setVisible(false);
			player2Prev.setVisible(false);

			player3PlayCard.setVisible(true);
			player3Next.setVisible(true);
			player3Prev.setVisible(true);

			player4PlayCard.setVisible(false);
			player4Next.setVisible(false);
			player4Prev.setVisible(false);
		}

		if(game.currentPlayer() == game.getPlayer4()) {

			ImageView graphic = new ImageView(cardImage);

			graphic.setFitHeight(180);
			graphic.setFitWidth(121);

			player1Card.setGraphic(cardBackImage1);
			player2Card.setGraphic(cardBackImage2);
			player3Card.setGraphic(cardBackImage3);
			player4Card.setGraphic(graphic);
			
			player1Card.setVisible(true);
			player2Card.setVisible(true);
			player3Card.setVisible(true);
			player4Card.setVisible(true);

			player1PlayCard.setVisible(false);
			player1Next.setVisible(false);
			player1Prev.setVisible(false);

			player2PlayCard.setVisible(false);
			player2Next.setVisible(false);
			player2Prev.setVisible(false);

			player3PlayCard.setVisible(false);
			player3Next.setVisible(false);
			player3Prev.setVisible(false);

			player4PlayCard.setVisible(true);
			player4Next.setVisible(true);
			player4Prev.setVisible(true);
		}
		
		
		//displays the card at the top of the discard pile
		ImageView graphic = new ImageView(discardImage);

		graphic.setFitHeight(180);
		graphic.setFitWidth(121);

		discardPile.setGraphic(graphic);
	}



	/**
	 * Method that sets up the initial game display when the program
	 * is first run.
	 */
	@Override
	public void initialize(final URL url, final ResourceBundle rb) {

		//deals the cards to players
		game.dealDeck();

		//plays the first card
		game.getDiscardPile().add(game.getDeck().get(0));
		game.getDeck().remove(0);

		//initialize the current cards in each players hand
		//(the card they are looking at)
		game.getPlayer1().setCurrentCard(game.getPlayer1().getPlayerDeck().get(0));
		game.getPlayer2().setCurrentCard(game.getPlayer2().getPlayerDeck().get(0));
		game.getPlayer3().setCurrentCard(game.getPlayer3().getPlayerDeck().get(0));
		game.getPlayer4().setCurrentCard(game.getPlayer4().getPlayerDeck().get(0));

		displayBoard();

	}    

}
