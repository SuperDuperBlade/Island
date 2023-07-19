package com.SuperDuperBlade.Scene;

import com.SuperDuperBlade.Main;
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
        camera = new Camera(player);
    }

    @Override
    public void update(double delta) {

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
        int tileScale = Main.getWindow().getTileScaled();
        //Entity render
        for (Entity e :entities){

            int entityPosY = e.getPosition().convertToWorldPosY(), entityPosX = e.getPosition().convertToWorldPosX();

                //the range is increased to make sure that the entities stop getting doawn offscreen
            if (entityPosY > camera.getRenderPosStartY() -1 && entityPosY < camera.getEndRenderPosY() + 1 ){
                if (entityPosX > camera.getRenderPosStartX() -1  && entityPosX < camera.getEndRenderPosX() + 1){
                    int posYOnScreen =  (tileScale*(e.getPosition().convertToWorldPosY() - camera.getRenderPosStartY()));
                    int posXOnScreen =   (tileScale*(e.getPosition().convertToWorldPosX() - camera.getRenderPosStartX()));

                    if (e != camera.getSelectedEntity()){
                        posXOnScreen -= camera.getOffsetX();
                        posYOnScreen -= camera.getOffsetY();
                    }

                    e.draw(g2,posXOnScreen,posYOnScreen);
                }
            }
        }
    }

    @Override
    public void onTick(){

    }
}
