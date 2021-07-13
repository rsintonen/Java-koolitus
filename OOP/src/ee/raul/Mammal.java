package ee.raul;
import java.util.*;

// pangas konto class
// public double kontojääk;

// -1000000
// MAINIS - konto.kontojääk = +1000000;

// kui keeran kinni (teen PRIVATE'iks), siis enam otse ligi ei pääse, peab looma ja kasutama funktsiooni
// see sätestab tingimused, kuidas seda muuta saan

// -1000000
// lisaPanka(1000)
// võtaPangast(10000)

public class Mammal extends Animal {
    // tavaliselt kõik need pannakse private'iks
    private boolean isPuppy; //true/false
    private int birthYear; // number
    private MammalType mammalType; // AnimalType enumist välja kutsutav
    private List<Mammal> children = new ArrayList<>(); // [Animal{}, Animal{}]; ei pea olema kohustuslik väli

    // List<Animal> children ---- null <-- siia ei saa juurde lisada elemente
    // List<Animal> children = new ArrayList<>() ---- [] <-- siia saab juurde lisada elemente


    // See on constructor, sulgude sees antakse väärtusi, kui see klass luuakse

    public Mammal(int _price, int _age, String _name, boolean _isPuppy, boolean _isSold, MammalType _mammalType) {
        super(_price, _age, _name, _isSold);
        this.isPuppy = _isPuppy;
        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        this.birthYear = year - _age;
        this.mammalType = _mammalType;


    }

    public void increaseAge() {
        increaseAgeByOne();
        if (getAge() > 1) {
            this.isPuppy = false;
        }
    }

    public List<Mammal> getChildren() {
        return children;
    }

    private void printChildren() {
        for (int i = 0; i < children.size(); i++) {
            System.out.println(i+1 + ". " + children.get(i).getName());
        }
    }

    public void printOneChild() {
        if (children.size() > 0) {

            System.out.println("Sul on valida nende laste seast: ");
            printChildren();

            Scanner scanner = new Scanner(System.in);

            String childName = null;
            while (childName == null) {
                System.out.println("Ütle lapse number millist soovid: ");
                String input = scanner.nextLine();
                try {
                    int i = Integer.parseInt(input);
                    childName = children.get(i - 1).getName();
                    System.out.println("Valisid lapse: " + childName);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Valisid numbri asemel tähe!");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Error: Valisid vale numbri!");
                }
            }

        }

    }

        public void addChild(Mammal child) {
        if (this.isPuppy) {
            System.out.println("Tegemist on kutsikaga, lapsi lisada ei saa!");
        }
        else {
            this.children.add(child);
        }
    }

    // kui toStringi ei ole, siis prindib ainult mälukoha välja
    @Override
    public String toString() {
        return "Animal{" +
                "price=" + getPrice() +
                ", age=" + getAge() +
                ", name='" + getName() + '\'' +
                ", isPuppy=" + isPuppy +
                ", isSold=" + isSold() +
                ", birthYear=" + birthYear +
                ", animalType=" + mammalType +
                '}';
    }
}