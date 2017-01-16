/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.Eindwerk;
import Logica.NaamGenerator;
import Logica.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leander
 */
public class Stresstest {
    
    public Stresstest() {
    }
    
    @Test
    public void stressTest() {
        NaamGenerator ng = new NaamGenerator();
        List<Student> ls = new ArrayList<Student>();
        List<Eindwerk> le = new ArrayList<Eindwerk>();
        List<String> voornamen = ng.getFirstNamesList();
        List<String> achternamen = ng.getLastNamesList();
        List<String> titels = ng.getTitlesList();
        List<String> opleidingen = Arrays.asList("Bedrijfsmanagement", "Biotechniek", "eo", "ergo", "ICT", "med bv", "OPT", "sociaal werk", "verpleegkunde", "vdk");
        
        Random r = new Random(1);
        for (int i = 0; i < 1000000; i++) {
            ls.add(new Student(voornamen.get(r.nextInt(voornamen.size())), achternamen.get(r.nextInt(achternamen.size()))));
        }
        
        for (int i = 0; i < 2000000; i++) {
            le.add(new Eindwerk(titels.get(r.nextInt(titels.size())), 2016, opleidingen.get(r.nextInt(opleidingen.size())), ls.get(r.nextInt(ls.size()))));
        }
        
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
