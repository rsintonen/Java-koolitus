package ee.raul;

import ee.raul.character.Enemy;
import ee.raul.character.Player;
import ee.raul.character.QuestMaster;
import ee.raul.item.Dagger;
import ee.raul.item.Hammer;
import ee.raul.item.Item;
import ee.raul.item.Sword;

import java.util.Scanner;
import java.util.Timer;

public class Game {

    // X enemy saab surma ja tema elud pannakse uuesti täis
    // X enemytel on erinevad tüübid erinevate eludega
    // X kui enemy saab surma, salvestatakse MAP tüüpi massiivi tema tüüp ja mitu korda
    //          teda on tapetud
    // itemitel on strength kasutusele võtmine -- vastavalt tugevusele elude võtmine
    // X ItemType kasutusele võtmine -- korrutada strength läbi ItemType-ga
    // X ItemType paremaks muutumine ehk leveli tõstmine ja kontroll kui on
    //          jõudnud mingi levelini
    // Salvestada, mitu sekundit mängija elude lõpuni jääb
    // Item - Transporter, millega saab mitte võidelda, vaid põgeneda
    // Uus Character nimega Healer, kes on peidetud ehk ilma Symbolita ja ravib juhuslikult
    //          elud täis

    // Angularis veebipood -- võtame tooted ja hakkame neid kuvama, saab ostukorvi lisada
    // Administraator saab tooteid juurde lisada, muuta, kustutada
    // Backend võtab need lisamised, muutmised, kustutamised vastu ja salvestab andmebaasi
    // Java Spring + Hibernate << Backend tehakse nende abil

    public static void main(String[] args) {

        World world = new World(5, 10);
        Timer timer = new Timer();
        GameController.startTimer(timer);

        Player player = new Player(world);
        world.addCharacter(player);
        Enemy enemy = new Enemy(world);
        world.addCharacter(enemy);
        enemy.randomiseCoordinates(world);
        QuestMaster questMaster = new QuestMaster(world);
        world.addCharacter(questMaster);

        Sword sword = new Sword(world);
        world.addItem(sword);
        Hammer hammer = new Hammer(world);
        world.addItem(hammer);
        Dagger dagger = new Dagger(world);
        world.addItem(dagger);

        world.printMap();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Liikumiseks kasuta WASD");
        System.out.println("Lõpetamiseks kirjuta 'end'");

        try {
            while (!input.equals("end")) {

                player.move(input, world);

                GameController.checkIfPlayerCanGetItem(world, player);
                GameController.playerMeetsEnemy(player, enemy, scanner);
                GameController.playerMeetsQuestmaster(world, player, enemy, questMaster);

                world.printMap();
                input = scanner.nextLine();
            }
            timer.cancel();
        } catch (GameOverException e) {
            System.out.println("SAID SURMA, MÄNG LÄBI!");
//            System.out.println("Kokku läks aega: " + GameController.getSeconds() + " sekundit.");
            player.showKilledEnemies();
            timer.cancel();
        }
    }
}
