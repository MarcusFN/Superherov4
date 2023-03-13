package com.example.superherov4.dto;

public class HeroNameCreationDTO {
    private String superheroName;
    private String realName;
    private int creationYear;

    public HeroNameCreationDTO(String superheroName, String realName, int creationYear) {
        this.superheroName = superheroName;
        this.realName = realName;
        this.creationYear = creationYear;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }
}
