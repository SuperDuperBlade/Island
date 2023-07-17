package com.SuperDuperBlade.Scene;


import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Scence {


    public abstract void update();
    public abstract void draw(Graphics2D g2);
    public  void onEventMouse(MouseEvent e){}


}
