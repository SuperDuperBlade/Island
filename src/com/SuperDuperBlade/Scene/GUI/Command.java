package com.SuperDuperBlade.Scene.GUI;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Managers.KeyManager;
import com.SuperDuperBlade.Scene.World;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Command extends Gui{

    private World world;

    public Command(World world) {
        this.world = world;
    }

    private boolean toggled = false;


    @Override
    public void draw(Graphics2D g2) {
        if (keyManager.isKeyTyped(KeyEvent.VK_TAB)){
            toggled = !toggled;
            keyManager.resetMessage();
        }


        if (toggled){
            Main.getWindow().getScence().paused = true;
            g2.setColor(new Color(9,2,0,127));
            g2.fillRect(0, getWindow().getScreenSizeY() -(5*getWindow().getScale()), getWindow().getScreenSizeX(),getWindow().getScreenSizeY());
            g2.setColor(Color.white);
            g2.drawString(">"+keyManager.getMessage(),5, getWindow().getScreenSizeY() - (getWindow().getScale()));
        }else {
            Main.getWindow().getScence().paused = false;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar()==KeyEvent.VK_ENTER){
            parseMessage();
        }
    }

    public void parseMessage(){
        String[] message = keyManager.getMessage().split(" ");
        //todo add responses to commands
        try {
            switch (message[0]){
                case "player.speed":
                    world.getCamera().getSelectedEntity().setMovementSpeed(Integer.parseInt(message[1]));
                    break;
            }
        }catch (Exception e){

        }

    }

}
