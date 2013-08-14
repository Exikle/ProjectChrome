package com.cvgstudios.pokemonchrome;

import java.io.File;

import com.badlogic.gdx.Game;
import com.cvgstudios.pokemonchrome.game.PlayWorld;
import com.cvgstudios.pokemonchrome.gamelogic.PokemonCreature;
import com.cvgstudios.pokemonchrome.gamelogic.PokemonType;
import com.cvgstudios.pokemonchrome.javascript.JSExecutor;
import com.cvgstudios.pokemonchrome.screens.BattleScreen;

public class ChromeGame extends Game {
	public static final String POKECHROME_VERSION = "0.0.0.04 Pre-Alpha";
	public static final String LOG = "Pokemon Chrome";

	@SuppressWarnings("unused")
	@Override
	public void create() {

		if (false) {
			JSExecutor.initializeExecutor(new File("res/javascript")
					.getAbsolutePath());
			BattleScreen tempScreen = new BattleScreen();
			tempScreen.setPlayerPokemon(PokemonCreature.makePokemon(PokemonType
					.getPokemon("tykepol")));
			setScreen(tempScreen);
		} else {
			setScreen(new PlayWorld(this));
		}

	}

	@Override
	public void dispose() {
		super.dispose();
	}

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
