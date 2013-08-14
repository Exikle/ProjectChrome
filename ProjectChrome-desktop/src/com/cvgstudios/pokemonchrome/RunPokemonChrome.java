package com.cvgstudios.pokemonchrome;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class RunPokemonChrome implements DisplayInterface{

	public static final int WIDTH = 720;
	public static final int HEIGHT = 540;

	static LwjglApplication gameInstance;
	
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Pokemon Chrome - CVG Studios "
				+ ChromeGame.POKECHROME_VERSION;

		cfg.useGL20 = true;
		cfg.width = WIDTH;
		cfg.height = HEIGHT;
		cfg.resizable = false;
		
		
		
		
//		Display
		gameInstance = new LwjglApplication(new ChromeGame(), cfg);
		
		ChromeGame.display = new RunPokemonChrome();


	}

	public int getDisplayWidth() {
		return gameInstance.getGraphics().getWidth();
	}

	public int getDisplayHeight() {
		return gameInstance.getGraphics().getHeight();
	}
}
