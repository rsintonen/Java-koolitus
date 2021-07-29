package ee.raul;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> nimeKiri = new ArrayList<>();
        Person mati = new Person("mati", 30);
        Nimekiri nmk = new Nimekiri();
        nmk.addToNimekiri();
        nmk.streamNimekiri();
        nmk.kontrolliNimekirja();
    }
}
