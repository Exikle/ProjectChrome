package com.cvgstudios.pokemonchrome;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.cvgstudios.pokemonchrome.entities.Player;
import com.cvgstudios.pokemonchrome.game.PokemonWorld;

public class InputHandler implements InputProcessor {

	PokemonWorld playScreen;

	OrthographicCamera camera;

	Player player;

	private boolean keyNotDown = true;

	public InputHandler(PokemonWorld screen,
			OrthographicCamera camera, Player player) {
		this.playScreen = screen;
		this.camera = camera;
		this.player = player;
	}

	private static final Map<Integer, Direction> MOVE_KEYS = new HashMap<Integer, Direction>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = -136331640107565190L;

		{
			this.put(Keys.RIGHT, Direction.RIGHT);
			this.put(Keys.LEFT, Direction.LEFT);
			this.put(Keys.UP, Direction.UP);
			this.put(Keys.DOWN, Direction.DOWN);
		}
	};

	private static enum Direction {
		DOWN(1, -2, "VERTICAL"), UP(2, 2, "VERTICAL"), RIGHT(3, 2,
				"HORIZONTAL"), LEFT(4, -2, "HORIZONTAL");

		float speed;

		int directionVal;

		String axis;

		private Direction(int d, float s, String a) {
			speed = s;
			directionVal = d;
			axis = a;
		}

		private float getSpeed() {
			return speed;

		}

		private int getDirection() {
			return directionVal;

		}

		private String getXis() {
			return axis;

		}
	}

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
		}

		return true;
	}

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer,
			int button) {
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
