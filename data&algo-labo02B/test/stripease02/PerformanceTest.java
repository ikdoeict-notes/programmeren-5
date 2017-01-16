/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stripease02;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import be.odisee.naamgenerator.NaamGenerator;

/**
 *
 * @author maliek.meersschaert
 */
public class PerformanceTest {
    private final IStripCollectie collectie;
    public PerformanceTest() {
        collectie = new StripCollectie();
        for(int i=0; i <= 100; i++) {
            collectie.voegToe(new Strip("reeks"+i, "schrijver"+i, "tekenaar"+i, "uitgeverij"+i, 200, "titel"+i));
            collectie.voegToe(new Strip("reeks"+i, "schrijver"+i, "tekenaar"+i, "uitgeverij"+i, 201, "titel_"+i));
        }
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(timeout = 1000)
    public void zoekStrips() {
        collectie.getStrips("reeks69");
    }
}
