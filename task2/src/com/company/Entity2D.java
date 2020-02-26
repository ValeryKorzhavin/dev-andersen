package com.company;

import com.company.exception.Entity2DOutOfBoundsException;

public abstract class Entity2D {
	
	protected Position2D position;
    protected Orientation2D orientation;
    protected System2D field;

    protected Movable2D move; 
    protected Turnable2D turn;

    public void move(Movable2D move, int points) {
        move.change(position, points);
        checkBounds();
    }

    public void move(Turnable2D turn, int points) {
        turn.change(orientation, points);
    }

    public void setField(System2D field) {
        this.field = field;
    }

    public abstract void draw();

    public abstract Entity2DOutOfBoundsException getException();

    public Position2D getPosition() {
        return position;
    }

    public Orientation2D getOrientation() {
        return orientation;
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
        return "Position: " + position.toString() + " Orientation: " + orientation.toString();
    }

}