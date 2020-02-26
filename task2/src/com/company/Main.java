package com.company;

public class Main {

    public static void main(String[] args) {
        
        System2D coordSystem = new System2D(5, 5);
        Entity2D tractor = new Tractor(new Position2D(0, 0, Orientation2D.EAST));
        Movable2D forwards = new MoveForwards();
        Movable2D clockWise = new TurnClockwise();

        coordSystem.addEntity(tractor);
        coordSystem.draw();
        tractor.move(forwards, 1);
        tractor.move(clockWise, 1);
        tractor.move(forwards, 1); 
        coordSystem.draw();
    }

}