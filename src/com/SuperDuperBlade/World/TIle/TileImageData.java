package com.SuperDuperBlade.World.TIle;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Utils.Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public enum TileImageData {
    Water("/Tiles/Water.png"),
    GRASS("/Tiles/Grass.png"),
    Sand("/Tiles/Sand.png"),
    TREE("/Tiles/Interactables/tree.png");

    private Image image;


    TileImageData(String imageLocation){
        this.image = Util.getImageFromSource(imageLocation);
    }
    public Image getImage(){
        return image;
    }

}
