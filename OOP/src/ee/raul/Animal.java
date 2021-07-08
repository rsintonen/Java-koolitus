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

public class Animal {
    // tavaliselt kõik need pannakse private'iks
    private int price; // number
    private int age; // number
    private String name; // sõna
    private boolean isPuppy; //true/false
    private boolean isSold; // true / false
    private int birthYear; // number
    private AnimalType animalType; // AnimalType enumist välja kutsutav
    private List<Animal> children = new ArrayList<>(); // [Animal{}, Animal{}]; ei pea olema kohustuslik väli

    // List<Animal> children ---- null <-- siia ei saa juurde lisada elemente
    // List<Animal> children = new ArrayList<>() ---- [] <-- siia saab juurde lisada elemente
    

    // See on constructor, sulgude sees antakse väärtusi, kui see klass luuakse

    public Animal(int _price, int _age, String _name, boolean _isPuppy, boolean _isSold, AnimalType _animalType) {
        this.price = _price;
        this.age = _age;
        this.name = _name;
        this.isPuppy = _isPuppy;
        this.isSold = _isSold;
        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        this.birthYear = year - _age;
        this.animalType = _animalType;


    }
    public void changeToSold() {
        // looma müümise hetkel kutsutakse funktsioon välja
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kas vajalikud dokumendid on esitatud?");
        String input = scanner.nextLine();
        if (input.equals("jah")) {
            // NB proovi toLowerCase juurde panna (tavaliselt front endist nupuga)
            this.isSold = true;
            System.out.println("Müüdud");
        }
        else {
            System.out.println("Ei saa dokumentideta müüa");
        }

        // this. << viitab instantsile (kass, koer jne)
    }

    public void increaseAge() {
        this.age++;
        if (this.age > 1) {
            this.isPuppy = false;
        }
    }

    public void changePrice(int newPrice) {
        this.price = newPrice;
    }

    public int getPrice() {
        // private price'i tagastamiseks (tuleb kutsuda kujul int koerPrice = koer.getPrice();)
        return this.price;
    }

    public List<Animal> getChildren() {
        return children;
    }


        public void addChild(Animal child) {
        if (this.isPuppy) {
            System.out.println("Tegemist on kutsikaga, lapsi lisada ei saa!");
        }
        else {
            this.children.add(child);
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "price=" + price +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", isPuppy=" + isPuppy +
                ", isSold=" + isSold +
                ", birthYear=" + birthYear +
                ", animalType=" + animalType +
                '}';
    }
}