package com.cvgstudios.pokemonchrome.input;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.Direction;
import com.cvgstudios.pokemonchrome.entities.Player;
import com.cvgstudios.pokemonchrome.game.PokemonWorld;

/**
 * Handles all in-game input
 */
public class WorldHandler implements InputProcessor {

	/**
	 * The game world
	 */
	PokemonWorld playScreen;

	/**
	 * The camera for the world
	 */
	OrthographicCamera camera;

	/**
	 * The player
	 */
	Player player;

	private boolean keyNotDown = true;

	/**
	 * Constructor
	 * 
	 * @param game
	 *            screen
	 * @param game
	 *            camera
	 * @para player
	 */
	public WorldHandler(PokemonWorld screen,
			OrthographicCamera camera, Player player) {
		this.playScreen = screen;
		this.camera = camera;
		this.player = player;
	}

	/**
	 * Contains the movement keys to move the player
	 */
	@SuppressWarnings("serial")
	private static final Map<Integer, Direction> MOVE_KEYS = new HashMap<Integer, Direction>() {

		{
			this.put(Keys.RIGHT, Direction.RIGHT);
			this.put(Keys.LEFT, Direction.LEFT);
			this.put(Keys.UP, Direction.UP);
			this.put(Keys.DOWN, Direction.DOWN);
		}
	};

	/**
	 * Checks what keys are pressed and acts accordingly
	 */
	@Override
	public boolean keyDown(int keycode) {
		while (keyNotDown) {
			if (MOVE_KEYS.containsKey(keycode)) {
				final Direction dir = MOVE_KEYS.get(keycode);
				if (dir.getXis().equals("HORIZONTAL")) {
					player.setXD(dir.getSpeed());
				} else if (dir.getXis().equals("VERTICAL")) {
					player.setYD(dir.getSpeed());
				}
				keyNotDown = false;
				player.changePlayerDirection(dir.getDirection());

			} else {
				keyNotDown = false;
			}
		}
		switch (keycode) {
			case Keys.SPACE:
				playScreen.checkPlayerInteraction();
				break;
			case Keys.ENTER:
				boolean visible = playScreen.isMenuVisible();
				playScreen.setMenuVisible(!visible);
				break;
			case Keys.A:
				boolean menuVisible = playScreen.isMenuVisible();
				if (menuVisible) {
					Gdx.app.log(ChromeGame.LOG, "Save Pressed");

					// Gdx.app.log(ChromeGame.LOG, GameFile.playerName);
					// Gdx.app.log(ChromeGame.LOG, GameFile.playerMoney
					// + "");
					//
					// GameFile.playerPosition = new Vector2(
					// player.getX(), player.getY());
					// Gdx.app.log(ChromeGame.LOG,
					// GameFile.playerPosition.x + ","
					// + GameFile.playerPosition.y);
					//
					// GameFile.currentMap = playScreen.mapName;
					// Gdx.app.log(ChromeGame.LOG, GameFile.currentMap);
					//
					// Gdx.app.log(ChromeGame.LOG, GameFile.musicName);
					//
					// GameSaver.save();
				}
				break;
		}

		return true;
	}

	/**
	 * Stops player movement and resets all animation
	 */
	@Override
	public boolean keyUp(int keycode) {
		player.stopMovement();
		keyNotDown = true;
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

}
