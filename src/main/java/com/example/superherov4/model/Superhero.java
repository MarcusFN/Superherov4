package com.example.superherov4.model;

public class Superhero {
    private int id;
    private String superHeroName;
    private String realName;
    private boolean isHuman;
    private String superPower;
    private int creationYear;
    private double powerLevel;
    private String city;


    //konstruktør


    public Superhero(int id, String superHeroName, String realName, boolean isHuman, int creationYear, double powerLevel) {
        this.id = id;
        this.superHeroName = superHeroName;
        this.realName = realName;
        this.isHuman = isHuman;
        this.creationYear = creationYear;
        this.powerLevel = powerLevel;
    }

    public Superhero() {

    }


    public Superhero(int id, String superHeroName, String reelName, int creationYear) {
        this.id = id;
        this.superHeroName = superHeroName;
        this.realName = reelName;
        this.creationYear = creationYear;
    }

    //Gettere


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public void setSuperHeroName(String superHeroName) {
        this.superHeroName = superHeroName;
    }

    public String getReelName() {
        return realName;
    }

    public void setReelName(String reelName) {
        this.realName = reelName;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public double getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(double powerLevel) {
        this.powerLevel = powerLevel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "id=" + id +
                ", superHeroName='" + superHeroName + '\'' +
                ", reelName='" + realName + '\'' +
                ", creationYear=" + creationYear +
                '}';
    }
}
