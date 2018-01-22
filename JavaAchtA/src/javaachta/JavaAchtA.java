/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaachta;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author seppesnoeck
 */
public class JavaAchtA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Student> studentenLijst = Student.genStudents();
        List<Eindwerk> eindwerkenLijst = Eindwerk.genEindwerken(studentenLijst);
        
        Supplier<Stream<Student>> studenten = () -> studentenLijst.stream();
        Supplier<Stream<Eindwerk>> eindwerken = () -> eindwerkenLijst.stream();
//        System.out.println("Original:");
//        studenten.get().forEach(System.out::println);
//        
//        System.out.println("Sorted:");
//        studenten.get().sorted(Comparator.comparing(Student::getLastName)
//                .thenComparing(Student::getFirstName).thenComparing(Student::getNumber))
//                .forEach(System.out::println);
//        
//        System.out.println("Eindwerken ICT:");
//        eindwerken.get().filter(e -> e.getOpleiding().equals("ICT")).forEach(System.out::println);
//
//        System.out.println("Eindwerken startende met T:");
//        Map<String, List<Eindwerk>> map = eindwerken.get()
//                .filter(e -> e.getOpleiding().substring(e.getOpleiding().length() - 1).equals("T"))
//                .sorted(Comparator.comparing(Eindwerk::getTitle))
//                .collect(Collectors.groupingBy(Eindwerk::getOpleiding));
//        map.forEach((k, v) -> System.out.println("key: " + k + " value: " + v.stream().limit(5).map(e -> e.student.voornaam).collect(toList())));
        
        List<Stream<Eindwerk>> losEindwerken = new ArrayList<Stream<Eindwerk>>();
        List<String> opleidingen = new ArrayList<String>();
        eindwerken.get().map(e -> e.opleiding).distinct().forEach(e -> opleidingen.add(e));
        for(String opl : opleidingen){
            losEindwerken.add(eindwerken.get().filter(e -> { return e.opleiding.equals(opl);}));
        }
        Stream<Stream<Eindwerk>> sosEindwerken = losEindwerken.stream();
        
        sosEindwerken.map(s -> 
                s.collect(groupingBy(e -> e.opleiding + e.jaartal, Collectors.counting())))
                .forEach(m -> {
                    for (String key : m.keySet()){
                        System.out.println(key + " " + m.get(key));
                    }
                });
    }
    
    

}
