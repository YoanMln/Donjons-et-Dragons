package fr.project.dungeoncrawler;

import fr.project.dungeoncrawler.db.DataBase;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Menu menu= new Menu();
    private final Dice dice = new Dice();
    private final Board board = new Board();
    private Scanner scanner = new Scanner(System.in);
    DataBase db = new DataBase();
    Character player = null ; // variable utilisée dans plusieurs méthodes

    public void start() {
        menu.DisplayMenu();

        int choice = scanner.nextInt();
        scanner.nextLine();



        switch (choice) {
            case 1:
                createCharacter(); // utilisation de la variable player
                start();
                break;

                case 2:
                if (player != null) {
                    db.getHeroes();
                } else {
                    menu.DisplayAlertCreat();

                }
                start();
                break;

                case 3:
                if (player != null) {
                    startGame();
                } else {
                    menu.DisplayAlertCreat();
                    start();
                }
                break;

            case 4:
                editCharacter();
                start();
                break;

                case 5:
                menu.DisplayGoodbye();
                break;



                default:
                menu.DisplayInvalidChoice();
                start();
                break;
        }
    }

    private void startGame() {
        menu.DisplayStartAlert();
        board.reset();

        while (!board.isFinished()) {
            menu.DisplayRollDice();
            scanner.nextLine();
            int diceRoll = dice.roll();
            System.out.println("Vous avez lancé un " + diceRoll);

            board.move(diceRoll);
            System.out.println(" Position actuelle : Case " +
                    board.getCurrentPosition() + " / " + board.getFinalPosition());
            board.interactWithCurrentCell(player);
        }

        menu.DisplayEndBoard();
        endGameMenu();
    }



    private void createCharacter() {

        menu.DisplayCharacterMenu();

        int TypeChoice = scanner.nextInt();
        scanner.nextLine();



        switch (TypeChoice) {
            case 1: player = new Warrior(); // affectation à la variable d'instance
            chooseName();
            chooseWeapon();
            break;

            case 2: player = new Wizzard();
            chooseName();
            chooseWeapon();
            break;
            default:
                menu.DisplayInvalidChoice();
            return;
        }
        menu.DisplayCreateSuccess();
        System.out.println(player);
        db.createHero(player);
    }

    private void chooseName() {
        menu.DisplayEnterName();
        String newName = scanner.nextLine();
        player.setName(newName);

    }

    private void chooseWeapon() {
        try {
            if (player.getType().equals("Warrior")) {
                menu.DisplayWeaponChoiceWarrior();

                int choice = scanner.nextInt();
                scanner.nextLine();

                OffensiveEquipment weapon = switch (choice) {
                    case 1 -> new Weapon.Sword();
                    case 2 -> new Weapon.Massue();
                    default -> {
                        menu.DisplayInvalidChoice();
                        yield new Weapon.Massue(); // valeur par défaut
                    }
                };
                player.setWeapon(weapon);

            } else if (player.getType().equals("Wizzard")) {
                menu.DisplayWeaponChoiceWizzard();

                int choice = scanner.nextInt();
                scanner.nextLine();

                OffensiveEquipment spell = switch (choice) {
                    case 1 -> new Spell.FireBall();
                    case 2 -> new Spell.Spark();
                    default -> {
                        menu.DisplayInvalidChoice();
                        yield new Spell.Spark(); // valeur par défaut
                    }
                };
                player.setWeapon(spell);
            }

            System.out.println("Arme choisie : " + player.getWeapon().getName() +
                    " (+ " + player.getWeapon().getAttackLevel() + " atk)");

        } catch (InputMismatchException e) {
            scanner.nextLine(); // vide le buffer
            menu.DisplayAlertWeaponChoice();

            // Valeur par défaut si erreur de saisie
            if (player.getType().equals("Warrior")) {
                player.setWeapon(new Weapon.Massue());
            } else {
                player.setWeapon(new Spell.Spark());
            }

            System.out.println("Une arme par défaut a été attribuée.");
        }
    }


    private void editCharacter() {
        db.getHeroes();

        System.out.print("ID du personnage à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nouveau nom : ");
        String name = scanner.nextLine();

        System.out.print("Nouveau type (Warrior/Wizard) : ");
        String type = scanner.nextLine();

        System.out.print("Nouveaux points de vie : ");
        int life = scanner.nextInt();

        System.out.print("Nouvelle force : ");
        int strength = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nouvelle arme : ");
        String weapon = scanner.nextLine();

        db.editHeroById(id, name, type, life, strength, weapon);
    }

    private void endGameMenu() {
        System.out.println("Souhaitez-vous rejouer ? (o/n)");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("o")) {
            startGame();
        } else {
            menu.DisplayGoodbye();
        }
    }

}

