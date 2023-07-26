package com.SuperDuperBlade.World.TIle;

import java.awt.*;


public class Tile {
    public Image image;
    public boolean collidable;

    public Tile(Image image,boolean collidable) {
        this.image = image;
        this.collidable = collidable;
    }

    public void onTick(){}


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public void setCollidable(boolean collidable) {
        this.collidable = collidable;
    }
}
