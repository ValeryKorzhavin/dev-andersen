package com.company;

public class Position2D {

    private int x;

    private int y;
    
    private Orientation2D orientation;

    public Position2D(int x, int y, Orientation2D orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public Position2D(Position2D position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    public Position2D(Position2D position, Orientation2D orientation) {
        this.x = position.getX();
        this.y = position.getY();
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void change(int points) {
        if (orientation == Orientation2D.WEST) {
            x -= points;
        }
        if (orientation == Orientation2D.EAST) {
            x += points;
        }
        if (orientation == Orientation2D.NORTH) {
            y -= points;
        }
        if (orientation == Orientation2D.SOUTH) {
            y += points;
        }
    }

    public void turnLeft() {
        if (orientation == Orientation2D.NORTH) {
            orientation = Orientation2D.WEST;
        } else if (orientation == Orientation2D.EAST) {
            orientation = Orientation2D.NORTH;
        } else if (orientation == Orientation2D.SOUTH) {
            orientation = Orientation2D.EAST;
        } else {
            orientation = Orientation2D.SOUTH;
        }
    }

    public void turnRight() {
        if (orientation == Orientation2D.NORTH) {
            orientation = Orientation2D.EAST;
        } else if (orientation == Orientation2D.EAST) {
            orientation = Orientation2D.SOUTH;
        } else if (orientation == Orientation2D.SOUTH) {
            orientation = Orientation2D.WEST;
        } else {
            orientation = Orientation2D.NORTH;
        }
    }

    public void setOrientation(Orientation2D orientation) {
        this.orientation = orientation;
    }

    public Orientation2D getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return String.format("x: %d, y: %d, orientation: %s", x, y, orientation.toString());
    }


}