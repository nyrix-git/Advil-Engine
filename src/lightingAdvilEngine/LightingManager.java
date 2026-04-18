package lightingAdvilEngine;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import java.util.ArrayList;
import java.util.List;

public class LightingManager {
	private List<Light> lightsList;

    public LightingManager() {
    	lightsList = new ArrayList<>();
    }

    public void addLight(float x, float y, float radius, Color color) {
    	lightsList.add(new Light(x, y, radius, color));
    }

    public void removeLight(Light light) {
    	lightsList.remove(light);
    }
    
    // use this to render normal light
    public void render(Graphics g) {
        for (Light light : lightsList) {
            renderGradientLight(g, light);
        }
    }

    // Note: this may cost huge amounts of fps depending on how many lights there are since were drawing more circles for the gradient effect
    
    // Use the bottom example for stress testing and this will take away many fps after initialziing a light source
    /*for (int i = 0; i <= 200; i++) { 
			lighting.render(g);			
		}*/
    
    // use this to render gradient light
    private void renderGradientLight(Graphics g, Light light) {
        int steps = 20; // number of circles
        for (int i = 0; i < steps; i++) {
            float ratio = (float)i / steps; // 0 = center, 1 = edge
            float radius = light.radius * (1 - ratio);
            float alpha = (1 - ratio) * 0.8f; // center is 0.8 alpha
            g.setColor(new Color(light.color.r, light.color.g, light.color.b, alpha));
            g.fillOval(light.x - radius, light.y - radius, radius * 2, radius * 2);
        }
    }

}