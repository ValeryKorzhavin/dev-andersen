package com.company;

public class TurnClockwiseTractorCommand implements Command {

    private Entity tractor;

    public TurnClockwiseTractorCommand(Entity tractor) {
        this.tractor = tractor;
    }

    public void execute() {
        Orientation orientation = tractor.getOrientation().turnRight();
        tractor.setOrientation(orientation);        
    }

}
