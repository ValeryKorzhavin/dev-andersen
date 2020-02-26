package com.company;

import java.util.List;
import java.util.ArrayList;

public class System2D {

    private int[][] field;

    private List<Entity2D> entities = new ArrayList<>();

    public System2D(int xSize, int ySize) {
        this.field = new int[xSize][ySize];
    }

    public System2D(int fieldSize) {
        this(fieldSize, fieldSize);
    }

	public void addEntity(Entity2D entity) {
        entity.setField(this);
        entities.add(entity);
    }

	public void removeEntity(Entity2D entity) {
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
        entities.stream().forEach(Entity2D::draw);
    }

    public void checkBounds() {
        entities.stream().forEach(Entity2D::checkBounds);
    }

}