package com.cvgstudios.pokemonchrome.screens;

import java.util.Vector;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cvgstudios.pokemonchrome.gamelogic.PokemonCreature;

public class BattleScreen implements Screen, InputProcessor{

	BitmapFont guiFont;
	SpriteBatch batch;
	
	PokemonCreature playerPokemon;
	PokemonCreature enemyPokemon;

	boolean downButton;
	boolean upButton;

	Vector<String> actionList;
	Vector<String> actionNameList;
	int selectedActionIndex;

	BattleState battleState;
	
	
	Texture battleBackgroundTexture;
	
	Texture playerPokemonTexture;
	Texture enemyPokemonTexture;
	
	Texture playerCharacter;
	Texture enemyCharacter;

	public BattleScreen(){
		super();
		battleState = BattleState.LOADING;
		Gdx.input.setInputProcessor(this);
		batch = new SpriteBatch();
		guiFont = new BitmapFont();
		//Something about setting up the fonts, perhaps?


	}

	public void setPlayerPokemon(PokemonCreature pokemon){
		battleState = BattleState.LOADING;
		playerPokemon = pokemon;
		actionList = new Vector<String>();
		actionNameList = new Vector<String>();

		for (int i = 0; i < pokemon.getType().getActions().size(); i ++){
			System.out.println("YO YO YO THIS IS A NEW ACTION BRO");
			if (pokemon.getActionAvailability(i)){
				actionList.add(pokemon.getType().getActions().get(i));
				actionNameList.add(pokemon.getType().getActionNames().get(i));
			}
		}
		
		
		
		battleState = BattleState.PLAYER_CHOOSING_ACTION;

	}

	public void setEnemyPokemon(PokemonCreature pokemon){
		enemyPokemon = pokemon;
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		
		switch(battleState){
		
		case LOADING:{
			guiFont.draw(batch, "Loading...", 100, 100);
			break;
		}
		case PLAYER_CHOOSING_ACTION:{
			guiFont.draw(batch, actionNameList.get(selectedActionIndex), 100, 100);
			break;
		}
		default:{
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


		if (battleState == BattleState.PLAYER_CHOOSING_ACTION){ //If it is currently your turn

			switch(keycode){
			case(Keys.DOWN):{
				
				selectedActionIndex = (selectedActionIndex + 1) % actionNameList.size(); 
				System.out.println(actionNameList.get(selectedActionIndex));
				
			}
			case(Keys.UP):{

				selectedActionIndex = (selectedActionIndex -= 1) < 0 ? actionNameList.size() - 1 : selectedActionIndex; 
				System.out.println(actionNameList.get(selectedActionIndex));

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
		// TODO Auto-generated method stub
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

}

enum BattleState{
	LOADING,
	PLAYER_CHOOSING_ACTION,
	PLAYER_POKEMON_DOING_ACTION,
	ENEMY_POKEMON_CHOOSING_ACTION,
	ENEMY_POKEMON_DOING_ACTION,
	;

}