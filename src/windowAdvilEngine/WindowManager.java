package windowAdvilEngine;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;

import mainAdvilEngine.AdvilEngine;
import versionAdvilEngine.VersionManager;

public class WindowManager {

	public static int Window_Width;
	public static int Window_Height;
	public static boolean Window_IsResizeable;
	public static String Window_Title;

	private static AppGameContainer app;
	private static boolean isWindowBeingResized = false;

	// ToDo: debug: find out whats causing the issue where the WindowTitle is blank
	// in the next AdvilEngine version 0.0.2

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
		app.setVSync(false); // v-sync setting
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