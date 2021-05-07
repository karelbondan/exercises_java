package com.assignment.genus;

public class Species extends Genus{
    private String speciesName;

    public Species(String species, String genus){
        super(genus);
        setSpeciesName(species);
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    @Override
    public String toString() {
        return getGenusName() + " " + speciesName;
    }

    public boolean equals(Species s){
        return speciesName.equals(s.getSpeciesName());
    }
}
