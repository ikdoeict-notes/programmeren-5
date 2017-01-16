package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package be.odisee.generate.names;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NaamGenerator { 
    
    private final Random random ;
    private List<String> firstNamesList;
    private List<String> lastNamesList;
    private List<String> titlesList;
    private final String wordsFile = "C:\\Users\\Maliek\\Downloads\\Labo2\\Labo2\\Labo 2 Profiling\\wordsEn.txt"; //put your own place here
    private final String firstNamesFile = "C:\\Users\\Maliek\\Downloads\\Labo2\\Labo2\\Labo 2 Profiling\\first-names.txt";
    private final String lastNamesFile = "C:\\Users\\Maliek\\Downloads\\Labo2\\Labo2\\Labo 2 Profiling\\names.txt";
    
    public NaamGenerator(){
        this.random = new Random(1);
        initialize();
    }
    
    private void initialize(){
        this.titlesList = readFile(wordsFile);
        this.firstNamesList = readFile(firstNamesFile);
        this.lastNamesList = readFile(lastNamesFile);
    } 

    private List<String> readFile(String fileName) {
        Scanner in;
        List<String> wordList = new ArrayList<>();
        try {
            in = new Scanner(new FileReader(fileName));
            while (in.hasNext()) {
                String text = in.next();
                wordList.add(text);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NaamGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wordList;
    }
    
    public String getRandomWordFromList(List<String> wordList){        
        int randomInt = random.nextInt(wordList.size());
        return wordList.get(randomInt);        
    }
    
    public String makeTitleWithRandomWords(List<String> wordList, int numberOfRandomWords){
        String randomWords = "";
        for (int i=0; i< numberOfRandomWords; i++){
            randomWords += getRandomWordFromList(wordList) + " ";
        }
        return randomWords;
    }

    public List<String> getFirstNamesList() {
        return firstNamesList;
    }

    public List<String> getLastNamesList() {
        return lastNamesList;
    }

    public List<String> getTitlesList() {
        return titlesList;
    }



}
