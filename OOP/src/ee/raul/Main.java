package ee.raul;

// KLASSI nime muutmiseks right-click > Refactor > Rename (muudab kõik koos)

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // Animal CLASSi OBJECTide (instantside) loomine,

        Animal kass = new Animal(70, 2, "Miisu", false, false, AnimalType.KASS);
        Animal koer = new Animal(80, 1, "Muri", true, false, AnimalType.KOER);
        Animal tiiger = new Animal(140, 5, "King", false, false, AnimalType.TIIGER);
        Animal rott = new Animal(10, 1, "Sipsi", false, false, AnimalType.ROTT);

        // main method läheb alati esimesena käima
        // ülal kass, koer jne on OBJECT, ehk instants CLASSist. Viitab OBJECT ORIENTED PROGRAMMINGule
        // KLASS on nagu andmemudel, ta kohustab väärtusi vastu võtma (määratud klassi loomisel)
        // instantsi (OBJECTi) loomisel peab alati kohustuslikud väärtused initsieerima

        rott.addChild(new Animal(2, 0, "N/A", true, false, AnimalType.ROTT));

        kass.changeToSold(); // siin on void, kuna pole vasakule poole muutujasse midagi panna
        koer.changeToSold();
        kass.increaseAge();
        koer.increaseAge();
        rott.changePrice(20);

        int koerPrice = koer.getPrice(); // siin on mingi tagastus (funktsiooni sees on return), mis pannakse vasakule)
        int kassPrice = kass.getPrice();
        int totalPrice = koerPrice + kassPrice;
        System.out.println(totalPrice);

        // muutujad PRIVATE'iks tehtud, seega allolevaid käske ei saa täita
        //int totalPrice = kass.price + koer.price;
        //System.out.println("Ostja koguhind oli: "+totalPrice);
        // toStringi testimine
        System.out.println(kass);
        System.out.println(koer);
        System.out.println(tiiger);
        System.out.println(rott);

        Bird papagoi = new Bird(45, 1, "Praagu", BirdColor.RED_YELLOW);
        Bird ookull = new Bird(55, 10, "Luigi", BirdColor.BROWN);
        Bird tihane = new Bird(40, 3, "Tihha", BirdColor.BLUE_YELLOW);
        Bird leevike = new Bird(50, 4, "Leevi", BirdColor.RED);

        System.out.println(papagoi);
        System.out.println(ookull);
        System.out.println(tihane);
        System.out.println(leevike);

        // List ja ArrayList importida

        List<Animal> koikLoomad = new ArrayList<Animal>();
        koikLoomad.add(kass);
        koikLoomad.add(koer);
        koikLoomad.add(tiiger);
        koikLoomad.add(rott);


        List<Bird> koikLinnud = new ArrayList<Bird>();
        koikLinnud.add(papagoi);
        koikLinnud.add(ookull);
        koikLinnud.add(tihane);
        koikLinnud.add(leevike);

        int koguSumma = 0;
        for (Animal loom:koikLoomad) {
            koguSumma += loom.getPrice();
        }

        for (Bird lind:koikLinnud) {
            koguSumma += lind.getPrice();
        }
        System.out.println("Kõikide loomade ostmiseks kogusumma: "+koguSumma);



    }
}
