package com.SuperDuperBlade.Scene;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Scene.GUI.Game.Command;
import com.SuperDuperBlade.Scene.GUI.Gui;
import com.SuperDuperBlade.Scene.GUI.Game.Stats;
import com.SuperDuperBlade.Utils.Util;
import com.SuperDuperBlade.World.Camera;
import com.SuperDuperBlade.World.Entity.Entity;
import com.SuperDuperBlade.World.Entity.NPC;
import com.SuperDuperBlade.World.Entity.Player;
import com.SuperDuperBlade.World.Layers.ILayer;
import com.SuperDuperBlade.World.Layers.Layer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class World extends Scence {
    private ArrayList<Layer> layers = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();

    private Camera camera;
    private Player player = new Player(100, 500, 1, 1, 16*Main.getScale(), 16*Main.getScale());


    public World(){
        layers.add(new Layer(Util.getFileFromSource("/Maps/Map1.txt")));
        layers.add(new ILayer(Util.getFileFromSource("/Maps/Map1Interactable.txt")));
        entities.add(player);

        Random r = new Random();
        for (int i = 0; i < 10
                ; i++) {
            entities.add(new NPC(1, 300,2*i,10, 48, 48));
        }
        entities.add(new NPC(1, 148, 20, 2, 32, 32));
        entities.add(new NPC(1, 148, 120, 20, 48, 48));
        guis.add(new Command(this));
        guis.add(new Stats(this.player));
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
            for (Entity entity: entities){
                entity.onTick();
            }
        }


        public Entity getColsestEntity(Entity e){


            Entity closestEntity = new NPC(0,0,Integer.MAX_VALUE,Integer.MAX_VALUE,0,0);

            for (Entity entity:entities) {
                if (entity == e ||
                        e.getPosition().getTotalDistanceFromPosition(entity.getPosition()) > e.getPosition().getTotalDistanceFromPosition(closestEntity.getPosition())) continue;
                closestEntity = entity;
            }

            return closestEntity;
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

