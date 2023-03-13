package com.example.superherov4.dto;

public class RealNameSuperpowersDTO {
    private String superheroName;
    private String realName;
    private String superpowers;

    public RealNameSuperpowersDTO(String superheroName, String realName, String superpowers) {
        this.superheroName = superheroName;
        this.realName = realName;
        this.superpowers = superpowers;
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

    public String getSuperpowers() {
        return superpowers;
    }

    public void setSuperpowers(String superpowers) {
        this.superpowers = superpowers;
    }
}
