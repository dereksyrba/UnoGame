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

/**
 *This class is the controller for all components of the GUI,
 *containing each component's action listener and related game logic
 *to link the GUI to the UnoGame class
 *
 * @author Derek Syrba, John Frocillo, and Adrian Harrell
 */
public class FXMLDocumentController implements Initializable {

	/**The UnoGame object to handle all of the logic in the game*/
	UnoGame game = new UnoGame();

	/**The button the player presses to draw a card from the deck*/
	@FXML
	private Button drawButton;

	/**The label to show the top card of the discard pile*/
	@FXML
	private Label discardPile;

	/**The button player 1 presses to play the current card they are
	 * viewing in their hand*/
	@FXML
	private Button player1PlayCard;

	/**The button that shows the next card in player 1's hand*/
	@FXML
	private Button player1Next;

	/**The button that shows the previous card in player 1's hand*/
	@FXML
	private Button player1Prev;

	/**The button player 2 presses to play the current card they are
	 * viewing in their hand*/
	@FXML
	private Button player2PlayCard;

	/**The button that shows the next card in player 2's hand*/
	@FXML
	private Button player2Next;

	/**The button that shows the previous card in player 2's hand*/
	@FXML
	private Button player2Prev;

	/**The button player 3 presses to play the current card they are
	 * viewing in their hand*/
	@FXML
	private Button player3PlayCard;

	/**The button that shows the next card in player 3's hand*/
	@FXML
	private Button player3Next;

	/**The button that shows the previous card in player 3's hand*/
	@FXML
	private Button player3Prev;

	/**The button player 4 presses to play the current card they are
	 * viewing in their hand*/
	@FXML
	private Button player4PlayCard;

	/**The button that shows the next card in player 4's hand*/
	@FXML
	private Button player4Next;

	/**The button that shows the previous card in player 4's hand*/
	@FXML
	private Button player4Prev;

	/**The label that shows the current card in player 1's hand*/
	@FXML
	private Label player1Card;

	/**The label that shows the current card in player 2's hand*/
	@FXML
	private Label player2Card;

	/**The label that shows the current card in player 3's hand*/
	@FXML
	private Label player3Card;

	/**The label that shows the current card in player 4's hand*/
	@FXML
	private Label player4Card;


