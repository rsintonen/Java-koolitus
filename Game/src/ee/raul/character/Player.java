package ee.raul.character;

import ee.raul.World;

public class Player extends Character {
    private Direction direction;

    public Player(World world) {
        super('X', world);
        this.direction = Direction.UP;
    }

    public void move(String input, World world) {
        switch(input) {
            case "w":
                direction = Direction.UP;
                break;
            case "s":
                direction = Direction.DOWN;
                break;
            case "a":
                direction = Direction.LEFT;
                break;
            case "d":
                direction = Direction.RIGHT;
                break;
        }

        switch(direction) {
            case UP:
                if (yCoord > 1) {
                    yCoord--;
                }
                break;
            case DOWN:
                if (yCoord < world.getHeight()-2) {
                    yCoord++;
                }
                break;
            case LEFT:
                if(xCoord > 0) {
                    xCoord--;
                }
                break;
            case RIGHT:
                if (xCoord < world.getWidth()-1) {
                    xCoord++;
                }
                break;
        }


    }
}
