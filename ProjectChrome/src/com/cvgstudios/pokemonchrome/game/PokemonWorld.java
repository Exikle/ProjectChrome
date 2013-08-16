package com.cvgstudios.pokemonchrome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.InputHandler;
import com.cvgstudios.pokemonchrome.entities.Player;

/**
 * The Pokemon World
 * 
 * @author Dixon D'Cunha:Exikle @
 */
public class PokemonWorld extends MapBase implements Screen {

	private boolean DEBUG = false;
	private ChromeGame game;

	private String START_MAP_NAME = "Exitium";
	private final Vector2 STARTCOORD = new Vector2(650, 150);

	private BitmapFont font;

	private ShapeRenderer sRen = new ShapeRenderer();

	private Player player;

	public PokemonWorld(ChromeGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		Vector2 oPos = new Vector2(player.getX(), player.getY());

		user = new Rectangle(player.getX() + player.xD, player.getY()
				+ player.yD, 38, 42);

		if (collision()) {
			player.xD = 0;
			player.yD = 0;
			player.setPosition(oPos.x, oPos.y);
		}
		player.moveUser();

		checkPlayerInteraction();

		// camera.zoom = 1.1f;
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		renderer.setView(camera);
		sRen.setProjectionMatrix(camera.combined);

		renderer.render(bgLayers);

		batch.begin();
		batch.draw(player, player.getX(), player.getY());
		batch.end();

		renderer.render(fgLayers);

		if (DEBUG) {
			showRect(sRen);

		}

	}

	private void showRect(ShapeRenderer sRen) {
		showCollisionRect(sRen);

		showInteractionRect(sRen);

		showPlayerRect(sRen);

		batch.begin();

		font.draw(batch, "Current Map: " + mapName, player.getX()
				- Gdx.graphics.getWidth() / 3,
				player.getY() - Gdx.graphics.getHeight() / 3);

		font.draw(batch, "X: " + player.getX() + ", Y:" + player.getY(),
				player.getX() - Gdx.graphics.getWidth() / 3, player.getY()
						- Gdx.graphics.getHeight() / 3 - 25);

		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(),
				player.getX() - Gdx.graphics.getWidth() / 3, player.getY()
						- Gdx.graphics.getHeight() / 3 - 50);

		batch.end();

	}

	@Override
	public void resize(int width, int height) {
		camera.viewportHeight = height;
		camera.viewportWidth = width;
		camera.update();
	}

	@Override
	public void show() {
		camera = new OrthographicCamera();
		player = new Player(camera);
		addPlayerToWorld(player);
		importMap(START_MAP_NAME, STARTCOORD);

		font = new BitmapFont(Gdx.files.internal("font/pokemon.fnt"),
				Gdx.files.internal("font/pokemon.png"), false);

		batch = new SpriteBatch();

		Gdx.input.setInputProcessor(new InputHandler(this, camera, player));

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
