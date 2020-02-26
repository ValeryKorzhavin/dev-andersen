package com.company;

import com.company.exception.ShipOutOfBoundsException;
import com.company.exception.Entity2DOutOfBoundsException;

public class Ship extends Entity2D {

    public Ship(Position2D position, Orientation2D orientation) {
        this.position = position; 
        this.orientation = orientation;
    }

    @Override
	public void draw() {
        System.out.println("Draw ship");
        System.out.println(this);
	}

    @Override
    public Entity2DOutOfBoundsException getException() {
        return new ShipOutOfBoundsException();
    }



}