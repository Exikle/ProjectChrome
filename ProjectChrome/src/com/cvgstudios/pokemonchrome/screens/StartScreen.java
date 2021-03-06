package com.cvgstudios.pokemonchrome.screens;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

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
import com.cvgstudios.pokemonchrome.tweenaccessors.BitmapFontTween;

public class StartScreen extends ScreenBase implements  InputProcessor {

	ChromeGame game;

	Music music = Gdx.audio.newMusic(Gdx.files
			.internal("music/PokemonHGSS.mp3"));

	Texture startBg;

	Sprite bg;

	SpriteBatch batch;

	TweenManager manager;

	BitmapFont font = new BitmapFont(
			Gdx.files.internal("font/pokemon.fnt"),
			Gdx.files.internal("font/pokemon.png"), false);

	boolean startFading = false;

	private int musicState = 0;

	public StartScreen() {
		music.play();
		music.setLooping(true);
		music.setVolume(0.01f);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		font.setColor(Color.LIGHT_GRAY);
		manager.update(delta);
		batch.begin();
		bg.draw(batch);
		font.draw(batch, "Press Start",
				(Gdx.graphics.getWidth() / 2) - 45, 125);
		batch.end();

		changeMusicVol(delta);
	}

	private void changeMusicVol(float delta) {
		float volume = music.getVolume();
		switch (musicState) {
			case 1:
				if (music.isLooping() || music.isPlaying()) {
					if (volume > 0.10f)
						volume -= delta;
					else {
						changeToMainMenu();
					}
					music.setVolume(Math.abs(volume));
				}
				break;
			case 0:
				if (music.isLooping() || music.isPlaying()) {
					if (volume < 1.0f)
						volume += delta * 3;
					else {
						volume = 1.0f;
					}
					music.setVolume(volume);
				}
				break;
		}
	}

	private void changeToMainMenu() {
		music.stop();
		((Game) Gdx.app.getApplicationListener())
				.setScreen(new MainMenu());
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		startBg = new Texture("imgs/WhiteTitleScreen.png");
		bg = new Sprite(startBg);
		batch = new SpriteBatch();

		Tween.registerAccessor(BitmapFont.class,
				new BitmapFontTween());

		manager = new TweenManager();

		Tween.to(font, BitmapFontTween.BETA, 1f).target(1)
				.repeatYoyo(1000000, .5f).start(manager);
	}

	protected void tweenCompleted() {
		// TODO Auto-generated method stub

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
		music.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		if (Keys.ENTER == keycode) {
			musicState = 1;
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
		((Game) Gdx.app.getApplicationListener())
				.setScreen(new PokemonWorld());

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
