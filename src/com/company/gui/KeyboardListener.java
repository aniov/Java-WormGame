package com.company.gui;

import com.company.domain.Direction;
import com.company.domain.Worm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Marius on 3/1/2017.
 */
public class KeyboardListener implements KeyListener {

    private Worm worm;

    public KeyboardListener(Worm worm) {
        this.worm = worm;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            worm.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            worm.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP){
            worm.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            worm.setDirection(Direction.DOWN);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
