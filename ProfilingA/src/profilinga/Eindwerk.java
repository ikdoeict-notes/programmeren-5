/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profilinga;

/**
 *
 * @author seppesnoeck
 */
public class Eindwerk implements Comparable<Eindwerk> {
    String titel;
    int jaartal;
    String opleiding;
    Student student;

    public Eindwerk(String titel, int jaartal, String opleiding, Student student) {
        this.titel = titel;
        this.jaartal = jaartal;
        this.opleiding = opleiding;
        this.student = student;
    }
    
    public String getOpleiding(){ return this.opleiding; }    
    public String getVoornaam(){ return this.student.voornaam; }
    public String getFamilienaam(){ return this.student.familienaam; }

    
    @Override
    public int compareTo(Eindwerk eindwerk) {
        if (this.opleiding == eindwerk.opleiding) {
            if (this.student.familienaam == eindwerk.student.familienaam) {
                return this.student.voornaam.compareTo(eindwerk.student.voornaam);
            }
            else return this.student.familienaam.compareTo(eindwerk.student.familienaam);
        }
        else return this.opleiding.compareTo(eindwerk.opleiding);           
    }
}
