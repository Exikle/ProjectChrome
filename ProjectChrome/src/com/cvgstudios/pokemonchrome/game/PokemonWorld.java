package com.cvgstudios.pokemonchrome.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.GameFile;
import com.cvgstudios.pokemonchrome.entities.Player;
import com.cvgstudios.pokemonchrome.input.WorldHandler;

/**
 * The Pokemon World
 * 
 * @author Dixon D'Cunha:Exikle
 */
public class PokemonWorld extends MapBase implements Screen {

	/**
	 * Whether debugging information is displayed
	 */
	private boolean DEBUG = false;

	/**
	 * The game instance
	 */
	private ChromeGame game;

	/*
	 * Temp, will be getting info from save file
	 */
	/**
	 * The map the player starts in
	 */
	private String START_MAP_NAME = "Route1";

	/*
	 * Temp, will be getting info from save file
	 */
	/**
	 * The coordinates the player starts at
	 */
	private final Vector2 STARTCOORD = new Vector2(528, 504);

	/**
	 * The pokemon font file
	 */
	private BitmapFont font;

	/**
	 * Renderer for the debugger, render rectangles for boundaries
	 */
	private ShapeRenderer sRen = new ShapeRenderer();

	/**
	 * The player
	 */
	private Player player;

	/**
	 * Constructor
	 * 
	 * @param the
	 *            game instance
	 */
	public PokemonWorld(ChromeGame game) {
		this.game = game;

		// read files
		try {
			readFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void readFile() throws Exception {
	}

	/**
	 * Renders the map and the player on the map, if debugging, renders the
	 * debug rectangles
	 */
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

	/**
	 * Shows the debugging rectangles
	 */
	private void showRect(ShapeRenderer sRen) {
		MapDebugger.showCollisionRect(sRen, collsionRect);
		MapDebugger.showInteractionRect(sRen, interactRect);
		MapDebugger.showPlayerRect(sRen, player);

		batch.begin();
		MapDebugger.showDebugText(batch, font, mapName, player, msg);
		batch.end();
	}

	/**
	 * Updates the camera size if the window is resized
	 */
	@Override
	public void resize(int width, int height) {
		camera.viewportHeight = height;
		camera.viewportWidth = width;
		camera.update();
	}

	/**
	 * Initializes the world's variables when first run
	 */
	@Override
	public void show() {
		super.show();
		camera = new OrthographicCamera();
		player = new Player(camera);
		addPlayerToWorld(player);
		importMap(START_MAP_NAME, STARTCOORD);

		font = new BitmapFont(Gdx.files.internal("font/pokemon.fnt"),
				Gdx.files.internal("font/pokemon.png"), false);

		batch = new SpriteBatch();

		Gdx.input.setInputProcessor(new WorldHandler(this, camera,
				player));

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
