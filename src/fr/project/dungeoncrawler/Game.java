package fr.project.dungeoncrawler;

import java.util.Scanner;

public class Game {
    private Menu menu= new Menu();
    private final Dice dice = new Dice();
    private final Board board = new Board();
    private Scanner scanner = new Scanner(System.in);
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
                    startGame();
                } else {
                    menu.DisplayAlertCreat();
                    start();
                }
                case 3:
                menu.DisplayGoodbye();
                break;
            default:
                menu.DisplayInvalidChoice();
                start();
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
    }

    private void chooseName() {
        menu.DisplayEnterName();
        String newName = scanner.nextLine();
        player.setName(newName);

    }

    private void chooseWeapon() {
        if (player.getType().equals("Warrior")) { // si le personnage est un guerrier
            menu.DisplayWeaponChoiceWarrior();

            int choice = scanner.nextInt(); // recuperation du choix de l'utilisateur (entrée clavier)
            scanner.nextLine();
            switch (choice) { // selon le choix, instancie l'arme correspondante et l'assigne au personnage
                case 1: player.setWeapon(new OffensiveEquipment(OffensiveEquipment.EquipmentType.WEAPON, "Massue", 3));
                break;

                case 2: player.setWeapon(new OffensiveEquipment(OffensiveEquipment.EquipmentType.WEAPON, "Epee", 5));
                break;
                default: // Si  choix invalide  une arme par défaut est definie
                    menu.DisplayInvalidChoice();
                    player.setWeapon(new OffensiveEquipment(OffensiveEquipment.EquipmentType.WEAPON,"Massue", 3));


            }
        } else if (player.getType().equals("Wizzard")) {
           menu.DisplayWeaponChoiceWizzard();

           int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: player.setWeapon(new OffensiveEquipment(OffensiveEquipment.EquipmentType.SPELL, "Boule de feu", 4));
                break;
                case 2: player.setWeapon(new OffensiveEquipment(OffensiveEquipment.EquipmentType.SPELL, "Eclair", 2));
                break;
                default:
                    menu.DisplayInvalidChoice();
                    player.setWeapon(new OffensiveEquipment(OffensiveEquipment.EquipmentType.SPELL, "Boule de feu", 4));
            }
        }
        System.out.println("Arme choisie:" + player.getWeapon().getName() + "(+ " + player.getWeapon().getAttackLevel() + "atk)"); // // Affichage du résultat  nom et puissance de l'arme choisi
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

