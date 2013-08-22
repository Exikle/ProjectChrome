package com.cvgstudios.pokemonchrome.javascript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

import com.cvgstudios.pokemonchrome.gamelogic.PokemonCreature;
import com.cvgstudios.pokemonchrome.gamelogic.PokemonType;
import com.cvgstudios.pokemonchrome.images.ImgPathConstants;

/**
 * It's going to execute JavaScript! Yeah! Totally!
 */
public class JSExecutor {

	@SuppressWarnings("unused")
	private static String moduleDirectory;

	private static JSPokemonEngineHandler pokemonEngineHandler;

	private static JSPokemonHandler pokemonHandlerTHIS;
	private static JSPokemonHandler pokemonHandlerTARGET;

	private static ScriptEngine jsEngine;
	private static Bindings binds;

	@SuppressWarnings("unused")
	private static ImgPathConstants pathconstants;

	public static void initializeExecutor(String resDirectory) {
		PokemonType.initializeTypes();
		JSPokemonEngineHandler.initializeTypeHandlers();
		System.out.println("Initializing JavaScript...");
		
		//Init scope handlers (THIS, TARGET, etc)
		pokemonHandlerTHIS = new JSPokemonHandler();
		pokemonHandlerTARGET = new JSPokemonHandler();
		
		
		jsEngine = new ScriptEngineManager().getEngineByName("javascript");
		pokemonEngineHandler = new JSPokemonEngineHandler();
		binds = new SimpleBindings();
		binds.put("pokemon", pokemonEngineHandler);
		binds.put("THIS", pokemonHandlerTHIS);
		binds.put("TARGET", pokemonHandlerTARGET);
		class pathconstants implements ImgPathConstants{}
		binds.put("PATH", new pathconstants());
		FileLister fl = new FileLister(resDirectory);

		File[] jsFiles = fl.getFiles();

		for (int i = 0; i < jsFiles.length; i++) {
			FileReader fr;
			try {
				System.out.println("Handling: " + jsFiles[i].getName());
				fr = new FileReader(jsFiles[i]);
				jsEngine.eval(fr, binds);
			} catch (FileNotFoundException e) {
				System.out.println("JSExecutor: File not found");
				e.printStackTrace();
			} catch (ScriptException e) {
				System.out.println("JSExecutor: Script error");
				e.printStackTrace();
			}

		}

	}

	public static void evaluate(String eval) {

		try {
			jsEngine.eval(eval, binds);
		} catch (ScriptException e) {
			System.out
					.println("Javascript error. Javascript error. Javascript error.");
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	public static void loadPokemon() {
		FileLister fl = new FileLister("res/pokemon");
		File[] pokemonFiles = fl.getFiles();
	}

	public static void setBind(String bindString, Object bindTo) {
		binds.put(bindString, bindTo);
	}

	public static void setThisScope(PokemonCreature scope) {
		pokemonHandlerTHIS.setHandle(scope);
	}
	
	public static void setTargetScope(PokemonCreature scope) {
		pokemonHandlerTARGET.setHandle(scope);
	}

}
