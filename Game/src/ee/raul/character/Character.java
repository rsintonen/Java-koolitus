package ee.raul.character;

import ee.raul.World;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Character {
    protected int xCoord;
    protected int yCoord;
    private final char symbol;
    // final >> peale muutuja esmakordset initsieerimist enam muuta ei saa
    private boolean isVisible;
    protected int health;

    public Character(char symbol, World world) {
        this.symbol = symbol;
        randomiseCoordinates(world);
        this.isVisible = true;
        this.health = 9;
        }

        // on parem kui:
//        this.xCoord = (int) (Math.random( * world.getWidth()));
//        this.yCoord = (int) (Math.random( * (world.getWidth()-2)+1));

    public void randomiseCoordinates(World world) {
        Random rand = new Random();
        this.xCoord = rand.nextInt(world.getWidth());
        this.yCoord = rand.nextInt(world.getHeight() - 2) + 1;
        checkCoordinateUniqueness(world);
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected void checkCoordinateUniqueness(World world) {
        List<Character> characters = world.getCharacters();
        List<Character> charactersWithoutThis = characters.stream()
                .filter(c -> c.symbol != this.symbol)
                .collect(Collectors.toList());
        // kui stream käsk pikaks läheb, tehakse loetavuse nimel uuele reale (enne punkti)
        for (Character c: charactersWithoutThis) {
            if(c.getxCoord() == this.getxCoord() && c.getyCoord() == this.getyCoord()) {
                randomiseCoordinates(world);
            }
        }
    }

    public int getxCoord() {
        return xCoord;
    }
    public int getyCoord() {
        return yCoord;
    }
    public char getSymbol() {
        return symbol;
    }
    public boolean isVisible() {
        return isVisible;
    }
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    // playeri jaoks mõeldud, kui kohtub healeriga
    protected void reboost() {
        this.health = 3;
    }

    public void takeHealth() {
        this.health--;

    }

    public int getHealth() {
        return health;
    }
}
