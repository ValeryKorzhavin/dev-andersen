package com.company;

import com.company.orientation.East;

public class Main {

    public static void main(String[] args) {

        int speed = 2;
        CoordinateSystem coordSystem = new CoordinateSystem(5, 5);
        Entity tractor = new Tractor(new Position(0, 0), new East());
        Command moveForwards = new MoveForwardsTractorCommand(tractor, speed);
        Command turnClockWise = new TurnClockwiseTractorCommand(tractor);

        coordSystem.addEntity(tractor);
        tractor.setCommand(turnClockWise);
        tractor.move();
        tractor.setCommand(moveForwards);
        tractor.move();
    }

}