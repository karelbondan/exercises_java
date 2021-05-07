package com.assignment.genus;

public class Genus {
    private String genusName;

    public Genus(String name){
        this.genusName = name;
    }

    public void setGenusName(String genusName) {
        this.genusName = genusName;
    }

    public String getGenusName() {
        return genusName;
    }

    @Override
    public String toString() {
        return "Genus name = " + genusName;
    }
}
