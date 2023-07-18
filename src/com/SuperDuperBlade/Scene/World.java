package com.SuperDuperBlade.Scene;

import com.SuperDuperBlade.Scene.Scence;
import com.SuperDuperBlade.World.Entity.Entity;
import com.SuperDuperBlade.World.Entity.Player;
import com.SuperDuperBlade.World.Layer;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class World extends Scence {
    private ArrayList<Layer> layers = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();

    public World(){
        layers.add(new Layer(new File("/home/sam/IdeaProjects/Islands/src/Res/Maps/Map1.txt")));

        entities.add(new Player(100,80, new Entity.Position(5,3)));
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g2) {

    }
}
