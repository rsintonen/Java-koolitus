package ee.raul;

import java.util.Scanner;

// extends = inheritance
//
public class Reptile extends Animal {

    private int familyCount;
    private static int breedCount;

    private String originCountry;

    // short 32,767 numbrit
    // int 2,123,123,123 numbrit
    //

    public Reptile(int age, String name, String originCountry) {
        super(10000, age, name);
        this.originCountry = originCountry;
        this.familyCount = 1;
        breedCount = 1;
        // suurendades MAX väärtust teeb ringi peale
        this.familyCount = Integer.MAX_VALUE;
    }

    public int getFamilyCount() {
        return familyCount;
    }

    public void increaseFamilyCount() {
        this.familyCount++;
    }

    public static int getBreedCount() {
        return breedCount;
    }

    public static void increaseBreedCount() {
        Reptile.breedCount++;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    // Polymorphism = millegi ülekirjutamine lapsklassides


    @Override
    public String toString() {
        return "Reptile{" +
                "originCountry='" + originCountry + '\'' +
                '}';
    }
}
