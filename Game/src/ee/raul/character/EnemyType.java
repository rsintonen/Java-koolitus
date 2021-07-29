package ee.raul.character;

import java.util.Random;

public enum EnemyType {
    GOBLIN, ORC, DRAGON, RAT, WIZARD, WOLF, SNAKE;

    public static EnemyType getRandomEnemyType() {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)];
    }
}
