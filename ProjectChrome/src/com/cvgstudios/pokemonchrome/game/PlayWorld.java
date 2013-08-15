package com.cvgstudios.pokemonchrome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.InputHandler;

public class PlayWorld extends MapBase implements Screen {
	@SuppressWarnings("unused")
	private ChromeGame game;

	private String MAP_NAME = "Exitium";
	private final Vector2 STARTCOORD = new Vector2(650, 150);

	private Sprite player = new Sprite();

	private BitmapFont font = new BitmapFont(
			Gdx.files.internal("font/pokemon.fnt"),
			Gdx.files.internal("font/pokemon.png"), false);

	private float xD = 0, yD = 0;

	private TextureRegion playerR = new TextureRegion(new Texture(
			"imgs/MalePlayer.png"));

	private int counter = 0;

	private int step;

	private int direction;

	private boolean keyDown = false;

	private final int STEP_DELAY = 15;

	public PlayWorld(ChromeGame game) {
		this.game = game;
		Gdx.input.setInputProcessor(new InputHandler(this, camera));
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		moveUser();
		if (keyDown) {
			changeUserSteps();
		}
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		renderer.setView(camera);

		renderer.render(bgLayers);

		batch.begin();

		batch.draw(player, player.getX(), player.getY());

		font.draw(batch, player.getX() + "," + player.getY(),
				0 + player.getX(), 0 + player.getY());
		batch.end();
		renderer.render(fgLayers);

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

	private void moveUser() {
		Vector2 oPos = new Vector2(player.getX(), player.getY());

		player.translate(xD, yD);

		// Gdx.app.log(ChromeGame.LOG, step + "");

		user = new Rectangle(player.getX(), player.getY(), player.getWidth(),
				player.getHeight());
		if (collision()) {
			xD = 0;
			yD = 0;
			player.setPosition(oPos.x, oPos.y);
		}
		checkPlayerInteraction();

		camera.position.set(player.getX(), player.getY(), 0);
		// Gdx.app.log(ChromeGame.LOG, player.getX() + "," + player.getY());

	}

	public void setXD(float x) {
		this.xD = x;
		keyDown = true;
	}

	public void setYD(float y) {
		this.yD = y;
		keyDown = true;
	}

	public void resetCameraDirection() {
		yD = 0;
		xD = 0;
		keyDown = false;
		step = 0;
		changePlayerDirection(direction);

	}

	@Override
	public void resize(int width, int height) {
		camera.viewportHeight = height;
		camera.viewportWidth = width;
		camera.update();
	}

	@Override
	public void show() {
		importMap(MAP_NAME, STARTCOORD);
		camera = new OrthographicCamera();

		Gdx.input.setInputProcessor(new InputHandler(this, camera));

		batch = new SpriteBatch();

		changePlayerDirection(1);

		player.setPosition(STARTCOORD.x, STARTCOORD.y);

	}

	public void changePlayerDirection(int d) {
		direction = d;
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
		player.setRegion(playerR);

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
		map.dispose();
		renderer.dispose();
	}
}
