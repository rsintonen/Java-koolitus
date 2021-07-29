package ee.raul.item;

import ee.raul.World;
import ee.raul.character.Enemy;
import ee.raul.character.Player;

import java.util.Random;

public class Item {
    private int strength;
    private int durability;
    private int level;
    private ItemType itemType;
    private int xCoord;
    private int yCoord;
    private char symbol;

    public Item(int strength, int durability, World world) {
        this.strength = strength;
        this.durability = durability;
        this.level = 0;
        this.itemType = ItemType.BRONZE;
        randomiseCoordinates(world);
        this.symbol = 'I';
    }

    public void randomiseCoordinates(World world) {
        Random rand = new Random();
        this.xCoord = rand.nextInt(world.getWidth());
        this.yCoord = rand.nextInt(world.getHeight() - 2) + 1;
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

    public void increaseDurability() {
        this.durability++;
    }

    @Override
    public String toString() {
        return "Item{" +
                "strength=" + strength +
                ", durability=" + durability +
                ", level=" + level +
                ", itemType=" + itemType +
                ", xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", symbol=" + symbol +
                '}';
    }

    public int getDurability() {
        return durability;
    }

    public void decreaseDurability(Player player) {
        if (durability == 1) {
            player.removeFromInventory(this);
        }
        else {
            this.durability--;
        }
    }
    public void hit(Enemy enemy) {
        strength = getStrengthByItemType();
        itemType = increaseLevel();
        enemy.loseHealth(strength);
    }

    private ItemType increaseLevel() {
        this.level++;
        switch (this.level / 3) {
            case 1:
                return ItemType.SILVER;
            case 2:
                return ItemType.IRON;
            case 3:
                return ItemType.STEEL;
            case 4:
                return ItemType.PLATINUM;
            default:
                return ItemType.BRONZE;
        }
    }

    private int getStrengthByItemType() {
        switch (this.itemType) {
            case SILVER:
                return (int) (this.strength * 1.5);
            case IRON:
                return this.strength * 2;
            case STEEL:
                return this.strength * 3;
            case PLATINUM:
                return this.strength * 4;
            default:
                return this.strength;
        }
    }

    public int getStrength() {
        return strength;
    }

    public int getLevel() {
        return level;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
