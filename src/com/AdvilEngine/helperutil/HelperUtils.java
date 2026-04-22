package com.AdvilEngine.helperutil;

import java.util.Random;

import org.newdawn.slick.geom.Vector2f;

public class HelperUtils {

	private static Random random = new Random();

	private HelperUtils() {
		throw new UnsupportedOperationException("Utility class");
	}

	public static float getDistanceSquared(float x1, float y1, float x2, float y2) {
		float dx = x2 - x1;
		float dy = y2 - y1;
		return dx * dx + dy * dy;
	}

	public static float getDistanceSquaredVector2(Vector2f a, Vector2f b) {
		float dx = b.x - a.x;
		float dy = b.y - a.y;
		return dx * dx + dy * dy;
	}

	public static boolean randomBoolean() {
		return random.nextBoolean();
	}

	public static boolean chance(double probability) {
		if (probability < 0 || probability > 1) {
			throw new IllegalArgumentException("probability must be between 0 and 1");
		}
		return random.nextDouble() < probability;
	}

	public static int randomInt(int minimumNumber, int maximumNumber) {
		if (minimumNumber >= maximumNumber) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		return minimumNumber + random.nextInt(maximumNumber - minimumNumber + 1);
	}

	public static double randomDouble(double minimumNumber, double maximumNumber) {
		if (minimumNumber >= maximumNumber) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		return minimumNumber + random.nextDouble() * (maximumNumber - minimumNumber);
	}

	public static float clamp(float value, float minimumNumber, float maximumNumber) {
		return Math.max(minimumNumber, Math.min(maximumNumber, value));
	}

	public static float lerp(float a, float b, float t) {
		return a + t * (b - a);
	}

	public static Vector2f normalize(Vector2f v) {
		float length = (float) Math.sqrt(v.x * v.x + v.y * v.y);
		if (length == 0) {
			return new Vector2f(0, 0);
		}
		return new Vector2f(v.x / length, v.y / length);
	}

}