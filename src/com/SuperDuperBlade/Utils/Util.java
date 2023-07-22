package com.SuperDuperBlade.Utils;

import com.SuperDuperBlade.World.Entity.Entity;

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
}
