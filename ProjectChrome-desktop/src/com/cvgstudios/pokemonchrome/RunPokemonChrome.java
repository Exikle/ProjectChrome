package com.cvgstudios.pokemonchrome;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class RunPokemonChrome implements DisplayInterface {

	/**
	 * Width of the screen
	 */
	public static final int WIDTH = 720;

	/**
	 * Height of the screen
	 */
	public static final int HEIGHT = 540;

	
	/**
	 * The game instance
	 */
	static LwjglApplication gameInstance;

	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Pokemon Chrome - CVG Studios "
				+ ChromeGame.VERISON;

		cfg.useGL20 = true;
		cfg.width = WIDTH;
		cfg.height = HEIGHT;
		cfg.resizable = false;
		cfg.addIcon("imgs/pokeball_icon.png", Files.FileType.Internal);

		// Display
		gameInstance = new LwjglApplication(new ChromeGame(), cfg);

		ChromeGame.display = new RunPokemonChrome();

	}

	/**
	 * @return display width
	 */
	public int getDisplayWidth() {
		return gameInstance.getGraphics().getWidth();
	}

	/**
	 * @return display height
	 */
	public int getDisplayHeight() {
		return gameInstance.getGraphics().getHeight();
	}
}
