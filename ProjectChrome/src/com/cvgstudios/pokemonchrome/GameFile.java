package com.cvgstudios.pokemonchrome;

import com.badlogic.gdx.math.Vector2;

/**
 * Contains data pertaining to the game's player and state
 * 
 * @author Dixon D'Cunha
 */
public class GameFile {

	/**
	 * Player's X Position
	 */
	static float locX = 0;

	/**
	 * Player's Y Position
	 */
	static float locY = 0;

	/**
	 * Player's coordinates on a 2D plane
	 */
	static Vector2 PlayerPosition;

	/**
	 * Player's current map location
	 */
	static String currentMap;

	/**
	 * Whether the save file existed before play or exists ATM
	 */
	static public Boolean saveExits = false;

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
}
