package com.cvgstudios.pokemonchrome;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	
	public static final int WIDTH = 720;
	public static final int HEIGHT = 540;

	public static void main(String[] args) {
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Pokemon Chrome - CVG Studios "
				+ ChromeGame.POKECHROME_VERSION;

		cfg.useGL20 = true;
		cfg.width = WIDTH;
		cfg.height = HEIGHT;
		cfg.resizable = false;
		
//		Display
		new LwjglApplication(new ChromeGame(), cfg);
		
	}
}
