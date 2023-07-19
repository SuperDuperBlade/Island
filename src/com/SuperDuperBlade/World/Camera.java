package com.SuperDuperBlade.World;

import com.SuperDuperBlade.GameWindow;
import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Utils.Position;
import com.SuperDuperBlade.World.Entity.Entity;


public class Camera {

    private Position position;

    //The entity the camera will follow
    private Entity selectedEntity;
    private final int[] cameraInfo = new int[9];
    private int cashedScreenSizeY = 0, cashedScreenSizeX = 0;
    private int halfTilesY , halfTilesX , offsetX, offsetY , renderPosStartX , renderPosStartY ,maxTilesX , maxTilesY;


    public Camera(Entity entity) {
        this.selectedEntity = entity;
    }

    public void update(){
        position = selectedEntity.position;
        GameWindow gw = Main.getWindow();

        if (cashedScreenSizeX != gw.getScreenSizeX()||cashedScreenSizeY !=gw.getScreenSizeY()) {
            halfTilesX = (gw.getScreenSizeX() / gw.getTileScaled()) / 2; //The tiles that the camera would subtract  from the entity's postition so that the player would end up in the middle of the screen on the X axis
            halfTilesY = (gw.getScreenSizeY() / gw.getTileScaled()) / 2; //The tiles that the camera would subtract  from the entity's postition so that the player would end up in the middle of the screen on the Y axis
            cashedScreenSizeY = halfTilesY;
            cashedScreenSizeX = halfTilesX;
        }


        offsetX = (int) (position.getPosX()%gw.getTileScaled()); //offset on the X axis
        offsetY = (int) (position.getPosY()%gw.getTileScaled()); //offset on the Y axis
        System.out.println(offsetX);

        this.renderPosStartX = position.convertToWorldPosX() - halfTilesX;
        this.renderPosStartY = position.convertToWorldPosY() - halfTilesY;

        this.maxTilesX = (halfTilesX*2)+2;
        this.maxTilesY = (halfTilesY*2)+3;
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

    public int getCashedScreenSizeY() {
        return cashedScreenSizeY;
    }

    public int getCashedScreenSizeX() {
        return cashedScreenSizeX;
    }

    public int getHalfTilesY() {
        return halfTilesY;
    }

    public int getHalfTilesX() {
        return halfTilesX;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public int getRenderPosStartX() {
        return renderPosStartX;
    }

    public int getRenderPosStartY() {
        return renderPosStartY;
    }

    public int getMaxTilesX() {
        return maxTilesX;
    }

    public int getMaxTilesY() {
        return maxTilesY;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSelectedEntity(Entity selectedEntity) {
        this.selectedEntity = selectedEntity;
    }

    public void setCashedScreenSizeY(int cashedScreenSizeY) {
        this.cashedScreenSizeY = cashedScreenSizeY;
    }

    public void setCashedScreenSizeX(int cashedScreenSizeX) {
        this.cashedScreenSizeX = cashedScreenSizeX;
    }

    public void setHalfTilesY(int halfTilesY) {
        this.halfTilesY = halfTilesY;
    }

    public void setHalfTilesX(int halfTilesX) {
        this.halfTilesX = halfTilesX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    public void setRenderPosStartX(int renderPosStartX) {
        this.renderPosStartX = renderPosStartX;
    }

    public void setRenderPosStartY(int renderPosStartY) {
        this.renderPosStartY = renderPosStartY;
    }

    public void setMaxTilesX(int maxTilesX) {
        this.maxTilesX = maxTilesX;
    }

    public void setMaxTilesY(int maxTilesY) {
        this.maxTilesY = maxTilesY;
    }
}
