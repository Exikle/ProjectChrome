package com.cvgstudios.pokemonchrome.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Player sprite that appears onto the screen
 * 
 * @author Dixon D'Cunha
 *         Extension of {@link Sprite}
 */
public class Player extends Sprite {

	/**
	 * Starts the player facing down
	 */
	public int direction = 1;

	/**
	 * Gets the sprite sheet of the player
	 */
	public static TextureRegion playerR = new TextureRegion(
			new Texture("imgs/MalePlayer.png"));

	/**
	 * The speed of movement on the x&y axis
	 */
	public float xD = 0, yD = 0;

	/**
	 * Counter for the steps animation
	 * 0 = standing still
	 * 1 = right leg
	 * 2 = left leg
	 */
	public int currentStep;

	/**
	 * Checks if a key is down
	 */
	public boolean keyDown = false;

	/**
	 * The delay in between steps
	 */
	public final int STEP_DELAY = 15;

	/**
	 * The counter that counts up to the STEPDELAY and resets
	 */
	public int counter = 0;

	/**
	 * The camera for the screen
	 */
	OrthographicCamera camera;

	/**
	 * Constructor
	 * 
	 * @param the
	 *            worlds camera
	 */
	public Player(OrthographicCamera camera) {
		this.camera = camera;
		changePlayerDirection(1);
	}

	/**
	 * Changes the part of the sprite sheet visible to reflect the players
	 * direction
	 */
	public void changePlayerDirection(int d) {
		setDirection(d);
		switch (d) {
			case 1:// down
				playerR.setRegion(0, 0 + (currentStep * 42), 37, 42);
				break;
			case 2:// up
				playerR.setRegion(37, 0 + (currentStep * 42), 37, 42);
				break;
			case 3:// right
				playerR.setRegion(74, 0 + (currentStep * 42), 37, 42);
				break;
			case 4:// left
				playerR.setRegion(111, 0 + (currentStep * 42), 37, 42);
				break;
		}
		this.setRegion(playerR);
	}

	/**
	 * @return the current step animation
	 */
	public int getCurrentStep() {
		return currentStep;
	}

	/**
	 * @param current
	 *            step animation
	 */
	public void setCurrentStep(int currentStep) {
		this.currentStep = currentStep;
	}

	/**
	 * Creates the step animation
	 */
	public void changeUserSteps() {
		counter++;
		if (counter == STEP_DELAY) {
			counter = 0;
			if (currentStep == 1) {
				setCurrentStep(2);
			} else {
				setCurrentStep(1);
			}
			changePlayerDirection(direction);
			// Gdx.app.log(ChromeGame.LOG, "Step " + step);
		}
	}

	/**
	 * Moves the player
	 */
	public void moveUser() {
		// Vector2 oPos = new Vector2(this.getX(), this.getY());

		this.translate(xD, yD);
		if (keyDown) {
			changeUserSteps();
		}
		// Gdx.app.log(ChromeGame.LOG, this.getX() + "," + this.getY());
		camera.position.set(this.getX(), this.getY(), 0);

	}

	/**
	 * Sets the speed the player moves on the x-axis
	 * 
	 * @param the
	 *            x-speed
	 */
	public void setXD(float x) {
		this.xD = x;
		keyDown = true;
	}

	/**
	 * Sets the speed the player moves on the Y-axis
	 * 
	 * @param the
	 *            y-speed
	 */
	public void setYD(float y) {
		this.yD = y;
		keyDown = true;
	}

	/**
	 * Moves the player and resets the camera motion
	 */
	public void stopMovement() {
		yD = 0;
		xD = 0;
		keyDown = false;
		currentStep = 0;
		changePlayerDirection(direction);

	}

	/**
	 * @return the direction the player is facing
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Sets the direction the player is facing
	 * 
	 * @param the
	 *            new direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

}
