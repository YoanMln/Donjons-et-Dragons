package fr.project.dungeoncrawler;

public class Board {
    private int currentPosition = 1;
    private final int finalPosition = 64;

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
}