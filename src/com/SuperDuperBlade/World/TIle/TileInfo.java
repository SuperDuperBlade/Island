package com.SuperDuperBlade.World.TIle;

import com.SuperDuperBlade.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public enum TileInfo {


    WATER("/Tiles/Water.png", false),// 0
    GRASS("/Tiles/Grass.png", false),// 1
    SAND("/Tiles/Sand.png", true), //   2
    TREE("/Tiles/Interactables/tree.png",true);


    private Image image;
    private boolean collisionEnabled;
    private static int cashedValue;
    private static TileInfo cashedTile;


    TileInfo(String imageLocation , boolean collide){
        this.collisionEnabled = collide;
        try {
            int tileSize = Main.getWindow().getTileScaled();
            this.image =  ImageIO.read(getDeclaringClass().getResourceAsStream(imageLocation)).getScaledInstance(tileSize,tileSize,0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static TileInfo valueOf(int value){

        //reduces loading speed
        if (cashedValue == value){
            return cashedTile;
        }


        for (int i = 0 ;i <values().length;i++){
            if (i==value){
                cashedValue = i;
                cashedTile = values()[i];
                return cashedTile;
            }
        }
        //Default tile if no tiles are found
        return WATER;
    }

    public static Tile[] valueOfArray(int intergerArray[]){
        Tile[] tileArray = new Tile[intergerArray.length];
        for (int i = 0; i < intergerArray.length; i++) {
            tileArray[i] = new Tile(intergerArray[i]);
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