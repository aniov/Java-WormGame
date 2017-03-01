package com.company.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Marius on 2/28/2017.
 */
public class Worm {

    private List<Element> worm = new LinkedList<>();
    private Direction direction;
    private int minSize;

    public Worm(int x, int y, Direction direction) {
        this.direction = direction;
        this.minSize = 3;
        worm.add(new Element(x, y));
    }

    /** Add a new element as head and delete the last one*/
    public void move(){
        if (worm.size() < minSize){
            grow();
        }
        worm.add(createNewHead());
        worm.remove(0);
    }
    /** Add a new element as head*/
    public void grow(){
        worm.add(createNewHead());
    }

    public boolean intersectAnotherElement(Element element){
        for (Element entry : worm){
            if (element.equals(entry) && element != entry){
                return true;
            }
        }
        return false;
    }

    public boolean intersectHimself(){
       for (Element entry : worm){
           if (intersectAnotherElement(entry)){
               return true;
           }
       }
       return false;
    }

    private Element createNewHead(){
        int newX = worm.get(worm.size() - 1).getX() + direction.getX();
        int newY = worm.get(worm.size() - 1).getY() + direction.getY();
        return new Element(newX, newY);
    }

    public List<Element> getWorm() {
        return worm;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean hitBorder(int width, int height) {
        for (Element element : worm) {
            if (! (element.getX() >= 0 && element.getX() < width && element.getY() >= 0 && element.getY() < height)) {
                return true;
            }
        }
        return false;
    }

    public int getWormSize(){
        return worm.size();
    }
}
