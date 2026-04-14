package settingsAdvilEngine;

import windowAdvilEngine.WindowManager;

public class SettingsManager {

	//private static AdvilEngine advilengine;

    // Note: for some reason couldn't get SetTPS() to work so I just left it, if someone can fix this be glad to do so
	/*public static void SetTPS(int TPSLimit) {
		advilengine.TicksPerSecond = TPSLimit;
	} */ 
    
    
    public static void SetFPS(int FPSLimit) {
		WindowManager.MaxFPS = FPSLimit;
	}

	public static void SetVSync(boolean isVSync) {
		WindowManager.is_VSync = isVSync;
	}
	
}