package com.anil.sample.robot.domain;

import java.util.Objects;

/**
 * Position information of the Robot.
 */
public final class Position {

    private int x;
    private int y;
    private Facing facing;
    private int maxX = 5; // Defaults to 5.
    private int maxY = 5; // Defaults to 5.

    public Position(int x, int y, Facing facing) {
        verifyInput(x, y, maxX,maxY);
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public Position(int x, int y, Facing facing, int maxX, int maxY) {
        verifyInput(x,y,maxX,maxY);
        this.x = x;
        this.y = y;
        this.facing = facing;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    private void verifyInput(int x, int y, int maximumX, int maximumY) {
        if(x > maximumX){
            throw new IllegalArgumentException("position x must be between 0 and "+maxX);
        }
        if(y > maximumY){
            throw new IllegalArgumentException("position x must be between 0 and "+maxY);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "," + facing + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y &&
                maxX == position.maxX &&
                maxY == position.maxY &&
                facing == position.facing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, facing, maxX, maxY);
    }

    /**
     * Enum for Facing
     */
    public enum Facing {
        NORTH("NORTH"), SOUTH("SOUTH"), WEST("WEST"), EAST("EAST");

        private final String direction;

        Facing(String direction) {
            this.direction = direction;
        }

        public String getDirection() {
            return direction;
        }

        public static Facing fromString(String value) {
            if (value == null || value.trim().equals("")) {
                return null;
            }
            for (Facing facing : Facing.values()) {
                if (facing.getDirection().equalsIgnoreCase(value)) {
                    return facing;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return direction;
        }
    }

}
