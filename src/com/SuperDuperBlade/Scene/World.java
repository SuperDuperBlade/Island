package com.SuperDuperBlade.Scene;

import com.SuperDuperBlade.Utils.Position;
import com.SuperDuperBlade.World.Camera;
import com.SuperDuperBlade.World.Entity.Entity;
import com.SuperDuperBlade.World.Entity.Player;
import com.SuperDuperBlade.World.Layer;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class World extends Scence {
    private ArrayList<Layer> layers = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();
    private Camera camera;
    private Player player = new Player(100,80, new Position(5,3));

    public World(){
        layers.add(new Layer(new File("/home/sam/IdeaProjects/Islands/src/Res/Maps/Map1.txt")));
        entities.add(player);
        camera = new Camera(player);
    }

    @Override
    public void update() {
         camera.update();
    }

    @Override
    public void draw(Graphics2D g2) {
        for (Layer layer: layers){

        }
    }
}
