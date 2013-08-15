package com.cvgstudios.pokemonchrome;

import com.badlogic.gdx.tools.hiero.Hiero;

public class GDXHiero {

	public static void main(String[] args){
		try {
			Hiero.main(args);
		} catch (Exception e) {
			System.err.println("Hiero derped hard");
			e.printStackTrace();
		}
	}
	
	
}
