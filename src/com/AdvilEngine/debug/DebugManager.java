package com.AdvilEngine.debug;

import org.newdawn.slick.GameContainer;

import com.AdvilEngine.core.AdvilEngine;

public class DebugManager {

	private static AdvilEngine advilEngine = new AdvilEngine(null);

	// get methods
	public static int getTPS() {
		return advilEngine.TicksPerSecond;
	}

	public static int getFPS(GameContainer container) {
		return container.getFPS();
	}

	// all of the memory functions are in Megabytes
	public static long getUsedMemoryMB() {
		Runtime runtime = Runtime.getRuntime();
		return (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
	}

	public static long getFreeMemoryMB() {
		return Runtime.getRuntime().freeMemory() / (1024 * 1024);
	}

	public static long getMaxMemoryMB() {
		return Runtime.getRuntime().maxMemory() / (1024 * 1024);
	}

}