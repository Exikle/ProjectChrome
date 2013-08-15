package com.cvgstudios.pokemonchrome.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Sprite {

	private int direction;

	private TextureRegion playerR = new TextureRegion(new Texture(
			"imgs/MalePlayer.png"));

	private int step;

	private final int STEP_DELAY = 15;

	private int counter = 0;

	/**
	 * @param direction
	 *            to set the player to face
	 * @return void
	 */
	private void changePlayerDirection(int d) {
		setDirection(d);
		switch (d) {
		case 1:// down
			playerR.setRegion(0, 0 + (step * 42), 37, 42);
			// playerR.setRegion(0, 0, 37, 42);
			break;
		case 2:// up
			playerR.setRegion(37, 0 + (step * 42), 37, 42);
			// playerR.setRegion(37, 0, 37, 42);
			break;
		case 3:// right
				// playerR.setRegion(74, 0, 37, 42);
			playerR.setRegion(74, 0 + (step * 42), 37, 42);
			break;
		case 4:// left
			playerR.setRegion(111, 0 + (step * 42), 37, 42);
			// playerR.setRegion(111, 0, 37, 42);
			break;
		}
		this.setRegion(playerR);
	}

	private void changeUserSteps() {
		counter++;
		if (counter == STEP_DELAY) {
			counter = 0;
			if (step == 1) {
				step = 2;
			} else {
				step = 1;
			}
			changePlayerDirection(direction);
			// Gdx.app.log(ChromeGame.LOG, "Step " + step);
		}
	}

	/**
	 * @return the direction the player is facing
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @param direction
	 *            to set the player to face
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

}
