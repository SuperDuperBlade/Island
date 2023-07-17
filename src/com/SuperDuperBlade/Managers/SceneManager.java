package com.SuperDuperBlade.Managers;

import com.SuperDuperBlade.Scene.Scence;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SceneManager {
    private Scence currentScene;
    private int scenceNumber = 0;


    public void update() {currentScene.update();}
    public void draw(Graphics2D g2) {currentScene.draw(g2);}
    public void onEventMouse(MouseEvent e){currentScene.onEventMouse(e);}




    public void changeScence(int scence) {
        this.scenceNumber = scence;

        switch (scence) {
            case 0:
                //    sceneManager = new MainMenu();
                break;
            case 1:
                //    sceneManager = new Game();
                break;
            default:
                throw new RuntimeException("Invalid Scence");
        }

    }
}
