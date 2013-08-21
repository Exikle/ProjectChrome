package com.cvgstudios.pokemonchrome.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.GameFile;

/**
 * Imports Save File
 * 
 * @author Dixon D'Cunha
 */
public class SaveImporter {

	public static void impt() throws Exception {

		File f = new File(System.getenv("APPDATA")
				+ "//.pokechrome/player.sav");
		FileInputStream fstream = new FileInputStream(f);
		BufferedReader br = new BufferedReader(new InputStreamReader(
				fstream));

		String strLine;
		while ((strLine = br.readLine()) != null) {
			Gdx.app.log(ChromeGame.LOG, strLine);
			String[] hold = strLine.split(":");
			switch (hold[0]) {
				case "NAME":
					GameFile.playerName = hold[1];
					break;
				case "MONEY":
					GameFile.playerMoney = Float.parseFloat(hold[1]);
					break;
				case "POS":
					String[] pos = hold[1].split(",");
					GameFile.playerPosition = new Vector2(
							Float.parseFloat(pos[0]),
							Float.parseFloat(pos[1]));
					break;
				case "MAP":
					GameFile.currentMap = hold[1];
					break;
				case "GENDER":
					GameFile.playerGender = hold[1];
					break;
				case "MUSIC":
					GameFile.musicPlaying = Gdx.audio
							.newMusic(Gdx.files.internal("music/"
									+ hold[1] + ".mp3"));
					break;
			}
		}
		br.close();
	}
}