	/**
	 * Method that acts as an action listener for the draw card button
	 * 
	 * @param e - the drawButton being pressed
	 */
	@FXML
	private void drawCard(ActionEvent e) {
		System.out.println("Card is Drawn");

		game.reshuffle();
		
		game.drawCard(game.currentPlayer(), 1);
		
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 1's next
	 * card button
	 * 
	 * @param e - the player1Next button being pressed
	 */
	@FXML
	private void nextCard1(ActionEvent e) {

		game.nextCard(game.player1, game.player1.getCurrentCard(), true);
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 1's previous
	 * card button
	 * 
	 * @param e - the player1Prev button being pressed
	 */
	@FXML
	private void prevCard1(ActionEvent e) {

		game.nextCard(game.player1, game.player1.getCurrentCard(), false);
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener player 1's play card
	 * button
	 * 
	 * @param e - the player1PlayCard button being pressed
	 */
	@FXML
	private void playCard1(ActionEvent e) {
		if(game.isValid(game.player1.getCurrentCard(), game.discardPile.get(game.discardPile.size() - 1))){
			if(game.player1.getCurrentCard().getIsWild()) {
				changeColor();
			}
			game.playCard(game.player1, game.player1.getCurrentCard());
			
			if(game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "Player 1 Wins!");
				System.exit(0);
			}
			
			displayBoard();
				
		}
		else
			JOptionPane.showMessageDialog(null, "Not a valid move");

	}

	
	/**
	 * Method that acts as an action listener for player 2's next
	 * card button
	 * 
	 * @param e - the player2Next button being pressed
	 */
	@FXML
	private void nextCard2(ActionEvent e) {
		game.nextCard(game.player2, game.player2.getCurrentCard(), true);
		displayBoard();
	}


	/**
	 * Method that acts as an action listener for player 2's previous
	 * card button
	 * 
	 * @param e - the player2Prev button being pressed
	 */
	@FXML
	private void prevCard2(ActionEvent e) {
		game.nextCard(game.player2, game.player2.getCurrentCard(), false);
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 2's play card
	 * button
	 * 
	 * @param e - the player2PlayCard button being pressed
	 */
	@FXML
	private void playCard2(ActionEvent e) {
		if(game.isValid(game.player2.getCurrentCard(), game.discardPile.get(game.discardPile.size() - 1))){
			if(game.player2.getCurrentCard().getIsWild()) {
				changeColor();
			}
			game.playCard(game.player2, game.player2.getCurrentCard());
			
			if(game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "Player 2 Wins!");
				System.exit(0);
			}
			
			displayBoard();
		}
		else
			JOptionPane.showMessageDialog(null, "Not a valid move");
	}

	
	/**
	 * Method that acts as an action listener for player 3's next
	 * card button
	 * 
	 * @param e - the player3Next button being pressed
	 */
	@FXML
	private void nextCard3(ActionEvent e) {
		game.nextCard(game.player3, game.player3.getCurrentCard(), true);
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 3's previous
	 * card button
	 * 
	 * @param e - the player3Prev button being pressed
	 */
	@FXML
	private void prevCard3(ActionEvent e) {
		game.nextCard(game.player3, game.player3.getCurrentCard(), false);
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 3's play
	 * card button
	 * 
	 * @param e - the player3PlayCard button being pressed
	 */
	@FXML
	private void playCard3(ActionEvent e) {
		if(game.isValid(game.player3.getCurrentCard(), game.discardPile.get(game.discardPile.size() - 1))){
			if(game.player3.getCurrentCard().getIsWild()) {
				changeColor();
			}
			game.playCard(game.player3, game.player3.getCurrentCard());
			
			if(game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "Player 3 Wins!");
				System.exit(0);
			}
			
			displayBoard();
		}
		else
			JOptionPane.showMessageDialog(null, "Not a valid move");
	}

	
	/**
	 * Method that acts as an action listener for player 4's next
	 * card button
	 * 
	 * @param e - the player4Next button being pressed
	 */
	@FXML
	private void nextCard4(ActionEvent e) {
		game.nextCard(game.player4, game.player4.getCurrentCard(), true);
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 4's previous
	 * card button
	 * 
	 * @param e - the player4Prev button being pressed
	 */
	@FXML
	private void prevCard4(ActionEvent e) {
		game.nextCard(game.player4, game.player4.getCurrentCard(), false);
		displayBoard();
	}

	
	/**
	 * Method that acts as an action listener for player 4's play
	 * card button
	 * 
	 * @param e - the player4PlayCard button being pressed
	 */
	@FXML
	private void playCard4(ActionEvent e) {
		if(game.isValid(game.player4.getCurrentCard(), game.discardPile.get(game.discardPile.size() - 1))){
			if(game.player4.getCurrentCard().getIsWild()) {
				changeColor();
			}
			game.playCard(game.player4, game.player4.getCurrentCard());
			
			if(game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "Player 4 Wins!");
				System.exit(0);
			}
			
			displayBoard();
		}
		else
			JOptionPane.showMessageDialog(null, "Not a valid move");
	}


	
	/**
	 * Method that provides a pop up window when a wild card is played
	 * so the player can select a new color
	 */
	private void changeColor() {

		String[] a = {"red", "green", "blue", "yellow"};
		String input = (String)JOptionPane.showInputDialog( null,
				"Select A New Color:", "Wild", JOptionPane.QUESTION_MESSAGE,
				null, a, a[0]);

		if(input == null || input.length() == 0)
			game.currentPlayer().getCurrentCard().setCardColor("red");


		//FIXME:
		if(!(input.equals(game.currentPlayer().getCurrentCard().getCardColor()))) {

			if(input.equals("red"))	{
				game.currentPlayer().getCurrentCard().setCardColor("red");
			}

			if(input.equals("green"))	{
				game.currentPlayer().getCurrentCard().setCardColor("green");
			}

			if(input.equals("blue"))	{
				game.currentPlayer().getCurrentCard().setCardColor("blue");
			}

			if(input.equals("yellow"))	{
				game.currentPlayer().getCurrentCard().setCardColor("yellow");
			}
		}

		else {

			JOptionPane.showMessageDialog(null, "Can't select the same color");

		}
	}

	
	/**
	 * Method that updates the the labels in the game display each time
	 * a button is pressed or a turn changes
	 */
	private void displayBoard() {
		if(game.player1.getCurrentCard().getIsPlus2()) {
			player1Card.setText("+2");
		}
		else if(game.player1.getCurrentCard().getIsPlus4()) {
			player1Card.setText("Wild: +4");
		}
		else if(game.player1.getCurrentCard().getIsReverse()) {
			player1Card.setText("Reverse");
		}
		else if(game.player1.getCurrentCard().getIsSkip()) {
			player1Card.setText("Skip");
		}
		else if(game.player1.getCurrentCard().getIsWild()) {
			player1Card.setText("Wild");
		}
		else {
			player1Card.setText(Integer.toString(game.player1.getCurrentCard().getCardNumber()));
		}

		if(game.player2.getCurrentCard().getIsPlus2()) {
			player2Card.setText("+2");
		}
		else if(game.player2.getCurrentCard().getIsPlus4()) {
			player2Card.setText("Wild: +4");
		}
		else if(game.player2.getCurrentCard().getIsReverse()) {
			player2Card.setText("Reverse");
		}
		else if(game.player2.getCurrentCard().getIsSkip()) {
			player2Card.setText("Skip");
		}
		else if(game.player2.getCurrentCard().getIsWild()) {
			player2Card.setText("Wild");
		}
		else {
			player2Card.setText(Integer.toString(game.player2.getCurrentCard().getCardNumber()));
		}

		if(game.player3.getCurrentCard().getIsPlus2()) {
			player3Card.setText("+2");
		}
		else if(game.player3.getCurrentCard().getIsPlus4()) {
			player3Card.setText("Wild: +4");
		}
		else if(game.player3.getCurrentCard().getIsReverse()) {
			player3Card.setText("Reverse");
		}
		else if(game.player3.getCurrentCard().getIsSkip()) {
			player3Card.setText("Skip");
		}
		else if(game.player3.getCurrentCard().getIsWild()) {
			player3Card.setText("Wild");
		}
		else {
			player3Card.setText(Integer.toString(game.player3.getCurrentCard().getCardNumber()));
		}

		if(game.player4.getCurrentCard().getIsPlus2()) {
			player4Card.setText("+2");
		}
		else if(game.player4.getCurrentCard().getIsPlus4()) {
			player4Card.setText("Wild: +4");
		}
		else if(game.player4.getCurrentCard().getIsReverse()) {
			player4Card.setText("Reverse");
		}
		else if(game.player4.getCurrentCard().getIsSkip()) {
			player4Card.setText("Skip");
		}
		else if(game.player4.getCurrentCard().getIsWild()) {
			player4Card.setText("Wild");
		}
		else {
			player4Card.setText(Integer.toString(game.player4.getCurrentCard().getCardNumber()));
		}


		player1Card.setStyle("-fx-background-color: " + game.player1.getCurrentCard().getCardColor());
		player2Card.setStyle("-fx-background-color: " + game.player2.getCurrentCard().getCardColor());
		player3Card.setStyle("-fx-background-color: " + game.player3.getCurrentCard().getCardColor());
		player4Card.setStyle("-fx-background-color: " + game.player4.getCurrentCard().getCardColor());

		discardPile.setStyle("-fx-background-color: " + game.discardPile.get(game.discardPile.size() - 1).getCardColor());

		if(game.discardPile.get(game.discardPile.size() - 1).getIsPlus2()) {
			discardPile.setText("+2");
		}
		else if(game.discardPile.get(game.discardPile.size() - 1).getIsPlus4()) {
			discardPile.setText("Wild: +4");
		}
		else if(game.discardPile.get(game.discardPile.size() - 1).getIsReverse()) {
			discardPile.setText("Reverse");
		}
		else if(game.discardPile.get(game.discardPile.size() - 1).getIsSkip()) {
			discardPile.setText("Skip");
		}
		else if(game.discardPile.get(game.discardPile.size() - 1).getIsWild()) {
			discardPile.setText("Wild");
		}
		else {
			discardPile.setText(Integer.toString(game.discardPile.get(game.discardPile.size() - 1).getCardNumber()));
		}

		if(game.player1.getIsPlayerTurn() == false) {
			player1PlayCard.setVisible(false);
			player1Next.setVisible(false);
			player1Prev.setVisible(false);
			player1Card.setVisible(false);
		}
		else {
			player1PlayCard.setVisible(true);
			player1Next.setVisible(true);
			player1Prev.setVisible(true);
			player1Card.setVisible(true);
		}

		if(game.player2.getIsPlayerTurn() == false) {
			player2PlayCard.setVisible(false);
			player2Next.setVisible(false);
			player2Prev.setVisible(false);
			player2Card.setVisible(false);
		}
		else {
			player2PlayCard.setVisible(true);
			player2Next.setVisible(true);
			player2Prev.setVisible(true);
			player2Card.setVisible(true);
		}

		if(game.player3.getIsPlayerTurn() == false) {
			player3PlayCard.setVisible(false);
			player3Next.setVisible(false);
			player3Prev.setVisible(false);
			player3Card.setVisible(false);
		}
		else {
			player3PlayCard.setVisible(true);
			player3Next.setVisible(true);
			player3Prev.setVisible(true);
			player3Card.setVisible(true);
		}

		if(game.player4.getIsPlayerTurn() == false) {
			player4PlayCard.setVisible(false);
			player4Next.setVisible(false);
			player4Prev.setVisible(false);
			player4Card.setVisible(false);
		}
		else {
			player4PlayCard.setVisible(true);
			player4Next.setVisible(true);
			player4Prev.setVisible(true);
			player4Card.setVisible(true);
		}

	}


	/**
	 * Method that sets up the initial game display when the program
	 * is first run
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		//deals the cards to players
		game.dealDeck();

		//plays the first card
		game.discardPile.add(game.deck.get(0));
		game.deck.remove(0);

		//initialize the current cards in each players hand(the card they are looking at)
		game.player1.setCurrentCard(game.player1.getPlayerDeck().get(0));
		game.player2.setCurrentCard(game.player2.getPlayerDeck().get(0));
		game.player3.setCurrentCard(game.player3.getPlayerDeck().get(0));
		game.player4.setCurrentCard(game.player4.getPlayerDeck().get(0));

		displayBoard();


	}    

}
