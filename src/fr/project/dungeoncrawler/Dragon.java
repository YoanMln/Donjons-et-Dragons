package fr.project.dungeoncrawler;

public class Dragon extends Character {
    public Dragon() {
        this.type = "Dragon";
        initializeStats();
    }

    @Override
    public void initializeStats() {
        this.life = 15;
        this.attack = 4;
    }
}
