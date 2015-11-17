package fr.soat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PersonneProvider {

    /**
     * load from file an array of {@link Personne}
     * 
     * @param filePath
     * @param nbPersons
     * @return a new arary
     */
    public static Personne[] load(String filePath, int nbPersons) {
        Personne[] array = new Personne[nbPersons];
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line = null;
            for (int j = 0; j < nbPersons; j++) {
                line = br.readLine();
                String[] firstLastName = line.split("\t");
                array[j] = new Personne(firstLastName[0], firstLastName[1]);
            }
        } catch (Exception e) {
            throw new RuntimeException("Can not read " + nbPersons + " personnes from " + filePath, e);
        }

        return array;
    }

    // public static void main(String[] args) {
    // load("personnes.txt", 2);
    // }

}
