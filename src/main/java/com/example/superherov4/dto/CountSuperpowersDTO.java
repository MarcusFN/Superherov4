package com.example.superherov4.dto;

public class CountSuperpowersDTO {
    private String superheroName;
    private String realName;
    private int superpowersAmount;

    public CountSuperpowersDTO(String superheroName, String realName, int superpowersAmount) {
        this.superheroName = superheroName;
        this.realName = realName;
        this.superpowersAmount = superpowersAmount;
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

    public int getSuperpowersAmount() {
        return superpowersAmount;
    }

    public void setSuperpowersAmount(int superpowersAmount) {
        this.superpowersAmount = superpowersAmount;
    }
}
