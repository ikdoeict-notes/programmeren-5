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
public class Alien {
    private String name;
    private int age;
    private String planet;
    private String color;
    public int id;
    
    public Alien(String name, int age, String planet, String color, int id) {
        this.name = name;
        this.age = age;
        this.planet = planet;
        this.color = color;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return name + "(" + age + ") from " + planet + " has a " + color + " skin color";
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
        final Alien other = (Alien) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
