package com.company;

public class MoveForwards implements Movable2D {

    public void changePosition(Position2D position, int points) {
        position.change(points);
    }

}

