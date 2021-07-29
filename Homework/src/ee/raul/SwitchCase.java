package ee.raul;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class SwitchCase {

//    Switch case + Scanner
//
//    Võimalda kasutajal kirjutada Terminali
//    Küsi enne kasutajale kirjutamise võimalust mis keelt ta räägib
//    Täida Switch, kus kontrollid mis kasutaja sisestas ning vasta talle selles keeles „Tere“
//    Ümbritse see while() loopiga ehk küsi niikaua kuni kasutaja sisestab „stop“

    Scanner scanner = new Scanner(System.in);
    private String [] jaapaniKeel = {"お早うございます。", "今日は。", "今晩は。", "もう遅いから 寝てくださいね。"};
    private String [] malaiKeel = {"Selamat pagi.", "Selamat siang.", "Selamat sore.", "Selamat malam."};
    private String [] eestiKeel = {"Tere hommikust.", "Tere päevast.", "Tere õhtust.", "Head ööd."};
    private String [] leeduKeel = {"Labas rytas.", "Labas dienas.", "Labas vakaras.", "Labanaktys."};

    public void Harjutus1() {
        int kell = LocalTime.now().getHour();
        int i;
        System.out.println("Vali keel:");
        String keel = scanner.nextLine();

        if (kell > 5 && kell < 12) {
            i = 0;
        }
        else if (kell >= 12 && kell < 18) {
            i = 1;
        }
        else if (kell >= 18 && kell < 24) {
            i = 2;
        }
        else {
            i = 3;
        }
        switch(keel) {
            case "eesti":
                System.out.println(eestiKeel[i]);;
                break;
            case "leedu":
                System.out.println(leeduKeel[i]);
                break;
            case "malai":
                System.out.println(malaiKeel[i]);
                LocalDateTime.now();
                break;
            case "jaapani":
                System.out.println(jaapaniKeel[i]);


        }
    }

}
