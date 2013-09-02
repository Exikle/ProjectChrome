package com.cvgstudios.pokemonchrome.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.GameFile;

public class MainMenu implements Screen, InputProcessor {

	ChromeGame game;

	Texture t, button, conButton;

	BitmapFont font = new BitmapFont(
			Gdx.files.internal("font/pokemon.fnt"),
			Gdx.files.internal("font/pokemon.png"), false);

	Texture selButton, selConButton;

	SpriteBatch batch;

	Sprite bg, regButton, regButton2, regButton3, butContinue;

	private boolean saveFileExists = GameFile.saveExits;

	private int choiceSelected = 1;

	public MainMenu() {
		GameFile.musicPlaying = null;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.begin();

		bg.draw(batch);
		updateSelection();

		regButton.draw(batch);
		regButton2.draw(batch);
		regButton3.draw(batch);

		if (saveFileExists) {
			font.draw(batch, "Continue", 190, 475);
			font.draw(batch, "New Game", 190, 190);
			font.draw(batch, "Credits", 190, 90);

		} else {
			font.draw(batch, "New Game", 190, 440);
			font.draw(batch, "Continue", 190, 340);
			font.draw(batch, "Credits", 190, 240);
		}
		batch.end();

	}

	private void updateSelection() {
		resetSelection();
		switch (choiceSelected) {
			case 1:
				if (saveFileExists) {
					regButton = new Sprite(selConButton);
					regButton.setX(150);
					regButton.setY(250);
				} else {
					regButton = new Sprite(selButton);
					regButton.setX(150);
					regButton.setY(400);
				}
				break;
			case 2:
				regButton2 = new Sprite(selButton);
				if (saveFileExists) {
					regButton2.setX(150);
					regButton2.setY(150);
				} else {
					regButton2.setX(150);
					regButton2.setY(300);
				}
				break;
			case 3:
				regButton3 = new Sprite(selButton);
				if (saveFileExists) {
					regButton3.setX(150);
					regButton3.setY(50);
				} else {
					regButton3.setX(150);
					regButton3.setY(200);
				}
				break;

		}

	}

	private void resetSelection() {
		if (saveFileExists) {
			regButton = new Sprite(conButton);
			regButton2 = new Sprite(button);
			regButton3 = new Sprite(button);

			regButton.setX(150);
			regButton.setY(250);

			regButton2.setX(150);
			regButton2.setY(150);

			regButton3.setX(150);
			regButton3.setY(50);
		} else {
			regButton = new Sprite(button);
			regButton2 = new Sprite(button);
			regButton3 = new Sprite(button);

			regButton.setX(150);
			regButton.setY(400);

			regButton2.setX(150);
			regButton2.setY(300);

			regButton3.setX(150);
			regButton3.setY(200);
		}
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

		Gdx.input.setInputProcessor(this);
		bg = new Sprite(new Texture("imgs/MainMenuBG.png"));

		button = new Texture("imgs/menubutton.png");
		conButton = new Texture("imgs/buttoncontinue.png");

		selButton = new Texture("imgs/menubuttonselected.png");
		selConButton = new Texture(
				"imgs/PokemonMenuContinueSelected.png");

		regButton2 = new Sprite(button);
		regButton3 = new Sprite(button);

		if (saveFileExists) {
			regButton = new Sprite(conButton);
			regButton.setX(150);
			regButton.setY(250);

			regButton2.setX(150);
			regButton2.setY(150);

			regButton3.setX(150);
			regButton3.setY(50);

		} else {
			regButton = new Sprite(button);
			regButton.setX(150);
			regButton.setY(400);

			regButton2.setX(150);
			regButton2.setY(300);

			regButton3.setX(150);
			regButton3.setY(200);
		}

		batch = new SpriteBatch();
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
			case (Keys.UP):
				if (choiceSelected != 1) {
					choiceSelected -= 1;
				}
				break;
			case (Keys.DOWN):
				if (choiceSelected != 3) {
					choiceSelected += 1;
				}
				break;
			case (Keys.SPACE):
				startAction(choiceSelected);
				break;
			case (Keys.ESCAPE):
				Gdx.app.exit();
				break;
		}
		return true;
	}

	private void startAction(int i) {
		if (i == 1) {
			if (saveFileExists) {
				Gdx.app.log(ChromeGame.LOG, "Run Game From Save File");
			} else {
				Gdx.app.log(ChromeGame.LOG, "Create a New Game");
				game.setScreen(new NGIntro(game));
			}
		} else if (i == 2) {
			if (saveFileExists) {
				Gdx.app.log(ChromeGame.LOG, "Create a New Game");
				game.setScreen(new NGIntro(game));
			} else {
				Gdx.app.log(ChromeGame.LOG, "No Save File!");

			}
		} else if (i == 3) {
			Gdx.app.log(ChromeGame.LOG, "Credits");
			((Game) Gdx.app.getApplicationListener())
					.setScreen(new ScrollingCredits());
		}
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
}