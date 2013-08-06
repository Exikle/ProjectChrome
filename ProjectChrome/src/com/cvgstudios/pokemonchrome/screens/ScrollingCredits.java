package com.cvgstudios.pokemonchrome.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cvgstudios.pokemonchrome.ChromeGame;

public class ScrollingCredits implements Screen {
	ChromeGame game;
	Sprite logo = new Sprite(new Texture("imgs/BlackTitleScreen.png"));
	SpriteBatch batch;

	BitmapFont font = new BitmapFont();

	float movingY = 0;
	float middle = Gdx.graphics.getWidth() / 2;

	public ScrollingCredits(ChromeGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(logo, 0, 0 + movingY);

		font.setScale(1.1f);
		font.draw(batch, "DESIGN/WRITING",
				middle - font.getBounds("DESIGN/WRITING").width / 2, -125
						+ movingY);
		
		font.setScale(.9f);
		font.draw(batch, "Creative Director",
				middle - font.getBounds("Creative Director").width / 2, -175
						+ movingY);

		font.draw(batch, "Arvin Zaldivar",
				middle - font.getBounds("Arvin Zaldivar").width / 2, -200
						+ movingY);

		font.draw(batch, "Level Designer",
				middle - font.getBounds("Level Designer").width / 2, -250
						+ movingY);

		font.draw(batch, "Gabriel Marc",
				middle - font.getBounds("Gabriel Marc").width / 2, -275
						+ movingY);

		font.draw(batch, "Julius D'Silva",
				middle - font.getBounds("Julius D'Silva").width / 2, -300
						+ movingY);

		font.setScale(1.1f);
		font.draw(batch, "PROGRAMMING/ENGINEERING",
				middle - font.getBounds("PROGRAMMING/ENGINEERING").width / 2, -400
						+ movingY);

		batch.end();

		movingY += 1.5f;

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		batch = new SpriteBatch();
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

}