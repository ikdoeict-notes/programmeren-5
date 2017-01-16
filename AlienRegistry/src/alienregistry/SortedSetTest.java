/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alienregistry;

import java.util.SortedSet;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author Nicolas
 */
public class SortedSetTest {    
    public static void testSortedSet(SortedSet<Visit> visits, Visit.Reason reason, int yearMin, int yearMax) {
        Supplier<Stream<Visit>> visitMaker = () -> visits.stream();
        
        System.out.println("Counting all visits...");
        long t0 = System.nanoTime();
        long count = visitMaker.get()
                        .sorted((Visit v1, Visit v2) -> {
                            return Integer.compare(v1.getYear(), v2.getYear());
                        })
                        .count();
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(count + " results in " + millis + " ms" );
        
        System.out.println("Counting all visits for " + reason.toString() + "...");
        t0 = System.nanoTime();
        count = visitMaker.get()
                    .filter(x -> x.getReason() == reason)
                    .sorted((Visit v1, Visit v2) -> {
                        return Integer.compare(v1.getYear(), v2.getYear());
                    })
                    .sorted((Visit v1, Visit v2) -> {
                        return v1.getAlien().getName().compareTo(v2.getAlien().getName());
                    })
                    .count();
        t1 = System.nanoTime();
        millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(count + " results in " + millis + " ms" );
        
        System.out.println("Counting all visits taking place in " + yearMin + "...");
        t0 = System.nanoTime();
        count = visitMaker.get()
                    .filter(x -> x.getYear() == yearMin)
                    .sorted((Visit v1, Visit v2) -> {
                        return v1.getAlien().getName().compareTo(v2.getAlien().getName());
                    })
                    .count();
        t1 = System.nanoTime();
        millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(count + " results in " + millis + " ms" );
        
        System.out.println("Counting all visits taking place between " + yearMin + " & " + yearMax + "...");
        t0 = System.nanoTime();
        count = visitMaker.get()
                        .filter(x -> x.getYear() >= yearMin && x.getYear() <= yearMax)
                        .sorted((Visit v1, Visit v2) -> {
                            return v1.getAlien().getName().compareTo(v2.getAlien().getName());
                        })
                        .count();
        t1 = System.nanoTime();
        millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(count + " results in " + millis + " ms" );
    }
}
