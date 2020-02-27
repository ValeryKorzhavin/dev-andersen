package com.company;

public abstract class Entity {

    private Position position;

    private Orientation orientation;

    private CoordinateSystem field;

    private Command command;

    public Entity(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    /* implement for visualization */ 
    public abstract void draw();

    public void setField(CoordinateSystem field) {
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

    public void setCommand(Command command) {
        this.command = command;
    }

    public void move() {
        command.execute();
    }

    public boolean checkBounds(Position position) {
        boolean isOutX = position.getX() >= field.getSizeX() 
                      || position.getX() < 0;

        boolean isOutY = position.getY() >= field.getSizeY() 
                      || position.getY() < 0;

        return isOutX || isOutY;          
    }

    @Override
    public String toString() {
        return "Position: " + position.toString() 
               + " Orientation: " + orientation.toString();
    }

}