package fr.project.dungeoncrawler;

public class EvilWizzard extends Character{

    public EvilWizzard() {
        this.type="EvilWizzard";
        initializeStats();
    }

    @Override
    public void initializeStats() {
        this.life = 15;
        this.attack =4;
    }

    @Override
    public String toString() {
        return "Type: " + type + " | hp: " + life + " | attack: " + attack;
    }
}
