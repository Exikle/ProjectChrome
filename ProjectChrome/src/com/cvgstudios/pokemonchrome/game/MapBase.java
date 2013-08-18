package com.cvgstudios.pokemonchrome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.entities.Player;

public abstract class MapBase implements Screen {

	/**
	 * The map
	 */
	protected TiledMap map;

	/**
	 * The map's renderer
	 */
	protected OrthogonalTiledMapRenderer renderer;

	/**
	 * The map's camera
	 */
	protected OrthographicCamera camera;

	/**
	 * The spritebatch
	 */
	protected SpriteBatch batch;

	/**
	 * The amount of collision rectangles there were
	 */
	protected int collisionAmount;

	/**
	 * The layers that were in the back ground, behind the player
	 */
	protected int[] bgLayers;

	/**
	 * The layers that were in the fore-ground, infront the player
	 */
	protected int[] fgLayers;

	/**
	 * The rectangles used for collisions
	 */
	protected Rectangle[] collsionRect;

	/**
	 * The rectangles used for collisions
	 */
	protected Rectangle[] interactRect;

	/**
	 * The interact objects
	 */
	protected RectangleMapObject[] interactObject;

	/**
	 * 
	 */
	protected int interactionAmount;

	/**
	 * 
	 */
	protected Rectangle user = new Rectangle(
			Gdx.graphics.getWidth() / 2,
			Gdx.graphics.getHeight() / 2, 38, 42);

	/**
	 * The player
	 */
	private Player player;

	/**
	 * The name of the map
	 */
	protected String mapName;

	/**
	 * The msg to display to the user
	 */
	protected String msg;

	/**
	 * Render a black BG
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

	}

	/**
	 * Import the map
	 * 
	 * @param map
	 *            name
	 * @param the
	 *            player's coordinates
	 */
	protected void importMap(String m, Vector2 pos) {
		map = new TmxMapLoader().load("maps/" + m + ".tmx");
		mapName = m;
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
		}
		renderer = new OrthogonalTiledMapRenderer(map);

		createCollisions();
		createInteractions();
		player.setPosition(pos.x, pos.y);
		camera.position.set(player.getX(), player.getY(), 0);

	}

	/**
	 * Create the interaction rectangles
	 */
	protected void createInteractions() {
		MapObjects mInteractions = map.getLayers().get("Interaction")
				.getObjects();

		interactionAmount = mInteractions.getCount();
		interactObject = new RectangleMapObject[interactionAmount];

		interactRect = new Rectangle[interactionAmount];

		for (int x = 0; x < interactionAmount; x++) {
			interactObject[x] = (RectangleMapObject) mInteractions
					.get(x);
			interactRect[x] = interactObject[x].getRectangle();
		}

	}

	/**
	 * Create the collision rectangles
	 */
	protected void createCollisions() {
		MapObjects mCollisions = map.getLayers().get("Collision")
				.getObjects();

		RectangleMapObject gameObject = new RectangleMapObject();
		collsionRect = new Rectangle[mCollisions.getCount()];

		collisionAmount = mCollisions.getCount();

		for (int x = 0; x < mCollisions.getCount(); x++) {
			gameObject = (RectangleMapObject) mCollisions.get(x);
			collsionRect[x] = gameObject.getRectangle();
		}
	}

	/**
	 * Check if there is a collisions
	 * 
	 * @return if there was a collision
	 */
	protected boolean collision() {
		for (int x = 0; x < collisionAmount; x++) {
			if (collsionRect[x].overlaps(user)) {

				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the player interacted with anything
	 */
	public void checkPlayerInteraction() {
		for (int x = 0; x < interactionAmount; x++) {
			if (interactRect[x].overlaps(user)) {
				checkWhatInteractAction(interactObject[x].getName());
			}
		}
	}

	/**
	 * Check what type of interaction the player did
	 * 
	 * @param the
	 *            interaction type
	 */
	protected void checkWhatInteractAction(String s) {
		if (s.contains("(CHANGEMAP)")) {
			String[] fields;
			fields = s.split(":");
			String[] pos = (fields[2].split(","));
			float x = Integer.parseInt(pos[0]);
			float y = Integer.parseInt(pos[1]);

			Vector2 playerPos = new Vector2(x, y);
			importMap(fields[1], playerPos);
		} else if (s.contains("(JUMP)")) {
			float dX = player.xD;
			float dY = player.yD;

			player.setX(player.getX() + dX * 32);
			player.setY(player.getY() + dY * 32);

		} else if (s.contains("(SCRIPT)")) {
			String[] fields = s.split(":");
			int id = Integer.parseInt(fields[1]);
			Gdx.app.log(ChromeGame.LOG, "" + id);
		} else {
			if (Gdx.input.isKeyPressed(Keys.SPACE)) {
				onlyIfButton(s);
			}
		}
	}

	/**
	 * what to do if the interaction was on a key press
	 * 
	 * @param msg
	 *            to display
	 */
	private void onlyIfButton(String s) {
		Gdx.app.log(ChromeGame.LOG, s);
		msg = s;
	}

	/**
	 * Add the player onto the screen
	 * 
	 * @param the
	 *            player
	 */
	protected void addPlayerToWorld(Player player) {
		this.player = player;
	}

	/**
	 * Show the player boundaries
	 * 
	 * @param the
	 *            rectangle renderer
	 */
	protected void showPlayerRect(ShapeRenderer sRen) {

		sRen.begin(ShapeType.Line);
		sRen.setColor(Color.BLACK);
		sRen.rect(player.getX(), player.getY(), 38, 42);
		sRen.end();
	}

	/**
	 * Show the interaction boundaries
	 */
	protected void showInteractionRect(ShapeRenderer sRen) {
		sRen.begin(ShapeType.Line);
		sRen.setColor(Color.ORANGE);

		for (int x = 0; x < interactRect.length; x++) {
			sRen.rect(interactRect[x].x, interactRect[x].y,
					interactRect[x].width, interactRect[x].height);
		}
		sRen.end();
	}

	/**
	 * Show the collision boundaries
	 * 
	 * @param the
	 *            rectangle renderer
	 */
	protected void showCollisionRect(ShapeRenderer sRen) {
		sRen.begin(ShapeType.Line);
		sRen.setColor(Color.MAGENTA);

		for (int x = 0; x < collsionRect.length; x++) {
			sRen.rect(collsionRect[x].x, collsionRect[x].y,
					collsionRect[x].width, collsionRect[x].height);
		}
		sRen.end();
	}

	/**
	 * Show the player boundaries
	 * The text to display on screen. X/Y Coord, Map name and the Msg
	 * 
	 * @param the
	 *            Sprite batch
	 * @param the
	 *            font
	 */
	protected void showDebugText(SpriteBatch batch, BitmapFont font) {
		font.draw(batch, "Current Map: " + mapName, player.getX()
				- Gdx.graphics.getWidth() / 3, player.getY()
				- Gdx.graphics.getHeight() / 3);

		font.draw(batch,
				"X: " + player.getX() + ", Y:" + player.getY(),
				player.getX() - Gdx.graphics.getWidth() / 3,
				player.getY() - Gdx.graphics.getHeight() / 3 - 25);

		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(),
				player.getX() - Gdx.graphics.getWidth() / 3,
				player.getY() - Gdx.graphics.getHeight() / 3 - 50);

		font.draw(batch, "MSG: " + msg,
				player.getX() - Gdx.graphics.getWidth() / 3 + 100,
				player.getY() - Gdx.graphics.getHeight() / 3 - 50);
	}
}
