package com.company;

public class Orientation2D {

    private Orientation orientation = Orientation.EAST;

    public Orientation2D(Orientation orientation) {
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void turnLeft(int points) {

    }

    public void turnRight(int points) {

    }

    @Override
    public String toString() {
        return orientation.toString();
    }

}