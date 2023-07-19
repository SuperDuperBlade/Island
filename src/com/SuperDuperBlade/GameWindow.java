package com.SuperDuperBlade;


import com.SuperDuperBlade.Managers.KeyManager;
import com.SuperDuperBlade.Managers.MouseManager;
import com.SuperDuperBlade.Managers.SceneManager;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("all")
public class GameWindow extends JPanel implements Runnable {
    private   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenSizeY = screenSize.height / 2 + 32;
    private int screenSizeX = screenSize.width / 2;
    private static final SceneManager sceneManager = new SceneManager();

    private   GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

    //TODO Add a option to disable VSYNC
    private int FPSCAP = env.getDefaultScreenDevice().getDisplayMode().getRefreshRate();
    private int scale = 3;
    private int tileSize = 16;
    private int tileScaled = scale * tileSize;
    private byte TPS = 20;


    public MouseManager mouseManager = new MouseManager();


    Thread mainThread;
    private KeyManager keyManager = new KeyManager();



    public GameWindow() {

        //configurations to the window
        this.setPreferredSize(new Dimension(screenSizeX, screenSizeY));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyManager);
        this.addMouseListener(mouseManager);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        mainThread = new Thread(this);
    }



    @Override
    public void run() {
        sceneManager.changeScence(0);
        new Thread(()->{
            startTickThread();
        }).start();
        startRenderingThread();

    }


    public void update(double delta) {
        sceneManager.update();
        this.screenSizeX = this.getWidth();
        this.screenSizeY = this.getHeight();
    }


    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.CYAN);

        sceneManager.draw(g2);
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
                sceneManager.onTick();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lastTime = System.currentTimeMillis();
            nextDrawTime += drawInterval;
            times++;
        }

    }

    protected void startRenderingThread() {


        double drawInterval = 1000000000 / FPSCAP;
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
                    Main.debug("FPS: " + times);
                    times = 0;
                    fps += 1000000000;
                }
                Thread.sleep((long) remainingTime);
                update(System.currentTimeMillis() - lastTime);
                repaint();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lastTime = System.currentTimeMillis();
            nextDrawTime += drawInterval;
            times++;
        }

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

    public MouseManager getMouseManager() {
        return mouseManager;
    }
    public SceneManager getSceneManager() {
        return sceneManager;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
