package com.SuperDuperBlade.Scene;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Scene.GUI.Command;
import com.SuperDuperBlade.Scene.GUI.Gui;
import com.SuperDuperBlade.World.Camera;
import com.SuperDuperBlade.World.Entity.Entity;
import com.SuperDuperBlade.World.Entity.NPC;
import com.SuperDuperBlade.World.Entity.Player;
import com.SuperDuperBlade.World.Layers.ILayer;
import com.SuperDuperBlade.World.Layers.Layer;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class World extends Scence {
    private ArrayList<Layer> layers = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();

    private Camera camera;
    private Player player = new Player(100, 500, 1, 1, 16*Main.getScale(), 16*Main.getScale());


    public World(){
        layers.add(new Layer(new File("/home/sam/IdeaProjects/Islands/src/Res/Maps/Map1.txt")));
        layers.add(new ILayer(new File("/home/sam/IdeaProjects/Islands/src/Res/Maps/Map1Interactable.txt")));
        entities.add(player);
        entities.add(new NPC(1, 1, 20, 2, 32, 32));
        entities.add(new NPC(1, 1, 20, 2, 32, 32));
        entities.add(new NPC(1, 1, 20, 20, 48, 48));
        guis.add(new Command(this));
        camera = new Camera(player);
    }

    @Override
    public void update(double delta) {
        if (paused) return;

        for (Entity e : entities) {
            e.update(delta);
        }

        camera.update();
    }

    @Override
    public void draw(Graphics2D g2) {

        // World rendering
        for (Layer layer : layers) {
            layer.drawLayer(g2, camera);
        }
        //Entity render
        //TODO Make the player render on top of all entity's
        for (Entity e : entities) {
            camera.renderOntoScreen(e, g2);
            g2.setColor(Color.RED);
        }
            //Gui rendering
            for (Gui gui : guis) {
                gui.draw(g2);
            }


    }
        @Override
        public void onTick() {
            if (paused) return;
        }

        public ArrayList<Layer> getLayers () {
            return layers;
        }

        public ArrayList<Entity> getEntities () {
            return entities;
        }

        public Camera getCamera () {
            return camera;
        }

        public Player getPlayer () {
            return player;
        }
    }

