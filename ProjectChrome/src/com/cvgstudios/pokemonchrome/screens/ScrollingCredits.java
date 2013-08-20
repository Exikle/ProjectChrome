package com.cvgstudios.pokemonchrome.screens;

import java.util.HashMap;
import java.util.Map;

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

	float m = Gdx.graphics.getWidth() / 2;

	private final String MARK = "Mark 'qmpzaltb' Bouchkevitch";

	private final String DIXON = "Dixon 'Exikle' D'Cunha";

	private final String JULIUS = "Julius D'Silva";

	private final String GABE = "Gabriel Marc";

	private final String ARVIN = "Arvin Zaldivar(AFK/MIA)";

	private final String XID = "Xid Studios";

	private final Map<String, String> EMPLOYES = new HashMap<String, String>();
	{
		EMPLOYES.put("MARK", "Mark 'qmpzaltb' Bouchkevitch");
		EMPLOYES.put("DIXON", "Dixon 'Exikle' D'Cunha");
		EMPLOYES.put("JULIUS", "Julius D'Silva");
		EMPLOYES.put("GABE", "Gabriel Marc");
		EMPLOYES.put("ARVIN", "Arvin Zaldivar(AFK/MIA)");
		EMPLOYES.put("NIKO", "Niko Katerelos");
		EMPLOYES.put("ROFEL", "Rofel Ganado");
	}

	private final Map<String, String> DEPT = new HashMap<String, String>();
	{
		DEPT.put("PROG_DEPT", "PROGRAMMING/ENGINEERING");
		DEPT.put("DES_DEPT", "DESIGN/WRITING");
		DEPT.put("ART_DEPT", "VISUAL ARTS");
		DEPT.put("SOUND_DEPT", "AUDIO");
	}

	public ScrollingCredits(ChromeGame game) {
		this.game = game;
		// String dept = "PROG_DEPT";
		// String deptName = DEPT.get(dept);
		// System.out.println(deptName); // outputs "PROGRAMMING/ENGINEERING"
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(logo, 0, 0 + movingY);

		// TODO make a shorter version of this all

		// font.draw(batch, STRING,
		// m - font.getBounds(STRING).width / 2, (-125-(50*lineNum))
		// + movingY);

		font.setScale(1.1f);
		font.draw(batch, "DESIGN/WRITING",
				m - font.getBounds("DESIGN/WRITING").width / 2, -125
						+ movingY);

		font.setScale(.9f);
		font.draw(batch, "Creative Director",
				m - font.getBounds("Creative Director").width / 2,
				-175 + movingY);

		font.draw(batch, ARVIN, m - font.getBounds(ARVIN).width / 2,
				-200 + movingY);

		font.draw(batch, "Level Designer",
				m - font.getBounds("Level Designer").width / 2, -250
						+ movingY);

		font.draw(batch, GABE, m - font.getBounds(GABE).width / 2,
				-275 + movingY);

		font.draw(batch, JULIUS,
				m - font.getBounds(JULIUS).width / 2, -300 + movingY);
		// ///

		font.setScale(1.1f);
		font.draw(batch, "PROGRAMMING/ENGINEERING",
				m - font.getBounds("PROGRAMMING/ENGINEERING").width
						/ 2, -400 + movingY);

		font.setScale(.9f);
		font.draw(batch, "Program Manager",
				m - font.getBounds("Program Manager").width / 2, -450
						+ movingY);

		font.draw(batch, JULIUS,
				m - font.getBounds(JULIUS).width / 2, -475 + movingY);

		font.draw(batch, "Lead Programmer",
				m - font.getBounds("Lead Programmer").width / 2, -525
						+ movingY);

		font.draw(batch, MARK, m - font.getBounds(MARK).width / 2,
				-550 + movingY);

		font.draw(batch, DIXON, m - font.getBounds(DIXON).width / 2,
				-575 + movingY);

		font.draw(batch, "Battle Programmer",
				m - font.getBounds("Battle Programmer").width / 2,
				-625 + movingY);

		font.draw(batch, MARK, m - font.getBounds(MARK).width / 2,
				-650 + movingY);

		font.draw(batch, "Gameplay Programmer",
				m - font.getBounds("Gameplay Programmer").width / 2,
				-700 + movingY);

		font.draw(batch, DIXON, m - font.getBounds(DIXON).width / 2,
				-725 + movingY);

		font.draw(
				batch,
				"Artificial Intelligence Programmer",
				m
						- font.getBounds("Artificial Intelligence Programmer").width
						/ 2, -775 + movingY);

		font.draw(batch, MARK, m - font.getBounds(MARK).width / 2,
				-800 + movingY);

		font.draw(batch, "Graphics Programmer",
				m - font.getBounds("Graphics Programmer").width / 2,
				-850 + movingY);

		font.draw(batch, DIXON, m - font.getBounds(DIXON).width / 2,
				-875 + movingY);

		font.draw(batch, JULIUS,
				m - font.getBounds(JULIUS).width / 2, -900 + movingY);

		font.draw(batch, "User Interface Programmer",
				m - font.getBounds("User Interface Programmer").width
						/ 2, -950 + movingY);

		font.draw(batch, DIXON, m - font.getBounds(DIXON).width / 2,
				-975 + movingY);

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