package com.company;

import com.company.exception.TractorOutOfBoundsException;

public class MoveForwardsTractorCommand implements Command {

    private Entity tractor;

    private int speed;

    public MoveForwardsTractorCommand(Entity tractor, int speed) {
        this.tractor = tractor;
        this.speed = speed;
    }

    public void execute() {
        Orientation orientation = tractor.getOrientation();
        Position position = orientation.moveThisDirection(tractor.getPosition(), speed);
        boolean isOutOfBounds = tractor.checkBounds(position);

        if (isOutOfBounds) {
            throw new TractorOutOfBoundsException();
        }
        tractor.setPosition(position);
    }

}
