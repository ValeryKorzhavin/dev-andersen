package com.company;

import com.company.exception.EntityOutOfBoundsException;

public abstract class Entity {

    protected Position position;

    protected Orientation orientation;

    protected CoordSystem field;

    protected MoveBehavior moveBehavior; 

    protected TurnBehavior turnBehavior;

    /* implement for visualization */ 
    public abstract void draw();

    public abstract EntityOutOfBoundsException getException();

    public void setField(CoordSystem field) {
        this.field = field;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setPosition(Position position) {
        this.position = position;
    }   

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void move(MoveBehavior moveBehavior, int speed) {
        Position newPosition = moveBehavior
            .performMove(position, orientation, speed);
        checkBounds(newPosition);
        setPosition(newPosition);
    }

    public void turn(TurnBehavior turnBehavior) {
        Orientation newOrientation = turnBehavior
            .performTurn(orientation);
        setOrientation(newOrientation);
    }

    public void checkBounds(Position position) {
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
        return "Position: " + position.toString() 
               + " Orientation: " + orientation.toString();
    }

}