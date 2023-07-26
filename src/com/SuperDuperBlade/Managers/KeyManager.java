package com.SuperDuperBlade.Managers;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Scene.GUI.Gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public  class KeyManager implements KeyListener {


    //If you have more keys on your keyboard than this...
    public boolean[] keyPressed = new boolean[300];
    public boolean[] keyTyped = new boolean[300];



    public String message = "";


    @Override
    public void keyTyped(KeyEvent e) {
            //Gui window hook
        for (Gui g: Main.getWindow().getScence().guis) {
            g.keyTyped(e);
        }

        char keyCode = e.getKeyChar();
        this.keyTyped[KeyEvent.getExtendedKeyCodeForChar(keyCode)] = true;
        switch (keyCode) {
            case KeyEvent.VK_ENTER:
                this.message = "";
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
    public void keyPressed(KeyEvent e){
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
    public String getMessage() {
        return this.message;
    }

    public boolean isKeyTyped(int keycode){
        boolean typed =   this.keyTyped[keycode];

        this.keyTyped[keycode] = false;
        return typed;
    }

    public void resetMessage(){
        this.message = "";
    }


}
