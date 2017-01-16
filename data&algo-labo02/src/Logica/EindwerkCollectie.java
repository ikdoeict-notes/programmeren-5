package Logica;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leander
 */
public class EindwerkCollectie implements EindwerkCollectieInterface {
    private List<Eindwerk> eindwerkenlijst;    
    private List<Student> studentenlijst;
    
    public EindwerkCollectie() {
        eindwerkenlijst = new ArrayList<Eindwerk>();
    }
    
    @Override
    public Eindwerk[] getEindwerkenVanOpleiding(String opleiding) {
        //SortedSet<Eindwerk> s = new TreeSet<Eindwerk>();
        List<Eindwerk> ls = new ArrayList<Eindwerk>();
        //eindwerkenlijst.stream().filter(e -> e.opleiding == opleiding).forEach(e -> ls.add(e));
        for (int i = 0; i < eindwerkenlijst.size(); i++) {
            if (eindwerkenlijst.get(i).opleiding.equals(opleiding) && !ls.contains(eindwerkenlijst.get(i))) ls.add(eindwerkenlijst.get(i));
        }
       
        Eindwerk[] e = new Eindwerk[ls.size()];
        
        if (ls.size() != 0) {     
            
            for (int i = 0; i < ls.size(); i++) {
                e[i] = ls.get(i);
            }
            
            Arrays.sort(e);
        }
        else e = null;

        return e;
    }

    @Override
    public void verwijder(Eindwerk eindwerk) {
        eindwerkenlijst.remove(eindwerk);        
    }

    @Override
    public void voegToe(Eindwerk eindwerk) {
        eindwerkenlijst.add(eindwerk);
    }
    
    public void AddStudent(String v, String a) {
        Student s = new Student(v, a);
        studentenlijst.add(s);
    }    
}
