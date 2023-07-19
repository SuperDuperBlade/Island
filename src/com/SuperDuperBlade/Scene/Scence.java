package com.SuperDuperBlade.Scene;


import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Scence {

    public boolean paused = false;


    public abstract void update(double delta);
    public abstract void draw(Graphics2D g2);
    public  void onEventMouse(MouseEvent e){}

    public void onTick(){

    }


}
