package com.AdvilEngine.settings;

import org.newdawn.slick.Font;
import org.newdawn.slick.TrueTypeFont;

import com.AdvilEngine.window.WindowManager;

public class SettingsManager {

	public static Font currentFont;

	public static void setFPS(int FPSLimit) {
		WindowManager.MaxFPS = FPSLimit;
	}

	public static void setVSync(boolean isVSync) {
		WindowManager.is_VSync = isVSync;
	}

	public static void setFont(Font font) {
		currentFont = new TrueTypeFont((java.awt.Font) font, true);
	}

}