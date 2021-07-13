package ee.raul;

import java.util.Scanner;

public class Animal implements ProjectObject {
    private int price;
    private int age;
    private String name;
    private boolean isSold;

    public Animal(int price, int age, String name, boolean isSold) {
        this.price = price;
        this.age = age;
        this.name = name;
        this.isSold = isSold;
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

    public void increaseAgeByOne() {
        this.age++;
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
        boolean correctAnswer = false;
        while (!correctAnswer) {
            System.out.println("Kas vajalikud dokumendid on esitatud? (jah/ei)");
            String input = scanner.nextLine();
            // menüüst Code > Surround with > While
            if (input.equals("jah")) {
                // NB proovi toLowerCase juurde panna (tavaliselt front endist nupuga)
                this.isSold = true;
                System.out.println("Müüdud");
                correctAnswer = true;
            } else if (input.equals("ei")) {
                System.out.println("Ei saa dokumentideta müüa");
                correctAnswer = true;
            } else {
                System.out.println("Palun sisesta jah või ei");
            }
        }

        // this. << viitab instantsile (kass, koer jne)
    }

    public Animal(int price, int age, String name) {
        this.price = price;
        this.age = age;
        this.name = name;
        this.isSold = false;
    }
}
