/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poker;

import Poker.Library.Rank;
import Poker.Library.Suit;

/**
 *
 * @author Ruben
 */
public class Card {
    
    public Suit suit;
    public Rank rank;
    
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
    
}
