/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alienregistry;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author Nicolas
 */
public class AlienRegistry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int amountAliens = 100000;
        int visitsPerAlien = 3;
        List<Visit> visitsList = new ArrayList<>();
        SortedSet<Visit> visitsSet = new TreeSet();
        for (int i = 0; i < amountAliens; i++) {
            Alien a = RandomGenerators.getRandomAlien(i);
            for (int j = 0; j < visitsPerAlien; j++) {
                String id = String.valueOf(i) + String.valueOf(j);
                Visit v = RandomGenerators.generateVisit(a, id);
                visitsList.add(v);
                visitsSet.add(v);
            }
        }
        
        int yearMin = 1930;
        int yearMax = 1935;
        Visit.Reason reason = Visit.Reason.DIPLOMACY;
        
        System.out.println("Testing ArrayList...");
        ArrayListTest.testArrayList(visitsList, reason, yearMin, yearMax);
        
        System.out.println("\nTesting SortedSet...");
        SortedSetTest.testSortedSet(visitsSet, reason, yearMin, yearMax);        
    }
}
