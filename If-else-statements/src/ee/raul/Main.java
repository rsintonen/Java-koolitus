package ee.raul;
// package'i viide
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //objekt-orienteeritud programmeerimine sügav teema
        // hoia hiirt peal, et näha erroreid jne, lisaks peale punkti saab kõiki funktsioone näha.
        boolean trueVoiFalse = true;
        int number = 7;
        String sona = "inimene";
        char taht = 'a';
        // String-klass koosneb char-idest (ta ei ole omaette primitiiv), seepärast on suure tähega

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta oma vanus: ");
        String input = scanner.nextLine();
        int inputAsNumber = Integer.parseInt(input);
        System.out.println(input+1);
        System.out.println(inputAsNumber+2);

        // Stringe omavahel võrrelda ei saa
        // kasuta equals()

        switch(inputAsNumber) {
            case 18:
                System.out.println("Oled 18");
                break;
            case 21:
                System.out.println("Oled 21");
                break;
            default:
                System.out.println("Sa pole 18 ega 21");
                break;

        }
        // impordib Listi
        List array = new ArrayList();
        // Näiteks: kõik poetooted ühes listis ("sink", "coca-cola", "muna" jne)
        // massiivi läbikäimiseks saab kasutada for-tsüklit

        array.add("sink");
        array.add("coca");
        array.add("piim");
        array.add("õlu");
        array.add("toiduõli");
        array.add("või");

        // allolevad for ja while tsüklid on ühesugused
        for (int i = 0; i < array.size(); i++) { // hea kasutada array.size(), kui ma ei tea suurust
            System.out.println(array.get(array.size()-1));

        }
        int j = 0;
        /* while (j < array.size()) {
            System.out.println(array.get(j));
            j++;
        } */

        for(Object s: array) {
            System.out.println(s);
        }

    }
}
