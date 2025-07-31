package fr.project.dungeoncrawler;

import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    Character player = null ;

    public void start() {
        System.out.println("Welcome to DungeonCrawler!");
        System.out.println("1. Créer un nouveau personnage");
        System.out.println("2. Quitter le jeu");

        int choice = scanner.nextInt();
        scanner.nextLine();



        switch (choice) {
            case 1:
                createCharacter();
                break;
            case 2:
                System.out.println("À bientôt");
                break;
            default:
                System.out.println("Choix invalide.");
                start();
        }
    }

    private void createCharacter() {

        System.out.println("Création du personnage");
        System.out.println("Choix du type");
        System.out.println("1 Warrior");
        System.out.println("2 Wizzard");

        int TypeChoice = scanner.nextInt();
        scanner.nextLine();



        switch (TypeChoice) {
            case 1: player = new Warrior();
            chooseName();
            chooseWeapon();
            break;

            case 2: player = new Wizzard();
            chooseName();
            chooseWeapon();
            break;
            default:
                System.out.println("Choix invalide.");
            return;
        }
        System.out.println("personnage créer");
        System.out.println(player);
    }

    private void chooseName() {
        System.out.println("Entrez un nom:");
        String newName = scanner.nextLine();
        player.setName(newName);

    }

    private void chooseWeapon() {
        if (player.getType().equals("Warrior")) {
            System.out.println("Choisir une arme");
            System.out.println("1 massue (+3 atk");
            System.out.println("2 epée (+5 atk)");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: player.setWeapon(new OffensiveEquipment(OffensiveEquipment.EquipmentType.WEAPON, "Massue", 3));
                break;

                case 2: player.setWeapon(new OffensiveEquipment(OffensiveEquipment.EquipmentType.WEAPON, "Epee", 5));
                break;
                default:
                    System.out.println("Choix invalide.");
                    player.setWeapon(new OffensiveEquipment(OffensiveEquipment.EquipmentType.WEAPON,"Massue", 3));


            }
        } else if (player.getType().equals("Wizzard")) {
            System.out.println("Choisir une sort");
            System.out.println("1 Boule de feu (+7 atk");
            System.out.println("2 Eclair (+2 atk)");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: player.setWeapon(new OffensiveEquipment(OffensiveEquipment.EquipmentType.SPELL, "Boule de feu", 4));
                break;
                case 2: player.setWeapon(new OffensiveEquipment(OffensiveEquipment.EquipmentType.SPELL, "Eclair", 2));
                break;
                default:
                    System.out.println("Choix invalide. Par defaut boule de feu");
                    player.setWeapon(new OffensiveEquipment(OffensiveEquipment.EquipmentType.SPELL, "Boule de feu", 4));
            }
        }
        System.out.println("Arme choisie:" + player.getWeapon().getName() + "(+ " + player.getWeapon().getAttackLevel() + "atk)");
    }

}

