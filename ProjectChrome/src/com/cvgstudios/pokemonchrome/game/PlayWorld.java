package com.cvgstudios.pokemonchrome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.InputHandler;

public class PlayWorld implements Screen {
	private ChromeGame game;

	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	TiledMapTileLayer layer;
	private SpriteBatch batch;

	Sprite player = new Sprite(new Texture("imgs/Up.png"));

	float xD = 0, yD = 0;

	int amount;

	int[] bgLayers = { 0, 1, 2, 3, 4 };
	int[] fgLayers = { 5, 6, 7 };

	ShapeRenderer sRender = new ShapeRenderer();

	RectangleMapObject[] gameObjects;

	MapObjects mObjs = new MapObjects();

	Rectangle[] collsionRect;

	Rectangle user = new Rectangle(Gdx.graphics.getWidth() / 2,
			Gdx.graphics.getHeight() / 2, player.getWidth(), player.getHeight());

	public PlayWorld(ChromeGame game) {
		this.game = game;
		Gdx.input.setInputProcessor(new InputHandler(this, camera));

		MapObjects mObjs = new MapObjects();
	}

	@Override
	public void render(float delta) {
		moveUser();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		renderer.setView(camera);

		// renderer.render(bgLayers);
		renderer.render();

		batch.begin();

		batch.draw(player, player.getX(), player.getY());

		batch.end();

	}

	private void moveUser() {
		float orgX = player.getX();
		float orgY = player.getY();
		
		user = new Rectangle(player.getX(), player.getY(), player.getWidth(),
				player.getHeight());
		
		if (collision()) {
			player.setPosition(orgX, orgY);
		} else
			player.translate(xD, yD);
		
		camera.position.set(player.getX(), player.getY(), 0);
		Gdx.app.log(ChromeGame.LOG, player.getX() + "," + player.getY());
	}

	private boolean collision() {
		for (int x = 0; x < amount; x++) {
			if (collsionRect[x].overlaps(user)) {
				Gdx.app.log(ChromeGame.LOG, "Overlap");
				xD = 0;
				yD = 0;
				return true;
			}
		}
		return false;
	}

	public void setXD(float x) {
		this.xD = x;
	}

	public void setYD(float y) {
		this.yD = y;
	}

	public void resetCameraDirection() {
		yD = 0;
		xD = 0;
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportHeight = height;
		camera.viewportWidth = width;
		camera.update();
	}

	@Override
	public void show() {
		map = new TmxMapLoader().load("maps/exitium.tmx");

		renderer = new OrthogonalTiledMapRenderer(map);

		camera = new OrthographicCamera();
		camera.position.set(507, 525, 0);
		Gdx.input.setInputProcessor(new InputHandler(this, camera));

		batch = new SpriteBatch();

		mObjs = map.getLayers().get("Collision").getObjects();

		gameObjects = new RectangleMapObject[mObjs.getCount()];
		collsionRect = new Rectangle[mObjs.getCount()];

		amount = mObjs.getCount();

		player.setPosition(509, 500);

		for (int x = 0; x < mObjs.getCount(); x++) {
			gameObjects[x] = (RectangleMapObject) mObjs.get(x);
			collsionRect[x] = gameObjects[x].getRectangle();
		}
		// Gdx.app.log(ChromeGame.LOG, "" + );

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
