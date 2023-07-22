package com.SuperDuperBlade.Utils;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Scene.Scence;
import com.SuperDuperBlade.Scene.World;
import com.SuperDuperBlade.World.Entity.Entity;
import com.SuperDuperBlade.World.Layer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public  class Util {

    public static BufferedImage getImageFromSource(String location){

        try {
            return  ImageIO.read(Util.class.getResourceAsStream(location));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

                        if (layer.getTilemap()[posY][posX].isCollisionEnabled()) {
                            return true;
                        }
                    }
                }
            }catch (Exception ex){
                return false;
            }
        return false;
    }
}
