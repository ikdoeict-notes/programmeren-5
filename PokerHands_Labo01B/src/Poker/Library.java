/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poker;

/**
 *
 * @author Ruben
 */
public class Library {
     
    public enum Suit { Hearts, Spades, Diamonds, Clubs }
    public enum Rank {        
        Ace(14),Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13);
        public int number;
        Rank(int number) {
            this.number = number;
        }
       public int getRank() { 
         return number;
       }
    }
}
