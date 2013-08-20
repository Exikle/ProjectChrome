package com.cvgstudios.pokemonchrome.script;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class ScriptImporter {

	static String[] script;

	public static String[] iScript(String scriptName) {
		String l = "";

		BufferedReader in = null;
		String line = "A B 1";
		String path = "res/script/" + scriptName;
		File f = new File(path);
		int counter = 0;
		int lines = 0;
		try {
			lines = count(path) + 1;
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		script = new String[lines];

		try {
			in = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
		}
		while (line != null) {
			try {
				line = in.readLine();
				if (line != null) {
					l = line;
				}
			} catch (IOException e) {
			}
			if (line != null) {
				script[counter] = l;
				counter++;
			}
		}
		try {
			in.close();
		} catch (IOException e) {
		}
		return script;
	}

	private static int count(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(
				filename));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}
}
