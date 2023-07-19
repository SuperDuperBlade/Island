package com.SuperDuperBlade.Utils;

import com.SuperDuperBlade.Main;

public class Position {
    double posX, posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
    public void addToPosY(double add) {
        this.posY += add;
    }
    public void addToPosX(double add) {
        this.posX += add;
    }

    public int convertToWorldPosX(){
        return (int) (posX/ Main.getWindow().getTileScaled());
    }
    public int convertToWorldPosY(){
        return (int) (posY/ Main.getWindow().getTileScaled());
    }

    public int offsetX(){
        return (int) (posX%Main.getWindow().getTileScaled());
    }
    public int offsetY(){
        return (int) (posY%Main.getWindow().getTileScaled());
    }

}