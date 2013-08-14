package com.cvgstudios.pokemonchrome.gamelogic;

import java.util.Vector;

import com.cvgstudios.pokemonchrome.javascript.JSExecutor;

public class PokemonCreature {

	protected PokemonType theBaseType;

	protected String givenName;

	protected Vector<Boolean> actionsAvailable;

	protected int currentHP;
	protected int currentHPMax;
	
	//Battle stats are a pokemon's in-battle stats. These can change with different buffs/debuffs within a battle, such as what Leer does.
	protected int battleAttack;
	protected int battleDefense;
	protected int battleSpAttack;
	protected int battleSpDefense;
	protected int battleSpeed;
	
	//Pokemon stats are a pokemon's stats overall, as in, when they begin a new battle.
	protected int pokeAttack;
	protected int pokeDefense;
	protected int pokeSpAttack;
	protected int pokeSpDefense;
	protected int pokeSpeed;
	
	//IV stats are IndiVidual stats. They represent each pokemon's uniqueness in stat attributes.
	protected int ivHP;
	protected int ivAttack;
	protected int ivDefense;
	protected int ivSpAttack;
	protected int ivSpDefense;
	protected int ivSpeed;

	private PokemonCreature(PokemonType pokemonType) {
		theBaseType = pokemonType;
		actionsAvailable = new Vector<Boolean>();
		for (@SuppressWarnings("unused")
		String s : theBaseType.actions) {
			actionsAvailable.add(false);
		}
		JSExecutor.setThisScope(this);
	}

	public void setActionAvailability(String actionName, boolean availability) {
		if (theBaseType.actions.contains(actionName)) {
			actionsAvailable.set(theBaseType.actions.indexOf(actionName),
					availability);
		}
	}

	public void setName(String newName) {
		givenName = newName;
	}

	public String getName() {
		return givenName;
	}

	public void setIvHP(int hp) {
		ivHP = hp;
	}

	public void setIvAttack(int attack) {
		ivAttack = attack;
	}

	public void setIvDefense(int defense) {
		ivDefense = defense;
	}

	public void setIvSpAttack(int spAttack) {
		ivSpAttack = spAttack;
	}

	public void setIvSpDefense(int spDefense) {
		ivSpDefense = spDefense;
	}

	public void setIvSpeed(int speed) {
		ivSpeed = speed;
	}

	public PokemonType getType() {
		return theBaseType;
	}
	
	public void setHP(int hp){
		currentHP = hp;
	}
	
	public void setMaxHP(int hp){
		currentHPMax = hp;
	}
	
	public void setBattleAttack(int attack){
		battleAttack = attack;
	}
	public void setBattleDefense(int defense){
		battleDefense = defense;
	}
	public void setBattleSpAttack(int spAttack){
		battleSpAttack = spAttack;
	}
	public void setBattleSpDefense(int spDefense){
		battleSpDefense = spDefense;
	}
	public void setBattleSpeed(int speed){
		battleSpeed = speed;
	}
	public void setPokemonAttack(int attack){
		pokeAttack = attack;
	}
	public void setPokemonDefense(int defense){
		pokeDefense = defense;
	}
	public void setPokemonSpAttack(int spAttack){
		pokeSpAttack = spAttack;
	}
	public void setPokemonSpDefense(int spDefense){
		pokeSpDefense = spDefense;
	}
	public void setPokemonSpeed(int speed){
		pokeSpeed = speed;
	}
	

	public boolean getActionAvailability(int actionIndex) {
		return actionsAvailable.get(actionIndex);
	}

	public boolean getActionAvailability(String actionCodeName) {
		return actionsAvailable
				.get(theBaseType.actions.indexOf(actionCodeName));
	}
	
	public int getHP(){
		return currentHP;
	}
	
	public int getHPMax(){
		return currentHPMax;
	}
	
	public int getBattleAttack(){
		return battleAttack;
	}
	
	public int getBattleDefense(){
		return battleDefense;
	}

	public int getBattleSpAttack(){
		return battleSpAttack;
	}
	
	public int getBattleSpDefense(){
		return battleSpDefense;
	}
	
	public int getBattleSpeed(){
		return battleSpeed;
	}
	
	public int getPokeAttack(){
		return pokeAttack;
	}
	
	public int getPokeDefense(){
		return pokeDefense;
	}

	public int getPokeSpAttack(){
		return pokeSpAttack;
	}
	
	public int getPokeSpDefense(){
		return pokeSpDefense;
	}
	
	public int getPokeSpeed(){
		return pokeSpeed;
	}
	
	public static PokemonCreature makePokemon(PokemonType pokemonType) {
		PokemonCreature newPokemon = new PokemonCreature(pokemonType);
		JSExecutor.setThisScope(newPokemon);
		JSExecutor.evaluate(pokemonType.baseName.concat("_on_spawn()"));
		return newPokemon;
	}

}
