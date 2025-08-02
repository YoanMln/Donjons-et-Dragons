package fr.project.dungeoncrawler;

public abstract class Cell {
    protected int position;

    public Cell(int position) {
        this.position = position;
    }
    public int getPosition() {
        return position;
    }

    public abstract void interact(Character player);

    @Override
    public abstract String toString();
}
