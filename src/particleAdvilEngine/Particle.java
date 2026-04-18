package particleAdvilEngine;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Particle {
	float x;
    float y;
	float velX, velY;
    int life;

    Color color;
    Image texture;

    public Particle(float x, float y, Color color, Image texture) {
        this.x = x;
        this.y = y;

        this.velX = (float)(Math.random() * 2 - 1);
        this.velY = (float)(Math.random() * 2 - 1);
        this.life = 1000;

        this.color = color;
        this.texture = texture;
    }

    public void tick() {
        x += velX * 2f;
        y += velY * 2f;
        life -= 16;
    }

    public void render(Graphics g) {
        if (texture != null) {
            texture.draw(x, y);
        } else {
            g.setColor(color != null ? color : Color.white);
            g.fillRect(x, y, 2, 2);
        }
    }

    public boolean isAlive() {
        return life > 0;
    }
}