package com.SuperDuperBlade.World.TIle;

import java.awt.*;

import static com.SuperDuperBlade.World.TIle.TileInfo.valueOf;

public class Tile {
    public Image image;
    public boolean collidable;

    public Tile(int value) {
        TileInfo tileInfo = TileInfo.valueOf(value);
        this.image = tileInfo.getImage();
        this.collidable = tileInfo.isCollisionEnabled();
    }

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
