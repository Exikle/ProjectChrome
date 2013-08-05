package com.cvgstudios.pokemonchrome;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.cvgstudios.pokemonchrome.game.PlayWorld;

public class InputHandler implements InputProcessor {

	PlayWorld playScreen;
	OrthographicCamera camera;
	private boolean keyNotDown = true;

	public InputHandler(PlayWorld screen, OrthographicCamera camera) {
		this.playScreen = screen;
		this.camera = camera;
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keyNotDown) {
			switch (keycode) {
			case Keys.RIGHT:
				playScreen.setXD(2);
				break;
			case Keys.LEFT:
				playScreen.setXD(-2);
				break;
			case Keys.DOWN:
				playScreen.setYD(-2);
				break;
			case Keys.UP:
				playScreen.setYD(2);
				break;
			}
			keyNotDown = false;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		playScreen.resetCameraDirection();
		keyNotDown = true;
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
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
