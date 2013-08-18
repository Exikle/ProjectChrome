package com.cvgstudios.pokemonchrome.gamelogic;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import com.badlogic.gdx.graphics.Texture;

/**
 * A class that describes a "type" of pokemon. So, a class that describes
 * Charizards in general, or Kirbys in general.
 * 
 * @author qmpzaltb
 */

public class PokemonType {

	/**
	 * The types of pokemon
	 */
	protected static Vector<PokemonType> typesOfPokemon;

	/**
	 * The actions
	 */
	protected Vector<String> actions;

	/**
	 * The action's names
	 */
	protected Vector<String> actionNames;

	/**
	 * The base name
	 */
	protected String baseName;

	/**
	 * The type of the name
	 */
	protected String typeName;

	/**
	 * An array of types
	 */
	protected String[] types;

	/**
	 * The ID of the type
	 */
	protected int typeID;

	/**
	 * The base HP
	 */
	protected int baseHP;

	/**
	 * The base attack
	 */
	protected int baseAttack;

	/**
	 * The base defence
	 */
	protected int baseDefense;

	/**
	 * The base special attack
	 */
	protected int baseSpAttack;

	/**
	 * The base special defense
	 */
	protected int baseSpDefense;

	/**
	 * The base speed
	 */
	protected int baseSpeed;

	/**
	 * The front image
	 */
	protected Image frontImage;

	/**
	 * The back image
	 */
	protected Image backImage;

	/**
	 * The front texture
	 */
	protected Texture frontTexture;

	/**
	 * The back texture
	 */
	protected Texture backTexture;

	/**
	 * Constructor
	 * 
	 * @param basePokemonName
	 */
	public PokemonType(String basePokemonName) {
		baseName = basePokemonName;
		actions = new Vector<String>();
		actionNames = new Vector<String>();
	}

	/**
	 * @return the actions
	 */
	public Vector<String> getActions() {
		return actions;
	}

	/**
	 * @return the actionNames
	 */
	public Vector<String> getActionNames() {
		return actionNames;
	}

	/**
	 * @return the frontTexture
	 */
	public Texture getFrontTexture() {
		return frontTexture;
	}

	/**
	 * @return the backTexture
	 */
	public Texture getBackTexture() {
		return backTexture;
	}

	/**
	 * @param Set
	 *            the typeName with typeName
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @param Set
	 *            the types with types
	 */
	public void setTypes(String[] types) {
		this.types = types;
	}

	/**
	 * Check it the list has a type
	 * 
	 * @return true/false
	 */
	public boolean hasType(String type) {
		for (String t : types) {
			if (t.equalsIgnoreCase(type)) {
				return true;
			}

		}
		return false;
	}

	/**
	 * @param Set
	 *            the frontImage with the image
	 */
	public void setFrontImage(String filepath) {
		try {
			System.out.print("Loading " + filepath);
			frontImage = ImageIO.read(new File(filepath));
		} catch (IOException e) {
			System.out.print(" File IO error!");
			// e.printStackTrace();
		} finally {
			System.out.println();
		}
	}

	/**
	 * @param Set
	 *            the backImage with the image
	 */
	public void setBackImage(String filepath) {
		try {
			System.out.print("Loading " + filepath);
			backImage = ImageIO.read(new File(filepath));
		} catch (IOException e) {
			System.out.print(" File IO error!");
			// e.printStackTrace();
		} finally {
			System.out.println();
		}
	}

	/**
	 * @param Set
	 *            the typesOfPokemon with typesOfPokemon
	 */
	public static void setTypesOfPokemon(
			Vector<PokemonType> typesOfPokemon) {
		PokemonType.typesOfPokemon = typesOfPokemon;
	}

	/**
	 * @param Set
	 *            the actions with actions
	 */
	public void setActions(Vector<String> actions) {
		this.actions = actions;
	}

	/**
	 * @param Set
	 *            the actionNames with actionNames
	 */
	public void setActionNames(Vector<String> actionNames) {
		this.actionNames = actionNames;
	}

	/**
	 * @param Set
	 *            the baseName with baseName
	 */
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	/**
	 * @param Set
	 *            the typeID with typeID
	 */
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	/**
	 * @param Set
	 *            the baseHP with baseHP
	 */
	public void setHP(int baseHP) {
		this.baseHP = baseHP;
	}

