package com.company;

public class Position2D {

    private int x;
    private int y;
    private Orientation2D orientation;

    public Position2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position2D(Position2D position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void changeX(int points) {
        x += points;
    }

    public void changeY(int points) {
        y += points;
    }

    @Override
    public String toString() {
        return String.format("x: %d, y: %d", x, y);
    }


}