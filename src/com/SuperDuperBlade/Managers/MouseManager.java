package com.SuperDuperBlade.Managers;

import com.SuperDuperBlade.GameWindow;
import com.SuperDuperBlade.Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {
    //just to be safe
    public MouseVector mouseButton[] = new MouseVector[10];
    public boolean isFoucsed = false;



    public void reset() {
        for (int i = 0; i < mouseButton.length; i++) {
            mouseButton[i] = new MouseVector(0, 0, false);
        }
    }

    public MouseManager() {
        reset();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Main.getWindow().onEventMouse(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ;
        mouseButton[e.getButton()] = new MouseVector(e.getX(), e.getY(), true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseButton[e.getButton()] = new MouseVector(e.getX(), e.getY(), false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        isFoucsed = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isFoucsed = false;
    }

    public class MouseVector {
        private final int posX;
        private final int posY;
        private final boolean isPressed;

        public MouseVector(int posX, int posY, boolean isPressed) {
            this.posX = posX;
            this.posY = posY;
            this.isPressed = isPressed;
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }

        public boolean isPressed() {
            return isPressed;
        }
    }
}
