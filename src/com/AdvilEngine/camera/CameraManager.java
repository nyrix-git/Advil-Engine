package com.AdvilEngine.camera;

import org.newdawn.slick.Graphics;

public class CameraManager {
	
	private float x;
    private float y;

    public CameraManager(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void move(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    public float getX() { return x; }
    public float getY() { return y; }

    // Apply camera transformation
    public void apply(Graphics g) {
        g.translate(-x, -y);
    }

    // Reset transformation (IMPORTANT)
    public void reset(Graphics g) {
        g.resetTransform();
    }
}