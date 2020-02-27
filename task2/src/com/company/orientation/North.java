package com.company.orientation;

import com.company.Orientation;
import com.company.Position;

public class North implements Orientation {

    public Position moveThisDirection(Position position, int speed) {
        return new Position(position.getX(), position.getY() - speed);
    }

    public Orientation turnLeft() {
        return new West();
    }

    public Orientation turnRight() {
        return new East();
    }

    @Override
    public String toString() {
        return "North";
    }

}
