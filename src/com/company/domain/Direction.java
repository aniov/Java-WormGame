package com.company.domain;

/**
 * Created by Marius on 2/28/2017.
 */
public enum Direction {

    UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

    private int x;
    private int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
