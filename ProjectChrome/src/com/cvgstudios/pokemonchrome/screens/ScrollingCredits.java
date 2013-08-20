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
import com.cvgstudios.pokemonchrome.script.ScriptImporter;

public class ScrollingCredits implements Screen {

	private ChromeGame game;

	private final Sprite logo = new Sprite(new Texture(
			"imgs/BlackTitleScreen.png"));

	private SpriteBatch batch;

	private BitmapFont font = new BitmapFont();

	private String[] script;

	private String[] hold;

	private int counter = 0;

	private int len;

	private float movingY = 0;

	private int lineNum = 0;

	private final float mid = Gdx.graphics.getWidth() / 2;

	private final String XID = "Xid Studios";

	private String string;

	private final Map<String, String> EMPLOYES = new HashMap<String, String>();
	{
		EMPLOYES.put("MARK", "Mark 'qmpzaltb' Bouchkevitch");
		EMPLOYES.put("DIXON", "Dixon 'Exikle' D'Cunha");
		EMPLOYES.put("JULIUS", "Julius D'Silva");
		EMPLOYES.put("GABE", "Gabriel Marc");
		EMPLOYES.put("ARVIN", "Arvin Zaldivar(AFK/MIA)");
		EMPLOYES.put("NIKO", "Niko Katerelos");
		EMPLOYES.put("ROFEL", "Rofel Ganado");
		EMPLOYES.put("TOMMY", "Tommy Huynh");

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
		processScript();
	}

	private void processScript() {
		script = ScriptImporter.iScript("credits.script");
		len = script.length - 1;
		Gdx.app.log(ChromeGame.LOG, "Processed Credits Script");
	}

	private String getLine(int n) {
		String[] hold = script[n].split(":");
		switch (hold[0]) {
			case "DEPT":
				return DEPT.get(hold[1]);
			case "POS":
				return hold[1];
			case "EMPLOYE":
				return EMPLOYES.get(hold[1]);
			default:
				return "";
		}
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(logo, 0, 0 + movingY);
		renderScript(batch);
		batch.end();

		movingY += 1.5f;
		Gdx.app.log(ChromeGame.LOG, movingY + "");

		checkChangeScreen();

	}

	private void checkChangeScreen() {
		if (movingY == 3000) {
			game.setScreen(new MainMenu(game));
		}
	}

	private void renderScript(SpriteBatch batch) {
		for (int x = 0; x < len; x++) {
			string = getLine(x);
			float t = setFontScale(x);
			font.scale(t);
			font.draw(batch, string, mid
					- font.getBounds(string).width / 2,
					(-100 - (35 * lineNum)) + movingY);
			lineNum++;
			font.setScale(1f);
		}
		lineNum = 0;
	}

	private float setFontScale(int line) {
		String[] hold = script[line].split(":");
		float scale = 1;
		switch (hold[0]) {
			case "POS":
				scale = 1f;
				break;
			case "EMPLOYE":
				scale = .5f;
				break;
			case "DEPT":
				scale = 1.5f;
				break;
		}
		return scale;

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