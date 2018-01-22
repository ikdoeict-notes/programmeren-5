/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaachta;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author seppesnoeck
 */
public class Eindwerk {
    String titel;
    int jaartal;
    String opleiding;
    Student student;

    public Eindwerk(String titel, int jaartal, String opleiding, Student student) {
        this.titel = titel;
        this.jaartal = jaartal;
        this.opleiding = opleiding;
        this.student = student;
    }
    
    public String getOpleiding(){return this.opleiding;}
    public String getTitle(){return this.titel;}
    public Eindwerk getEindwerk(){return this;}

    
    public static List<Eindwerk> genEindwerken(List<Student> studentenLijst){
        List<String> opleidingen = Arrays.asList("ICT", "OPT", "ELEKTRONICA", "QOT");
        Random r = new Random();
        return IntStream.rangeClosed(1,100).mapToObj(i -> new Eindwerk(
                makeTitle(5),
                (r.nextInt(2018 - 1994) +1) + 1994,
                opleidingen.get(r.nextInt(opleidingen.size())),
                studentenLijst.get(r.nextInt(studentenLijst.size()))
        )).collect(toList());
    }
    
    private static String makeTitle(int count){
        List<String> randWords = new ArrayList<String>();
        Random r = new Random();
        IntStream.rangeClosed(1, count).forEach(i -> randWords.add(DataGenerator.wordList().get(r.nextInt(DataGenerator.wordList().size()))));
        randWords.set(0, randWords.get(0).substring(0,1).toUpperCase() + randWords.get(0).substring(1));
        return randWords.stream().collect(Collectors.joining(" "));
    }
    
    public String toString(){
        return this.titel + " " + this.jaartal + " " + this.opleiding + " - " + this.student.voornaam + " " + this.student.familienaam;
    }
}
