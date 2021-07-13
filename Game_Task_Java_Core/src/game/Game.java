package game;

import personage.Goblin;
import personage.Skeleton;
import personage.Hero;
import personage.PotionSeller;
import entity.FantasyCharacter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    private static BufferedReader br;
    private static FantasyCharacter player = null;
    private static BattleScene battleScene = null;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        battleScene = new BattleScene();
        System.out.println("Введите имя персонажа:");

        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void command(String string) throws IOException {
        if (player == null) {
            player = new Hero(
                    string,
                    100,
                    20,
                    20,
                    0,
                    0
            );
            System.out.println(String.format("Спасти наш мир от драконов вызвался %s! Да будет его броня крепка и бицепс кругл!", player.getName()));

            printNavigation();
        }

        switch (string) {
            case "1": {
                //System.out.println("Торговец еще не приехал");
                //printNavigation();
                saveSeller();
                printNavigationSeller();
                //commandBuy(br.readLine());
            }
            break;
            case "2": {
                commitFight();
            }
            break;
            case "3":
                System.out.println(String.format("До новых встреч %s!", player.getName()));
                System.exit(1);
                break;
            case "да":
                command("2");
                break;
            case "нет": {
                printNavigation();
                command(br.readLine());
            }
        }

        command(br.readLine());
    }

    private static void commandBuy(String string) throws IOException {

        switch (string) {
            case "1": {
                if (player.getGold() >= 10) {
                    System.out.println("Почти купил.."); // player.setHealthPoints(player.getHealthPoints())+20);
                } else {
                    System.out.println(String.format("Извени друг, у тебя не хватает золотых для покупки, приходи когда заработаешь!"));
                    printNavigation();
                    command(br.readLine());
                }

            }

            case "2": {
                if (player.getGold() >= 10) {
                    System.out.println("Почти купил..");
                } else {
                    System.out.println(String.format("Извени друг, у тебя не хватает золотых для покупки, приходи когда заработаешь!"));
                    printNavigation();
                    command(br.readLine());
                }

            }

            case "3":
                System.out.println(String.format("Заходи еще %s!", player.getName()));
                printNavigation();
                command(br.readLine());
        }
        commandBuy(br.readLine());
    }

    private static void commitFight() {
        battleScene.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья.", player.getName(), player.getSkill(), player.getGold(), player.getHealthPoints()));
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {

            }
        });
    }

    private static void saveSeller() {
        System.out.println(String.format("Приветствую тебя %s! Что желаешь приобрести в моей лавке,", player.getName()));
        System.out.println("В наличии есть зелье для повышения ловкости, аптечка");
        printNavigationSeller();
        System.out.println(String.format("%s у тебя %d опыта и %d золота, а также осталось %d едениц здоровья.", player.getName(), player.getSkill(), player.getGold(), player.getHealthPoints()));
        try {
            commandBuy(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }

    private static void printNavigationSeller() {
        System.out.println("Что выберешь?");
        System.out.println("1. Аптечка +20% - 10 золотых");
        System.out.println("2. Зелье, повысить ловкость на 20 ед. - 10 золотых");
        System.out.println("3. Выход");
    }

    private static FantasyCharacter createMonster() {
        //Рандомайзер
        int random = (int) (Math.random() * 10);
        //С вероятностью 50% создается или скелет  или гоблин
        if (random % 2 == 0) return new Goblin(
                "Гоблин",
                50,
                10,
                10,
                100,
                20
        );
        else return new Skeleton(
                "Скелет",
                25,
                20,
                20,
                100,
                10
        );
    }

    interface FightCallback {
        void fightWin();

        void fightLost();
    }
}
