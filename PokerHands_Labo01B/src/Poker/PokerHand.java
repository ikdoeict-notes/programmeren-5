/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poker;

import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;

/**
 *
 * @author Ruben
 */
public class PokerHand {
   
    public List<Card> cards;
    private static int MAXCARDS = 5;
   
    public PokerHand(){
        
    }
    
    public boolean checkSize(List<Card> cardList) {
        Boolean tooLong = false;
        if (cardList.size() != MAXCARDS) {
            tooLong = true;
            throw new IllegalArgumentException("Card count does not equal 5");            
        }
        return tooLong;
    }
    
    public boolean checkDuplicates(List<Card> cardList){
        Boolean duplicate = false;
        
        for (int i = 0; i < cardList.size(); i++) {
            for (int j = 0; j < cardList.size(); j++) {
                if (i != j ) {
                    if (cardList.get(i).rank == cardList.get(j).rank && cardList.get(i).suit == cardList.get(j).suit ) {
                        duplicate = true;                        
                        throw new IllegalArgumentException("Card count does not equal 5");                        
                    }
                }
            }
        }
        return duplicate;
    }
    
    public boolean checkStraightFlush(List<Card> cardList) {
        Boolean straightFlush = false;
        
        for (int i = 0; i < cardList.size();i++) {
            for (int j = 1; j < cardList.size(); j++) {
                if (cardList.get(i).suit == cardList.get(j-1).suit && ((cardList.get(i).rank.getRank() + 1) == (cardList.get(j).rank.getRank())) && cardList.get(i).rank.getRank() <= 10) {
                        straightFlush = true;
                        break;
                }
            }            
        }
        return straightFlush;
    }
    
    public boolean checkRoyalFlush(List<Card> cardList) {
        Boolean royalFlush = false;
        
        for (int i = 0; i < cardList.size();i++) {
            for (int j = 1; j < cardList.size(); j++) {
                if (cardList.get(i).suit == cardList.get(j-1).suit && ((cardList.get(i).rank.getRank() + 1) == (cardList.get(j).rank.getRank())) && cardList.get(i).rank.getRank() >= 10) {
                        royalFlush = true;
                        break;
                }
            }            
        }
        return royalFlush;
    }

    public boolean checkThreeOfaKind(List<Card> cardList) {
      Boolean threeOfaKind = false;
      int count = 0;
      for (int i = 0; i < cardList.size();i++) {
            for (int j = 1; j < cardList.size(); j++) {                
                if (cardList.get(i).rank.getRank() == cardList.get(j).rank.getRank()) {
                    count++;
                    if (count == 3) {
                        threeOfaKind = true;
                        break;
                    }                        
                }
            }            
        }
        return threeOfaKind;
    }
    
    public boolean checkFourOfaKind(List<Card> cardList) {
      Boolean fourOfaKind = false;
      int count = 0;
      for (int i = 0; i < cardList.size();i++) {
        if (cardList.get(i).rank.getRank() == cardList.get(i+1).rank.getRank()) {
            count++;
            if (count == 4) {
                fourOfaKind = true;
                break;
            }                        
        }
      }
        return fourOfaKind;
    }
}
        
