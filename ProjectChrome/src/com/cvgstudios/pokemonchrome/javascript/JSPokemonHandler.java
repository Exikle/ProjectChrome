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

	public void change_hp(int change) {
		handledPokemon.setHP(Math.max(Math.min(get_hp() + change, get_hp()), 0));
	}

	public void set_hp(int hp) {
		handledPokemon.setHP(hp);
	}

	public void set_battle_attack(int attack) {
		handledPokemon.setBattleAttack(attack);
	}

	public void set_battle_defense(int defense) {
		handledPokemon.setBattleDefense(defense);
	}

	public void set_battle_sp_attack(int spAttack) {
		handledPokemon.setBattleSpAttack(spAttack);
	}

	public void set_battle_sp_defense(int spDefense) {
		handledPokemon.setBattleSpDefense(spDefense);
	}

	public void set_battle_speed(int speed) {
		handledPokemon.setBattleSpeed(speed);
	}

	public void set_pokemon_attack(int attack) {
		handledPokemon.setPokemonAttack(attack);
	}

	public void set_pokemon_defense(int defense) {
		handledPokemon.setPokemonDefense(defense);
	}

	public void set_pokemon_sp_attack(int spAttack) {
		handledPokemon.setPokemonSpAttack(spAttack);
	}

	public void set_pokemon_sp_defense(int spDefense) {
		handledPokemon.setPokemonSpDefense(spDefense);
	}

	public void set_pokemon_speed(int speed) {
		handledPokemon.setPokemonSpeed(speed);
	}

	public int get_hp() {
		return handledPokemon.getHP();
	}

	public int get_max_hp() {
		return handledPokemon.getHPMax();
	}

	public int get_battle_attack() {
		return handledPokemon.getBattleAttack();
	}

	public int get_battle_defense() {
		return handledPokemon.getBattleDefense();
	}

	public int get_battle_sp_attack() {
		return handledPokemon.getBattleSpAttack();
	}

	public int get_battle_sp_defense() {
		return handledPokemon.getBattleSpDefense();
	}

	public int get_battle_speed() {
		return handledPokemon.getBattleSpeed();
	}

	public int get_pokemon_attack() {
		return handledPokemon.getPokeAttack();
	}

	public int get_pokemon_defense() {
		return handledPokemon.getPokeDefense();
	}

	public int get_pokemon_sp_attack() {
		return handledPokemon.getPokeSpAttack();
	}

	public int get_pokemon_sp_defense() {
		return handledPokemon.getPokeSpDefense();
	}

	public int get_pokemon_speed() {
		return handledPokemon.getPokeSpeed();
	}

}
