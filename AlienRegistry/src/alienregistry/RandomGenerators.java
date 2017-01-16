/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alienregistry;

import java.security.SecureRandom;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Nicolas
 */
public class RandomGenerators {
    public static Alien getRandomAlien(int id) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sbName = new StringBuilder(7);
        StringBuilder sbPlanet = new StringBuilder(7);
        StringBuilder sbColor = new StringBuilder(7);
        for (int j = 0; j < 7; j++) {
            sbName.append( AB.charAt( rnd.nextInt(AB.length()) ) );
            sbPlanet.append( AB.charAt( rnd.nextInt(AB.length()) ) );
            sbColor.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        }
        Alien alien = new Alien(sbName.toString(), (int) Math.random(), sbPlanet.toString(), sbColor.toString(), id);
        return alien;
    }
    
    public static Visit generateVisit(Alien alien, String id) {
        Random random = new Random();
        int randomYear = 1900 + (int)(Math.random() * ((2017 - 1900) + 1));
        Visit.Reason randomReason = Visit.Reason.values()[random.nextInt(4)];
        Visit visit = new Visit(randomReason, randomYear, alien, id);
        return visit;
    }
}
