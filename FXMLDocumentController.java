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
        
        System.out.println(game.player1.getCurrentCard().getCardColor());
        System.out.println(game.player1.getCurrentCard().getCardNumber());
        System.out.println(game.player1.getCurrentCard().getIsWild());
        System.out.println(game.player1.getCurrentCard().getIsReverse());
        System.out.println(game.player1.getCurrentCard().getIsSkip());
        System.out.println(game.player1.getCurrentCard().getIsPlus2());
        System.out.println(game.player1.getCurrentCard().getIsPlus4());
    }
    
    @FXML
    private void prevCard1(ActionEvent e) {
        
        game.nextCard(game.player1, game.player1.getCurrentCard(), false);
        
        System.out.println(game.player1.getCurrentCard().getCardColor());
        System.out.println(game.player1.getCurrentCard().getCardNumber());
        System.out.println(game.player1.getCurrentCard().getIsWild());
        System.out.println(game.player1.getCurrentCard().getIsReverse());
        System.out.println(game.player1.getCurrentCard().getIsSkip());
        System.out.println(game.player1.getCurrentCard().getIsPlus2());
        System.out.println(game.player1.getCurrentCard().getIsPlus4());
    }
    
    @FXML
    private void playCard1(ActionEvent e) {
    	
    }
    
    @FXML
    private void nextCard2(ActionEvent e) {
        System.out.println("Player two views the next card");
    }
    
    
    @FXML
    private void prevCard2(ActionEvent e) {
        
    }
    
    @FXML
    private void playCard2(ActionEvent e) {
        
    }
    
    @FXML
    private void nextCard3(ActionEvent e) {
        
    }
    
    @FXML
    private void prevCard3(ActionEvent e) {
        
    }
    
    @FXML
    private void playCard3(ActionEvent e) {
        
    }
    
    @FXML
    private void nextCard4(ActionEvent e) {
        
    }
    
    @FXML
    private void prevCard4(ActionEvent e) {
        
    }
    
    @FXML
    private void playCard4(ActionEvent e) {
        
    }
    
    
    
    
    
    private void displayBoard() {
    	//need a current card method
    	//if(player.currentcard == "x card" then display that image
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
