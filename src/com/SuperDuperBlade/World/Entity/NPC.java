package com.SuperDuperBlade.World.Entity;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Managers.KeyManager;
import com.SuperDuperBlade.Utils.Position;
import com.SuperDuperBlade.Utils.Util;
import com.SuperDuperBlade.World.Entity.AI.AI;
import com.SuperDuperBlade.World.Entity.AI.Follow;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class NPC extends Entity{

    String playerImagePath = "/Res/Entities/Player/player";
    private final Image
            playerUp = Util.getImageFromSource(playerImagePath+"Up.png"),
            playerDown = Util.getImageFromSource(playerImagePath+"Down.png"),
            playerLeft = Util.getImageFromSource(playerImagePath+"Left.png"),
            playerRight = Util.getImageFromSource(playerImagePath+"Right.png");
    //DEFAULT
    private Image selectedImage = playerDown;

    private Follow ai;

    public NPC(int health, int movementSpeed, int posX, int posY, int hitBoxX, int hitBoxY) {
        super(health, movementSpeed, posX, posY, hitBoxX, hitBoxY);
    }


    @Override
    public void update(double delta) {
        ai = new Follow(this, Main.getCurrentWorld().getPlayer());
        ai.update(delta);
    }

    @Override
    public void draw(Graphics2D g2, int posX, int posY) {
        int size = Main.getWindow().getTileScaled();
        g2.drawImage(selectedImage,posX,posY,size,size,null);
        g2.drawRect(posX,posY,hitBoxX,hitBoxY);
    }


    @Override
    public void onTick() {

    }




}
