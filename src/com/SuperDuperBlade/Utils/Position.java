package com.SuperDuperBlade.Utils;

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
        this.posY += add;
    }
}