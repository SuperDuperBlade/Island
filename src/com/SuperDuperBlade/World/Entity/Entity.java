package com.SuperDuperBlade.World.Entity;

import java.awt.*;

public abstract class Entity {
    // movement speed = pixels per second;
    public  int health , movementSpeed;
    public Position position;

    public Entity(int health, int movementSpeed, Position position) {
        this.health = health;
        this.movementSpeed = movementSpeed;
        this.position = position;
    }

    public abstract void update(double delta);
    public abstract void draw(Graphics2D g2, int posX,int posY);
    public abstract void  onTick();

    public int getMovementSpeed() {
        return movementSpeed;
    }
    public double calulateSpeedDif(double deltaTime){
        return movementSpeed*(deltaTime/1000);
    }


    public static class Position {
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
}

