package com.SuperDuperBlade;

import javax.swing.*;

public class Main {
    private static GameWindow gWindow;

    public static void main(String args[]){
         JFrame  window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Simulation");

        gWindow = new GameWindow();
        window.add(gWindow);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gWindow.startThread();

    }


    public static GameWindow getWindow(){
        return gWindow;
    }


}
