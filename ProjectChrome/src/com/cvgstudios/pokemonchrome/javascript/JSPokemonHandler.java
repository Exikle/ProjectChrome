package com.cvgstudios.pokemonchrome.javascript;

import com.cvgstudios.pokemonchrome.gamelogic.PokemonCreature;

public class JSPokemonHandler {

	PokemonCreature handledPokemon;

	public void setHandle(PokemonCreature handlingPokemon) {
		handledPokemon = handlingPokemon;
	}

	public JSPokemonHandler() {

	}
	
	public void set_action_allowed(String actioncodename) {
		handledPokemon.setActionAvailability(actioncodename, true);
	}

	public void set_action_disallowed(String actioncodename) {
		handledPokemon.setActionAvailability(actioncodename, false);
	}

	public void set_type(String type) {
		handledPokemon.setType(type);
	}

	public void set_iv_hp(int hp) {
		handledPokemon.setIvHP(hp);
	}

	public void set_iv_attack(int attack) {
		handledPokemon.setIvAttack(attack);
	}

	public void set_iv_defense(int defense) {
		handledPokemon.setIvDefense(defense);
	}

	public void set_iv_sp_attack(int spAttack) {
		handledPokemon.setIvSpAttack(spAttack);
	}

	public void set_iv_sp_defense(int spDefense) {
		handledPokemon.setIvSpDefense(spDefense);
	}

	public void set_iv_speed(int speed) {
		handledPokemon.setIvSpeed(speed);
	}



	public int get_hp(){
		return handledPokemon.getHP();
	}
	public int get_max_hp(){
		return handledPokemon.getHPMax();
	}
	public int get_battle_attack(){
		return handledPokemon.getBattleAttack();
	}
	public int get_battle_defense(){
		return handledPokemon.getBattleDefense();
	}
	public int get_battle_sp_attack(){
		return handledPokemon.getBattleSpAttack();
	}
	public int get_battle_sp_defense(){
		return handledPokemon.getBattleSpDefense();
	}
	public int get_battle_speed(){
		return handledPokemon.getBattleSpeed();
	}
	public int get_normal_attack(){
		return handledPokemon.getPokeAttack();
	}
	public int get_normal_defense(){
		return handledPokemon.getPokeDefense();
	}
	public int get_normal_sp_attack(){
		return handledPokemon.getPokeSpAttack();
	}
	public int get_normal_sp_defense(){
		return handledPokemon.getPokeSpDefense();
	}
	public int get_normal_speed(){
		return handledPokemon.getPokeSpeed();
	}
	

}
