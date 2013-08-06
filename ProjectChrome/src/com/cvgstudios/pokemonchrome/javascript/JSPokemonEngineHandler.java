package com.cvgstudios.pokemonchrome.javascript;

import java.util.Vector;

import com.cvgstudios.pokemonchrome.gamelogic.PokemonType;

public class JSPokemonEngineHandler {

	private static Vector<JSPokemonTypeHandler> pokemonTypes;

	public static void initializeTypeHandlers() {
		pokemonTypes = new Vector<JSPokemonTypeHandler>();
	}

	public static void register_pokemon(String pokemonName) {
		PokemonType.addPokemon(pokemonName);
		JSExecutor.evaluate(pokemonName + " = new Object()");
		JSPokemonTypeHandler newTypeHandler = new JSPokemonTypeHandler(
				PokemonType.getPokemon(pokemonName));
		pokemonTypes.add(newTypeHandler);
		JSExecutor.setBind(pokemonName, newTypeHandler);
	}

}
