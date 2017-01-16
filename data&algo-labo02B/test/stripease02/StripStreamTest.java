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

/**
 *
 * @author maliek.meersschaert
 */
public class StripStreamTest {
    
    private StripStream stripstrm;
    
    public StripStreamTest() {
        
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
    
//    @Test
//    public void testSort1() {
//        stripstrm = new StripStream();
//        stripstrm.printSortStrips1();
//        assertTrue(true);
//    }
//    
//    @Test
//    public void testSort2() {
//        stripstrm = new StripStream();
//        stripstrm.printSortStrips2();
//        assertTrue(true);
//    }
    
//    @Test
//    public void testSort3() {
//        stripstrm = new StripStream();
//        stripstrm.printSortStrips3();
//        assertTrue(true);
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
//    @Test
//    public void testFilterReeksNaam() {
//        stripstrm = new StripStream();
//        stripstrm.filterStrip("Jommeke");
//        assertTrue(true);
//    }
    
//    @Test
//    public void testFilterXTitel() {
//        stripstrm = new StripStream();
//        stripstrm.filterXTitles();
//        assertTrue(true);
//    }
    
    @Test
    public void testFile() {
        stripstrm = new StripStream();
        stripstrm.streamToHashMap();
        assertTrue(true);
    }
}
