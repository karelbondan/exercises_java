package com.assignment.genus;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        do {
            String choice, spesi, genus, sName;
            int cage;
            java.util.Scanner animal = new Scanner(System.in);
            java.util.Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("\nAdd animal? any char/n ");
                choice = animal.nextLine().toUpperCase(Locale.ROOT).trim();
                if (choice.equals("N"))
                    break;
                System.out.print("\nEnter Genus: ");
                genus = animal.nextLine().toUpperCase(Locale.ROOT).trim();
                System.out.print("Enter Species: ");
                spesi = animal.nextLine().toUpperCase(Locale.ROOT).trim();
                System.out.print("Enter Name: ");
                sName = animal.nextLine().toUpperCase(Locale.ROOT).trim();
                System.out.print("Enter Cage number: ");
                cage = scanner.nextInt();

                Species spesies = new Species(spesi, genus);
                Specimen spesimen = new Specimen(sName, cage, spesies);

                if (!Additional.makeList(spesimen)) {
                    System.out.println("An entry with the same exact details is found in the database");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid data type");
            }
        } while (true);
        System.out.println("\nSpecimens:");
        for (Specimen speciman : Additional.getSpecimen()) {
            System.out.println(speciman);
        }

        System.out.println("\nSpecies:");
        LinkedList<Species> species = Additional.makeSpeciesList(Additional.getSpecimen());
        for (Species a : species) {
            System.out.println(a);
        }

        System.out.println("\nUnique Species:");
        LinkedList<Species> unique = Additional.makeSpeciesListUnique(species);
        for (Species b : unique) {
            System.out.println(b);
        }
    }
}
