package com.AdvilEngine.core;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class AdvilEngine extends BasicGame {

	public int TicksPerSecond = 60;

	private double getTimePerTick() {
		return 1000.0 / TicksPerSecond;
	}

	private double accumulator = 0;
	private int TickCounter = 0;

	public AdvilEngine(String windowTitle_String) {
		super(windowTitle_String);
	}

	public final void init(GameContainer container) throws SlickException {
		Init(container);
	}

	public final void render(GameContainer container, Graphics g) {
		Render(g);
	}

	public final void update(GameContainer container, int delta) {
		accumulator += delta;

		while (accumulator >= getTimePerTick()) {
			Tick(container);
			accumulator -= getTimePerTick();
		}
	}

	// these methods will be used
	public void Init(GameContainer container) {
		// initializes everything
	}

	public void Render(Graphics g) {
		// render fps doesnt affect game logic tps
	}

	public void Tick(GameContainer container) {
		// Main game logic with 60 tps

		// to know if the AdvilEngine class is running, this piece of code should be
		// printing to the console
		// this piece of code will not run due to it not being instantiated unless new
		// AdvilEngine() is instantiated in the WindowManager.CreateWindow() class
		TickCounter++;
		System.out.println("Tick Counter: " + TickCounter);

		if (TickCounter >= 60) {
			TickCounter = 0;
		}

	}

}