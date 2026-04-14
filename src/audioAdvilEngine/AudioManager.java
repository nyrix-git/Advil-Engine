package audioAdvilEngine;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioManager {
	// audio only supports .ogg or .wav unless you use another library that supports the audio format you want to use

	// use this to only play a short sound
	public static void PlaySound(String filePath, float volume) {
		try {
			Sound sound = new Sound(filePath);
			sound.play(1.0f, volume); // pitch = 1.0 (normal), volume = 0.0-1.0
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	// use this to only play music
	public static void PlayMusic(String filePath, float volume) {
		try {
			Music music = new Music(filePath);
			music.setVolume(volume);
			music.loop(); // loops indefinitely
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	// use this to stop music
	public static void StopMusic(Music music) {
        if (music != null && music.playing()) {
            music.stop();
        }
    }
}