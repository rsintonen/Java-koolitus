package ee.raul.character;

import ee.raul.World;

import java.util.Random;

public abstract class Character {
    protected int xCoord;
    protected int yCoord;
    protected char symbol;

    public Character(char symbol, World world) {
        this.symbol = symbol;
        Random rand = new Random();
        this.xCoord = rand.nextInt(world.getWidth());
        this.yCoord = rand.nextInt(world.getHeight() - 2) + 1;

        // on parem kui:
//        this.xCoord = (int) (Math.random( * world.getWidth()));
//        this.yCoord = (int) (Math.random( * (world.getWidth()-2)+1));
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
}
