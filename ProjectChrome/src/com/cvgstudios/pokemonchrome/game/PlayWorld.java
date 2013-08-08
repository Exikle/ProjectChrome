package com.cvgstudios.pokemonchrome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
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

	int[] bgLayers = { 0, 1, 2 };
	int[] fgLayers = { 3 };

	ShapeRenderer sRender = new ShapeRenderer();

	RectangleMapObject[] gameObjects;

	MapObjects mObjs = new MapObjects();

	Rectangle[] collsionRect;

	Rectangle user = new Rectangle(Gdx.graphics.getWidth() / 2,
			Gdx.graphics.getHeight() / 2, player.getWidth(), player.getHeight());

	Texture p = new Texture("imgs/PlayerSheet.png");
	TextureRegion playerR = new TextureRegion(p);

	public PlayWorld(ChromeGame game) {
		this.game = game;
		Gdx.input.setInputProcessor(new InputHandler(this, camera));
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		moveUser();

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		renderer.setView(camera);
		sRender.setProjectionMatrix(camera.combined);

		renderer.render(bgLayers);

		batch.begin();

		batch.draw(player, player.getX(), player.getY());

		batch.end();
		renderer.render(fgLayers);

	}

	private void moveUser() {
		Vector2 oPos = new Vector2(player.getX(), player.getY());

		player.translate(xD, yD);

		user = new Rectangle(player.getX(), player.getY(), player.getWidth(),
				player.getHeight());
		if (collision()) {
			Gdx.app.log(ChromeGame.LOG, "");
			player.setPosition(oPos.x, oPos.y);
		}

		camera.position.set(player.getX(), player.getY(), 0);
		// Gdx.app.log(ChromeGame.LOG, player.getX() + "," + player.getY());
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
		map = new TmxMapLoader().load("maps/Route1.tmx");

		renderer = new OrthogonalTiledMapRenderer(map);

		camera = new OrthographicCamera();
		camera.position.set(507, 525, 0);
		Gdx.input.setInputProcessor(new InputHandler(this, camera));

		batch = new SpriteBatch();

		mObjs = map.getLayers().get("Collision").getObjects();

		gameObjects = new RectangleMapObject[mObjs.getCount()];
		collsionRect = new Rectangle[mObjs.getCount()];

		amount = mObjs.getCount();

		player.setPosition(450, 500);

		for (int x = 0; x < mObjs.getCount(); x++) {
			gameObjects[x] = (RectangleMapObject) mObjs.get(x);
			collsionRect[x] = gameObjects[x].getRectangle();
		}
		changePlayerDirection(1);

	}

	public void changePlayerDirection(int d) {
		switch (d) {
		case 1:// down
			playerR.setRegion(0, 0, 37, 42);
			break;
		case 2:// up
			playerR.setRegion(37, 0, 37, 42);
			break;
		case 3:// right
			playerR.setRegion(74, 0, 37, 42);
			break;
		case 4:// left
			playerR.setRegion(111, 0, 37, 42);
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
