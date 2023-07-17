package com.SuperDuperBlade;


import com.SuperDuperBlade.Managers.KeyManager;
import com.SuperDuperBlade.Managers.MouseManager;
import com.SuperDuperBlade.Managers.SceneManager;

import javax.swing.*;
import java.awt.*;



public class GameWindow extends JPanel implements Runnable {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int maxScreenY = screenSize.height / 2 + 32;
    public int maxScreenX = screenSize.width / 2;
    private final SceneManager sceneManager = new SceneManager();

    private   GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

    //TODO Add a option to disable VSYNC
    final int FPSCAP = env.getDefaultScreenDevice().getDisplayMode().getRefreshRate();
    private int scale = 3;


    protected Thread gameThread;
    public MouseManager mouseManager = new MouseManager();


    Thread mainThread;
    private KeyManager keyManager = new KeyManager();

    public SceneManager getSceneManager() {
        return sceneManager;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public GameWindow() {

        //modifications to the window

        this.setPreferredSize(new Dimension(maxScreenX, maxScreenY));
        this.setDoubleBuffered(true);
        this.setBackground(Color.gray);
        this.setFocusable(true);
        this.addKeyListener(keyManager);
        this.addMouseListener(mouseManager);
        this.setCursor(new Cursor(0));

    }


    public void startThread() {
        mainThread = new Thread(this);
        mainThread.run();
    }

    @Override
    public void run() {
        sceneManager.changeScence(0);
        startMultiThreads();
    }


    public void update(double delta) {
        sceneManager.update();
        this.maxScreenX = this.getWidth();
        this.maxScreenY = this.getHeight();

    }


    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.CYAN);

        sceneManager.draw(g2);
    }




    // main thread of the game + Vsync
     void startMultiThreads() {


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
                    System.out.println("FPS: " + times);
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

}
