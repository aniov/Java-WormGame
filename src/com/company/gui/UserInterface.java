package com.company.gui;

import com.company.game.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marius on 3/1/2017.
 */
public class UserInterface {

    private JFrame frame;
    private Game game;
    private int blockSize;
    private DrawingBoard drawingBoard;

    public UserInterface(Game game, int blockSize) {
        this.game = game;
        this.blockSize = blockSize;
    }

    public void start(){
        frame = new JFrame("Worms...");
        int width = (game.getWidth()) * blockSize + 5;
        int height = (game.getHeight() + 1) * blockSize + 5;

        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {

        drawingBoard = new DrawingBoard(game, blockSize);
        container.add(drawingBoard);

        frame.addKeyListener(new KeyboardListener(game.getWorm()));
    }

    public DrawingBoard getDrawingBoard() {
        return drawingBoard;
    }
}
