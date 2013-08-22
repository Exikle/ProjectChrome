package com.cvgstudios.pokemonchrome.input;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.game.MenuActor;

public class MenuHandler implements InputProcessor{

	MenuActor menu;

	@SuppressWarnings({ "serial", "unused" })
	private static final Map<Integer, MenuMove> MOVE_KEYS = new HashMap<Integer, MenuMove>() {

		{
			this.put(Keys.UP, MenuMove.UP);
			this.put(Keys.DOWN, MenuMove.DOWN);
		}
	};

	public MenuHandler(MenuActor menu) {
		this.menu = menu;
		Gdx.app.log(ChromeGame.LOG, "Menu input created");
	}

	@Override
	public boolean keyDown(int keycode) {
		Gdx.app.log(ChromeGame.LOG, "Menu clicked");
		switch (keycode) {
			case Keys.A:
				menu.save();
				break;
		}

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer,
			int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer,
			int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	enum MenuMove {
		UP, DOWN;
	}
}
