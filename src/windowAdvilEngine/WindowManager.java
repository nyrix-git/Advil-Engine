package windowAdvilEngine;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;

import mainAdvilEngine.AdvilEngine;
import versionAdvilEngine.VersionManager;

public class WindowManager {

	// window settings
	public static int windowWidth;
	public static int windowHeight;
	public static boolean windowIsResizable;

	private static AppGameContainer app;

	// settings
	public static int MaxFPS = 0; // 0 = unlimited
	public static boolean is_VSync = false;

	public static void createWindow(AdvilEngine appInstance, int WindowWidth, int WindowHeight,
			boolean WindowResizeable) throws Exception {
		windowWidth = WindowWidth;
		windowHeight = WindowHeight;
		windowIsResizable = WindowResizeable;

		System.out.println(VersionManager.getAdvilEngineVersion()); // print version first

		// change this to new AdvilEngine() when working on the engine since testing
		// most code in that class and revert this change when releasing and test if the
		// engine features work
		app = new AppGameContainer(appInstance);

		app.setDisplayMode(WindowWidth, WindowHeight, false);
		Display.setResizable(WindowResizeable);
		app.setVSync(is_VSync);
		app.setTargetFrameRate(MaxFPS);
		app.setShowFPS(false);

		app.start();
	}

	public static void resizeWindow(int WindowWidth, int WindowHeight) throws Exception {
		windowWidth = WindowWidth;
		windowHeight = WindowHeight;

		app.setDisplayMode(WindowWidth, WindowHeight, false);
	}

}