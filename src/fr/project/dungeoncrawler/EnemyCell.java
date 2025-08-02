package fr.project.dungeoncrawler;

public class EnemyCell extends Cell {
    public EnemyCell(int position) {
        super(position);
    }
    @Override
    public void interact(Character player) {
        System.out.println("Un ennemi apparait");
    }

    @Override
    public String toString() {
        return "Case avec ennemi";
    }
}
