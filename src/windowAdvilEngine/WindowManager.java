package windowAdvilEngine;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;

import mainAdvilEngine.AdvilEngine;
import versionAdvilEngine.VersionManager;

public class WindowManager {

	// window settings
	public static int Window_Width;
	public static int Window_Height;
	public static boolean Window_IsResizeable;
	public static String Window_Title;

	private static AppGameContainer app;
	private static boolean isWindowBeingResized = false;

	// settings
	public static int MaxFPS = 0; // 0 = unlimited Note: default used to be 60
	public static boolean is_VSync = false;

	// WINDOW TITLE IS FIXED!!!!
	// ToDo:
	// Window Title is not needed anymore, in Advil Engine 0.3.0 remove almost
	// completely all WindowTitle references and if needed replace it with the
	// required variable or value
	// its gonna stay here for Advil Engine 0.2.0 although its pretty much useless
	
	public static void CreateWindow(AdvilEngine appInstance, String WindowTitle, int WindowWidth, int WindowHeight,
			boolean WindowResizeable) throws Exception {
		Window_Title = WindowTitle;
		Window_Width = WindowWidth;
		Window_Height = WindowHeight;
		Window_IsResizeable = WindowResizeable;
		if (Window_Title == null || Window_Title.isEmpty()) { // the same as WindowTitle == ""
			throw new Exception("Window Title is null or empty");
		} else { // if the build comes out successful without errors
			System.out.println(VersionManager.GetAdvilEngineVersion()); // prints out the version first
			System.out.println("Window " + Window_Title + " created succefully!");
		}
		// change this to new AdvilEngine() when working on the engine since testing
		// most code in that class and revert this change when releasing and test if the
		// engine features work
		app = new AppGameContainer(appInstance);

		app.setDisplayMode(WindowWidth, WindowHeight, false);
		Display.setResizable(WindowResizeable);
		app.setVSync(is_VSync); // v-sync setting
		app.setTargetFrameRate(MaxFPS);
		app.setShowFPS(false); // shows the fps ui

		app.start();
	}

	public static void CloseWindow() {
		// doesn't do anything currently + don't know how to implement
	}

	public static void MinimizeWindow() {
		// doesn't do anything currently + don't know how to implement
	}

	public static void ResizeWindow(int WindowWidth, int WindowHeight) throws Exception {
		Window_Width = WindowWidth;
		Window_Height = WindowHeight;

		app.setDisplayMode(WindowWidth, WindowHeight, false);

		System.out.println("Window resized to " + WindowWidth + "x" + WindowHeight);
	}

}