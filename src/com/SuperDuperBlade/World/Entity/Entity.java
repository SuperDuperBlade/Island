package com.SuperDuperBlade.World.Entity;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Utils.Position;

import java.awt.*;

public abstract class Entity {
    // movement speed = pixels per second;
    public  int health , movementSpeed;
    public Position position;

    //TODO Allow the hitBox to be positioned
    public int hitBoxX , hitBoxY;

    public Entity(int health, int movementSpeed, int posX, int posY, int hitBoxX,int hitBoxY) {
        this.health = health;
        this.movementSpeed = movementSpeed;
        this.position =  new Position(this,posX * Main.getWindow().getTileScaled(),posY * Main.getWindow().getTileScaled());
        this.hitBoxX = hitBoxX;
        this.hitBoxY = hitBoxY;
    }

    public abstract void update(double delta);


    public abstract void draw(Graphics2D g2, int posX,int posY);
    public abstract void  onTick();

    public int getMovementSpeed() {
        return movementSpeed;
    }
    public double calculateSpeedDif(double deltaTime){
        return movementSpeed*(deltaTime/1000);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getHitBoxX() {
        return hitBoxX;
    }

    public void setHitBoxX(int hitBoxX) {
        this.hitBoxX = hitBoxX;
    }

    public int getHitBoxY() {
        return hitBoxY;
    }

    public void setHitBoxY(int hitBoxY) {
        this.hitBoxY = hitBoxY;
    }
}


