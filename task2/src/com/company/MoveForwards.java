package com.company;

public class MoveForwards implements MoveBehavior {

    public Position performMove(Position position, 
                                Orientation orientation, int speed) {
        return orientation.moveThisDirection(position, speed);
    }

}

