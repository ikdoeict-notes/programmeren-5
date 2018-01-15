/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import profilinga.*;

/**
 *
 * @author seppesnoeck
 */
public class Stresstest {
    
    NaamGenerator gen;
    Random random;
    EindwerkCollectie collectie;
    
    @Test
    public void Stresstest() {
        List<Student> studenten = maakStudentsList();
        maakEindwerkenList(studenten);
        System.out.println(collectie.getEindwerkenVanOpleiding("ICT").length);
    }
    
    private List<Student> maakStudentsList (){
        gen = new NaamGenerator();
        random = new Random(1);
        List<Student> studentenList = new ArrayList<Student>(); 
        IntStream.range(1,1000000).forEach(i -> studentenList.add(new Student(
                    gen.getFirstNamesList().get(random.nextInt(gen.getFirstNamesList().size())), 
                    gen.getLastNamesList().get(random.nextInt(gen.getLastNamesList().size())))
            ));
        return studentenList;
    }
    
    private void maakEindwerkenList (List<Student> studentenList){
        collectie = new EindwerkCollectie();
        gen = new NaamGenerator();
        random = new Random(1);
        List<String> opleidingen = Arrays.asList("ICT", "OPT", "ELEKTRONICA");
        List<Eindwerk> eindwerkenList = new ArrayList<Eindwerk>(); 
        IntStream.range(1,2000000).forEach(i -> eindwerkenList.add(
                        new Eindwerk(gen.getTitlesList().get(random.nextInt(gen.getTitlesList().size())),2018, opleidingen.get(random.nextInt(opleidingen.size())), studentenList.get(random.nextInt(studentenList.size())))
        ));
        eindwerkenList.stream().forEach(item -> collectie.voegToe(item));
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
    // @Test
    // public void hello() {}
}
