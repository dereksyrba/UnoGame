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
 *
 * @author johnathon
 */
public class FXMLDocumentController implements Initializable {

	UnoGame game = new UnoGame();

	@FXML
	private Button drawButton;

	@FXML
	private Label discardPile;

	@FXML
	private Button player1PlayCard;

	@FXML
	private Button player1Next;

	@FXML
	private Button player1Prev;

	@FXML
	private Button player2PlayCard;

	@FXML
	private Button player2Next;

	@FXML
	private Button player2Prev;

	@FXML
	private Button player3PlayCard;

	@FXML
	private Button player3Next;

	@FXML
	private Button player3Prev;

	@FXML
	private Button player4PlayCard;

	@FXML
	private Button player4Next;

	@FXML
	private Button player4Prev;

	@FXML
	private Label player1Card;

	@FXML
	private Label player2Card;

	@FXML
	private Label player3Card;

	@FXML
	private Label player4Card;


	@FXML
	private void drawCard(ActionEvent e) {
		System.out.println("Card is Drawn");

		game.reshuffle();
		
		game.drawCard(game.currentPlayer(), 1);
		
		displayBoard();
	}

	@FXML
	private void nextCard1(ActionEvent e) {

		game.nextCard(game.player1, game.player1.getCurrentCard(), true);
		displayBoard();
	}

	@FXML
	private void prevCard1(ActionEvent e) {

		game.nextCard(game.player1, game.player1.getCurrentCard(), false);
		displayBoard();
	}

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

	@FXML
	private void nextCard2(ActionEvent e) {
		game.nextCard(game.player2, game.player2.getCurrentCard(), true);
		displayBoard();
	}


	@FXML
	private void prevCard2(ActionEvent e) {
		game.nextCard(game.player2, game.player2.getCurrentCard(), false);
		displayBoard();
	}

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

	@FXML
	private void nextCard3(ActionEvent e) {
		game.nextCard(game.player3, game.player3.getCurrentCard(), true);
		displayBoard();
	}

	@FXML
	private void prevCard3(ActionEvent e) {
		game.nextCard(game.player3, game.player3.getCurrentCard(), false);
		displayBoard();
	}

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

	@FXML
	private void nextCard4(ActionEvent e) {
		game.nextCard(game.player4, game.player4.getCurrentCard(), true);
		displayBoard();
	}

	@FXML
	private void prevCard4(ActionEvent e) {
		game.nextCard(game.player4, game.player4.getCurrentCard(), false);
		displayBoard();
	}

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
