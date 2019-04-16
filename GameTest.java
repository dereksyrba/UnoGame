package uno;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import uno.UnoGame;
import uno.UnoCards;

/**
 * JUnit tests for the game logic.
 *
 * @author Derek Syrba, John Frocillo, Adrian Harrel
 */
public class GameTest {
    
    /** A field of the UnoGame class to test it. */
    UnoGame game;
    
    /**
     * Instantiate a new UnoGame before every test.
     */
    @Before
    public void setUp() {
        game = new UnoGame();
    }
    
    /**
     * Test the playCard method of the game. When a player plays a card,
     * the game must check if it is a valid move, once that is checked,
     * the game will play the card from their hand.
     */
    @Test
    public void testPlayCard() {
        //Create a test Card for player1
        game.dealDeck();
        game.shuffleDeck(game.getDeck());
        game.getPlayer1().setCurrentCard(game.getPlayer1().getPlayerDeck().get(0));
        game.getPlayer1().getCurrentCard().setCardColor("red");
        game.getPlayer1().getCurrentCard().setCardNumber(5);
        
        //Create a test Card for the draw pile
        game.getDiscardPile().add(game.getDeck().get(0));
        
        game.getDiscardPile().get(0).setCardColor("red");
        game.getDiscardPile().get(0).setCardNumber(0);
        UnoCards top = game.getDiscardPile().get(0);
        UnoCards card = game.getPlayer1().getCurrentCard();
        
        //If the play is valid, play it on the discard pile. The player
        //should now have one less card in their hand.
        assertTrue((game.isValid(card, top)));
        game.playCard(game.getPlayer1(), game.getPlayer1().getCurrentCard());
        assertTrue(game.getPlayer1().getPlayerDeck().size() == 6);
    }
    
    /**
     * Test the drawCard method of the game. When a player draws a card
     * their hand/deck size should increase by 1 (or however many is
     * passed as a parameter)
     */
    @Test
    public void testDrawCard() {
        game.dealDeck();
        game.shuffleDeck(game.getDeck());
        assertTrue(game.getPlayer1().getPlayerDeck().size() == 7);
    
        game.drawCard(game.getPlayer1(), 1);
        assertTrue(game.getPlayer1().getPlayerDeck().size() == 8);
    }
    
    /**
     * Test the changeTurn method of the game. If the game has not been
     * reversed, the flow should be player 1,2,3,4. If the order is
     * reversed, the flow should be player 4,3,2,1.
     */
    @Test
    public void testChangeTurn() {
        
        //Standard counter clockwise tests
        game.dealDeck();
        game.shuffleDeck(game.getDeck());
        assertTrue(game.getPlayer1().getIsPlayerTurn());
        
        game.changeTurn();
        assertTrue(!game.getPlayer1().getIsPlayerTurn());
        assertTrue(game.getPlayer2().getIsPlayerTurn());
        
        game.changeTurn();
        assertTrue(!game.getPlayer2().getIsPlayerTurn());
        assertTrue(game.getPlayer3().getIsPlayerTurn());
        
        game.changeTurn();
        assertTrue(!game.getPlayer3().getIsPlayerTurn());
        assertTrue(game.getPlayer4().getIsPlayerTurn());
        
        game.changeTurn();
        assertTrue(!game.getPlayer4().getIsPlayerTurn());
        assertTrue(game.getPlayer1().getIsPlayerTurn());
        
        //Reversed clockwise tests
        game.setReverse();
        
        game.changeTurn();
        assertTrue(!game.getPlayer1().getIsPlayerTurn());
        assertTrue(game.getPlayer4().getIsPlayerTurn());
        
        game.changeTurn();
        assertTrue(!game.getPlayer4().getIsPlayerTurn());
        assertTrue(game.getPlayer3().getIsPlayerTurn());
        
        game.changeTurn();
        assertTrue(!game.getPlayer3().getIsPlayerTurn());
        assertTrue(game.getPlayer2().getIsPlayerTurn());
        
        game.changeTurn();
        assertTrue(!game.getPlayer2().getIsPlayerTurn());
        assertTrue(game.getPlayer1().getIsPlayerTurn());
        
        game.changeTurn();
        assertTrue(!game.getPlayer1().getIsPlayerTurn());
        assertTrue(game.getPlayer4().getIsPlayerTurn());
    }
    
    /**
     * Tests the nextPlayer method of the game. This method keeps track of the
     * flow of the game. Normally, the next player is the one counter clockwise
     * to the current player. If the order of play has been reversed, then the
     * "next player" should be the player sitting clockwise to the player whose
     * turn it is.
     */
    @Test
    public void testNextPlayer() {
        game.dealDeck();
        game.shuffleDeck(game.getDeck());
        
        //Game should start with Player 1's turn, and Player 2 being next.
        assertTrue(game.nextPlayer() == game.getPlayer2());
        
        //Standard counter clockwise tests
        game.changeTurn();
        assertTrue(game.nextPlayer() == game.getPlayer3());
        game.changeTurn();
        assertTrue(game.nextPlayer() == game.getPlayer4());
        game.changeTurn();
        assertTrue(game.nextPlayer() == game.getPlayer1());
        
        //Reverse clockwise tests
        game.changeTurn();
        game.setReverse();
        assertTrue(game.nextPlayer() == game.getPlayer4());
        game.changeTurn();
        assertTrue(game.nextPlayer() == game.getPlayer3());
        game.changeTurn();
        assertTrue(game.nextPlayer() == game.getPlayer2());
        game.changeTurn();
        assertTrue(game.nextPlayer() == game.getPlayer1());
        game.changeTurn();
        assertTrue(game.nextPlayer() == game.getPlayer4());
    }
    
