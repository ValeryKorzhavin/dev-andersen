package com.company;

import java.util.List;
import java.util.ArrayList;

public class CoordinateSystem {

    private int[][] field;

    private List<Entity> entities = new ArrayList<>();

    public CoordinateSystem(int xSize, int ySize) {
        this.field = new int[xSize][ySize];
    }

    public CoordinateSystem(int fieldSize) {
        this(fieldSize, fieldSize);
    }

    public void addEntity(Entity entity) {
        entity.setField(this);
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        boolean success = entities.remove(entity);
        if (success) {
            entity.setField(null);
        }
    }

    public int getSizeX() {
        return field[0].length;
    }

    public int getSizeY() {
        return field[1].length;
    }

    public void draw() {
        entities.stream().forEach(Entity::draw);
    }

}