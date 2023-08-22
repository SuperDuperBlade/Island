package com.SuperDuperBlade.Scene.GUI.Game;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Scene.GUI.Gui;
import com.SuperDuperBlade.World.Entity.Player;

import java.awt.*;

public class Stats extends Gui {
    private Player player;

    public Stats(Player player){
        this.player = player;
    }


    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        g2.setColor(Color.black);
        g2.fillRect(10,10,(28* Main.getScale())+10,13);
        g2.setColor(Color.green);

        int percentage = (int) (((double) player.getHealth() /100)*((28*Main.getScale())+8));

        g2.fillRect(11,11,percentage,11);
        g2.setColor(Color.white);
        g2.drawString("Health 100/"+player.health,15,21);
    }


}
