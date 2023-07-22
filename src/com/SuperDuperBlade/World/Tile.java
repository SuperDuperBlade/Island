package com.SuperDuperBlade.World;

import com.SuperDuperBlade.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public enum Tile {


    WATER("/Tiles/Water.png", true),// 0
    GRASS("/Tiles/Grass.png", false),// 1
    SAND("/Tiles/Sand.png", false);//   2


    private Image image;
    private boolean collisionEnabled;


    Tile(String imageLocation , boolean collide){
        this.collisionEnabled = collide;
        try {
            int tileSize = Main.getWindow().getTileScaled();
            this.image =  ImageIO.read(getDeclaringClass().getResourceAsStream(imageLocation)).getScaledInstance(tileSize,tileSize,0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Tile valueOf(int value){

        for (int i = 0 ;i <values().length;i++){
            if (i==value){
                return values()[i];
            }
        }
        //Default tile if no tiles are found
        return WATER;
    }

    public static Tile[] valueOfArray(int intergerArray[]){
        Tile[] tileArray = new Tile[intergerArray.length];
        for (int i = 0; i < intergerArray.length; i++) {
            tileArray[i] = valueOf(intergerArray[i]);
        }
        return tileArray;
    }

    public Image getImage() {
        return image;
    }

    public boolean isCollisionEnabled() {
        return collisionEnabled;
    }
}
