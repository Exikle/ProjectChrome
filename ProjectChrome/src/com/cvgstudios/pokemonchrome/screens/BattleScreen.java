package com.cvgstudios.pokemonchrome.screens;

import java.util.Vector;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cvgstudios.pokemonchrome.ChromeGame;
import com.cvgstudios.pokemonchrome.gamelogic.PokemonCreature;
import com.cvgstudios.pokemonchrome.images.Graphic;

public class BattleScreen implements Screen, InputProcessor {

	public static final String STR_FIGHT = "FIGHT";
	public static final String STR_POKEMON = "POKÈMON";
	public static final String STR_BAG = "BAG";
	public static final String STR_RUN = "RUN";





	public static final int HUD_BAR_HEIGHT = 187;
	public static final float PLAYER_POKEMON_Y_BACKGROUND_PERCENT_POSITION = 0.12f; // twelve
	// percent
	// background
	// height
	// from
	// the
	// guibar
	public static final float PLAYER_POKEMON_X_PERCENT_POSITION = 0.20f; // twenty
	// percent
	// screen
	// width
	// from
	// the
	// left

	public static final float ENEMY_POKEMON_Y_BACKGROUND_PERCENT_POSITION = 0.46f;
	public static final float ENEMY_POKEMON_X_PERCENT_POSITION = 0.68f;


	public static float MENU_BUTTON_1_X_PERC = 0.295f;
	public static float MENU_BUTTON_1_Y_PERC = 0.395f;
	public static float MENU_BUTTON_2_X_PERC = 0.516f;
	public static float MENU_BUTTON_2_Y_PERC = 0.395f;
	public static float MENU_BUTTON_3_X_PERC = 0.313f;
	public static float MENU_BUTTON_3_Y_PERC = 0.112f;
	public static float MENU_BUTTON_4_X_PERC = 0.500f;
	public static float MENU_BUTTON_4_Y_PERC = 0.112f;

	BitmapFont guiFont;
	SpriteBatch batch;

	PokemonCreature playerPokemon;
	PokemonCreature enemyPokemon;

	boolean downButton;
	boolean upButton;

	int buttonSelect = 1;

	Vector<String> actionList;
	Vector<String> actionNameList;
	int selectedActionIndex;

	BattleState battleState;

	Texture battleBackgroundTexture;
	Texture statBarPlayer;
	Texture statBarEnemy;
	Texture hudBar;
	Texture hudSelect;

	Texture playerPokemonTexture;
	Texture enemyPokemonTexture;

	Texture playerCharacter;
	Texture enemyCharacter;

	public BattleScreen() {
		super();
		battleState = BattleState.LOADING;
		Gdx.input.setInputProcessor(this);
		batch = new SpriteBatch();
		guiFont = new BitmapFont(Gdx.files.internal("font/pokemon.fnt"), Gdx.files.internal("font/pokemon.png"), false);
		// Something about setting up the fonts, perhaps?
		battleBackgroundTexture = Graphic.GrassBattleSetting.getTexture();
		statBarPlayer = Graphic.PlayerPokemonStatBar.getTexture();
		statBarEnemy = Graphic.EnemyPokemonStatBar.getTexture();
		hudBar = Graphic.BattleScreenMenu.getTexture();
		hudSelect = Graphic.BattleScreenMenuSelect.getTexture();
	}

	public void setPlayerPokemon(PokemonCreature pokemon) {
		battleState = BattleState.LOADING;
		playerPokemon = pokemon;
		actionList = new Vector<String>();
		actionNameList = new Vector<String>();

		playerPokemonTexture = playerPokemon.getType().getBackTexture();

		for (int i = 0; i < pokemon.getType().getActions().size(); i++) {
			if (pokemon.getActionAvailability(i)) {
				actionList.add(pokemon.getType().getActions().get(i));
				actionNameList.add(pokemon.getType().getActionNames().get(i));
			}
		}

		battleState = BattleState.PLAYER_CHOOSING_ACTION;

	}

