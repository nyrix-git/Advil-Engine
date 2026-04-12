package physicsAdvilEngine;

import org.newdawn.slick.geom.Shape;

public class PhysicsManager {

	public static float Gravity = 0.5f;

    // Physics
    public static float applyGravity(float velocityY) {
        return velocityY + Gravity;
    }

    public static float applyFriction(float velocityX, float friction) {
        if (velocityX > 0) {
            velocityX -= friction;
            if (velocityX < 0) velocityX = 0;
        } else if (velocityX < 0) {
            velocityX += friction;
            if (velocityX > 0) velocityX = 0;
        }
        return velocityX;
    }

    public static void move(Shape shape, float velX, float velY) {
        shape.setX(shape.getX() + velX);
        shape.setY(shape.getY() + velY);
    }

    // Collision
    public static boolean checkCollision(Shape a, Shape b) {
        return a.intersects(b);
    }

    // Resolution
    public static void resolveX(Shape shape, float oldX) {
        shape.setX(oldX);
    }

    public static void resolveY(Shape shape, float oldY) {
        shape.setY(oldY);
    }

    // Move with collision
    public static boolean moveWithCollisionX(Shape shape, float velX, Shape obstacle) {
        float oldX = shape.getX();

        shape.setX(oldX + velX);

        if (checkCollision(shape, obstacle)) {
            resolveX(shape, oldX);
            return true; // collided
        }

        return false;
    }

    public static boolean moveWithCollisionY(Shape shape, float velY, Shape obstacle) {
        float oldY = shape.getY();

        shape.setY(oldY + velY);

        if (checkCollision(shape, obstacle)) {
            resolveY(shape, oldY);
            return true;
        }

        return false;
    }
	
	
	
}