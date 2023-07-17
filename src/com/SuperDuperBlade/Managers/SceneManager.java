package com.SuperDuperBlade.Managers;

import com.SuperDuperBlade.Scene.MainMenu;
import com.SuperDuperBlade.Scene.Scence;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SceneManager {
    private Scence currentScene;



    public void update() {currentScene.update();}
    public void draw(Graphics2D g2) {currentScene.draw(g2);}
    public void onEventMouse(MouseEvent e){currentScene.onEventMouse(e);}




    public void changeScence(int scence) {

        switch (scence) {
            case 0:
                 currentScene = new MainMenu();
                break;
            case 1:
                break;
            default:
                throw new RuntimeException("Invalid Scene");
        }

    }
}
