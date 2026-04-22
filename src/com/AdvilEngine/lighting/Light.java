package com.AdvilEngine.lighting;

import org.newdawn.slick.Color;

public class Light {
	public float x;
	public float y;
	public float radius;
	public Color color;

	public Light(float x, float y, float radius, Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	}
}