/**
 * 
 */
package com.cvgstudios.pokemonchrome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author Dixon D'Cunha
 */
public class MenuActor extends Actor {

	TextureRegion region;

	public MenuActor() {
		super();
		region = new TextureRegion();

		region.setRegion(new Texture(Gdx.files
				.internal("imgs/MenuBox.png")));
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(region, 0, 0, region.getRegionWidth(),
				region.getRegionHeight());

	}

}
