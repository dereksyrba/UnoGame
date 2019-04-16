package uno;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import uno.Player;
import uno.UnoGame;

/**
 * JUnit tests for the Card Deck logic and creation.
 *
 * @author John Frocillo
 */
public class PlayerTest {
	
	/** A field of the Player class to test the player's functionality. */
	Player p1;
	
	/** A field of the Game class to test the player's hand. */
	UnoGame game;
	
	/**
     * Instantiate a new UnoGame before every test.
     */
    @Before
    public void setUp() {
    	game = new UnoGame();
    }
	
    /**
     * Test the current player logic and the functionality to switch 
     * the current player.
     */
    @Test
    public void testCurrentPlayer() {
    	p1 = new Player(true);
    	assertEquals(p1.getIsPlayerTurn(), true);
    	p1 = new Player(false);
    	assertEquals(p1.getIsPlayerTurn(), false);
    	
    	p1.setIsPlayerTurn(true);
    	assertEquals(p1.getIsPlayerTurn(), true);
    }
    
    /**
     * Test the current card logic and the functionality to change
     * the current card of a player.
     */
    @Test
    public void testCurrentCard() {
    	game.shuffleDeck(game.getDeck());
    	game.dealDeck();
    	game.getPlayer1().setCurrentCard(game.getPlayer1().getPlayerDeck().get(5));
    	assertEquals(game.getPlayer1().getCurrentCard(), game.getPlayer1().getPlayerDeck().get(5));
    }
    
    /**
     * Test the ability for a player to be dealt a hand of cards.
     */
    @Test
    public void testPlayerDeck() {
    	game.shuffleDeck(game.getDeck());
    	game.dealDeck();
    	assertNotEquals(game.getPlayer1().getPlayerDeck(), null);
    }
	
}
