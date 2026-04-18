package inputAdvilEngine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class InputManager {
	
	// Keyboard input
	public static boolean keyboardInputDown(GameContainer container, int keycode) {
		Input input = container.getInput();
		return input.isKeyDown(keycode); // returns true if the key is currently held down
	}

	public static boolean keyboardInputPressed(GameContainer container, int keycode) {
		Input input = container.getInput();
		return input.isKeyPressed(keycode); // returns true only once when key is first pressed
	}

	// Mouse input
	public static boolean mouseInputDown(GameContainer container, int buttonNumber) {
		Input input = container.getInput();
		return input.isMouseButtonDown(buttonNumber); // true while button is held down
	}

	public static boolean mouseInputPressed(GameContainer container, int buttonNumber) {
		Input input = container.getInput();
		return input.isMousePressed(buttonNumber); // true only once when button is clicked
	}

}