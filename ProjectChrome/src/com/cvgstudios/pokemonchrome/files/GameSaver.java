package com.cvgstudios.pokemonchrome.files;

import com.cvgstudios.pokemonchrome.GameFile;

/**
 * Saves the game
 * 
 * @author Dixon D'Cunha
 */
@SuppressWarnings("unused")
public class GameSaver {

	// NAME:Ash
	// MONEY:999999
	// POS:10,10
	// MAP:Exitium
	// GENDER:Male
	// MUSIC:NimbasaCity
	private final String NAME = GameFile.playerName;

	private final String MONEY = GameFile.playerMoney + "";

	private final String POS = GameFile.playerPosition.x + ","
			+ GameFile.playerPosition.y;

	private final String MAP = GameFile.currentMap;

	private final String GENDER = GameFile.playerName;

	private final String MUSIC = GameFile.musicName;

	public static void create() {

	}

	public static void save() {
		// GameFile.
	}
}
