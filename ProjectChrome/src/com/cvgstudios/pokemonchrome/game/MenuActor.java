/**
 * 
 */
package com.cvgstudios.pokemonchrome.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.cvgstudios.pokemonchrome.ChromeGame;

/**
 * @author Dixon D'Cunha
 */
public class MenuActor extends Actor {

	TextureRegion region;

	BitmapFont font;

	private float mid;

	public MenuActor() {
		super();
		region = new TextureRegion();

		region.setRegion(new Texture(Gdx.files
				.internal("imgs/MenuBox.png")));
		font = new BitmapFont(Gdx.files.internal("font/pokemon.fnt"),
				Gdx.files.internal("font/pokemon.png"), false);
		font.setScale(2f);

		mid = this.getWidth() / 2;
	}

	public void save() {
		Gdx.app.log(ChromeGame.LOG, "Saved");
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(region, 0, 0, region.getRegionWidth(),
				region.getRegionHeight());
		font.setColor(Color.BLACK);
		font.draw(batch, "SAVE", mid + font.getBounds("SAVE").width
				/ 2, 150);

	}
}
