package com.company;

public interface Orientation {

    Position moveThisDirection(Position position, int speed);

    Orientation turnLeft();

    Orientation turnRight();

}
