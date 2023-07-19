package com.SuperDuperBlade.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public  class Util {

    public static BufferedImage getImageFromSource(String location){

        try {
            return  ImageIO.read(Util.class.getResourceAsStream(location));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
