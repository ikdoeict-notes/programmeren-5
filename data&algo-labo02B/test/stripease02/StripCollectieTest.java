/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stripease02;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class StripCollectieTest {
    
    private final Strip strip1, strip2, strip3, strip4, strip5, strip6;
    private final IStripCollectie collectie;
    
    public StripCollectieTest() {        
        this.strip1 = new Strip("Suske en Wiske", "W. Vandersteen", "W. Vandersteen", "Standaard Uitgeverij", 68, "Het Eiland Amoras");
        this.strip2 = new Strip("Suske en Wiske", "W. Vandersteen", "W. Vandersteen", "Standaard Uitgeverij", 67, "De Poenscheppers");
        this.strip3 = new Strip("Suske en Wiske", "W. Vandersteen", "W. Vandersteen", "Standaard Uitgeverij", 69, "De Nerveuze Nerviers");
        this.strip4 = new Strip("Jommeke", "J. Nys", "J. Nys", "Het Volk", 1, "De Jacht op een Voetbal");
        this.strip5 = new Strip("Suske en Wiske", "W. Vandersteen", "W. Vandersteen", "Standaard Uitgeverij", 200, "Angst op de Amsterdam");
        this.strip6 = new Strip("Suske en Wiske", "W. Vandersteen", "W. Vandersteen", "Standaard Uitgeverij", 69, "De Nerveuze Nerviers");        
        this.collectie = new StripCollectie();
        this.collectie.voegToe(strip1);
        this.collectie.voegToe(strip2);
        this.collectie.voegToe(strip3);
        this.collectie.voegToe(strip4);
        this.collectie.voegToe(strip5);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of voegToe method, of class StripCollectie.
     */
    @Test
    public void testVoegToe() {
        System.out.println("voegToe");
        System.out.println(Arrays.toString(collectie.getStrips("Suske en Wiske")));
        assertEquals(4, collectie.getStrips("Suske en Wiske").length);
        assertEquals(1, collectie.getStrips("Jommeke").length);
        this.collectie.voegToe(strip6);
        System.out.println(strip6.compareTo(strip3));
        System.out.println(Arrays.toString(collectie.getStrips("Suske en Wiske")));
        assertEquals(4, collectie.getStrips("Suske en Wiske").length);        
    }

    /**
     * Test of verwijder method, of class StripCollectie.
     */
    @Test
    public void testVerwijder() {
        System.out.println("verwijder");
        collectie.verwijder(strip4);
        assertNull(collectie.getStrips("Jommeke"));
        collectie.verwijder(strip1);
        collectie.verwijder(strip2);
        collectie.verwijder(strip3);
        assertEquals(1, collectie.getStrips("Suske en Wiske").length);
        collectie.verwijder(strip5);
        collectie.verwijder(strip6);
        assertNull(collectie.getStrips("Suske en Wiske"));
        
    }

    /**
     * Test of getStrips method, of class StripCollectie.
     */
    @Test
    public void testGetStrips() {
        System.out.println("getStrips");        
        Strip[] expResult = {strip4};
        Strip[] result = collectie.getStrips("Jommeke");
        assertArrayEquals(expResult, result);
        Strip[] expResult1 = {strip2, strip1, strip3, strip5};
        Strip[] result1 = collectie.getStrips("Suske en Wiske");
        assertArrayEquals(expResult1, result1);
    }
    
}
