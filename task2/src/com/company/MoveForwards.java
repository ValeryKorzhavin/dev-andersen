package com.company;

public class MoveForwards implements Movable2D {

    public void change(Position2D position, int points) {
        position.changeX(points);
    }

}

