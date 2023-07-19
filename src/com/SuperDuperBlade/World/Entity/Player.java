package com.SuperDuperBlade.World.Entity;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Managers.KeyManager;
import com.SuperDuperBlade.Utils.Util;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity{
    private final KeyManager keyManager;
    String playerImagePath = "/Res/Entities/Player/player";
    private final BufferedImage
            playerUp = Util.getImageFromSource(playerImagePath+"Up.png"),
            playerDown = Util.getImageFromSource(playerImagePath+"Down.png"),
            playerLeft = Util.getImageFromSource(playerImagePath+"Left.png"),
            playerRight = Util.getImageFromSource(playerImagePath+"Right.png");
    //DEFAULT
    private BufferedImage selectedImage = playerDown;




    public Player(int health, int movementSpeed, Position position) {
        super(health, movementSpeed, position);
        this.keyManager = Main.getWindow().getKeyManager();
    }


    //TODO add images for the player going diagonally
    @Override
    public void update(double delta) {
        double motion = calulateSpeedDif(delta);

        if (keyManager.keyPressed[KeyEvent.VK_W]) {
            this.position.addToPosY(-motion);
            selectedImage = playerUp;
        }
        if (keyManager.keyPressed[KeyEvent.VK_S]) {
            this.position.addToPosY(motion);
            selectedImage = playerDown;
        }
        if (keyManager.keyPressed[KeyEvent.VK_A]) {
            this.position.addToPosX(-motion);
            selectedImage = playerLeft;
        }
        if (keyManager.keyPressed[KeyEvent.VK_D]) {
            this.position.addToPosX(motion);
            selectedImage = playerRight;
        }
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
