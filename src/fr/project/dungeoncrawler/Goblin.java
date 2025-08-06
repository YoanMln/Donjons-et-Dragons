package fr.project.dungeoncrawler;

public class Goblin extends Character{
    public Goblin() {
        this.type = "Goblin";
        initializeStats();
    }

    @Override
    public void initializeStats() {
        this.life = 15;
        this.attack = 4;
    }

    @Override
    public String toString() {
        return "Type: " + type + " | hp: " + life + " | attack: " + attack;
    }
}
