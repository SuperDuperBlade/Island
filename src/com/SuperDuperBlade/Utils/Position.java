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
        if (Util.checkForTileCollision(entity)){
            return true;
        }

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

    public double[] getDistanceFromPosition(Position position){
        return new double[]{
                Math.max(posX ,position.getPosX()) -  Math.min(posX ,position.getPosX()),
                Math.max(posY ,position.getPosX()) -  Math.min(posY ,position.getPosX()),
        };
    }
    public double getTotalDistanceFromPosition(Position p){
        double[] pos = getDistanceFromPosition(p);
        return pos[0] + pos[1];
    }

    public int convertToWorldPosX(){
        return (int) Math.floor(posX/ (Main.getTileScaled()));
    }
    public int convertToWorldPosY(){
        return (int) Math.floor(posY/( Main.getWindow().getTileScaled()));
    }

    public int offsetX(){
        return (int) (posX%Main.getWindow().getTileScaled());
    }
    public int offsetY(){
        return (int) (posY%Main.getWindow().getTileScaled());
    }
    public int convertToWorldCentrePosX(){
        return (int) (posX + (Main.getTileScaled()/2))/Main.getTileScaled();
    }
    public int convertToWorldCentrePosY(){
        return  convertToWorldPosY()+1;
    }


}