    /**
     * Tests the currentPlayer method of the game. The method should correctly
     * return whose turn it currently is when called.
     */
    @Test
    public void testCurrentPlayer() {
        game.dealDeck();
        game.shuffleDeck(game.getDeck());
        
        assertTrue(game.currentPlayer() == game.getPlayer1());
        game.changeTurn();
        assertTrue(game.currentPlayer() == game.getPlayer2());
        game.changeTurn();
        assertTrue(game.currentPlayer() == game.getPlayer3());
        game.changeTurn();
        assertTrue(game.currentPlayer() == game.getPlayer4());
        game.changeTurn();
        assertTrue(game.currentPlayer() == game.getPlayer1());
    }
    
    /**
     * Tests the IsGameOver method of the game. If any player's hand is now
     * empty (0 cards), then they have won the game.
     */
    @Test
    public void testIsGameOver() {
        game.dealDeck();
        game.shuffleDeck(game.getDeck());
        
        game.getPlayer1().getPlayerDeck().clear();
        assertTrue(game.isGameOver());
        game.getPlayer1().getPlayerDeck().add(game.getDeck().get(0));
        
        game.getPlayer2().getPlayerDeck().clear();
        assertTrue(game.isGameOver());
        game.getPlayer2().getPlayerDeck().add(game.getDeck().get(1));
        
        game.getPlayer3().getPlayerDeck().clear();
        assertTrue(game.isGameOver());
        game.getPlayer3().getPlayerDeck().add(game.getDeck().get(2));
        
        game.getPlayer4().getPlayerDeck().clear();
        assertTrue(game.isGameOver());
        game.getPlayer4().getPlayerDeck().add(game.getDeck().get(3));
        
    }
    
    /**
     * Tests the method that sets the next card variable for game flow.
     * If the current card is different after the method is called, then
     * it has successfully moved the current card to the new one that is
     * being viewed.
     */
    @Test
    public void testNextCard() {
        game.dealDeck();
        game.shuffleDeck(game.getDeck());
        
        //Create the current card.
        game.getPlayer1().setCurrentCard(game.getPlayer1().getPlayerDeck().get(0));
        UnoCards first = game.getPlayer1().getCurrentCard();
        
        //Test the method to see if it moves the current card.
        game.nextCard(game.getPlayer1(), game.getPlayer1().getPlayerDeck().get(0), true);
        UnoCards second = game.getPlayer1().getCurrentCard();
        //If the first and second Uno Cards are not the same, then the current
        //card was moved correctly.
        assertTrue(first != second);
        
        //Test the method with the current card moving the other direction.
        game.getPlayer1().setCurrentCard(game.getPlayer1().getPlayerDeck().get(0));
        first = game.getPlayer1().getCurrentCard();
        game.nextCard(game.getPlayer1(), game.getPlayer1().getPlayerDeck().get(0), false);
        second = game.getPlayer1().getCurrentCard();
        //If the first and second Uno Cards are not the same, then the current
        //card was moved correctly.
        assertTrue(first != second);
    }
    
    /**
     * Tests the reshuffle method of the game. The draw pile deck order should
     * be different after a reshuffle.
     */
    @Test
    public void testReshuffle() {
        ArrayList<UnoCards> first = new ArrayList<>(game.getDeck());
        game.dealDeck();
        game.getDeck().clear();
        for(int i = 0; i < 6; i++) {
            game.getDiscardPile().add(game.getPlayer1().getPlayerDeck().get(i));
        }
   
        game.reshuffle();
        ArrayList<UnoCards> second = new ArrayList<>(game.getDeck());
        
        //If the decks are different, then the deck has been reshuffled as
        //the cards are no longer in the same position.
        assertTrue(!first.equals(second));
    }
    
    /**
     * Tests the dealing method of the game. Players should have 7 cards each.
     */
    @Test
    public void testDeal() {
        assertTrue(game.getPlayer1().getPlayerDeck().isEmpty());
        assertTrue(game.getPlayer2().getPlayerDeck().isEmpty());
        assertTrue(game.getPlayer3().getPlayerDeck().isEmpty());
        assertTrue(game.getPlayer4().getPlayerDeck().isEmpty());
        
        game.dealDeck();
        
        assertTrue(game.getPlayer1().getPlayerDeck().size() == 7);
        assertTrue(game.getPlayer2().getPlayerDeck().size() == 7);
        assertTrue(game.getPlayer3().getPlayerDeck().size() == 7);
        assertTrue(game.getPlayer4().getPlayerDeck().size() == 7);
    }
    
}
