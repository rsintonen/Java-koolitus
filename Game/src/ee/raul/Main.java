package ee.raul;

import ee.raul.character.Enemy;
import ee.raul.character.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        World world = new World(5, 10);
        Player player = new Player(world);
        Enemy enemy = new Enemy(world);
        world.addCharacter(player);
        world.addCharacter(enemy);
        world.printMap();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Liikumiseks kasuta WASD");
        System.out.println("Lõpetamiseks kirjuta 'end'");
        while (!input.equals("end")) {
            // annan move'ile väärtused kaasa
            player.move(input, world);
            world.printMap();
            input = scanner.nextLine();

        }


    }
}