	public void setEnemyPokemon(PokemonCreature pokemon) {
		battleState = BattleState.LOADING;

		enemyPokemon = pokemon;
		enemyPokemonTexture = enemyPokemon.getType().getFrontTexture();

		battleState = BattleState.PLAYER_CHOOSING_ACTION;
	}

	public void render(float delta) {
		int displayWidth = ChromeGame.display.getDisplayWidth();
		int displayHeight = ChromeGame.display.getDisplayHeight();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();

		switch (battleState) {

		case LOADING: {
			guiFont.draw(batch, "Loading...", 100, 100);
			break;
		}
		case PLAYER_CHOOSING_ACTION: {
			// Draws battle background
			batch.draw(battleBackgroundTexture, 0, HUD_BAR_HEIGHT, displayWidth, displayHeight - HUD_BAR_HEIGHT);
			// Draws choice menu
			batch.draw(hudBar, 0, 0, displayWidth, HUD_BAR_HEIGHT);
			// Draws player pokemon
			batch.draw(playerPokemonTexture, (displayWidth * PLAYER_POKEMON_X_PERCENT_POSITION), (HUD_BAR_HEIGHT + PLAYER_POKEMON_Y_BACKGROUND_PERCENT_POSITION * (displayHeight - HUD_BAR_HEIGHT)));
			// Draws enemy pokemon
			batch.draw(enemyPokemonTexture, (displayWidth * ENEMY_POKEMON_X_PERCENT_POSITION), (HUD_BAR_HEIGHT + ENEMY_POKEMON_Y_BACKGROUND_PERCENT_POSITION * (displayHeight - HUD_BAR_HEIGHT)));


			guiFont.setColor(Color.RED);
			guiFont.setScale(1.2f);

			float x1 = 0.385f * displayWidth;
			float y1 = 0.542f * HUD_BAR_HEIGHT;

			float x2 = 0.602f * displayWidth;
			float y2 = 0.542f * HUD_BAR_HEIGHT;

			float x3 = 0.397f * displayWidth;
			float y3 = 0.250f * HUD_BAR_HEIGHT;

			float x4 = 0.585f * displayWidth;
			float y4 = 0.250f * HUD_BAR_HEIGHT;

			drawStringCentered(guiFont, STR_FIGHT, x1, y1);
			drawStringCentered(guiFont, STR_POKEMON, x2, y2);

			guiFont.setColor(Color.WHITE);
			drawStringCentered(guiFont, STR_BAG, x3, y3);
			drawStringCentered(guiFont, STR_RUN, x4, y4);

			float hudStretch = ((float) hudBar.getHeight() / (float) HUD_BAR_HEIGHT);

			switch (buttonSelect){
			case 1:{
				batch.draw(hudSelect, MENU_BUTTON_1_X_PERC * displayWidth, MENU_BUTTON_1_Y_PERC * HUD_BAR_HEIGHT, hudSelect.getWidth() * hudStretch, hudSelect.getHeight() * hudStretch);
				break;
			}
			case 2:{
				batch.draw(hudSelect, MENU_BUTTON_2_X_PERC * displayWidth, MENU_BUTTON_2_Y_PERC * HUD_BAR_HEIGHT, hudSelect.getWidth() * hudStretch, hudSelect.getHeight() * hudStretch);
				break;
			}
			case 3:{
				batch.draw(hudSelect, MENU_BUTTON_3_X_PERC * displayWidth, MENU_BUTTON_3_Y_PERC * HUD_BAR_HEIGHT, hudSelect.getWidth() * hudStretch, hudSelect.getHeight() * hudStretch);
				break;
			}
			case 4:{
				batch.draw(hudSelect, MENU_BUTTON_4_X_PERC * displayWidth, MENU_BUTTON_4_Y_PERC * HUD_BAR_HEIGHT, hudSelect.getWidth() * hudStretch, hudSelect.getHeight() * hudStretch);
				break;
			}
			} 





			break;
		}
		case PLAYER_CHOOSING_ATTACK: {
			// Draws battle background
			batch.draw(battleBackgroundTexture, 0, HUD_BAR_HEIGHT, displayWidth, displayHeight - HUD_BAR_HEIGHT);
			// Draws choice menu
			batch.draw(hudBar, 0, 0, displayWidth, HUD_BAR_HEIGHT);
			// Draws player pokemon
			batch.draw(playerPokemonTexture, (displayWidth * PLAYER_POKEMON_X_PERCENT_POSITION), (HUD_BAR_HEIGHT + PLAYER_POKEMON_Y_BACKGROUND_PERCENT_POSITION * (displayHeight - HUD_BAR_HEIGHT)));
			// Draws enemy pokemon
			batch.draw(enemyPokemonTexture, (displayWidth * ENEMY_POKEMON_X_PERCENT_POSITION), (HUD_BAR_HEIGHT + ENEMY_POKEMON_Y_BACKGROUND_PERCENT_POSITION * (displayHeight - HUD_BAR_HEIGHT)));
			guiFont.draw(batch, actionNameList.get(selectedActionIndex), 100, 100);
			break;
		}
		default: {
			guiFont.drawMultiLine(batch, "NOT loading :D", 100, 100);

			break;
		}

		}

		batch.end();
	}

	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	public void show() {
		// TODO Auto-generated method stub
	}

