package com.AdvilEngine.settings;

import com.AdvilEngine.window.WindowManager;

public class SettingsManager {

    // Note: for some reason couldn't get SetTPS() to work so I just left it, if someone can fix this be glad to do so
    
    public static void setFPS(int FPSLimit) {
		WindowManager.MaxFPS = FPSLimit;
	}

	public static void setVSync(boolean isVSync) {
		WindowManager.is_VSync = isVSync;
	}
	
}