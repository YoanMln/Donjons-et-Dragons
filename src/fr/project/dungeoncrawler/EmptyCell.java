package fr.project.dungeoncrawler;

public class EmptyCell extends Cell {
    public EmptyCell(int position) {
        super(position);
    }
    @Override
    public void interact(Character player) {
        System.out.println("Vous êtes sur une case vide");
    }

    @Override
    public String toString() {
        return "Case vide";
    }
}

