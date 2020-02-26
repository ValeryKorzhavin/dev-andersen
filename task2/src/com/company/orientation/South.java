package com.company.orientation;

import com.company.Orientation;
import com.company.Position;

public class South implements Orientation {

    public Position moveThisDirection(Position position, int speed) {
        return new Position(position.getX(), position.getY() + speed);
    }
	
    public Orientation turnLeft() {
        return new East();
    }

    public Orientation turnRight() {
        return new West();
    }

    @Override
    public String toString() {
        return "South";
    }

}