package com.eriknj99.quickui.window;

import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;

public class Compositor extends JPanel {

    private BufferedImage frameBuffer;
    public InputHandler inputHandler;

    public Compositor(){
        super();

        inputHandler = new InputHandler();
        this.addMouseListener(inputHandler);
        this.addMouseMotionListener(inputHandler);
    }

    public void paint(Graphics g){
        if(frameBuffer != null){
            g.drawImage(frameBuffer,0,0,null);
        }
    }

    public void render(){
        BufferedImage frame = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = frame.createGraphics();

        g.fillRect(100,100,100,100);

        g.dispose();
        frameBuffer = frame;
        repaint();
    }

}
