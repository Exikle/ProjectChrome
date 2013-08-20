package com.cvgstudios.pokemonchrome.input;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.game.PokemonWorld;

public class NewGameHandler implements InputProcessor {

	private int counter;

	private int len;

	private boolean optionsVisible;

	private String[] script;

	private String playerName;

	private String playerGender;

	private ChromeGame game;

	private int optionsScreen;

	public NewGameHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case (Keys.SPACE):
			if (counter < len) {
				counter++;
				optionsVisible = false;

				if (script[counter].contains("(NAME)")) {
					script[counter] = script[counter].replace("(NAME)",
							playerName);
				} else if (script[counter].contains("(GENDERPICK)")) {
					// allow user to choose gender
				} else if (script[counter].contains("(NAME CREATION)")) {
					// allow user to enter a name
				} else if (script[counter].contains("(GENDER)")) {
					script[counter] = script[counter].replace("(GENDER)",
							playerGender);
				}

				if (script[counter].contains("(OPTION)")) {
					script[counter] = script[counter].replace("(OPTION)", "");
					optionsVisible = true;
				}

				getLines();
			} else {
				m.stop();
				game.setScreen(new PokemonWorld(game));
			}
			break;
		case (Keys.UP):
			if (optionsScreen == 1) {

			}
			break;
		case (Keys.DOWN):
			if (optionsScreen == 1) {

			}
			break;
		}

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
