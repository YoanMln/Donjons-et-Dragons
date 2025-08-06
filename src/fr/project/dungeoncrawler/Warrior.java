package fr.project.dungeoncrawler;

public class Warrior extends Character {

    public Warrior() {
        this.type = "Warrior";
        initializeStats();
    }

    @Override
    public void initializeStats() {
        this.life = 10;
        this.attack = 5;
    }

    @Override
    public String toString() {
        return "Type: " + type + " | hp: " + life + " | attack: " + attack;
    }
}