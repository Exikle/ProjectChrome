package com.cvgstudios.pokemonchrome;

import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class RunAndroidChrome extends AndroidApplication {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		cfg.useGL20 = true;

		Gdx.app.log(ChromeGame.LOG,
				"Attempting to make Android Chrome Work");
		initialize(new ChromeGame(), cfg);
	}
}