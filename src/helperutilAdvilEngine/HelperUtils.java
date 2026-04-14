package helperutilAdvilEngine;

import java.util.Random;

import org.newdawn.slick.geom.Vector2f;

public class HelperUtils {
	// this class is just to mostly help developers do math more easily to develop things more faster
	
	private static final Random Random = new Random();
	
	// use this if not using Vector2's
	public static float getDistance(float x1, float y1, float x2, float y2) { // this is probably optimized, ToDo: check if optimized
	    float dx = x2 - x1;
	    float dy = y2 - y1;
	    return dx * dx + dy * dy;
	}
	
	// use this for Vector2's
	public static float getDistanceVector2(Vector2f a, Vector2f b) { // this is probably optimized, ToDo: check if optimized
	    float dx = b.x - a.x; 
	    float dy = b.y - a.y;
	    return dx * dx + dy * dy;
	}

	public static float GetRandom(float minimumValue, float maximumValue) { // makes random more easy
		return minimumValue + Random.nextFloat() * (maximumValue - minimumValue);
	}
	
	
	

}