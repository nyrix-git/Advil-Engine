package com.AdvilEngine.lighting;

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

	public void Render(Graphics g, boolean useGradientLighting, int gradientSteps) {
		for (Light light : lightsList) {
			if (useGradientLighting == true) {
				renderGradientLight(g, light, gradientSteps);
			} else { // else useGradientLighting == false
				renderFlatLight(g, light);
			}
		}
	}

	// Note: this costs a huge amount of fps (less steps = more performance)

	private void renderGradientLight(Graphics g, Light light, int steps) {
		steps = Math.max(1, Math.min(steps, 100)); // clamps between 0 - 100

		for (int i = steps; i > 0; i--) {
			float ratio = (float) i / steps;
			float radius = light.radius * ratio;
			float alpha = (float) Math.pow(ratio, 2) * 0.8f;

			g.setColor(new Color(light.color.r, light.color.g, light.color.b, alpha));
			g.fillOval(light.x - radius, light.y - radius, radius * 2, radius * 2);
		}
	}

	private void renderFlatLight(Graphics g, Light light) {
		g.setColor(light.color);
		g.fillOval(light.x - light.radius, light.y - light.radius, light.radius * 2, light.radius * 2);
	}

}