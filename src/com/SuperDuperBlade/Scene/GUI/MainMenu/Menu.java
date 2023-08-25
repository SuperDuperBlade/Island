package com.SuperDuperBlade.Scene.GUI.MainMenu;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.Scene.GUI.Gui;
import com.SuperDuperBlade.Scene.MainMenu;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Menu extends Gui {

    private MainMenu menu;
    private int selectedGui;
    private ArrayList<Gui> guis = new ArrayList<>();

    public Menu(MainMenu menu) {
        this.menu = menu;
        guis.add(new Play());
        guis.add(new Play());



        selectedGui = 0;
    }



    @Override
    public void draw(Graphics2D g2) {

        Font logoFont  = new Font("Arial",Font.PLAIN,11 * Main.getScale());
        Font selectionFont = new Font("Arial",Font.PLAIN,7 * Main.getScale());

        FontMetrics metrics = g2.getFontMetrics(logoFont);

        int posX  = (Main.getWindow().getScreenSizeX() - metrics.stringWidth("Island"))/2;
        int posY =  (Main.getWindow().getScreenSizeY() - metrics.getHeight())/2;


        g2.setFont(logoFont);
        g2.drawString("Island",posX-(6*Main.getScale()),posY);
        g2.setFont(selectionFont);
        for (int i = 0; i < guis.size(); i++) {

            String toDraw = guis.get(i).getClass().getSimpleName();
            if (i == selectedGui){
                toDraw = ">"+toDraw+"<";
            }

            posX  = (Main.getWindow().getScreenSizeX() - metrics.stringWidth(toDraw))/2;
            posY =  (Main.getWindow().getScreenSizeY() - metrics.getHeight())/2;


                g2.drawString(toDraw, posX,posY+ (metrics.getHeight()*(i+1)));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

        int keyCode = KeyEvent.getExtendedKeyCodeForChar(e.getKeyChar());

        if (keyCode == KeyEvent.VK_W|| keyCode == KeyEvent.VK_UP){
            if (selectedGui +1 == guis.size()){
                selectedGui = 0;

            }else {
                selectedGui++;
            }
        }
        if (keyCode == KeyEvent.VK_S|| keyCode == KeyEvent.VK_DOWN){
            if (selectedGui - 1 < 0){
                selectedGui = guis.size() - 1;
            }else {
                selectedGui--;
            }
        }


        if (keyCode == KeyEvent.VK_ENTER){
           Main.getWindow().changeScence(1);
        }
    }


    public MainMenu getMenu() {
        return menu;
    }

    public void setMenu(MainMenu menu) {
        this.menu = menu;
    }

    public int getSelectedGui() {
        return selectedGui;
    }

    public void setSelectedGui(int selectedGui) {
        this.selectedGui = selectedGui;
    }

    public ArrayList<Gui> getGuis() {
        return guis;
    }

    public void setGuis(ArrayList<Gui> guis) {
        this.guis = guis;
    }
}
