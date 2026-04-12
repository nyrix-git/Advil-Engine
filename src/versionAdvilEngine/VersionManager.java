package versionAdvilEngine;

public class VersionManager {

	private static String AdvilEngine_Version = "0.0.1";
	private static String AdvilEngine_VersionName = "Tahoe";

	public static String GetAdvilEngineVersion() {
		return "Advil Engine " + AdvilEngine_Version + " -- " + AdvilEngine_VersionName;
	}

}