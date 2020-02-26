package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start the program");

        System2D coordSystem = new System2D(5, 5);

        Entity2D tractor = new Tractor(new Position2D(0, 0), new Orientation2D(Orientation.EAST));
        Entity2D ship = new Ship(new Position2D(0, 0), new Orientation2D(Orientation.EAST));

        coordSystem.addEntity(tractor);
        coordSystem.addEntity(ship);

        Movable2D forwards = new MoveForwards();
        Turnable2D clockWise = new TurnClockwise();

        coordSystem.draw();

        tractor.move(forwards, 1);
        tractor.move(clockWise, 1); 
        ship.move(forwards, 9);
        ship.move(clockWise, 2);      

        coordSystem.draw();

    }

}