/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stripease02;

import java.util.Objects;

/**
 *
 * @author maliek.meersschaert
 */
class Strip implements Comparable<Strip> {

    private String reeksNaam ;
    private String schrijver;
    private String tekenaar;
    private String uitgeverij;
    private int albumNummer;
    private String albumTitel;

    Strip(String reeksNaam, String schrijver, String tekenaar, String uitgeverij, int albumNummer, String albumTitel) {
        this.reeksNaam = reeksNaam;
        this.schrijver = schrijver;
        this.tekenaar = tekenaar;
        this.uitgeverij = uitgeverij;
        this.albumNummer = albumNummer;
        this.albumTitel = albumTitel;
    }

    public String getReeksNaam() {
        return reeksNaam;
    }

    public void setReeksNaam(String reeksNaam) {
        this.reeksNaam = reeksNaam;
    }

    public String getSchrijver() {
        return schrijver;
    }

    public void setSchrijver(String schrijver) {
        this.schrijver = schrijver;
    }

    public String getTekenaar() {
        return tekenaar;
    }

    public void setTekenaar(String tekenaar) {
        this.tekenaar = tekenaar;
    }

    public String getUitgeverij() {
        return uitgeverij;
    }

    public void setUitgeverij(String uitgeverij) {
        this.uitgeverij = uitgeverij;
    }

    public int getAlbumNummer() {
        return albumNummer;
    }

    public void setAlbumNummer(int albumNummer) {
        this.albumNummer = albumNummer;
    }

    public String getAlbumTitel() {
        return albumTitel;
    }

    public void setAlbumTitel(String albumTitel) {
        this.albumTitel = albumTitel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Strip other = (Strip) obj;
        if (this.albumNummer != other.albumNummer) {
            return false;
        }
        if (!Objects.equals(this.reeksNaam, other.reeksNaam)) {
            return false;
        }
        if (!Objects.equals(this.schrijver, other.schrijver)) {
            return false;
        }
        if (!Objects.equals(this.tekenaar, other.tekenaar)) {
            return false;
        }
        if (!Objects.equals(this.uitgeverij, other.uitgeverij)) {
            return false;
        }
        if (!Objects.equals(this.albumTitel, other.albumTitel)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return this.tekenaar + "||" + this.uitgeverij + "||" + this.reeksNaam + "||" + this.albumTitel + "||" + this.albumNummer;
    }

    @Override
    public int compareTo(Strip o) {
        if (this.reeksNaam.equals(o.reeksNaam)) {
            return this.albumNummer - o.albumNummer;
        }
        return this.reeksNaam.compareTo(o.reeksNaam);
    }
    
}
