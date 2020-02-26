package com.company;

import com.company.exception.TractorOutOfBoundsException;
import com.company.exception.EntityOutOfBoundsException;

public class Tractor extends Entity {

    public Tractor(Position position, Orientation orientation) {
        this.position = position; 
        this.orientation = orientation;
    }

    @Override
    public void draw() {}

    @Override
    public EntityOutOfBoundsException getException() {
        return new TractorOutOfBoundsException();
    }
    
}