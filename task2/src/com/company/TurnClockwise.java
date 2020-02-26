package com.company;

public class TurnClockwise implements Movable2D {
	
	public void changePosition(Position2D position, int points) {
        position.turnRight();
	}

}