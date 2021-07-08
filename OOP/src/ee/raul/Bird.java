package ee.raul;

// hiljem tuleb siia plugin @LISACONSTRUCTOR ja muu selline koodi lihtsustamiseks

import java.util.Scanner;

public class Bird {
    private int price;
    private int age;
    private String name;
    private boolean isSold;
    private BirdColor birdColor;

    // auto-generate >> parem klikk > generate > constructor
    public Bird(int price, int age, String name, BirdColor birdColor) {
        this.price = price;
        this.age = age;
        this.name = name;
        this.isSold = false; // ülevalt kustutatud ja siia automaatne FALSE defaultiks
        this.birdColor = birdColor;
    }

    // auto-gen >> parem klikk > generate > getter and setter

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSold() {
        return isSold;
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

    public BirdColor getBirdColor() {
        return birdColor;
    }

    public void setBirdColor(BirdColor birdColor) {
        this.birdColor = birdColor;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "price=" + price +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", isSold=" + isSold +
                ", birdColor=" + birdColor +
                '}';
    }
}

