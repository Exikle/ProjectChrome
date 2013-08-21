/**
 * 
 */
package com.cvgstudios.pokemonchrome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author Dixon D'Cunha
 */
public class MenuActor extends Actor {

	Texture region;

	public MenuActor() {
		region = new Texture(
				Gdx.files.internal("imgs/OptionBox.png"));
	}

	public void draw(SpriteBatch batch) {
		batch.draw(region, getX(), getY(), getOriginX(), getOriginY());
	}

}
