/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaachta;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author seppesnoeck
 */
public class Student {
    String voornaam;
    String familienaam;
    String studentnummer;

    public Student(String voornaam, String familienaam, String studentnummer) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.studentnummer = studentnummer;
    }
    
    public static List<Student> genStudents(){
        Random r = new Random();
        DecimalFormat df = new DecimalFormat("000");
        return IntStream.rangeClosed(1,100).mapToObj(i -> new Student(
                        DataGenerator.getFirstNames().get(r.nextInt(DataGenerator.getFirstNames().size())),
                        DataGenerator.getLastNames().get(r.nextInt(DataGenerator.getLastNames().size())),
                        df.format(i))).collect(toList());
    }
    
    public String getFirstName(){ return voornaam;}
    public String getLastName(){ return familienaam;}
    public String getNumber(){ return studentnummer;}

    
    public String toString(){
        return this.studentnummer + " " + this.voornaam + " " +this.familienaam;
    }
}
