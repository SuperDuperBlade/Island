package com.SuperDuperBlade.World.Entity;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Utils.Position;

import java.awt.*;

public abstract class Entity {
    // movement speed = pixels per second;
    public  int health , movementSpeed;
    public Position position;

    public Entity(int health, int movementSpeed, Position position) {
        this.health = health;
        this.movementSpeed = movementSpeed;
        this.position = new Position(position.getPosX() * Main.getWindow().getTileScaled(),position.getPosY() * Main.getWindow().getTileScaled());
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
}