	public void hide() {
		// TODO Auto-generated method stub
	}

	public void pause() {
		// TODO Auto-generated method stub
	}

	public void resume() {
		// TODO Auto-generated method stub
	}

	public void dispose() {
		// TODO Auto-generated method stub
	}

	public boolean keyDown(int keycode) {

		if (battleState == BattleState.PLAYER_CHOOSING_ATTACK) { // If it is
			// currently
			// your turn

			switch (keycode) {

			case (Keys.UP): {

				selectedActionIndex = (selectedActionIndex -= 1) < 0 ? actionNameList.size() - 1 : selectedActionIndex;
				System.out.println(actionNameList.get(selectedActionIndex));
				break;

			}
			case (Keys.DOWN): {

				selectedActionIndex = (selectedActionIndex += 1) % actionNameList.size();
				System.out.println(actionNameList.get(selectedActionIndex));
				break;

			}

			}

		} else if (battleState == BattleState.PLAYER_CHOOSING_ACTION) {


			switch (buttonSelect){
			case 1:{
				switch (keycode){
				case Keys.DOWN:{
					buttonSelect = 3;
					break;
				}
				case Keys.RIGHT:{
					buttonSelect = 2;
					break;
				}
				case Keys.SPACE:{
					battleState = BattleState.PLAYER_CHOOSING_ATTACK;
					break;
				}
				}

				break;	
			}
			case 2:{
				switch (keycode){
				case Keys.DOWN:{
					buttonSelect = 4;
					break;
				}
				case Keys.LEFT:{
					buttonSelect = 1;
					break;
				}
				}
				
				break;	
			}
			case 3:{
				switch (keycode){
				case Keys.UP:{
					buttonSelect = 1;
					break;
				}
				case Keys.RIGHT:{
					buttonSelect = 4;
					break;
				}
				}

				break;	
			}
			case 4:{
				switch (keycode){
				case Keys.UP:{
					buttonSelect = 2;
					break;
				}
				case Keys.LEFT:{
					buttonSelect = 3;
					break;
				}
				}

				break;	
			}




			}






		}



		return false;

	}

	public boolean keyUp(int keycode) {
		return false;
	}

	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		System.out.println("X: " + (screenX / (float) ChromeGame.display.getDisplayWidth()) + "  Y: " + ((ChromeGame.display.getDisplayHeight() - screenY) / (float)HUD_BAR_HEIGHT));
		return false;
	}

	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	private void drawStringCentered(BitmapFont fnt, String str, float x, float y){
		fnt.draw(batch, str, x - fnt.getBounds(str).width / 2, y + fnt.getBounds(str).height / 2);

	}


}

enum BattleState {
	LOADING, PLAYER_CHOOSING_ACTION, PLAYER_CHOOSING_ATTACK, PLAYER_POKEMON_DOING_ACTION, ENEMY_POKEMON_CHOOSING_ACTION, ENEMY_POKEMON_DOING_ACTION, ;

}