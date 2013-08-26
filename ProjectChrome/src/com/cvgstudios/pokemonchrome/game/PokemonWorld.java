package com.cvgstudios.pokemonchrome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
	private boolean DEBUG = true;

	/**
	 * The game instance
	 */
	@SuppressWarnings("unused")
	private ChromeGame game;

	/*
	 * Temp, will be getting info from save file
	 */
	/**
	 * The map the player starts in
	 */
	private String START_MAP_NAME = "Route2";

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
	 * The music currently playing
	 */
	private Music music;

	/**
	 * Renderer for the debugger, render rectangles for boundaries
	 */
	private ShapeRenderer sRen = new ShapeRenderer();

	/**
	 * The player
	 */
	private Player player;

	private boolean menuVisible = false;

	protected MenuActor menu;

	protected Stage stage;

	/**
	 * Constructor
	 * 
	 * @param the
	 *            game instance
	 */
	public PokemonWorld(ChromeGame game) {
		this.game = game;
		GameFile.load();
		createMenu();
		music = Gdx.audio.newMusic(Gdx.files
				.internal("music/"+GameFile.musicName+".mp3"));
//		music.play();
	}

	protected void createMenu() {
		menu = new MenuActor();
		menu.setWidth(90);
		// menu.set

		stage = new Stage();
		stage.setViewport(190, ChromeGame.display.getDisplayHeight(),
				false, 540 - 350, 0, 350, 720);
		stage.addActor(menu);

		Gdx.app.log(ChromeGame.LOG, "Menu Created");

	}

	/**
	 * Renders the map and the player on the map
	 * If debugging, renders the debug rectangles
	 */
	@Override
	public void render(float delta) {
		super.render(delta);
		if (!menuVisible) {
			movementCalc();
		}
		cameraUpdater();

		drawWorld();

		if (menuVisible) {
			stage.act(delta);
			stage.draw();
		}

		if (DEBUG) {
			showRect(sRen);
		}

	}

	/**
	 * @param Set
	 *            the menuVisible with menuVisible
	 */
	public void setMenuVisible(boolean menuVisible) {
		this.menuVisible = menuVisible;
	}

	private void drawWorld() {
		renderer.render(bgLayers);

		batch.begin();

		batch.draw(player, player.getX(), player.getY());

		batch.end();

		renderer.render(fgLayers);
	}

	private void cameraUpdater() {
		// camera.zoom = 1.1f;
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		renderer.setView(camera);
		sRen.setProjectionMatrix(camera.combined);
	}

	private void movementCalc() {
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
		stage.setViewport(width, height, true);
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

	/**
	 * @return the menuVisible
	 */
	public boolean isMenuVisible() {
		return menuVisible;
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
