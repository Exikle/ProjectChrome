package com.cvgstudios.pokemonchrome;

import java.io.File;

import com.badlogic.gdx.Game;
import com.cvgstudios.pokemonchrome.game.PokemonWorld;
import com.cvgstudios.pokemonchrome.gamelogic.PokemonCreature;
import com.cvgstudios.pokemonchrome.gamelogic.PokemonType;
import com.cvgstudios.pokemonchrome.javascript.JSExecutor;
import com.cvgstudios.pokemonchrome.screens.BattleScreen;

/**
 * Class which contains info to start the game
 */
public class ChromeGame extends Game {

	/**
	 * Game Version
	 */
	public static final String POKECHROME_VERSION = "0.0.0.05 Pre-Alpha";

	/**
	 * Used for logging
	 */
	public static final String LOG = "Pokemon Chrome";

	/**
	 * Width of the screen
	 */
	public static final int WIDTH = 720;

	/**
	 * Height of the screen
	 */
	public static final int HEIGHT = 540;

	public static DisplayInterface display;

	/**
	 * Sets screen to the splash screen on the games start
	 */
	@SuppressWarnings("unused")
	@Override
	public void create() {

		if (true) {
			JSExecutor.initializeExecutor(new File("res/javascript")
					.getAbsolutePath());
			BattleScreen tempScreen = new BattleScreen();
			tempScreen.setPlayerPokemon(PokemonCreature
					.makePokemon(PokemonType.getPokemon("tykepol")));
			tempScreen.setEnemyPokemon(PokemonCreature
					.makePokemon(PokemonType.getPokemon("embite")));
			setScreen(tempScreen);
		} else {
			setScreen(new PokemonWorld(this));
		}

	}

	/**
	 * Disposes resources
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	/**
	 * Renders stuff to the screen
	 */
	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int w, int h) {
		super.resize(w, h);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
