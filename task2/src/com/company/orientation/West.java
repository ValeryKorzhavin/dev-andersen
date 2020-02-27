package com.company.orientation;

import com.company.Orientation;
import com.company.Position;

public class West implements Orientation {

    public Position moveThisDirection(Position position, int speed) {
        return new Position(position.getX() - speed, position.getY());
    }

    public Orientation turnLeft() {
        return new South();
    }

    public Orientation turnRight() {
        return new North();
    }

    @Override
    public String toString() {
        return "West";
    }

}
