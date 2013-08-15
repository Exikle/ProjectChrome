package com.cvgstudios.pokemonchrome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
	@SuppressWarnings("unused")
	private ChromeGame game;

	private String MAP_NAME = "Exitium";
	private final Vector2 STARTCOORD = new Vector2(650, 150);

	private BitmapFont font;

	private Player player;

	public PokemonWorld(ChromeGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		player.moveUser();
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		renderer.setView(camera);

		renderer.render(bgLayers);

		batch.begin();
		// render player
		batch.end();
		renderer.render(fgLayers);

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

		font = new BitmapFont(Gdx.files.internal("font/pokemon.fnt"),
				Gdx.files.internal("font/pokemon.png"), false);

		camera = new OrthographicCamera();
		// camera.position.set(STARTCOORD.x, STARTCOORD.y, 0);
		batch = new SpriteBatch();

		player = new Player(camera);
		player.setPosition(STARTCOORD.x, STARTCOORD.y);

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
