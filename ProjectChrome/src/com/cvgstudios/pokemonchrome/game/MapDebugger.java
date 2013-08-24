package com.cvgstudios.pokemonchrome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.cvgstudios.pokemonchrome.GameFile;
import com.cvgstudios.pokemonchrome.entities.Player;

/**
 * Class that outputs the map debugging info onto the screen
 * 
 * @author Dixon D'Cunha
 */
// TODO move map specific debugging here
public class MapDebugger {

	/**
	 * Show the collision boundaries
	 * 
	 * @param the
	 *            rectangle renderer
	 */
	public static void showCollisionRect(ShapeRenderer sRen,
			Rectangle[] cRect) {
		sRen.begin(ShapeType.Line);
		sRen.setColor(Color.MAGENTA);

		for (int x = 0; x < cRect.length; x++) {
			sRen.rect(cRect[x].x, cRect[x].y, cRect[x].width,
					cRect[x].height);
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
	 * @param maps
	 *            name
	 * @param the
	 *            player
	 * @param the
	 *            message
	 */
	protected static void showDebugText(SpriteBatch batch,
			BitmapFont font, String mapName, Player player, String msg) {
		font.draw(batch, "Current Map: " + mapName, player.getX()
				- Gdx.graphics.getWidth() / 3, player.getY()
				- Gdx.graphics.getHeight() / 3);

		font.draw(batch,
				"X: " + player.getX() + ", Y:" + player.getY(),
				player.getX() - Gdx.graphics.getWidth() / 3,
				player.getY() - Gdx.graphics.getHeight() / 3 - 20);

		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(),
				player.getX() - Gdx.graphics.getWidth() / 3,
				player.getY() - Gdx.graphics.getHeight() / 3 - 45);

		font.draw(batch, "MSG: " + msg,
				player.getX() - Gdx.graphics.getWidth() / 3 + 100,
				player.getY() - Gdx.graphics.getHeight() / 3 - 45);

		font.draw(batch, "CUURENT MUSIC: " + GameFile.musicName,
				player.getX() - Gdx.graphics.getWidth() / 3,
				player.getY() - Gdx.graphics.getHeight() / 3 - 70);
	}

	/**
	 * Show the player boundaries
	 * 
	 * @param the
	 *            rectangle renderer
	 * @param the
	 *            player
	 */
	protected static void showPlayerRect(ShapeRenderer sRen,
			Player player) {

		sRen.begin(ShapeType.Line);
		sRen.setColor(Color.BLACK);
		sRen.rect(player.getX(), player.getY(), 38, 42);
		sRen.end();
	}

	/**
	 * Show the interaction boundaries
	 */
	protected static void showInteractionRect(ShapeRenderer sRen,
			Rectangle[] interactRect) {
		sRen.begin(ShapeType.Line);
		sRen.setColor(Color.ORANGE);

		for (int x = 0; x < interactRect.length; x++) {
			sRen.rect(interactRect[x].x, interactRect[x].y,
					interactRect[x].width, interactRect[x].height);
		}
		sRen.end();
	}
}
