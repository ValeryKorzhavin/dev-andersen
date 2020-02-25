package com.company;

/**
 * Необходимо выполнить рефакторинг существующего кода - исправить все места, которые вам покажутся некрасивыми или не
 * правильными. Можно изменять этот класс и/или добавлять новые. Результатом работы должен быть код, который будет прост
 * и понятен, без логических ошибок. Так же необходимо предусмотреть возможность дальнейшего расширения функционала -
 * могут быть добавлены как новые команды для трактора (новые способы движения, вращения), так и новые "фигуры", которые
 * могут двигатся совершенно в другой системе координат.
 */
public class Tractor {

    int[] position = new int[]{0, 0};
    int[] field = new int[]{5, 5};
    Orientation orientation = Orientation.NORTH;

    public void move(String command) {
        if (command == ("F")) {
            moveForwards();
        } else if (command == "T") {
            turnClockwise();
        }
    }

    private void moveForwards() {
        if (orientation == Orientation.NORTH) {
            position = new int[]{position[0], position[1] + 1};
        } else if (orientation == Orientation.EAST) {
            position = new int[]{position[0] + 1, position[1]};
        } else if (orientation == Orientation.SOUTH) {
            position = new int[]{position[0], position[1] - 1};
        } else if (orientation == Orientation.WEST) {
            position = new int[]{position[0] - 1, position[1]};
        }
        if (position[0] > field[0] || position[1] > field[1]) {
            throw new TractorInDitchException();
        }
    }

    private void turnClockwise() {
        if (orientation == Orientation.NORTH) {
            orientation = Orientation.EAST;
        } else if (orientation == Orientation.EAST) {
            orientation = Orientation.SOUTH;
        } else if (orientation == Orientation.SOUTH) {
            orientation = Orientation.WEST;
        } else if (orientation == Orientation.WEST) {
            orientation = Orientation.NORTH;
        }
    }

    /**
     * Метод добавлен для демонстрации работы приложения.
     */
    public static void main(String[] args) {
        Tractor tractor = new Tractor();

        for (int i = 0; i < 10; i++) {
            tractor.move("F");
        }
    }
}
