package com.SuperDuperBlade.Utils;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Scene.World;
import com.SuperDuperBlade.World.Entity.Entity;
import com.SuperDuperBlade.World.Layers.Layer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public  class Util {

    public static Image getImageFromSource(String location){

        try {
          return ImageIO.read(Util.class.getResourceAsStream(location)).getScaledInstance(Main.getTileScaled(),Main.getTileScaled(),0);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static File getFileFromSource(String location) {
        return new File(Main.getWorkingDirectory()+location);
    }
    public static boolean checkForEntityCollision(Entity e , Entity e1){
        if (e.getPosition().getPosY() + e.getHitBoxY() > e1.getPosition().getPosY() && e.getPosition().getPosY() < e1.getPosition().getPosY() + e1.getHitBoxY()){
            if (e.getPosition().getPosX() + e.getHitBoxX() > e1.getPosition().getPosX() && e.getPosition().getPosX() < e1.getPosition().getPosX() + e1.getHitBoxX()){
                return true;
            }
        }
        return false;
    }
    public static boolean checkForTileCollision(Entity e){

            try {
                if (Main.getWindow().getScence() instanceof World) {
                    World world = (World) Main.getWindow().getScence();

                    int posX = e.getPosition().convertToWorldCentrePosX();
                    int posY = e.getPosition().convertToWorldCentrePosY();

                    for (Layer layer : world.getLayers()) {
                        if (layer.getTilemap()[posY][posX].collidable) {
                            return true;
                        }
                    }
                }
            }catch (Exception ex){
                return false;
            }
        return false;
    }

    public static   double calculateSpeedDif(double deltaTime, double movementSpeed){

        return (movementSpeed*(deltaTime/1000000000));
    }

}
