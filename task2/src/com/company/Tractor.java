package com.company;

import com.company.exception.TractorOutOfBoundsException;
import com.company.exception.Entity2DOutOfBoundsException;

public class Tractor extends Entity2D {

    public Tractor(Position2D position) {
        this.position = position; 
    }

    @Override    
    public void draw() {
        System.out.println(this);
    }

    @Override
    public Entity2DOutOfBoundsException getException() {
        return new TractorOutOfBoundsException();
    }
    
}