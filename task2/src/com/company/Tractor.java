package com.company;

import com.company.exception.TractorOutOfBoundsException;
import com.company.exception.Entity2DOutOfBoundsException;

public class Tractor extends Entity2D {

    public Tractor(Position2D position, Orientation2D orientation) {
        this.position = position; 
        this.orientation = orientation;
    }

    @Override    
    public void draw() {
        System.out.println("Draw tractor");
        System.out.println(this);
    }

    @Override
    public Entity2DOutOfBoundsException getException() {
        return new TractorOutOfBoundsException();
    }
    
}