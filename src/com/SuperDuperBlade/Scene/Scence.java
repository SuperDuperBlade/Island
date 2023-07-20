package com.SuperDuperBlade.Scene;


import com.SuperDuperBlade.Scene.GUI.Gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class Scence {

    public boolean paused = false;
    public ArrayList<Gui> guis = new ArrayList<>();


    public abstract void update(double delta);
    public abstract void draw(Graphics2D g2);
    public  void onEventMouse(MouseEvent e){}

    public void onTick(){

    }




}
