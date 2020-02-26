package com.company.orientation;

import com.company.Orientation;
import com.company.Position;

public class East implements Orientation {

    public Position moveThisDirection(Position position, int speed) {
        return new Position(position.getX() + speed, position.getY());
    }
	
    public Orientation turnLeft() {
        return new North();
    }

    public Orientation turnRight() {
        return new South();
    }

    @Override
    public String toString() {
        return "East";
    }

}