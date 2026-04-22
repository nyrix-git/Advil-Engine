package com.AdvilEngine.particle;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class ParticleManager {
	
	private static ArrayList<Particle> particlesList = new ArrayList<>();

	public static void createParticle(float x, float y) {
		particlesList.add(new Particle(x, y, Color.white, null));
	}

	public static void createParticle(float x, float y, Color color) {
		particlesList.add(new Particle(x, y, color, null));
	}

	public static void createParticle(float x, float y, Image texture) {
		particlesList.add(new Particle(x, y, null, texture));
	}

	public static void createParticle(float x, float y, Color color, Image texture) {
		particlesList.add(new Particle(x, y, color, texture));
	}

    public static void tick() {
        Iterator<Particle> it = particlesList.iterator();

        while (it.hasNext()) {
            Particle p = it.next();
            p.tick();

            if (!p.isAlive()) {
                it.remove();
            }
        }
    }

    public static void render(Graphics g) {
        for (Particle p : particlesList) {
            p.render(g);
        }
    }
}