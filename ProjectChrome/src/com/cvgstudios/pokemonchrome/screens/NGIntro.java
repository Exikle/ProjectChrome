package com.cvgstudios.pokemonchrome.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.game.PokemonWorld;
import com.cvgstudios.pokemonchrome.script.ScriptImporter;

public class NGIntro extends ScreenBase implements InputProcessor {

	ChromeGame game;

	String[] script;

	String[] hold;

	private int counter = 0;

	private int len;

	private Sprite optionBox;

	BitmapFont font = new BitmapFont(
			Gdx.files.internal("font/pokemon.fnt"),
			Gdx.files.internal("font/pokemon.png"), false);

	SpriteBatch batch;

	private String lineOne = "";

	private String lineTwo = "";

	String playerName = "Ash";

	String playerGender = "male";

	Sprite bg, box, prof;

	private boolean optionsBoxVisible = false;

	// private boolean profVisible = true;
	private Music m = Gdx.audio.newMusic(Gdx.files
			.internal("music/ProfessorIntro.mp3"));

	private int optionsScreen = 1;

	private boolean optionsVisible = false;

	public NGIntro(ChromeGame game) {
		this.game = game;
		Gdx.input.setInputProcessor(this);
		m.play();
		m.setLooping(true);
		processScript();
	}

	private void processScript() {
		script = ScriptImporter.iScript("newgame.script");
		len = script.length - 1;
		getLines();
	}

	public void getLines() {
		hold = script[counter].split(";");
		lineOne = hold[0];
		lineTwo = hold[1];
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		font.setColor(Color.BLACK);
		batch.begin();
		bg.draw(batch);
		if (optionsBoxVisible) {
			box.draw(batch);
		}
		prof.draw(batch);
		font.draw(batch, lineOne, 190, 125);
		font.draw(batch, lineTwo, 190, 75);

		if (optionsVisible) {
			optionBox.draw(batch);
			font.draw(batch, "Yes", 60, 255);
			font.draw(batch, "No", 60, 215);
		}

		batch.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		optionBox = new Sprite(new Texture("imgs/OptionBox.png"));
		optionBox.setPosition(25, 150);

		bg = new Sprite(new Texture("imgs/WelcomeBG.png"));
		box = new Sprite(new Texture("imgs/OptionBox.png"));
		prof = new Sprite(new Texture("imgs/Professor.png"));
		prof.setX(500);

		batch = new SpriteBatch();
		font.setColor(Color.BLACK);
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
			case (Keys.SPACE):
				if (counter < len) {

					counter++;
					optionsVisible = false;

					if (script[counter].contains("(NAME)")) {
						script[counter] = script[counter].replace(
								"(NAME)", playerName);
					} else if (script[counter]
							.contains("(GENDERPICK)")) {
						// allow user to choose gender
					} else if (script[counter]
							.contains("(NAME CREATION)")) {
						// allow user to enter a name
					} else if (script[counter].contains("(GENDER)")) {
						script[counter] = script[counter].replace(
								"(GENDER)", playerGender);
					}

					if (script[counter].contains("(OPTION)")) {
						script[counter] = script[counter].replace(
								"(OPTION)", "");
						optionsVisible = true;
					}

					getLines();
				} else {
					m.stop();
					((Game) Gdx.app.getApplicationListener())
							.setScreen(new PokemonWorld());
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
