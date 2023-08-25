package com.SuperDuperBlade.World;

import com.SuperDuperBlade.GameWindow;
import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Utils.Position;
import com.SuperDuperBlade.World.Entity.Entity;

import java.awt.*;

@SuppressWarnings("all")
public class Camera {

    private Position position;

    //The entity the camera will follow
    private Entity selectedEntity;

    private int cashedScreenSizeY = 0, cashedScreenSizeX = 0;
    private int halfTilesY , halfTilesX , offsetX, offsetY , renderPosStartX , renderPosStartY , tilesToRenderX, tilesToRenderY , endRenderPosX , endRenderPosY;


    public Camera(Entity entity) {
        this.selectedEntity = entity;
    }

    public void update(){
        position = selectedEntity.position;
        GameWindow gw = Main.getWindow();

        if (cashedScreenSizeX != gw.getScreenSizeX()||cashedScreenSizeY !=gw.getScreenSizeY()) {
            halfTilesX = (gw.getScreenSizeX() / gw.getTileScaled()) / 2; //The tiles that the camera would subtract  from the entity's position so that the player would end up in the middle of the screen on the X axis
            halfTilesY = (gw.getScreenSizeY() / gw.getTileScaled()) / 2; //The tiles that the camera would subtract  from the entity's position so that the player would end up in the middle of the screen on the Y axis
            cashedScreenSizeY = halfTilesY;
            cashedScreenSizeX = halfTilesX;
        }


        offsetX = position.offsetX(); //offset on the X axis
        offsetY = position.offsetY(); //offset on the Y axis


        this.renderPosStartX = position.convertToWorldPosX() - halfTilesX;
        this.renderPosStartY = position.convertToWorldPosY() - halfTilesY;

        this.tilesToRenderX = (halfTilesX*2)+3;
        this.tilesToRenderY = (halfTilesY*2)+3;

        this.endRenderPosX = renderPosStartX + tilesToRenderX;
        this.endRenderPosY = renderPosStartY + tilesToRenderY;
    }

    public void renderOntoScreen(Entity e, Graphics2D g2){
        int entityPosY = e.getPosition().convertToWorldPosY(), entityPosX = e.getPosition().convertToWorldPosX();
        if (entityPosY > this.getRenderPosStartY() -1 && entityPosY < this.getEndRenderPosY() + 1 ){
            if (entityPosX > this.getRenderPosStartX() -1  && entityPosX < this.getEndRenderPosX() + 1){
                int posYOnScreen =  (Main.getTileScaled()*(e.getPosition().convertToWorldPosY() - this.getRenderPosStartY()));
                int posXOnScreen =   (Main.getTileScaled()*(e.getPosition().convertToWorldPosX() - this.getRenderPosStartX()));

                if (e != this.getSelectedEntity()) {
                    posXOnScreen = (posXOnScreen - this.getOffsetX()) + e.getPosition().offsetX();
                    posYOnScreen = (posYOnScreen - this.getOffsetY()) + e.getPosition().offsetY();
                }

                e.draw(g2,posXOnScreen,posYOnScreen);
            }
        }
    }



    public Position getPosition() {
        return position;
    }

    public Entity getSelectedEntity() {
        return selectedEntity;
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

    public int getTilesToRenderX() {
        return tilesToRenderX;
    }

    public int getTilesToRenderY() {
        return tilesToRenderY;
    }

    public int getEndRenderPosX() {
        return endRenderPosX;
    }

    public void setEndRenderPosX(int endRenderPosX) {
        this.endRenderPosX = endRenderPosX;
    }

    public int getEndRenderPosY() {
        return endRenderPosY;
    }

    public void setEndRenderPosY(int endRenderPosY) {
        this.endRenderPosY = endRenderPosY;
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

    public void setTilesToRenderX(int tilesToRenderX) {
        this.tilesToRenderX = tilesToRenderX;
    }

    public void setTilesToRenderY(int tilesToRenderY) {
        this.tilesToRenderY = tilesToRenderY;
    }
}
