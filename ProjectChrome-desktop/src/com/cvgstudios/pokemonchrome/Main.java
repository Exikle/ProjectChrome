package com.cvgstudios.pokemonchrome;

import java.io.File;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.javascript.JSExecutor;

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

		//This belongs with the ChromeGame constructor, really, but I don't know if I can get to res/javascript from the default project
		JSExecutor.initializeExecutor(new File("res/javascript").getAbsolutePath());
		
		
		new LwjglApplication(new ChromeGame(), cfg);
	}
}
