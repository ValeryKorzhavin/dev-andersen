package com.company;

import com.company.orientation.*;

public class Main {

    public static void main(String[] args) {

        CoordSystem coordSystem = new CoordSystem(5, 5);
        Entity tractor = new Tractor(new Position(0, 0), new East());
        MoveBehavior forwards = new MoveForwards();
        TurnBehavior clockWise = new TurnClockwise();

        coordSystem.addEntity(tractor);
        tractor.move(forwards, 1);
        tractor.turn(clockWise);
        tractor.move(forwards, 3); 
        tractor.turn(clockWise);
        tractor.move(forwards, 10);
    }

}