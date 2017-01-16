/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package be.odisee.eindwerken;

import Logica.Eindwerk;
import Logica.Student;
import Logica.EindwerkCollectie;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Peter
 */
public class EindwerkCollectieTest {
    
    private final EindwerkCollectie collectie; 
    private final Student student1;
    private final Eindwerk eindwerk1;
    private final Eindwerk eindwerk2;
    private final Eindwerk eindwerk3;
    private final Eindwerk eindwerk4;
            
    
    public EindwerkCollectieTest() {
        this.collectie = new EindwerkCollectie();
        this.student1 = new Student("Peter", "Demeester");
        Student student2 = new Student("Katja", "Verbeeck");
        Student student3 = new Student("Kristien", "Van Assche");
        this.eindwerk1 = new Eindwerk("Scheiding der veranderlijken in de geodetische Hamilton-Jacobi vergelijking", 2011, "ICT", student1);
        this.eindwerk2 = new Eindwerk("Automatische verificatie van eindige state machines", 2012, "ICT", student2);
        this.eindwerk3 = new Eindwerk("Coordinated Exploration in Multi-agent Reinforcement Learning", 2012, "ICT", student3);
        this.eindwerk4 = new Eindwerk("Performantie van ATM schakelelementen met gemeenschappelijke buffer", 2010, "OPT", student1);
        collectie.voegToe(eindwerk1);
        collectie.voegToe(eindwerk2);
        collectie.voegToe(eindwerk3);
        collectie.voegToe(eindwerk4);        
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
     * Test of voegToe method, of class EindwerkCollectie.
     */
    @Test
    public void testVoegToe() {
        System.out.println("voegToe");
        this.collectie.voegToe(eindwerk1);
        assertEquals(3, this.collectie.getEindwerkenVanOpleiding("ICT").length);
        assertEquals(1, this.collectie.getEindwerkenVanOpleiding("OPT").length);
    }

    /**
     * Test of verwijder method, of class EindwerkCollectie.
     */
    @Test
    public void testVerwijder() {
        System.out.println("verwijder");
        this.collectie.verwijder(eindwerk4);        
        assertNull(this.collectie.getEindwerkenVanOpleiding("OPT"));
        this.collectie.verwijder(eindwerk1);
        this.collectie.verwijder(eindwerk2);
        assertEquals(1, this.collectie.getEindwerkenVanOpleiding("ICT").length);
        this.collectie.verwijder(eindwerk3);
        assertNull(this.collectie.getEindwerkenVanOpleiding("ICT"));
        
    }

    /**
     * Test of getEindwerkenVanOpleiding method, of class EindwerkCollectie.
     */
    @Test
    public void testGetEindwerkenVanOpleiding() {
        System.out.println("getEindwerkenVanOpleiding");        
        Eindwerk[] expResult = {eindwerk1, eindwerk3, eindwerk2};
        assertArrayEquals(expResult, this.collectie.getEindwerkenVanOpleiding("ICT"));        
    }

    /**
     * Test of toString method, of class EindwerkCollectie.
     */
    @Ignore
    public void testToString() {
        System.out.println("toString");
        EindwerkCollectie instance = new EindwerkCollectie();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
