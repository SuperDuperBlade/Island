package com.SuperDuperBlade.Scene;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Scene.GUI.Command;
import com.SuperDuperBlade.Scene.GUI.Gui;
import com.SuperDuperBlade.Utils.Position;
import com.SuperDuperBlade.World.Camera;
import com.SuperDuperBlade.World.Entity.Entity;
import com.SuperDuperBlade.World.Entity.NPC;
import com.SuperDuperBlade.World.Entity.Player;
import com.SuperDuperBlade.World.Layer;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class World extends Scence {
    private ArrayList<Layer> layers = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();

    private Camera camera;
    private Player player = new Player(100,500, new Position(1,1));

    public World(){
        layers.add(new Layer(new File("/home/sam/IdeaProjects/Islands/src/Res/Maps/Map1.txt")));
        entities.add(player);
        entities.add(new NPC(1,1,new Position(20,2)));
        entities.add(new NPC(1,1,new Position(20,20)));
        entities.add(new NPC(1,1,new Position(20,27)));
        guis.add(new Command(this));
        camera = new Camera(player);
    }

    @Override
    public void update(double delta) {
        if (paused) return;

         for (Entity e: entities){
             e.update(delta);
         }

         camera.update();
    }

    @Override
    public void draw(Graphics2D g2) {

        // World rendering
        for (Layer layer: layers){
            layer.drawLayer(g2,camera);
        }
        //Entity render
        for (Entity e :entities){
            camera.renderOntoScreen(e,g2);
        }
        //Gui rendering
        for (Gui gui:guis) {
            gui.draw(g2);
        }

    }

    @Override
    public void onTick(){
        if (paused) return;
    }

    public ArrayList<Layer> getLayers() {
        return layers;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public Camera getCamera() {
        return camera;
    }

    public Player getPlayer() {
        return player;
    }
}
