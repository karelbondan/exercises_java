package com.assignment.genus;

import java.util.LinkedList;

public class Specimen {
    private String name;
    private int cageNumber;
    private Species toa;

    public Specimen(String name, int cage, Species species) {
        setName(name);
        setCage(cage);
        setTOA(species);
    }

    @Override
    public String toString() {
        return name + " is a " + toa + " in cage " + cageNumber;
    }

    public Species getTOA() {
        return toa;
    }

    public int getCage() {
        return cageNumber;
    }

    public String getName() {
        return name;
    }

    public void setTOA(Species toa) {
        this.toa = toa;
    }

    public void setCage(int cageNumber) {
        this.cageNumber = cageNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int countSpecimen(LinkedList<Specimen> animals, Species s) {
        int specimenCount = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (s.equals(animals.get(i).getTOA())) {
                specimenCount++;
            }
        }
        return specimenCount;
    }
}
