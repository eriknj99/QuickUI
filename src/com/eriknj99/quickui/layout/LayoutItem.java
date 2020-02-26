package com.eriknj99.quickui.layout;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class LayoutItem {

    private Rectangle2D.Double bounds;
    private Rectangle roundedBounds;
    private boolean xl,yl,wl,hl;

    public LayoutItem(double x, double y, double w, double h){
        bounds = new Rectangle2D.Double(x,y,w,h);
        xl = false;
        yl = false;
        wl = false;
        hl = false;
    }

    //Single value setters
    public boolean setX(double x){
        if(!xl){
            bounds.x = x;
            return true;
        }
        return false;
    }
    public boolean setY(double y){
        if(!yl){
            bounds.y = y;
            return true;
        }
        return false;
    }
    public boolean setW(double w){
        if(!wl){
            bounds.width = w;
            return true;
        }
        return false;
    }
    public boolean setH(double h){
        if(!hl){
            bounds.height = h;
            return true;
        }
        return false;
    }
    //Single value getters
    public double getX(){
        return bounds.getX();
    }
    public double getY(){
        return bounds.getY();
    }
    public double getW(){
        return bounds.getWidth();
    }
    public double getH(){
        return bounds.getHeight();
    }

    public Rectangle2D.Double getBounds(){
        return bounds;
    }

    //Rounded getters
    public Rectangle getRoundedBounds(){
        return  roundedBounds;
    }
    public int getRX(){
        return  roundedBounds.x;
    }
    public int getRY(){
        return  roundedBounds.y;
    }
    public int getRW() {
        return roundedBounds.width;
    }
    public int getRH(){
        return  roundedBounds.height;
    }
    private void round(){
        roundedBounds = new Rectangle((int)getX(), (int)getY(), (int)getW(), (int)getH());
    }

    //Misc getters
    public Point2D.Double getCenter(){
        return new Point2D.Double(bounds.getCenterX(),bounds.getCenterY());
    }

    //Lock setters
    public void setXLock(boolean xl){
        this.xl = xl;
    }
    public void setYLock(boolean yl){
        this.yl = xl;
    }
    public void setWLock(boolean wl){
        this.wl = xl;
    }
    public void setHLock(boolean hl){
        this.hl = xl;
    }

    //Lock getters
    public boolean getXLock(){
        return xl;
    }
    public boolean getYLock(){
        return yl;
    }
    public boolean getWLock(){
        return wl;
    }
    public boolean getHLock(){
        return hl;
    }

    public void unlockAll(){
        xl = false;
        yl = false;
        wl = false;
        hl = false;
    }
}
