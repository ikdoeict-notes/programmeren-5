package Logica;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leander
 */
public class Eindwerk implements Comparable<Eindwerk> {
    private String titel;
    private int jaartal;
    public String opleiding;
    private Student student;   
    
    public Eindwerk(String t, int j, String o, Student s) {
        titel = t;
        jaartal = j;
        opleiding = o;
        student = s;
    }

    @Override
    public int compareTo(Eindwerk eindwerk) {
        if (this.opleiding == eindwerk.opleiding) {
            if (this.student.achternaam == eindwerk.student.achternaam) {
                return this.student.voornaam.compareTo(eindwerk.student.voornaam);
            }
            else return this.student.achternaam.compareTo(eindwerk.student.achternaam);
        }
        else return this.opleiding.compareTo(eindwerk.opleiding);           
    }
}
