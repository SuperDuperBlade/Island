package com.SuperDuperBlade.World.TIle;

import com.SuperDuperBlade.Main;

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
        try {
            this.image =  ImageIO.read(getDeclaringClass().getResourceAsStream(imageLocation)).getScaledInstance(Main.getTileScaled(),Main.getTileScaled(),0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Image getImage(){
        return image;
    }

}
