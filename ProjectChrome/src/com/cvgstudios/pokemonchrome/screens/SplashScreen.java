package com.cvgstudios.pokemonchrome.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cvgstudios.pokemonchrome.tweenaccessors.ScreenTween;

public class SplashScreen extends ScreenBase {

	Texture splashTexture;

	Sprite splashSprite;

	SpriteBatch batch;

	TweenManager manager;

	public SplashScreen() {}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		manager.update(delta);
		batch.begin();
		splashSprite.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		splashTexture = new Texture("imgs/copyright.png");

		splashTexture.setFilter(TextureFilter.Linear,
				TextureFilter.Linear);

		splashSprite = new Sprite(splashTexture);
		splashSprite.setColor(1, 1, 1, 0);

		batch = new SpriteBatch();

		Tween.registerAccessor(Sprite.class, new ScreenTween());

		manager = new TweenManager();

		TweenCallback cb = new TweenCallback() {

			@Override
			public void onEvent(int type, BaseTween<?> source) {
				tweenCompleted();
			}
		};

		Tween.to(splashSprite, ScreenTween.ALPHA, 1.5f).target(1)
				.ease(TweenEquations.easeInQuad).repeatYoyo(1, 1.5f)
				.setCallback(cb)
				.setCallbackTriggers(TweenCallback.COMPLETE)
				.start(manager);

	}

	private void tweenCompleted() {
		// Gdx.app.log(ChromeGame.LOG, "Splash Tween Complete");
		((Game) Gdx.app.getApplicationListener())
				.setScreen(new StartScreen());
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

}
