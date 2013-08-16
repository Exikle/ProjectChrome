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
				middle - font.getBounds("DESIGN/WRITING").width / 2,
				-125 + movingY);

		font.setScale(.9f);
		font.draw(batch, "Creative Director",
				middle - font.getBounds("Creative Director").width
						/ 2, -175 + movingY);

		font.draw(
				batch,
				"Arvin Zaldivar(AFK/MIA)",
				middle
						- font.getBounds("Arvin Zaldivar(AFK/MIA)").width
						/ 2, -200 + movingY);

		font.draw(batch, "Level Designer",
				middle - font.getBounds("Level Designer").width / 2,
				-250 + movingY);

		font.draw(batch, "Gabriel Marc",
				middle - font.getBounds("Gabriel Marc").width / 2,
				-275 + movingY);

		font.draw(batch, "Julius D'Silva",
				middle - font.getBounds("Julius D'Silva").width / 2,
				-300 + movingY);
		// ///

		font.setScale(1.1f);
		font.draw(
				batch,
				"PROGRAMMING/ENGINEERING",
				middle
						- font.getBounds("PROGRAMMING/ENGINEERING").width
						/ 2, -400 + movingY);

		font.setScale(.9f);
		font.draw(batch, "Program Manager",
				middle - font.getBounds("Program Manager").width / 2,
				-450 + movingY);

		font.draw(batch, "Julius D'Silva",
				middle - font.getBounds("Julius D'Silva").width / 2,
				-475 + movingY);

		font.draw(batch, "Lead Programmer",
				middle - font.getBounds("Lead Programmer").width / 2,
				-525 + movingY);

		font.draw(
				batch,
				"Mark 'qmpzaltb' Bouchkevitch",
				middle
						- font.getBounds("Mark 'qmpzaltb' Bouchkevitch").width
						/ 2, -550 + movingY);

		font.draw(
				batch,
				"Dixon 'Exikle' D'Cunha",
				middle
						- font.getBounds("Dixon 'Exikle' D'Cunha").width
						/ 2, -575 + movingY);

		font.draw(batch, "Battle Programmer",
				middle - font.getBounds("Battle Programmer").width
						/ 2, -625 + movingY);

		font.draw(
				batch,
				"Mark 'qmpzaltb' Bouchkevitch",
				middle
						- font.getBounds("Mark 'qmpzaltb' Bouchkevitch").width
						/ 2, -650 + movingY);

		font.draw(batch, "Gameplay Programmer",
				middle - font.getBounds("Gameplay Programmer").width
						/ 2, -700 + movingY);

		font.draw(
				batch,
				"Dixon 'Exikle' D'Cunha",
				middle
						- font.getBounds("Dixon 'Exikle' D'Cunha").width
						/ 2, -725 + movingY);

		font.draw(
				batch,
				"Artificial Intelligence Programmer",
				middle
						- font.getBounds("Artificial Intelligence Programmer").width
						/ 2, -775 + movingY);

		font.draw(
				batch,
				"Mark 'qmpzaltb' Bouchkevitch",
				middle
						- font.getBounds("Mark 'qmpzaltb' Bouchkevitch").width
						/ 2, -800 + movingY);

		font.draw(batch, "Graphics Programmer",
				middle - font.getBounds("Graphics Programmer").width
						/ 2, -850 + movingY);

		font.draw(
				batch,
				"Dixon 'Exikle' D'Cunha",
				middle
						- font.getBounds("Dixon 'Exikle' D'Cunha").width
						/ 2, -875 + movingY);

		font.draw(batch, "Julius D'Silva",
				middle - font.getBounds("Julius D'Silva").width / 2,
				-900 + movingY);

		font.draw(
				batch,
				"User Interface Programmer",
				middle
						- font.getBounds("User Interface Programmer").width
						/ 2, -950 + movingY);

		font.draw(
				batch,
				"Dixon 'Exikle' D'Cunha",
				middle
						- font.getBounds("Dixon 'Exikle' D'Cunha").width
						/ 2, -975 + movingY);

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