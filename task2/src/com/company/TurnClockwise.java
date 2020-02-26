package com.company;

public class TurnClockwise implements TurnBehavior {

    public Orientation performTurn(Orientation orientation) {
        return orientation.turnRight();
    }

}