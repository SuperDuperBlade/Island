package com.SuperDuperBlade.World.Entity;

public class Entity {
    private int health , movementSpeed;
    private Position position;

    public Entity(int health, int movementSpeed, Position position) {
        this.health = health;
        this.movementSpeed = movementSpeed;
        this.position = position;
    }

    class Position {
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
}
}

