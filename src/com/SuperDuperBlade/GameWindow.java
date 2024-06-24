package com.SuperDuperBlade;


import com.SuperDuperBlade.Managers.KeyManager;
import com.SuperDuperBlade.Managers.MouseManager;
import com.SuperDuperBlade.Scene.MainMenu;
import com.SuperDuperBlade.Scene.Scence;
import com.SuperDuperBlade.Scene.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;


@SuppressWarnings("all")
public class GameWindow extends JPanel implements Runnable {
    private   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenSizeY = screenSize.height / 2 + 32;
    private int screenSizeX = screenSize.width / 2;


    private   GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

    //TODO Add a option to disable VSYNC
    private int FPSCAP = env.getDefaultScreenDevice().getDisplayMode().getRefreshRate();
    private int scale = 5;
    private int tileSize = 16;
    private int tileScaled = scale * tileSize;
    private byte TPS = 20;

    public Graphics2D g2;

    public MouseManager mouseManager = new MouseManager();


    Thread mainThread;
    private KeyManager keyManager = new KeyManager();



    public GameWindow() {
        System.out.println(screenSizeX);
        //configurations to the window
        this.setPreferredSize(new Dimension(screenSizeX, screenSizeY));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyManager);
        this.addMouseListener(mouseManager);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        this.setFocusTraversalKeysEnabled(false);
        mainThread = new Thread(this);
    }



    @Override
    public void run() {
        changeScence(0);
        new Thread(()->{
            startTickThread();
        }).start();
        startMainThread();

    }


    public double update(double delta) {
        currentScene.update(delta);
        this.screenSizeX = this.getWidth();
        this.screenSizeY = this.getHeight();
        return System.currentTimeMillis();
    }


    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.CYAN);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        this.g2 = g2;
        if (currentScene !=null)
        currentScene.draw(g2);
        g2.dispose();
        g.dispose();
    }



    private void startTickThread(){

        double drawInterval = 1000000000 / TPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        double lastTime = System.currentTimeMillis();



        double fps = System.nanoTime() + 1000000000;
        int times = 0;
        while (mainThread != null) {

            try {
                double remainingTime = (nextDrawTime - System.nanoTime());
                remainingTime = remainingTime / 1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                if (System.nanoTime() >= fps) {
                    Main.debug("TPS: " + times);
                    times = 0;
                    fps += 1000000000;
                }
                Thread.sleep((long) remainingTime);
                currentScene.onTick();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lastTime = System.currentTimeMillis();
            nextDrawTime += drawInterval;
            times++;
        }

    }

    protected void startMainThread() {


        double drawInterval = 1000000000 / FPSCAP;
        double nextDrawTime = System.nanoTime() + drawInterval;
        double fps = System.nanoTime() + 1000000000;
        double lastTime = System.nanoTime();
        int times = 0;
        while (mainThread != null) {

            try {
                double remainingTime = (nextDrawTime - System.nanoTime());
                remainingTime = remainingTime / 1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                if (System.nanoTime() >= fps) {
                    Main.debug("TPS: " + times);
                    times = 0;
                    fps += 1000000000;
                }
                Thread.sleep((long) remainingTime);
                update(System.nanoTime()-lastTime);
                repaint();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lastTime = System.nanoTime();
            nextDrawTime += drawInterval;
            times++;
        }


    }

    private Scence currentScene;


    public void onEventMouse(MouseEvent e){currentScene.onEventMouse(e);}




    public void changeScence(int scence) {

        switch (scence) {
            case 0:
                currentScene = new MainMenu();
                break;
            case 1:
                currentScene = new World();
                break;
            default:
                throw new RuntimeException("Invalid Scene");
        }

    }
    public Scence getScence(){
        return currentScene;
    }


    public KeyManager getKeyManager() {
        return this.keyManager;
    }

    public Dimension getScreenSize() {
        return screenSize;
    }

    public int getScreenSizeY() {
        return screenSizeY;
    }

    public int getScreenSizeX() {
        return screenSizeX;
    }

    public GraphicsEnvironment getEnv() {
        return env;
    }

    public int getFPSCAP() {
        return FPSCAP;
    }

    public int getTileScaled() {
        return tileScaled;
    }



    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public MouseManager getMouseManager() {
        return this.mouseManager;
    }
}
