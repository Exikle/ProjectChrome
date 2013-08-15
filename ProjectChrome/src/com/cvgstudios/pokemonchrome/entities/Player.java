package com.cvgstudios.pokemonchrome.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.cvgstudios.pokemonchrome.ChromeGame;

public class Player extends Sprite {

	public int direction;

	public static TextureRegion playerR = new TextureRegion(new Texture(
			"imgs/MalePlayer.png"));

	public float xD = 0, yD = 0;

	public int currentStep;
	public boolean keyDown = false;

	public final int STEP_DELAY = 15;

	public int counter = 0;

	OrthographicCamera camera;

	public Player(OrthographicCamera camera) {
		this.camera = camera;
		changePlayerDirection(1);
	}

	public Player() {
		super(playerR);
	}

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

	public int getCurrentStep() {
		return currentStep;
	}

	public void setCurrentStep(int currentStep) {
		this.currentStep = currentStep;
	}

	public void changeUserSteps() {
		counter++;
		if (counter == STEP_DELAY) {
			counter = 0;
			if (currentStep == 1) {
				currentStep = 2;
			} else {
				currentStep = 1;
			}
			changePlayerDirection(direction);
			// Gdx.app.log(ChromeGame.LOG, "Step " + step);
		}
	}

	public void moveUser() {
		Vector2 oPos = new Vector2(this.getX(), this.getY());

		this.translate(xD, yD);

		// checkPlayerInteraction();
		//
		camera.position.set(this.getX(), this.getY(), 0);
		Gdx.app.log(ChromeGame.LOG, this.getX() + "," + this.getY());

	}

	public void setXD(float x) {
		this.xD = x;
		keyDown = true;
	}

	public void setYD(float y) {
		this.yD = y;
		keyDown = true;
	}

	public void stopMovement() {
		yD = 0;
		xD = 0;
		keyDown = false;
		currentStep = 0;
		changePlayerDirection(direction);

	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
