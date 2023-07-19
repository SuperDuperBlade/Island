package com.SuperDuperBlade.Scene.GUI;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Managers.KeyManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Command extends Gui{

    private boolean toggled = false;


    @Override
    public void draw(Graphics2D g2) {
        if (keyManager.isKeyTyped(KeyEvent.VK_TAB)){
            toggled = !toggled;
            keyManager.resetMessage();
        }


        if (toggled){
            Main.getWindow().getSceneManager().getScence().paused = true;
            g2.setColor(new Color(9,2,0,127));
            g2.fillRect(0, getWindow().getScreenSizeY() -(5*getWindow().getScale()), getWindow().getScreenSizeX(),getWindow().getScreenSizeY());
            g2.setColor(Color.white);
            g2.drawString(">"+keyManager.getMessage(),5, getWindow().getScreenSizeY() - (getWindow().getScale()));
        }else {
            Main.getWindow().getSceneManager().getScence().paused = false;
        }

    }
}