	/**
	 * @param Set
	 *            the baseAttack with baseAttack
	 */
	public void setAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}

	/**
	 * @param Set
	 *            the baseDefense with baseDefense
	 */
	public void setDefense(int baseDefense) {
		this.baseDefense = baseDefense;
	}

	/**
	 * @param Set
	 *            the baseSpAttack with baseSpAttack
	 */
	public void setSpAttack(int baseSpAttack) {
		this.baseSpAttack = baseSpAttack;
	}

	/**
	 * @param Set
	 *            the baseSpDefense with baseSpDefense
	 */
	public void setSpDefense(int baseSpDefense) {
		this.baseSpDefense = baseSpDefense;
	}

	/**
	 * @param Set
	 *            the baseSpeed with baseSpeed
	 */
	public void setSpeed(int baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	/**
	 * @param Set
	 *            the frontImage with frontImage
	 */
	public void setFrontImage(Image frontImage) {
		this.frontImage = frontImage;
	}

	/**
	 * @param Set
	 *            the backImage with backImage
	 */
	public void setBackImage(Image backImage) {
		this.backImage = backImage;
	}

	/**
	 * @param Set
	 *            the frontTexture with frontTexture
	 */
	public void setFrontTexture(Texture frontTexture) {
		this.frontTexture = frontTexture;
	}

	/**
	 * @param Set
	 *            the backTexture with backTexture
	 */
	public void setBackTexture(Texture backTexture) {
		this.backTexture = backTexture;
	}

	/**
	 * Set the front texture of the pokeon
	 * 
	 * @param Texture
	 *            location
	 */
	public void setFrontTexture(String filepath) {
		System.out.print("Loading " + filepath);
		frontTexture = new Texture(filepath);
	}

	/**
	 * Set the back texture of the pokemon
	 * 
	 * @param Texture
	 *            location
	 */
	public void setBackTexture(String filepath) {
		System.out.print("Loading " + filepath);
		backTexture = new Texture(filepath);
	}

	/**
	 * Add an action the the Actions
	 * 
	 * @param action
	 *            name
	 * @param the
	 *            original name
	 */
	public void giveAction(String actionname, String actionTrueName) {
		actions.add(actionname);
		actionNames.add(actionTrueName);
	}

	/**
	 * Initializa the types of pokemon
	 */
	public static void initializeTypes() {
		typesOfPokemon = new Vector<PokemonType>();
	}

	/**
	 * Add pokemon to the vector
	 * 
	 * @param pokemon
	 *            name
	 */
	public static void addPokemon(String pokemonName) {
		typesOfPokemon.add(new PokemonType(pokemonName));
	}

	/**
	 * @return the types of pokemon
	 * @param pokemon
	 *            name
	 */
	public static PokemonType getPokemon(String pokemonName) {

		for (int i = 0; i < typesOfPokemon.size(); i++) {
			if (typesOfPokemon.get(i).baseName
					.equalsIgnoreCase(pokemonName)) {
				return typesOfPokemon.get(i);
			}
		}

		return null;

	}

	/**
	 * @return the typesOfPokemon
	 */
	public static Vector<PokemonType> getTypesOfPokemon() {
		return typesOfPokemon;
	}

	/**
	 * @return the baseName
	 */
	public String getBaseName() {
		return baseName;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @return the types
	 */
	public String[] getTypes() {
		return types;
	}

	/**
	 * @return the typeID
	 */
	public int getTypeID() {
		return typeID;
	}

	/**
	 * @return the baseHP
	 */
	public int getBaseHP() {
		return baseHP;
	}

	/**
	 * @return the baseAttack
	 */
	public int getBaseAttack() {
		return baseAttack;
	}

	/**
	 * @return the baseDefense
	 */
	public int getBaseDefense() {
		return baseDefense;
	}

	/**
	 * @return the baseSpAttack
	 */
	public int getBaseSpAttack() {
		return baseSpAttack;
	}

	/**
	 * @return the baseSpDefense
	 */
	public int getBaseSpDefense() {
		return baseSpDefense;
	}

	/**
	 * @return the baseSpeed
	 */
	public int getBaseSpeed() {
		return baseSpeed;
	}

	/**
	 * @return the frontImage
	 */
	public Image getFrontImage() {
		return frontImage;
	}

	/**
	 * @return the backImage
	 */
	public Image getBackImage() {
		return backImage;
	}

}
