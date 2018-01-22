/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaachta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
public class DataGenerator {
    static String firstNamesFile = "first-names.txt";
    static String lastNamesFile = "names.txt";
    static String wordsFile = "wordsEn.txt";

    public DataGenerator(){}
    
    public static List<String> getFirstNames() {
        try {
            return Files.lines(Paths.get(firstNamesFile)).collect(toList());
        } catch(IOException e){
            System.out.println("IOException: " + e);
        }
        return null;
    }
    
    public static List<String> getLastNames() {
        try {
            return Files.lines(Paths.get(lastNamesFile)).collect(toList());
        } catch(IOException e){
            System.out.println("IOException: " + e);
        }
        return null;
    }
    
    public static List<String> wordList(){
        try {
            return Files.lines(Paths.get(wordsFile)).collect(toList());
        } catch(IOException e){
            System.out.println("IOException: " + e);
        }
        return null;
    }
    
    public static List<String> fullNames(){
        Random r = new Random();
        return Stream.generate(() -> getFirstNames().get(r.nextInt(getFirstNames().size())) + " " + getLastNames().get(r.nextInt(getLastNames().size()))).limit(100).collect(toList());
    }
}
