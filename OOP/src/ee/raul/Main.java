package ee.raul;

// KLASSI nime muutmiseks right-click > Refactor > Rename (muudab kõik koos)

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // Animal CLASSi OBJECTide (instantside) loomine,

        Mammal kass = new Mammal(70, 2, "Miisu", false, false, MammalType.KASS);
        Mammal koer = new Mammal(80, 1, "Muri", true, false, MammalType.KOER);
        Mammal tiiger = new Mammal(140, 5, "King", false, false, MammalType.TIIGER);
        Mammal tiiger2 = new Mammal(140, 5, "King", false, false, MammalType.TIIGER);
        Mammal rott = new Mammal(10, 1, "Sipsi", false, false, MammalType.ROTT);

        // main method läheb alati esimesena käima
        // ülal kass, koer jne on OBJECT, ehk instants CLASSist. Viitab OBJECT ORIENTED PROGRAMMINGule
        // KLASS on nagu andmemudel, ta kohustab väärtusi vastu võtma (määratud klassi loomisel)
        // instantsi (OBJECTi) loomisel peab alati kohustuslikud väärtused initsieerima

        MainController.addChildrenToMammal(rott);
        MainController.addChildrenToMammal(kass);

        rott.printOneChild();

        rott.setPrice(20);

        MainController.calculateObjectSum(koer, kass);

        // muutujad PRIVATE'iks tehtud, seega allolevaid käske ei saa täita
        //int totalPrice = kass.price + koer.price;
        //System.out.println("Ostja koguhind oli: "+totalPrice);
        // toStringi testimine

        Bird papagoi = new Bird(45, 1, "Praagu", BirdColor.RED_YELLOW);
        Bird ookull = new Bird(55, 10, "Luigi", BirdColor.BROWN);
        Bird tihane = new Bird(40, 3, "Tihha", BirdColor.BLUE_YELLOW);
        Bird leevike = new Bird(50, 1, "Leevi", BirdColor.RED);

        // List ja ArrayList importida

        List<Animal> koikLoomad = new ArrayList<>();
        // koikLoomad.add(kass);
        // koikLoomad.add(koer);
        // koikLoomad.add(tiiger);
        // koikLoomad.add(rott);
        // koikLoomad.add(papagoi);
        // koikLoomad.add(ookull);
        // koikLoomad.add(tihane);
        // koikLoomad.add(leevike);
        koikLoomad = Arrays.asList(kass,koer,tiiger,tiiger2,rott,papagoi,ookull,tihane,leevike);

        List<Animal> koikLinnud = new ArrayList<>();
        koikLinnud.add(papagoi);
        koikLinnud.add(ookull);
        koikLinnud.add(tihane);
        koikLinnud.add(leevike);

        MainController.printObjects(koikLoomad);

        MainController.calculateTotalAmount(koikLoomad);

        Reptile krokodill = new Reptile(99, "Gena", "Venemaa");
        Reptile kilpkonn = new Reptile(150, "Mutant", "Keenia");
        Reptile sisalik = new Reptile(50, "Sissi", "Brasiilia");

        MainController.setAndPrintReptileCount(krokodill, kilpkonn, sisalik);

        try {
            leevike.increaseBirdAge();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<MammalType, Integer> animalsCount = new HashMap<>();
        // animalsCount.put(MammalType.KASS, 7);

        List<Mammal> koikImetajad = Arrays.asList();

        for (Mammal m:koikImetajad) {
                if (animalsCount.containsKey(m.getMammalType())) {
                    animalsCount.put(m.getMammalType(), animalsCount.get(m.getMammalType())+1);
                }
                else {
                    animalsCount.put(m.getMammalType(), 1);
                }

        }

        animalsCount.forEach((key, value) -> System.out.println(key + " " + value));



        for (Animal a:koikLoomad) {
            if (a.getClass().getName().equals("ee.raul.Mammal")) {
                if (animalsCount.containsKey(((Mammal) a).getMammalType())) {
                    animalsCount.put(((Mammal) a).getMammalType(), animalsCount.get(((Mammal) a).getMammalType()));
                }
                else {
                    animalsCount.put(((Mammal) a).getMammalType(), 1);
                }
            }
        }
        animalsCount.forEach((key, value) -> System.out.println(key + " " + value));


    }


}
