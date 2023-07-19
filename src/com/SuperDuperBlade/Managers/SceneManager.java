package com.SuperDuperBlade.Managers;

import com.SuperDuperBlade.Scene.MainMenu;
import com.SuperDuperBlade.Scene.Scence;
import com.SuperDuperBlade.Scene.World;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SceneManager {
    private Scence currentScene;



    public void update() {currentScene.update();}
    public void draw(Graphics2D g2) {
        if (currentScene!=null) currentScene.draw(g2);
    }
    public void onTick(){
        currentScene.onTIck();
    }
    public void onEventMouse(MouseEvent e){currentScene.onEventMouse(e);}




    public void changeScence(int scence) {

        switch (scence) {
            case 0:
                 currentScene = new World();
                break;
            case 1:
                break;
            default:
                throw new RuntimeException("Invalid Scene");
        }

    }
}
