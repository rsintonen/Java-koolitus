package ee.raul.character;

import ee.raul.World;

import java.util.Random;

public class Enemy extends Character {
    private EnemyType enemyType;

    public Enemy(World world) {
        super('Z', world);
        this.enemyType = EnemyType.getRandomEnemyType();
        getHealthByEnemyType();
    }

    public void reboostEnemy() {
        reboost();
    }

//    public void randomiseCoordinates(World world) {
////        Random rand = new Random();
////        this.xCoord = rand.nextInt(world.getWidth());
////        this.yCoord = rand.nextInt(world.getHeight());
////        checkCoordinateUniqueness(world);
//
//    }

    private void getHealthByEnemyType() {
        switch (this.enemyType) {
            case RAT:
                this.setHealth(1);
                break;
            case ORC:
                this.setHealth(5);
                break;
            case GOBLIN:
                this.setHealth(3);
                break;
            case WOLF:
                this.setHealth(4);
                break;
            case DRAGON:
                this.setHealth(7);
                break;
            case WIZARD:
                this.setHealth(6);
                break;
            case SNAKE:
                this.setHealth(2);
                break;
        }
    }
    public EnemyType getEnemyType() {
           return enemyType;
        }
    public void loseHealth(int strength) {
        this.setHealth(getHealth()-strength);
    }
}
