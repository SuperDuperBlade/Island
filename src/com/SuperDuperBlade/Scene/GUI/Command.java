package com.SuperDuperBlade.Scene.GUI;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Managers.KeyManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Command extends Gui{

    private boolean toggled = false;


    @Override
    public void draw(Graphics2D g2) {
        if (keyManager.isKeyPressed(KeyEvent.VK_TAB)) toggled = !toggled;

        if (toggled){
            g2.setColor(new Color(9,2,0,127));
            g2.fillRect(0, getWindow().getScreenSizeY() -(20*getWindow().getScale()), getWindow().getScreenSizeX(),getWindow().getScreenSizeY());
        }

    }
}
