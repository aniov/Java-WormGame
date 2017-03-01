package com.company.domain;

/**
 * Created by Marius on 2/28/2017.
 */
public class Element {

    private int x;
    private int y;

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Element) ) return false;

        Element element = (Element) o;

        if (x != element.x) return false;
        return y == element.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
