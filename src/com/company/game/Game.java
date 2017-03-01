package com.company.game;

import com.company.domain.Direction;
import com.company.domain.Food;
import com.company.domain.Worm;
import com.company.gui.DrawingBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


/**
 * Created by Marius on 3/1/2017.
 */
public class Game extends Timer implements ActionListener{

    private int width;
    private int height;
    private Worm worm;
    private Food food;
    private boolean gameOver;
    private DrawingBoard drawingBoard;

    public Game(int width, int height){
        super(1000, null);
        this.width = width;
        this.height = height;
        this.gameOver = false;
        /** The warm is created in middle of board and directed Down*/
        worm = new Worm(width / 2, height / 2, Direction.DOWN);
        food = createNewFood();

        addActionListener(this);
        setInitialDelay(1000);

    }
    /** Food should not be outside board or on the worm*/
    private Food createNewFood() {
        Random random = new Random();
        Food newFood;
        while (true) {
            newFood = new Food(random.nextInt(width), random.nextInt(height));
            if (!worm.intersectAnotherElement(newFood)){
                return newFood;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver){
            return;
        }
        worm.move();
        if (worm.intersectHimself() || worm.hitBorder(width, height)) {
            gameOver = true;
            return;
        }
        if (worm.intersectAnotherElement(food)){
            worm.grow();
            food = createNewFood();
        }
        drawingBoard.update(); /** Calling repaint(); */
        setDelay(1000 / worm.getWormSize());
    }

    public DrawingBoard getDrawingBoard() {
        return drawingBoard;
    }

    public void setDrawingBoard(DrawingBoard drawingBoard) {
        this.drawingBoard = drawingBoard;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
