package com.SuperDuperBlade.Scene;

import com.SuperDuperBlade.Scene.Scence;
import com.SuperDuperBlade.World.Layer;

import java.awt.*;
import java.io.File;

public class World extends Scence {

    public World(){
        Layer groundLayer = new Layer(new File("/home/sam/IdeaProjects/Islands/src/Res/Maps/Map1.txt"));
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g2) {

    }
}
