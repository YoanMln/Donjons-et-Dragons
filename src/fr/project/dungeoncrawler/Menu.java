package fr.project.dungeoncrawler;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void DisplayMenu(){

        System.out.println("Welcome to DungeonCrawler!");
        System.out.println("1. Créer un nouveau personnage");
        System.out.println("2. Démarrer la partie");
        System.out.println("3. Quitter le jeu");
    }

    public void DisplayCharacterMenu() {
        System.out.println("Création du personnage");
        System.out.println("Choix du type");
        System.out.println("1 Warrior");
        System.out.println("2 Wizzard");
    }


    public void DisplayStartAlert() {
        System.out.println("La partie commence...");
    }

    public void DisplayRollDice() {
        System.out.println("Appuyez pour lancer le de");
    }

    public void DisplayAlertCreat(){
        System.out.println("Vous devez d'abord créer un personnage");
    }

    public void DisplayEndBoard() {
        System.out.println("Vous avez atteint la fin du plateau");
    }

    // switch Choice //

    public void DisplayGoodbye() {
        System.out.println("À bientôt");
    }

    public void DisplayInvalidChoice() {
        System.out.println("Choix invalide.");
    }

    public void DisplayCreateSuccess() {
        System.out.println("personnage créer");
    }

    public void DisplayEnterName() {
        System.out.println("Entrez un nom:");
    }

    // switch weapon

    public void DisplayWeaponChoiceWarrior() {
        System.out.println("Choisir une arme");
        System.out.println("1 massue (+3 atk)");
        System.out.println("2 epée (+5 atk)");
    }


    public void DisplayWeaponChoiceWizzard() {
        System.out.println("Choisir une sort");
        System.out.println("1 Boule de feu (+7 atk)");
        System.out.println("2 Eclair (+2 atk)");
    }


}
