package com.SuperDuperBlade;

import com.SuperDuperBlade.Scene.World;
import com.SuperDuperBlade.World.Camera;

import javax.swing.*;

public class Main {
    private static GameWindow gWindow;

    public static void main(String args[]){
         JFrame  window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Island");


        gWindow = new GameWindow();
        window.add(gWindow);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gWindow.run();
    }


    public static GameWindow getWindow(){
        return gWindow;
    }
    public static void debug(String text){
        System.out.println("DEBUG: "+text);
    }
    public static int getScale(){
        return gWindow.getScale();
    }
    public static int getTileScaled(){
        return gWindow.getTileScaled();
    }
    public static Camera getCamera(){
        if (gWindow.getScence() instanceof World){
            World world  = (World) gWindow.getScence();
            return world.getCamera();
        }
        return null;
    }


}
