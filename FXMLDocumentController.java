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
    }
    
    @FXML
    private void nextCard1(ActionEvent e) {
        System.out.println("Player one views the next card");
        //COPY THE FOLLOWING TWO LINES TO EVERY next AND prev METHODS
        int index = game.player1.getPlayerDeck().indexOf(game.player1.getCurrentCard()) + 1;
        
        game.player1.setCurrentCard(game.player1.getPlayerDeck().get(index));
    }
    
    @FXML
    private void prevCard1(ActionEvent e) {
        System.out.println("Player one views the previous card");
    }
    
    @FXML
    private void nextCard2(ActionEvent e) {
        System.out.println("Player two views the next card");
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //deals the cards to players;
        game.dealDeck();
        //initialize the current cards in each player hand(the card they are looking at)
        game.player1.setCurrentCard(game.player1.getPlayerDeck().get(0));
        game.player2.setCurrentCard(game.player2.getPlayerDeck().get(0));
        game.player3.setCurrentCard(game.player3.getPlayerDeck().get(0));
        game.player4.setCurrentCard(game.player4.getPlayerDeck().get(0));
        
    }   
    
}
