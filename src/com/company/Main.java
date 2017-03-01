package com.company;

import com.company.game.Game;
import com.company.gui.UserInterface;

public class Main {

    private static final int BLOCK_SIZE = 25;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game(WIDTH, HEIGHT);
        UserInterface userInterface = new UserInterface(game, BLOCK_SIZE);
        userInterface.start();

        Thread.sleep(500);
        game.setDrawingBoard(userInterface.getDrawingBoard());
        game.start();
    }
}
