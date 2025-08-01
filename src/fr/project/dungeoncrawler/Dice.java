package fr.project.dungeoncrawler;

import java.util.Random;

public class Dice {
    private Random random = new Random();

    public int roll() {
        return random.nextInt(6) + 1; // 1 à 6 inclus
    }
}