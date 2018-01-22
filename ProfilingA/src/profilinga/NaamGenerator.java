/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profilinga;

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
    
    private final String PATH = System.getProperty("user.dir") + "/src/profilinga/"; 
    private final String wordsFile = PATH + "/wordsEn.txt";
    private final String firstNamesFile = PATH + "/first-names.txt";
    private final String lastNamesFile = PATH + "/names.txt";
    
    public NaamGenerator(){
        this.random = new Random(1);
        System.out.println(System.getProperty("user.dir") + "/src/profininga/");
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
