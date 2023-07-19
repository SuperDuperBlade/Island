package com.SuperDuperBlade.World;

import com.SuperDuperBlade.GameWindow;
import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Utils.Position;
import com.SuperDuperBlade.World.Entity.Entity;
import com.SuperDuperBlade.World.Entity.Player;

public class Camera {

    private Position position;

    //The entity the camera will follow
    private Entity selectedEntity;
    private final int[] cameraInfo = new int[5];

    public Camera(Entity entity) {
        this.selectedEntity = entity;
    }

    public void update(){
        position = selectedEntity.position;
        GameWindow gw = Main.getWindow();
        cameraInfo[0] =    ( gw.getScreenSizeX() /gw.getTileScaled()); //The tiles that the camera would subtract  from the entity's postition so that the player would end up in the middle of the screen on the X axis
        cameraInfo[1] =   ( gw.getScreenSizeX() /gw.getTileScaled()); //The tiles that the camera would subtract  from the entity's postition so that the player would end up in the middle of the screen on the Y axis
        cameraInfo[3] = (int) (position.getPosX()%gw.getTileScaled()); //offset on the X axis
        cameraInfo[4] = (int) (position.getPosY()%gw.getTileScaled()); //offset on the Y axis
    }

    public Position getPosition() {
        return position;
    }

    public Entity getSelectedEntity() {
        return selectedEntity;
    }
    public int[] getCameraInfo(){
        return this.cameraInfo;
    }
}
