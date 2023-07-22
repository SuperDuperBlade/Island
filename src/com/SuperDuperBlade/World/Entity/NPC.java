package com.SuperDuperBlade.World.Entity;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Managers.KeyManager;
import com.SuperDuperBlade.Utils.Position;
import com.SuperDuperBlade.Utils.Util;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class NPC extends Entity{

    String playerImagePath = "/Res/Entities/Player/player";
    private final BufferedImage
            playerUp = Util.getImageFromSource(playerImagePath+"Up.png"),
            playerDown = Util.getImageFromSource(playerImagePath+"Down.png"),
            playerLeft = Util.getImageFromSource(playerImagePath+"Left.png"),
            playerRight = Util.getImageFromSource(playerImagePath+"Right.png");
    //DEFAULT
    private BufferedImage selectedImage = playerDown;

    public NPC(int health, int movementSpeed, int posX, int posY, int hitBoxX, int hitBoxY) {
        super(health, movementSpeed, posX, posY, hitBoxX, hitBoxY);
    }


    @Override
    public void update(double delta) {
        super.update(delta);


    }

    @Override
    public void draw(Graphics2D g2, int posX, int posY) {
        int size = Main.getWindow().getTileScaled();
        g2.drawImage(selectedImage,posX,posY,size,size,null);
    }


    @Override
    public void onTick() {

    }




}
