package com.SuperDuperBlade.Scene.GUI;

import com.SuperDuperBlade.GameWindow;
import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Managers.KeyManager;
import com.SuperDuperBlade.Managers.MouseManager;

import java.awt.*;


public abstract class Gui {

    public MouseManager mouseManager = Main.getWindow().getMouseManager();
    public KeyManager keyManager = Main.getWindow().getKeyManager();

    GameWindow getWindow(){
        return Main.getWindow();
    }

    public void onTick(){}
    public void draw(Graphics2D g2){}


}
