package com.cvgstudios.pokemonchrome;

import java.io.File;
import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Vector2;
import com.cvgstudios.pokemonchrome.files.SaveImporter;

/**
 * Contains data pertaining to the game's player and state
 * 
 * @author Dixon D'Cunha
 */
public class GameFile {

	/**
	 * Player's coordinates on a 2D plane
	 */
	public static Vector2 playerPosition;

	/**
	 * Player's coordinates on a 2D plane
	 */
	public static Music musicPlaying;

	/**
	 * Player's current map location
	 */
	public static String currentMap;

	/**
	 * Whether the save file existed before play or exists ATM
	 */
	public static Boolean saveExits = false;

	/**
	 * Player's gender
	 */
	public static String playerGender;

	/**
	 * Player's name
	 */
	public static String playerName;

	/**
	 * Player's current money
	 */
	public static float playerMoney;

	public static void load() {
		checkGameSaveFile();
	}

	private static void checkGameSaveFile() {
		File f = new File(System.getenv("APPDATA")
				+ "//.pokechrome/player.sav");
		if (f.exists()) {
			Gdx.app.log(ChromeGame.LOG, "Exists");
			saveExits = true;
			try {
				SaveImporter.impt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Gdx.app.log(ChromeGame.LOG, "Doesn't Exist");
			File folder = new File(System.getenv("APPDATA")
					+ "//.pokechrome");
			folder.mkdir();
			saveExits = false;
		}
	}

}
