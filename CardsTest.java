package uno;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import uno.UnoGame;

/**
 * JUnit tests for the Card Deck logic and creation.
 *
 * @author John Frocillo
 */
public class CardsTest {
	/** A field of the UnoGame class to test the cards. */
    UnoGame game;
    
    /**
     * Instantiate a new UnoGame before every test.
     */
    @Before
    public void setUp() {
    	game = new UnoGame();
    	game.dealDeck();
    }
    /**
     * Test the functionality to successfully change a card number.
     */
    @Test
    public void testChangeCardNumber() {
    	game.getDeck().get(0).setCardNumber(5);
    	assertEquals(game.getDeck().get(0).getCardNumber(), 5);
    }
    
    /**
     * Test the functionality to successfully change a card color.
     */
    @Test
    public void testChangeCardColor() {
    	game.getDeck().get(0).setCardColor("blue");
    	assertEquals(game.getDeck().get(0).getCardColor(), "blue");
    }
    
    /**
     * Test the functionality to successfully make a card wild.
     */
    @Test
    public void testChangeWild() {
    	game.getDeck().get(0).setIsWild(true);
    	assertEquals(game.getDeck().get(0).getIsWild(), true);
    }
    
    /**
     * Test the functionality to successfully make a card a Plus 4.
     */
    @Test
    public void testChangePlus4() {
    	game.getDeck().get(0).setIsPlus4(true);
    	assertEquals(game.getDeck().get(0).getIsPlus4(), true);
    }
    
    /**
     * Test the functionality to successfully make a card a Plus 2.
     */
    @Test
    public void testChangePlus2() {
    	game.getDeck().get(0).setIsPlus2(true);
    	assertEquals(game.getDeck().get(0).getIsPlus2(), true);
    }
    
    /**
     * Test the functionality to successfully make a card a Reverse.
     */
    @Test
    public void testChangeReverse() {
    	game.getDeck().get(0).setIsReverse(true);
    	assertEquals(game.getDeck().get(0).getIsReverse(), true);
    }
    
    /**
     * Test the functionality to successfully make a car a Skip.
     */
    @Test
    public void testChangeSkip() {
    	game.getDeck().get(0).setIsSkip(true);
    	assertEquals(game.getDeck().get(0).getIsSkip(), true);
    }
    
	
}
