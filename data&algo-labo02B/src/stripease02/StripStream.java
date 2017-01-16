/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stripease02;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author maliek.meersschaert
 */
public class StripStream {

    private List<Strip> collectie;

    public StripStream() {
        collectie = new ArrayList<Strip>();
        for (int i = 0; i <= 100; i++) {
            if(i < 20) {
                collectie.add(new Strip("Kiekeboe", "schrijver", "Andreas", "Lannoo", i, "titel_" + i));
            } else if (i < 40 && i > 20) {                
                collectie.add(new Strip("Jommeke", "schrijver", "Carl Barks", "De Boeck", i, "titel" + i));
            } else if (i < 60 && i > 40) {
                collectie.add(new Strip("Nero", "schrijver", "Jef", "Houtekiet", i, "titel_X_" + i));
            } else if (i < 80 && i > 60) {
                collectie.add(new Strip("Rode oortjes", "Andreas", "Andreas", "Lannoo", i, "titel_" + i));
            } else {
                collectie.add(new Strip("Roze ridder", "Jef", "Jef", "Houtekiet", i, "titel_" + i));
            }
        }
    }

    public Supplier<Stream<Strip>> stripMaker() {
        Supplier<Stream<Strip>> suppl = () -> collectie.stream();
        return suppl;
    }
    
    public Supplier<Stream<Strip>> stripMakerFile() {
        String filename = "C://Users//maliek.meersschaert//Downloads//Stripease02//Stripease02//test//stripease02//strips.txt";
        List<Strip> strips = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(s -> {
                String[] valuesArray = s.split("-");
                strips.add(new Strip(valuesArray[0], valuesArray[1], valuesArray[2], valuesArray[3], Integer.parseInt(valuesArray[4]), valuesArray[5]));
            });
        } catch (Exception e) {
        }
        Supplier<Stream<Strip>> suppl = () -> strips.stream();
        return suppl;
    }

    public void printSortStrips1() {
        stripMaker()
                .get()
                .sorted((e1, e2) -> {
                    if(e1.getReeksNaam().equals(e2.getReeksNaam())) {
                        return e1.getAlbumNummer() - e2.getAlbumNummer();
                    }
                    return e1.getReeksNaam().compareTo(e2.getReeksNaam());
                })
                .forEach(strip -> System.out.println(strip));                    
    }
    
    public void printSortStrips2() {
        stripMaker()
                .get()
                .sorted((e1,e2) -> {
                    if (!e1.getUitgeverij().equals(e2.getUitgeverij())) {
                        return e1.getUitgeverij().compareTo(e2.getUitgeverij());                        
                    }
                    if(!e1.getReeksNaam().equals(e2.getReeksNaam())) {
                        return e1.getReeksNaam().compareTo(e2.getReeksNaam());   
                    }
                    return e1.getAlbumNummer() - e2.getAlbumNummer();
                    
                })
                .forEach(strip -> System.out.println(strip));
    }
    
    public void printSortStrips3() {
        stripMaker()
                .get()
                .sorted((e1,e2) -> {
                    if (!e1.getTekenaar().equals(e2.getTekenaar())) {
                        return e1.getTekenaar().compareTo(e2.getTekenaar());                        
                    }
                    if(!e1.getReeksNaam().equals(e2.getReeksNaam())) {
                        return e1.getReeksNaam().compareTo(e2.getReeksNaam());   
                    }
                    return e1.getAlbumTitel().compareTo(e2.getAlbumTitel());
                    
                })
                .forEach(System.out::println);
    }
    
    public void filterStrip(String reeksNaam) {
        stripMaker()
                .get()
                .filter(strip -> strip.getReeksNaam().equals(reeksNaam))
                .forEach((System.out::println));
    }
    
    public void filterXTitles() {
        int aantalX = (int)stripMaker()
                .get()
                .filter(strip -> strip.getAlbumTitel().contains("X"))
                .count();
        
        System.out.println(aantalX);
    }
    
    public void streamToHashMap() {
        
        Map<String, SortedSet<Strip>> map = stripMakerFile()
                .get()
                .sorted((s1, s2) -> s1.getAlbumNummer() - s2.getAlbumNummer())
                .collect(Collectors.groupingBy(Strip::getReeksNaam, Collectors.toCollection(TreeSet::new)));
        
        map.entrySet().stream().forEach(set -> set.getValue().stream().limit(5).forEach(x -> System.out.println(x)));               
    }
}
