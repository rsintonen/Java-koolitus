package ee.raul;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // SwitchCase
        // loome uue instantsi SwitchCase klassist
        SwitchCase test = new SwitchCase();
        test.Harjutus1();

        // ENUM
        List<Loomad> loomad = new ArrayList<>();
        loomad.add(Loomad.HÜÄÄN);
        loomad.add(Loomad.VAAL);
        loomad.set(1, Loomad.ÜKSSARVIK);
        loomad.add(Loomad.VAAL);
        System.out.println(loomad);

        for (Loomad loom:loomad) {
            System.out.println(loom);
        }
        
        // Inheritance

        Scanner ohPlease = new Scanner(System.in);

        SuperAdmin adminMadis = new SuperAdmin("Madis", "Teeveer", 26, "3456789");
        Admin adminRobert = new Admin("Robert", "Puusepp", 55);

        System.out.println(adminMadis.identificationCode);
        System.out.println(adminRobert.identificationCode);

        adminMadis.getsPaid = ohPlease.nextBoolean();
        System.out.println(adminMadis.getsPaid);

        for (int i = 0; i < 3; i++) {
            if (adminMadis.getsPaid = true) {
                adminMadis.maksaPalka();
                System.out.println(adminMadis.pangaArve);
            }
            else {
                System.out.println("Sorry, Madisele ei maksta palka.");
            }
        }
    }
}
