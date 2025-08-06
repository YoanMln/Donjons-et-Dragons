package fr.project.dungeoncrawler;
import fr.project.dungeoncrawler.db.DataBase;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase();
        db.getHeroes();
        Game game = new Game();
        game.start();
    }
}
