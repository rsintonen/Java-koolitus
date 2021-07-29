package ee.raul;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Nimekiri {
    private List<String> strNimekiri = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public boolean kinni = true;
    String sisend;

    public void addToNimekiri() {
        boolean sulge = false;
        System.out.println("Nimekirja lisamiseks sisesta nimi: ");
        System.out.println("(Lõpetamiseks sisesta \"valmis\")");
        while(!sulge) {
            sisend = scanner.nextLine();
            if (sisend.equals("valmis")) {
                sulge = true;
            }
            else {
                strNimekiri.add(sisend);
            }
        }
    }
    public void kontrolliNimekirja() {
        System.out.println("Sisesta korduv nimi:");

        while (!sisend.equals("valmis")) {
            sisend = scanner.nextLine();
            if (strNimekiri.stream().anyMatch(x -> x.equals(sisend))) {
                System.out.println("See nimi on juba olemas, sisesta uuesti:");
            } else {
                strNimekiri.add(sisend);
            }
        }
    }
    public void streamNimekiri() {
        System.out.println("Sisesta täht või kombinatsioon, mida otsid:");
        sisend = scanner.nextLine();
        System.out.println(strNimekiri.stream().filter(x -> x.contains(sisend)).collect(Collectors.toList()));
        strNimekiri.stream().filter(x -> (x.length() == 4)).forEach(System.out::println);
    }
}
