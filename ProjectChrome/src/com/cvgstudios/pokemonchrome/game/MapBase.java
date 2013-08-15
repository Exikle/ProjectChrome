package com.cvgstudios.pokemonchrome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cvgstudios.pokemonchrome.ChromeGame;

public abstract class MapBase implements Screen {

	protected TiledMap map;
	protected OrthogonalTiledMapRenderer renderer;
	protected OrthographicCamera camera;
	protected SpriteBatch batch;

	protected int collisionAmount;

	protected int[] bgLayers;
	protected int[] fgLayers;

	protected Rectangle[] collsionRect;
	protected Rectangle[] interactRect;

	protected RectangleMapObject[] interactObject;

	protected int interactionAmount;

	protected Rectangle user = new Rectangle(Gdx.graphics.getWidth() / 2,
			Gdx.graphics.getHeight() / 2, 38, 42);;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}

	protected void importMap(String m, Vector2 pos) {
		map = new TmxMapLoader().load("maps/" + m + ".tmx");

		int index = 0;
		int layerNum = map.getLayers().getCount() - 2;

		for (int x = 0; x < layerNum; x++) {
			if (map.getLayers().get(x).getName()
					.equalsIgnoreCase("playerLayer")) {
				index = x;
			}
		}
		bgLayers = new int[index];
		for (int x = 0; x < index; x++) {
			bgLayers[x] = x;
		}

		fgLayers = new int[layerNum - (index + 1)];
		int topLayerStart = index + 1;

		for (int x = 0; x < fgLayers.length; x++) {
			fgLayers[x] = x + topLayerStart;
			Gdx.app.log(ChromeGame.LOG, fgLayers[x] + "");
		}
		renderer = new OrthogonalTiledMapRenderer(map);

		createCollisions();
		createInteractions();
	}

	protected void createInteractions() {
		MapObjects mInteractions = map.getLayers().get("Interaction")
				.getObjects();

		interactionAmount = mInteractions.getCount();
		interactObject = new RectangleMapObject[interactionAmount];

		interactRect = new Rectangle[interactionAmount];

		for (int x = 0; x < interactionAmount; x++) {
			interactObject[x] = (RectangleMapObject) mInteractions.get(x);
			interactRect[x] = interactObject[x].getRectangle();
		}

	}

	protected void createCollisions() {
		MapObjects mCollisions = map.getLayers().get("Collision").getObjects();

		RectangleMapObject gameObject = new RectangleMapObject();
		collsionRect = new Rectangle[mCollisions.getCount()];

		collisionAmount = mCollisions.getCount();

		for (int x = 0; x < mCollisions.getCount(); x++) {
			gameObject = (RectangleMapObject) mCollisions.get(x);
			collsionRect[x] = gameObject.getRectangle();
		}
	}

	protected boolean collision() {
		for (int x = 0; x < collisionAmount; x++) {
			if (collsionRect[x].overlaps(user)) {
				// Gdx.app.log(ChromeGame.LOG, "Collide");
				return true;
			}
		}
		return false;
	}

	public void checkPlayerInteraction() {
		for (int x = 0; x < interactionAmount; x++) {
			if (interactRect[x].overlaps(user)) {
				Gdx.app.log(ChromeGame.LOG, interactObject[x].getName());
				checkIfInteractAction(interactObject[x].getName());
			}
		}
	}

	protected void checkIfInteractAction(String s) {
		if (s.contains("(CHANGEMAP)")) {
			String[] fields;
			fields = s.split(":");
			String[] pos = (fields[2].split(","));
			float x = Integer.parseInt(pos[0]);
			float y = Integer.parseInt(pos[1]);

			Vector2 playerPos = new Vector2(x, y);
			importMap(fields[1], playerPos);
		} else if (s.contains("(SCRIPT)")) {
			String[] fields = s.split(":");
			int id = Integer.parseInt(fields[1]);
			Gdx.app.log(ChromeGame.LOG, "" + id);
		} else {

		}
	}

}
