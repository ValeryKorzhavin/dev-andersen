package com.company;

import com.company.exception.Entity2DOutOfBoundsException;

public abstract class Entity2D {
	
	protected Position2D position;

    protected System2D field;

    protected Movable2D move; 

    public abstract void draw();

    public abstract Entity2DOutOfBoundsException getException();

    public void setField(System2D field) {
        this.field = field;
    }

    public Position2D getPosition() {
        return position;
    }

    public void move(Movable2D move, int points) {
        move.changePosition(position, points);
        checkBounds();
    }
    
    public void checkBounds() {
        boolean isOutX = position.getX() >= field.getSizeX() 
                      || position.getX() < 0;

        boolean isOutY = position.getY() >= field.getSizeY() 
                      || position.getY() < 0;

        if (isOutX || isOutY) {
            throw getException();        
        }
                   
    }

    @Override
    public String toString() {
        return "Position: " + position.toString();
    }

}