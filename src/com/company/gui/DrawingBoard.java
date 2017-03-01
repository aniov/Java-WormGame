package com.company.gui;

import com.company.domain.Element;
import com.company.domain.Food;
import com.company.game.Game;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Marius on 3/1/2017.
 */
public class DrawingBoard extends JPanel {

    private Game game;
    private int blockSize;

    public DrawingBoard(Game game, int blockSize){
        super.setBackground(Color.LIGHT_GRAY);
        this.game = game;
        this.blockSize = blockSize;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        List<Element> worm = game.getWorm().getWorm();
        for (Element element : worm){
            if (worm.get(worm.size() - 1).equals(element)){
                graphics.setColor(Color.MAGENTA);
            } else {
                graphics.setColor(Color.PINK);
            }
            graphics.fill3DRect(element.getX() * blockSize, element.getY() * blockSize, blockSize, blockSize, true);
        }
        Food food = game.getFood();
        graphics.setColor(Color.GREEN);
        //graphics.fillOval(food.getX() * blockSize, food.getY() * blockSize, blockSize, blockSize);
        graphics.fill3DRect(food.getX() * blockSize, food.getY() * blockSize, blockSize, blockSize, true);
    }

    public void update(){
        repaint();
    }
}
