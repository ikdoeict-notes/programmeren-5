/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alienregistry;

/**
 *
 * @author Nicolas
 */
public class Visit implements Comparable<Visit>{
    
    @Override
    public int compareTo(Visit o) {
        return id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Visit other = (Visit) obj;
        if (this.id == null ? other.id != null : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    public enum Reason {
        TRADE, DIPLOMACY, PLEASURE, WAR
    }
    private int year;
    private Reason reason;
    private Alien alien;
    private String id;
    
    public Visit (Reason reason, int year, Alien alien, String id) {
        this.reason = reason;
        this.year = year;
        this.alien = alien;
        this.id = id;
    }

    public Alien getAlien() {
        return alien;
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }    

    @Override
    public String toString() {
        return year + ": " + reason + ": " + alien.getName() + "(" + alien.getAge() + ")";
    }
}
