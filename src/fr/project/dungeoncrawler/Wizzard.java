package fr.project.dungeoncrawler;

public class Wizzard extends Character {

    public Wizzard() {
        this.type = "Wizzard";
        initializeStats();
    }

    @Override
    public void initializeStats() {
        this.life = 6;
        this.attack = 8;
    }
}