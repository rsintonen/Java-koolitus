package ee.raul;

import java.util.List;

public class MainController {

    // public static void meetod > saab otse välja kutsuda

    public static void addChildrenToMammal(Mammal mammal) {
        mammal.addChild(new Mammal(2, 0, "Sipsi II", true, false, mammal.getMammalType()));
        mammal.addChild(new Mammal(3, 1, "Rott1", true, false, mammal.getMammalType()));
        mammal.addChild(new Mammal(4, 2, "Rott2", true, false, mammal.getMammalType()));
        mammal.addChild(new Mammal(5, 3, "Rott3", true, false, mammal.getMammalType()));
        mammal.addChild(new Mammal(6, 4, "Rott4", true, false, mammal.getMammalType()));
    }

    public static void calculateObjectSum(Mammal koer, Mammal kass) {
        kass.changeToSold(); // siin on void, kuna pole vasakule poole muutujasse midagi panna
        koer.changeToSold();
        kass.increaseAge();
        koer.increaseAge();

        int koerPrice = koer.getPrice(); // siin on mingi tagastus (funktsiooni sees on return), mis pannakse vasakule)
        int kassPrice = kass.getPrice();
        int totalPrice = koerPrice + kassPrice;
        System.out.println(totalPrice);
    }

    public static void printObjects(List<Animal> animals) {
        for (Animal a: animals) {
            System.out.println(a);

        }
    }

    public static void calculateTotalAmount(List <Animal> animals) {
        int koguSumma = 0;
        for (Animal loom:animals) {
            koguSumma += loom.getPrice();
        }
        System.out.println("Kõikide loomade ostmiseks kogusumma: "+koguSumma);
    }

    public static void setAndPrintReptileCount(Reptile krokodill, Reptile kilpkonn, Reptile sisalik) {
        // krokodill.increaseFamilyCount();
        krokodill.increaseBreedCount();
        System.out.println(krokodill.getFamilyCount());
        System.out.println(krokodill.getBreedCount());

        kilpkonn.increaseFamilyCount();
        kilpkonn.increaseBreedCount();
        System.out.println(kilpkonn.getFamilyCount());
        System.out.println(kilpkonn.getBreedCount());

        sisalik.increaseFamilyCount();
        sisalik.increaseBreedCount();
        System.out.println(sisalik.getFamilyCount());
        System.out.println(sisalik.getBreedCount());

    }
}
