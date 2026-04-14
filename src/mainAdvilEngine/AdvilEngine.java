package mainAdvilEngine;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import networkingAdvilEngine.NetworkClient;
import windowAdvilEngine.WindowManager;

public class AdvilEngine extends BasicGame {
	// networking things
	private NetworkClient client;
	
	// tick things
	public int TicksPerSecond = 60;
	
	private double getTimePerTick() { // ms per tick
	    return 1000.0 / TicksPerSecond;
	} 
	
	private double accumulator = 0;
	private int TickCounter = 0;

	public AdvilEngine(String title) {
		super(title);
	}

	public void init(GameContainer container) throws SlickException {
		Init(container);
	}

	public void render(GameContainer container, Graphics g) {
		Render(g);
	}
	
	public void update(GameContainer container, int delta) {
		accumulator += delta; // delta is already ms

		while (accumulator >= getTimePerTick()) {
		    Tick(container);
		    accumulator -= getTimePerTick();
		}
	}

	// use this methods instead of the Slick2D provided ones
	public void Init(GameContainer container) { // initializes everything
		
	}

	public void Render(Graphics g) { // render fps doesnt affect game logic tps
		
	}

	public void Tick(GameContainer container) { // Main game logic with 60 tps
		// to know if the AdvilEngine class is running, this piece of code should be printing to the console
		// this piece of code will not run due to it not being instantiated unless new
		// AdvilEngine() is instantiated in the WindowManager.CreateWindow() class
		TickCounter++;
		System.out.println("Tick Counter: " + TickCounter);

		if (TickCounter >= 60) {
			TickCounter = 0;
		}

	}

	public static void main(String[] args) throws Exception {
		WindowManager.CreateWindow(null, "Advil Engine Testing", 1280 / 2, 720 / 2, false);
		
	}

}