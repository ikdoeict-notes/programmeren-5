package stripease02;

import java.util.*;

public class StripCollectie implements IStripCollectie {
    
    public SortedMap<String,SortedSet<Strip>> strips;
    
    public StripCollectie() {
        strips = new TreeMap<>();
    }
    @Override
    public Strip[] getStrips(String reeks) {
        Set<Strip> strip = strips.get(reeks);        
        if (strip.isEmpty()) {
            return null;
        }       
        return strip.toArray(new Strip[strip.size()]);
    }

    @Override
    public void verwijder(Strip strip) {
        strips.get(strip.getReeksNaam()).remove(strip);
    }

    @Override
    public void voegToe(Strip strip) {
        if (!strips.containsKey(strip.getReeksNaam())) {
            strips.put(strip.getReeksNaam(), new TreeSet<Strip>());  
        }              
        strips.get(strip.getReeksNaam()).add(strip);       
    }
}