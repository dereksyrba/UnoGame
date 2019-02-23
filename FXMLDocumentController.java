/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.net.URL;
import java.util.ResourceBundle;
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
        
        game.drawCard(game.currentPlayer(), 1);
        
        //update board icons
        
        game.changeTurn();
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
    	game.playCard(game.player1, game.player1.getCurrentCard());
        displayBoard();
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
        game.playCard(game.player2, game.player2.getCurrentCard());
        displayBoard();
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
        
    }
    
    
    
    
    private void displayBoard() {
    	player1Card.setText(Integer.toString(game.player1.getCurrentCard().getCardNumber()));
    	player2Card.setText(Integer.toString(game.player2.getCurrentCard().getCardNumber()));
    	player3Card.setText(Integer.toString(game.player3.getCurrentCard().getCardNumber()));
    	player4Card.setText(Integer.toString(game.player4.getCurrentCard().getCardNumber()));
    	
    	player1Card.setStyle("-fx-background-color: " + game.player1.getCurrentCard().getCardColor());
    	player2Card.setStyle("-fx-background-color: " + game.player2.getCurrentCard().getCardColor());
    	player3Card.setStyle("-fx-background-color: " + game.player3.getCurrentCard().getCardColor());
    	player4Card.setStyle("-fx-background-color: " + game.player4.getCurrentCard().getCardColor());
    }
            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	//deals the cards to players
    	game.dealDeck();
    	
    	//initialize the current cards in each players hand(the card they are looking at)
    	game.player1.setCurrentCard(game.player1.getPlayerDeck().get(0));
    	game.player2.setCurrentCard(game.player2.getPlayerDeck().get(0));
    	game.player3.setCurrentCard(game.player3.getPlayerDeck().get(0));
    	game.player4.setCurrentCard(game.player4.getPlayerDeck().get(0));
    	
    	
    }    
    
}
