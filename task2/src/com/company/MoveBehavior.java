package com.company;

public interface MoveBehavior {

    Position performMove(Position position, 
                         Orientation orientation, int speed);

}