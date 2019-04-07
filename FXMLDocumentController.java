/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uno;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

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
	
	/** The menu item to exit the game (under 'File'). */
    @FXML
    private MenuItem exitButton;
    
    /** The menu item to show the game rules (under Help). */
    @FXML
    private MenuItem howToPlay;
    
    /** How many cards player 1 has left. */
    @FXML
    private Label player1CardsLeft;
    
    /** How many cards player 2 has left. */
    @FXML
    private Label player2CardsLeft;
    
    /** How many cards player 3 has left. */
    @FXML
    private Label player3CardsLeft;
    
    /** How many cards player 4 has left. */
    @FXML
    private Label player4CardsLeft;
    
    @FXML
    private Label currentColor;
    
    
    /**
     * Method that acts as a listener for the exit Game button in the 
     * File menu.
     * 
     * @param e  - the exitGame button being pressed.
     */
    @FXML
    private void exitGame(final ActionEvent e) {
        System.exit(0);
    }
    
    @FXML
    private void howToPlay(final ActionEvent e) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Uno Rules");
    	alert.setHeaderText("How to Play Uno");

    	Label label = new Label("How to Play Uno: ");

    	TextArea textArea = new TextArea("Every player starts with 7 cards. \n"
    			+ "The goal is to be the first player to play all the cards in their hand. "
    			+ "Players can play any of the cards in their hand. They must play one that "
    			+ "matches the discard pile's color or number. If the player has no applicable "
    			+ "cards, then they can play a wild card to change the color, or draw a card "
    			+ "from the pile. This will complete their turn. "
    			+ "If a player is dealt a draw 2 or plus 4 this is also their complete turn. "
    			+ "Anytime a player has to draw a card on their turn, their turn is now over.\n"
    			+ "When a player has played all their cards in their hand, the game is now over.");
    	textArea.setEditable(false);
    	textArea.setWrapText(true);

    	textArea.setMaxWidth(Double.MAX_VALUE);
    	textArea.setMaxHeight(Double.MAX_VALUE);
    	GridPane.setVgrow(textArea, Priority.ALWAYS);
    	GridPane.setHgrow(textArea, Priority.ALWAYS);

    	GridPane expContent = new GridPane();
    	expContent.setMaxWidth(Double.MAX_VALUE);
    	expContent.add(label, 0, 0);
    	expContent.add(textArea, 0, 1);

    	alert.getDialogPane().setExpandableContent(expContent);

    	alert.showAndWait();
    }

	/**
	 * Method that acts as an action listener for the draw card button.
	 * 
	 * @param e - the drawButton being pressed.
	 */
	@FXML
	private void drawCard(final ActionEvent e) {
		System.out.println("Card is Drawn");

		game.reshuffle();
		
		game.drawCard(game.currentPlayer(), 1);
		
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
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText("Player 1 wins!");
				alert.showAndWait();
				System.exit(0);
			}
			
			displayBoard();
				
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Not a valid move!");
			alert.showAndWait();
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
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText("Player 2 Wins!");
				alert.showAndWait();
				System.exit(0);
			}
			
			displayBoard();
			
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Not a valid move!");
			alert.showAndWait();
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
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText("Player 3 Wins!");
				alert.showAndWait();
				System.exit(0);
			}
			
			displayBoard();
			
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Not a valid move!");
			alert.showAndWait();
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
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText("Player 4 Wins!");
				alert.showAndWait();
				System.exit(0);
			}
			
			displayBoard();
			
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Not a valid move!");
			alert.showAndWait();
		}
	}


	
	/**
	 * Method that provides a pop up window when a wild card is played
	 * so the player can select a new color.
	 */
	private void changeColor() {
		

		List<String> choices = new ArrayList<>();
		choices.add("red");
		choices.add("green");
		choices.add("blue");
		choices.add("yellow");
		
		Optional<String> input;

		ChoiceDialog<String> dialog = new ChoiceDialog<>("red", choices);
		dialog.setTitle("Wild Card");
		//dialog.setHeaderText("Look, a Choice Dialog");
		dialog.setContentText("Choose Select a New Color:");
		
		do {
			
		input = dialog.showAndWait();
		
		
		if(input.get().equals(game.getDiscardPile().get(game.getDiscardPile().size() - 1).getCardColor())) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Can't select the same color!");
			alert.showAndWait();
			
		}
		
		
		else {
			
			if (input.get().equals("red"))	{
				game.currentPlayer().getCurrentCard().setCardColor("red");
			}

			else if (input.get().equals("green")) {
				game.currentPlayer().getCurrentCard().setCardColor("green");
			}

			else if (input.get().equals("blue"))	{
				game.currentPlayer().getCurrentCard().setCardColor("blue");
			}

			else if (input.get().equals("yellow"))	{
				game.currentPlayer().getCurrentCard().setCardColor("yellow");
			}
		}
		
	}while(input.get().equals(game.getDiscardPile().get(game.getDiscardPile().size() - 1).getCardColor()));
		
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
		
		player1CardsLeft.setText("Cards Left: " + game.getPlayer1().getPlayerDeck().size());
		player2CardsLeft.setText("Cards Left: " + game.getPlayer2().getPlayerDeck().size());
		player3CardsLeft.setText("Cards Left: " + game.getPlayer3().getPlayerDeck().size());
		player4CardsLeft.setText("Cards Left: " + game.getPlayer4().getPlayerDeck().size());
		currentColor.setText("Current Color: " + (game.getDiscardPile().get(game.getDiscardPile().size()-1).getCardColor()));
				
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
		for(int i =0; i < game.getDeck().size(); i++) {
			if(!(game.getDeck().get(i).getIsWild() || game.getDeck().get(i).getIsReverse() ||
					game.getDeck().get(i).getIsSkip() || game.getDeck().get(i).getIsPlus2())) {
				game.getDiscardPile().add(game.getDeck().get(i));
				game.getDeck().remove(i);
			}
		}

		//initialize the current cards in each players hand
		//(the card they are looking at)
		game.getPlayer1().setCurrentCard(game.getPlayer1().getPlayerDeck().get(0));
		game.getPlayer2().setCurrentCard(game.getPlayer2().getPlayerDeck().get(0));
		game.getPlayer3().setCurrentCard(game.getPlayer3().getPlayerDeck().get(0));
		game.getPlayer4().setCurrentCard(game.getPlayer4().getPlayerDeck().get(0));

		displayBoard();
	}
	/**
	//START
	TranslateTransition move = new TranslateTransition();
	move.setDuration(Duration.seconds(2));
	move.setNode(player1Card);
	player1Card.toFront();
	double origX = player1Card.getLayoutX();
	double origY = player1Card.getLayoutY();
	move.setToX(discardPile.getLayoutX() - origX);
	move.setToY(discardPile.getLayoutY() - origY);
	move.play();
	//END
	**/

}
