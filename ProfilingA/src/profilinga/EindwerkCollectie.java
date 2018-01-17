/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profilinga;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

/**
 *
 * @author seppesnoeck
 */
public class EindwerkCollectie implements IEindwerkCollectie {

    //List<Eindwerk> eindwerkenlist = new ArrayList<Eindwerk>(); //2300 ms
    //SortedSet<Eindwerk> eindwerkenlist = new TreeSet<Eindwerk>(); //478 ms
    //HashSet<Eindwerk> eindwerkenlist = new HashSet<Eindwerk>(); //5602 ms
    //Queue<Eindwerk> eindwerkenlist = new ArrayDeque<Eindwerk>(); //2175 ms
    //Stack<Eindwerk> eindwerkenlist = new Stack<Eindwerk>(); //2333ms
    Queue<Eindwerk> eindwerkenlist = new LinkedList<Eindwerk>(); //2227ms
    
    @Override
    public Eindwerk[] getEindwerkenVanOpleiding(String opleiding) {
        List<Eindwerk> sorted = eindwerkenlist.stream()
                .filter(e -> e.opleiding.equals(opleiding))
                .distinct()
                .sorted(Comparator.comparing(Eindwerk::getFamilienaam))
                .collect(Collectors.toList());
           
        return sorted.size() > 0 ? sorted.toArray(new Eindwerk[sorted.size()]) : null;
    }

    @Override
    public void verwijder(Eindwerk eindwerk) {
        eindwerkenlist.remove(eindwerk);
    }

    @Override
    public void voegToe(Eindwerk eindwerk) {
        eindwerkenlist.add(eindwerk);
    }
    
}
