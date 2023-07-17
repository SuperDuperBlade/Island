package com.SuperDuperBlade.Managers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public  class KeyManager implements KeyListener {

    public boolean[] keyPressed = new boolean[300];
    public String message = "";


    @Override
    public void keyTyped(KeyEvent e) {
        char keyCode = e.getKeyChar();
        switch (keyCode) {
            case KeyEvent.VK_ENTER:
                this.message = "";
                System.out.println("here");
                break;
            case KeyEvent.VK_BACK_SPACE:
                this.message = removeLastChar(message);
                break;
            default:
                this.message += e.getKeyChar();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPressed[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed[e.getKeyCode()] = false;
    }
    public static String removeLastChar(String str) {
        return removeLastChars(str, 1);
    }
    public static String removeLastChars(String str, int chars) {
        if (str.length()!=0)
        return str.substring(0, str.length() - chars);
        return "";
    }

    public boolean[] getKeyPressed() {
        return keyPressed;
    }
    public boolean isKeyPressed(int key){
        return keyPressed[key];
    }
}
