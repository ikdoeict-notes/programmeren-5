/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdda;

import java.util.function.Function;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author seppesnoeck
 */
public class TicTacToesTest {
    
    @Test
    public void containsThree() {
        System.out.println("* TicTacToesTest: containsThree()");
        
        Function<Integer, Object> contains3 = TicTacToes.containsValue("Tic", 3);
        assertEquals("Tic", contains3.apply(3));
        assertEquals("Tic", contains3.apply(13));
        assertEquals("Tic Tic", contains3.apply(33));
        assertEquals(2, contains3.apply(2));
    }
    
    @Test
    public void idDividableByThree() {
        System.out.println("* TicTacToesTest: idDividableByThree()");
        Function<Integer, Object> dividableBy3 = TicTacToes.dividable("Tic", 3);
        assertEquals("Tic", dividableBy3.apply(3));
        assertEquals("Tic", dividableBy3.apply(33));
        assertEquals(13, dividableBy3.apply(13));
        assertEquals(23, dividableBy3.apply(23));
    }
    
    @Test
    public void containsFive() {
        System.out.println("* TicTacToesTest: containsFive()");
        Function<Integer, Object> contains5 = TicTacToes.containsValue("Tac", 5);
        assertEquals("Tac", contains5.apply(5));
        assertEquals("Tac", contains5.apply(15));
        assertEquals("Tac Tac", contains5.apply(55));
        assertEquals(2, contains5.apply(2));
    }
    
    @Test
    public void idDividableByFive() {
        System.out.println("* TicTacToesTest: idDividableByFive()");
        Function<Integer, Object> dividableBy5 = TicTacToes.dividable("Tac", 5);
        assertEquals("Tac", dividableBy5.apply(5));
        assertEquals("Tac", dividableBy5.apply(55));
        assertEquals(13, dividableBy5.apply(13));
        assertEquals(23, dividableBy5.apply(23));
    }
    
    @Test
    public void containsSeven() {
        System.out.println("* TicTacToesTest: containsSeven()");
        Function<Integer, Object> contains7 = TicTacToes.containsValue("Toe", 7);
        assertEquals("Toe", contains7.apply(7));
        assertEquals("Toe", contains7.apply(17));
        assertEquals("Toe Toe", contains7.apply(77));
        assertEquals(2, contains7.apply(2));
    }
    
    @Test
    public void idDividableBySeven() {
        System.out.println("* TicTacToesTest: idDividableBySeven()");
        Function<Integer, Object> dividableBy7 = TicTacToes.dividable("Toe", 7);
        assertEquals("Toe", dividableBy7.apply(7));
        assertEquals("Toe", dividableBy7.apply(77));
        assertEquals(13, dividableBy7.apply(13));
        assertEquals(23, dividableBy7.apply(23));
    }
    
    @Test
    public void totalResult() {
        System.out.println("* TicTacToesTest: totalResult()");
        TicTacToes ttt = new TicTacToes("Tic", "Tac", "Toe", 3, 5 ,7, 1, 100);
        assertEquals("Tic Tic", ttt.TicTacToe(3));
        assertEquals("Tic", ttt.TicTacToe(13));
        assertEquals("Tic", ttt.TicTacToe(23));
        assertEquals("Tic Tic Tic", ttt.TicTacToe(33));
        assertEquals("Tac Tac", ttt.TicTacToe(5));
        assertEquals("Tic Tac Tac", ttt.TicTacToe(15));
        assertEquals("Tac Tac", ttt.TicTacToe(25));
        assertEquals("Toe Toe", ttt.TicTacToe(7));
        assertEquals("Toe", ttt.TicTacToe(17));
        assertEquals("Tic Toe", ttt.TicTacToe(21));
        assertEquals(2, ttt.TicTacToe(2));
        System.out.println();
        System.out.println("Iterate with top and bot values");
        ttt.Iterator();

    }
    
    @Test (expected=IllegalArgumentException.class)
    public void botAndTopValues(){
        System.out.println("* TicTacToesTest: botAndTopValues()");
        TicTacToes test1 = new TicTacToes("Tic", "Tac", "Toe", 3, 5 ,7, -1, 100);
        TicTacToes test2 = new TicTacToes("Tic", "Tac", "Toe", 3, 5 ,7, 1, 101);
    }
}
