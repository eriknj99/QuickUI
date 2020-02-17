package com.eriknj99.quickui.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Viewer extends JFrame {

    private BufferedImage frameBuffer;
    private Timer masterClock;

    private final int DRAW_DELAY = 15; //Delay in mS between each redraw
    private final int BUFFEREDIMAGE_TYPE = BufferedImage.TYPE_3BYTE_BGR;

    private int offsetX = 0;
    private int offsetY = 0;

    private Compositor comp;

    public Viewer(){
        this.setTitle("floatme");
        this.setBounds(100,100,500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        comp = new Compositor();
        comp.setBounds(100,100,250,250);
        comp.setBackground(Color.RED);
        this.add(comp);
        this.addKeyListener(comp.inputHandler);

        this.setVisible(true);

        masterClock = new Timer(DRAW_DELAY, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                resizeCompositor();
                comp.render();
            }
        });
        masterClock.start();
    }

    private void resizeCompositor(){
        comp.setBounds(offsetX,offsetY,this.getWidth() - offsetX, this.getHeight() - offsetY);
    }

}
