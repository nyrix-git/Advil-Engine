package com.AdvilEngine.input;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class InputManager {
	
	// Keyboard input
	public static boolean keyboardInputDown(GameContainer container, int keycode) {
		Input input = container.getInput();
		return input.isKeyDown(keycode);
	}

	public static boolean keyboardInputPressed(GameContainer container, int keycode) {
		Input input = container.getInput();
		return input.isKeyPressed(keycode);
	}

	// Mouse input
	public static boolean mouseInputDown(GameContainer container, int buttonNumber) {
		Input input = container.getInput();
		return input.isMouseButtonDown(buttonNumber);
	}

	public static boolean mouseInputPressed(GameContainer container, int buttonNumber) {
		Input input = container.getInput();
		return input.isMousePressed(buttonNumber);
	}
	
	// Controller input
	public static boolean controllerButtonPressed(GameContainer container, int controller, int button) {
	    Input input = container.getInput();
	    return input.isButtonPressed(controller, button);
	}

	public static boolean controllerLeft(GameContainer container, int controller) {
	    Input input = container.getInput();
		return input.isControllerLeft(controller);
	}

	public static boolean controllerRight(GameContainer container, int controller) {
		Input input = container.getInput();
		return input.isControllerRight(controller);
	}

	public static boolean controllerUp(GameContainer container, int controller) {
		Input input = container.getInput();
		return input.isControllerUp(controller);
	}

	public static boolean controllerDown(GameContainer container, int controller) {
		Input input = container.getInput();
		return input.isControllerDown(controller);
	}

	public static float getAxisValue(GameContainer container, int controller, int axis) {
		Input input = container.getInput();
		return input.getAxisValue(controller, axis);
	}
	
}