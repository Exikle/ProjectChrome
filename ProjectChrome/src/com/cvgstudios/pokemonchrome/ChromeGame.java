package com.cvgstudios.pokemonchrome;

import com.badlogic.gdx.Game;
import com.cvgstudios.pokemonchrome.game.PlayWorld;
import com.cvgstudios.pokemonchrome.screens.SplashScreen;

public class ChromeGame extends Game {
	public static final String POKECHROME_VERSION = "0.0.0.03 Pre-Alpha";
	public static final String LOG = "Pokemon Chrome";

	@Override
	public void create() {
		setScreen(new SplashScreen(this));
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
