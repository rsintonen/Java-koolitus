package ee.raul;

import ee.raul.character.Enemy;
import ee.raul.character.EnemyType;
import ee.raul.character.Player;
import ee.raul.character.QuestMaster;
import ee.raul.item.Item;

import java.util.*;

public abstract class GameController {
    private static int seconds;

    public static int getSeconds() {
        return seconds;
    }

    // annan move'ile väärtused kaasa
    public static void checkIfPlayerCanGetItem(World world, Player player) {
        for (Item i: world.getItems()) {
            if (i.getxCoord() == player.getxCoord() && i.getyCoord() == player.getyCoord()) {
                if (!player.getInventory().contains(i)) {
                    player.addToInventory(i);
                }
                else {
                    i.increaseDurability();
                }
            }
        }
    }
    public static void playerMeetsEnemy(Player player, Enemy enemy, Scanner scanner)  throws GameOverException{
        String input;
        if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord() && enemy.isVisible()) {
            enemy.setVisible(false);
            System.out.println("Kohtusid vaenlasega!");
            if (player.isInventoryEmpty()) {
                System.out.println("Sul pole relvi, et võidelda, mine korja!");
            }
            else {
                chooseWeapon(player, enemy, scanner);
            }
        }
    }
    private static void chooseWeapon(Player player, Enemy enemy, Scanner scanner) throws GameOverException{
        String input;
        System.out.println("Vali, millist relva tahad kasutada: ");
        player.showInventory();

        Item item = null;
        while (item == null) {
            input = scanner.nextLine();
            try {
                item = player.getFromInventory(Integer.parseInt(input));
                item.decreaseDurability(player);
                System.out.println("Valisid relva: " + item.getClass().getName().substring(13));
                fightEnemy(player, enemy, scanner, item);
            } catch (NumberFormatException e) {
                System.out.println("Viga: sisestasid numbri asemel sümboli, palun vali uuesti.");
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Viga: palun vali õige relva number.");
            }
        }
    }
    private static void fightEnemy(Player player, Enemy enemy, Scanner scanner, Item item) throws GameOverException {
        Random rand = new Random();
        while (enemy.getHealth() > 0) {
            System.out.println("Lahinguks ütle üks number 1-st 3-ni:");
            int enemyFightNumber = rand.nextInt(3)+1;
            int playerFightNumber = 0;
            while (playerFightNumber == 0) {
                try {
                    String input = scanner.nextLine();
                    playerFightNumber = Integer.parseInt(input);
                    if (playerFightNumber < 1 || playerFightNumber > 3) {
                        System.out.println("Viga: palun vali õige number.");
                        playerFightNumber = 0;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Viga: sisestasid numbri asemel sümboli, palun vali uuesti.");
                }
            }
            if (enemyFightNumber == playerFightNumber) {
//                enemy.takeHealth();
                item.hit(enemy);
                System.out.println("Relva level: " + item.getLevel() + item.getItemType());
                System.out.println("Võtsid vaenlaselt " + item.getStrength() + " elu. Enemy elud: " + enemy.getHealth());
            } else {
                player.takeHealth();
                System.out.println("Playeri elud: " + player.getHealth());
                if (player.getHealth() < 1) {
                    throw new GameOverException();
                }
            }
        }
        player.addToKilledEnemies(enemy.getEnemyType());
        System.out.println("Tapetud vaenlased: ");
        player.showKilledEnemies();
//        System.out.println("SIIA JÕUAB ALLES SIIS KUI ENEMY ON TAPETUD");
    }
    public static void playerMeetsQuestmaster(World world, Player player, Enemy enemy, QuestMaster questMaster) {
        if (questMaster.isVisible() &&
                player.getxCoord() == questMaster.getxCoord() &&
                player.getyCoord() == questMaster.getyCoord()) {
            questMaster.setVisible(false);
            enemy.randomiseCoordinates(world);
//            enemy.reboostEnemy();
            enemy.setVisible(true);
        }
        else if (!questMaster.isVisible() &&
                !(player.getxCoord() == questMaster.getxCoord() &&
                        player.getyCoord() == questMaster.getyCoord())) {
            questMaster.setVisible(true);
        }
    }

    public static void startTimer(Timer timer) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seconds++;
            }
        }, 1000, 1000);
    }
}