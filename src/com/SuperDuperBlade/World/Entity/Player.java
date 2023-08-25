package com.SuperDuperBlade.World.Entity;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Managers.KeyManager;
import com.SuperDuperBlade.Utils.Util;
import com.SuperDuperBlade.World.Item.Item;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.SuperDuperBlade.Utils.Util.calculateSpeedDif;

public class Player extends Entity{
    private final KeyManager keyManager;
    private int stamina = 100;
    private Item selectedItem = new Item("Hand",2,1,1,10);

    String playerImagePath = "/Res/Entities/Player/player";
    private final Image
            playerUp = Util.getImageFromSource(playerImagePath+"Up.png"),
            playerDown = Util.getImageFromSource(playerImagePath+"Down.png"),
            playerLeft = Util.getImageFromSource(playerImagePath+"Left.png"),
            playerRight = Util.getImageFromSource(playerImagePath+"Right.png");
    //DEFAULT
    private Image selectedImage = playerDown;

    public Player(int health, int movementSpeed, int posX, int posY, int hitBoxX, int hitBoxY) {
        super(health, movementSpeed, posX, posY, hitBoxX, hitBoxY);
        this.keyManager = Main.getWindow().getKeyManager();
    }


    //TODO add images for the player going diagonally
    @Override
    public void update(double delta) {
        double motion = calculateSpeedDif(delta,movementSpeed);

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
        g2.drawImage(selectedImage,posX,posY,Main.getTileScaled(),Main.getTileScaled(),null);
        g2.drawRect(posX,posY,hitBoxX,hitBoxY);
    }


    @Override
    public void onTick() {

    }


    public void useItem(){
        if (stamina - selectedItem.getStaminaDuration()<0) return;

        stamina -= selectedItem.getStaminaDuration();
        if (selectedImage==playerUp){

        }
    }




}
