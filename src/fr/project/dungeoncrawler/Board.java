package fr.project.dungeoncrawler;
import java.util.ArrayList;

public class Board {
    private int currentPosition = 1;
    private final int finalPosition = 64;
    private ArrayList<Cell> cells = new ArrayList<>();

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        cells.add(new EmptyCell(1));
        cells.add(new EnemyCell(2));  //
        cells.add(new EquipmentCell(3, "weapon"));
        cells.add(new EquipmentCell(4, "potion"));
    }

    public void reset() {
        currentPosition = 1;
    }

    public void move(int steps) {
        currentPosition += steps;
        if (currentPosition > finalPosition) {
            currentPosition = finalPosition;
        }
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getFinalPosition() {
        return finalPosition;
    }

    public boolean isFinished() {
        return currentPosition >= finalPosition;
    }

    public Cell getCurrentCell() {
        if (currentPosition <= cells.size()) {
            return cells.get(currentPosition - 1);
        } else {
            return new EmptyCell(currentPosition);
        }
    }


    public void interactWithCurrentCell(Character player) {
        Cell currentCell = getCurrentCell();
        System.out.println("Position " + currentPosition + " : " + currentCell.toString());
        currentCell.interact(player);
    }
}