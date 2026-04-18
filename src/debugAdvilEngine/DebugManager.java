package debugAdvilEngine;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.newdawn.slick.GameContainer;

import mainAdvilEngine.AdvilEngine;

public class DebugManager {

	private static final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
	private static AdvilEngine advilEngine = new AdvilEngine(null);
	
	// use this to see levels of an error that your debugging
	public static void debugPrint(Object text, String levelError, String source) {

		String time = LocalTime.now().format(timeFormat);

		if (levelError == null) {
			System.out.println("[" + time + "] [INFO] " + text + " from " + source);
			return;
		}

		switch (levelError.toUpperCase()) {
		case "WARN":
			System.out.println("[" + time + "] [WARN] " + text + " from " + source);
			break;

		case "ERROR":
			System.err.println("[" + time + "] [ERROR] " + text + " from " + source);
			break;

		default:
			System.out.println("[" + time + "] [INFO] " + text + " from " + source);
			break;
		}
	}

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

	public static void printMemoryInfo() {
		Runtime runtime = Runtime.getRuntime();

	    long used = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
	    long total = runtime.totalMemory() / (1024 * 1024);
	    long max = runtime.maxMemory() / (1024 * 1024);

	    System.out.println("Memory: " + used + "MB / " + total + "MB (Max: " + max + "MB)");
	}
	
}