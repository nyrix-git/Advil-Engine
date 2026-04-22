package com.AdvilEngine.audio;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioManager {
	// Note: audio only supports .ogg or .wav unless you use another library that supports the audio format
	
	public static void playSound(String filePath, float volume) {
		try {
			Sound sound = new Sound(filePath);
			sound.play(1.0f, volume);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public static void playMusic(String filePath, float volume) {
		try {
			Music music = new Music(filePath);
			music.setVolume(volume);
			music.loop();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public static void stopMusic(Music music) {
        if (music != null && music.playing()) {
            music.stop();
        }
    }
}