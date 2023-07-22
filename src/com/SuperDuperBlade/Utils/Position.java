package com.SuperDuperBlade.Utils;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Scene.Scence;
import com.SuperDuperBlade.Scene.World;
import com.SuperDuperBlade.World.Entity.Entity;

public class Position {
    double posX, posY ;
    double prePosX, prePosY;

    private Entity entity;

    public Position(Entity selectedEntity ,double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
        this.entity = selectedEntity;
    }
    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public boolean testCollision(){

        Scence scence = Main.getWindow().getScence();
        if (scence instanceof World){
            World world = (World) Main.getWindow().getScence();
            for (Entity e: world.getEntities()) {
                if (e != this.entity && Util.checkForEntityCollision(this.entity,e)){
                    return true;
                }
            }
        }
        return false;
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
        this.prePosY = posY;
        this.posY += add;
        entity.setPosition(new Position(entity,posX,posY));
         if (testCollision()){
           this.posY = prePosY;
         }
         entity.setPosition(new Position(entity,posX,posY));
    }
    public void addToPosX(double add) {
        this.prePosX = posX;
         this.posX += add;
        if (entity!= null&& testCollision()){
            this.posX = prePosX;
        }
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