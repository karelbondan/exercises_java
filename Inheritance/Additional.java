package com.assignment.genus;
import java.util.LinkedList;

public class Additional {
    private static LinkedList<Specimen> specimen = new LinkedList<>();

    public static boolean makeList(Specimen animals) { // I changed the datatype from LinkedList to boolean because the problem does not specify to return the linked list.
        if (!specimen.isEmpty()) {
            for (Specimen speciman : specimen) {
                if (speciman.getName().equals(animals.getName()) && speciman.getTOA().equals(animals.getTOA())) {
                    return false;
                }
            }
        }
        specimen.add(animals);
        return true;
    }

    public static LinkedList<Species> makeSpeciesList(LinkedList<Specimen> animals) {
        LinkedList<Species> species = new LinkedList<>();
        for (Specimen animal : animals) {
            species.add(animal.getTOA());
        }
        return species;
    }

    public static LinkedList<Species> makeSpeciesListUnique(LinkedList<Species> allSpecies) {
        LinkedList<Species> uniqueSpecies = new LinkedList<>();
        for (Species allSpecy : allSpecies) {
            boolean check = false;
            if (uniqueSpecies.isEmpty()) {
                uniqueSpecies.add(allSpecy);
            } else {            // I didn't use LinkedList.contains() because it contains the object address not the TOA String.
                for (Species uniqueSpecy : uniqueSpecies) {
                    if (uniqueSpecy.getSpeciesName().equals(allSpecy.getSpeciesName())) {
                        check = true;
                        break;
                    }
                }
                if (!check)
                    uniqueSpecies.add(allSpecy);
            }
        }
        return uniqueSpecies;
    }

    public static LinkedList<Specimen> getSpecimen() {
        return specimen;
    }
}
