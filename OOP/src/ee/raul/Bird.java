package ee.raul;

// hiljem tuleb siia plugin @LISACONSTRUCTOR ja muu selline koodi lihtsustamiseks

import java.util.Scanner;

// extend ANIMAL tähendab, et Birdile antakse kõik omadused, funktsioonid jne, mis Animali klassis on.

public class Bird extends Animal {
    // extendimisel eriomadused jäävad siia (BirdColor)
    private BirdColor birdColor;

    // auto-generate >> parem klikk > generate > constructor
    public Bird(int price, int age, String name, BirdColor birdColor) {
        super(price, age, name);
        this.birdColor = birdColor;
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
                "price=" + getPrice() +
                ", age=" + getAge() +
                ", name='" + getName() + '\'' +
                ", isSold=" + isSold() +
                ", birdColor=" + birdColor +
                '}';
    }
}

