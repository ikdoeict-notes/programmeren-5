/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Poker.Card;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Poker.PokerHand;
import Poker.Library.Rank;
import Poker.Library.Suit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Ruben Thys en Maliek Meersschaert
 */
public class PokerHandTest {
    
    private PokerHand hand;
    
    @Before
    public void setUp() {
        hand = new PokerHand();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testValidHandCount(){

        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Suit.Clubs, Rank.Ace));
        cards.add(new Card(Suit.Clubs, Rank.Ace));
        cards.add(new Card(Suit.Clubs, Rank.Ace));
        cards.add(new Card(Suit.Clubs, Rank.Ace));

        assertEquals(true,hand.checkSize(cards));  

    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidHandDuplicates(){

        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Suit.Clubs, Rank.Ace));
        cards.add(new Card(Suit.Clubs, Rank.Two));
        cards.add(new Card(Suit.Clubs, Rank.Three));
        cards.add(new Card(Suit.Clubs, Rank.Four));
        cards.add(new Card(Suit.Clubs, Rank.Four));

        assertEquals(true,hand.checkDuplicates(cards));    
    }
    
    @Test
    public void testStraightFlush() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Suit.Clubs, Rank.Two));
        cards.add(new Card(Suit.Clubs, Rank.Three));
        cards.add(new Card(Suit.Clubs, Rank.Four));
        cards.add(new Card(Suit.Clubs, Rank.Five));
        cards.add(new Card(Suit.Clubs, Rank.Six));
        assertEquals(true, hand.checkStraightFlush(cards));
    }
    
    @Test
    public void testRoyalFlush() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Suit.Clubs, Rank.Ten));
        cards.add(new Card(Suit.Clubs, Rank.Jack));
        cards.add(new Card(Suit.Clubs, Rank.Queen));
        cards.add(new Card(Suit.Clubs, Rank.King));
        cards.add(new Card(Suit.Clubs, Rank.Ace));
        assertEquals(true, hand.checkRoyalFlush(cards));
    }
    
    @Test
    public void testThreeOfaKind() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Suit.Diamonds, Rank.Ten));
        cards.add(new Card(Suit.Clubs, Rank.Ten));
        cards.add(new Card(Suit.Hearts, Rank.Ten));
        cards.add(new Card(Suit.Clubs, Rank.King));
        cards.add(new Card(Suit.Clubs, Rank.Ace));
        assertEquals(true, hand.checkThreeOfaKind(cards));
    }
    
    @Test
    public void testFourOfaKind() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Suit.Diamonds, Rank.Ten));
        cards.add(new Card(Suit.Clubs, Rank.Ten));
        cards.add(new Card(Suit.Hearts, Rank.Ten));
        cards.add(new Card(Suit.Spades, Rank.Ten));
        cards.add(new Card(Suit.Clubs, Rank.Ace));
        assertEquals(true, hand.checkFourOfaKind(cards));
    }
}
