package com.cvgstudios.pokemonchrome.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.cvgstudios.pokemonchrome.GameFile;

/**
 * Saves the game
 * 
 * @author Dixon D'Cunha
 */
public class GameSaver {

	// NAME:Ash
	// MONEY:999999
	// POS:10,10
	// MAP:Exitium
	// GENDER:Male
	// MUSIC:NimbasaCity
	private static String NAME = GameFile.playerName;

	private static String MONEY = GameFile.playerMoney + "";

	private static String POS = GameFile.playerPosition.x + ","
			+ GameFile.playerPosition.y;

	private static String MAP = GameFile.currentMap;

	private static String GENDER = GameFile.playerName;

	private static String MUSIC = GameFile.musicName;

	public static void create() {

	}

	public static void save() {
		int counter = 0;
		PrintWriter out = null; // variable representing the PrintWriter
		String line = ""; // variable to read each line from the data file
		// Open the data file
		File f = new File(System.getenv("APPDATA")
				+ "//.pokechrome/player.sav");
		try {
			// in general we have substituted the word Writer for Reader
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					f, false)), false);
			// add ,true parameter to the PrintWriter to FLUSH Buffer with every
			// write line
			// add ,true parameter to the FileWriter for opening as APPEND
			System.out.println("Start Saving");
		} catch (IOException e) {
			System.out.println("Problem opening File");
		}
		while (counter < 6) {
			line = write(counter, line);
			out.println(line); // outputs the contents of the variable 'line' to
								// the
								// file
			counter++;
		}
		out.close(); // Close the data file
		System.out.println("Done Saving");
	}

	private static String write(int c, String l) {
		switch (c) {
			case 0:
				return "NAME:" + NAME;
			case 1:
				return "MONEY:" + MONEY;
			case 2:
				return "POS:" + POS;
			case 3:
				return "MAP:" + MAP;
			case 4:
				return "GENDER:" + GENDER;
			case 5:
				return "MUSIC:" + MUSIC;
		}
		return null;

	}
}
