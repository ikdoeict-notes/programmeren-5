
package tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 *
 * @author hanne.goossens
 */
public class TicTacToeTest {
    private TicTacToe spel;
    private int ondergrens = 1;
    private int bovengrens = 99;
    
    @Before
    public void setUp() {
        spel = new TicTacToe();
    }
    
    /*@Test
    public void testGrenswaarden(){
        assertEquals(Integer.toString(ondergrens),spel.inputNumber(ondergrens));
        assertEquals("Tic",spel.inputNumber(bovengrens));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgument() {
        assertEquals(Integer.toString(ondergrens--),spel.inputNumber(ondergrens--));
        assertEquals(Integer.toString(bovengrens++),spel.inputNumber(bovengrens++));
    }
    
    @Test
    public void testTicsTacsToes(){
        assertEquals("Tic",spel.inputNumber(6));
        assertEquals("Tac",spel.inputNumber(10));
        assertEquals("Toe",spel.inputNumber(14));
    }
    
    @Test
    public void testCombinaties(){
        assertEquals("TicToe",spel.inputNumber(21));
        // MORE COMBINATIONS TO TEST
    }*/
    
    @Test
    public void testFritsFreddy() {
        assertEquals("FritsFreddy", spel.inputNumber(42));
        assertEquals("FritsFreddyFreddy", spel.inputNumber(60));
    }
}
