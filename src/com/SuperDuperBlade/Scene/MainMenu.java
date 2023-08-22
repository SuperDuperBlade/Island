package com.SuperDuperBlade.Scene;

import com.SuperDuperBlade.Scene.GUI.Gui;
import com.SuperDuperBlade.Scene.GUI.MainMenu.Menu;

import java.awt.*;

public class MainMenu extends Scence {

    private Gui selectedGui;

    public MainMenu(){
        Menu menu = new Menu(this);
        selectedGui  = menu;
        guis.add(selectedGui);
    }



    @Override
    public void update(double delta) {


    }

    @Override
    public void draw(Graphics2D g2) {
        selectedGui.draw(g2);
    }

    public Gui getSelectedGui() {
        return selectedGui;
    }

    public void setSelectedGui(Gui selectedGui) {
        this.selectedGui = selectedGui;
    }
}
