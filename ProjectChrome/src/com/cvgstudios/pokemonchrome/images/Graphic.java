package com.cvgstudios.pokemonchrome.images;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.badlogic.gdx.graphics.Texture;

/**
 * Method to import Images.
 * 
 * @param needs
 *            to be in the Pictures folder at least for the image to be imported
 *            must be an operation that has registered itself with the object
 * @return imported Images that are imported
 */
public enum Graphic implements ImgPathConstants{

	// Stuff
	StartMenuLogo("res/imgs/TitleScreen.png"),

	StartMenuBG("res/imgs/MainMenuBG.png"), Box("res/imgs/PokemonMenuAll.png"), BoxHighLight(
			"res/imgs/PokemonMenuAllSelected.png"), ContinueBox(
			"res/imgs/PokemonMenuContinue.png"), ContinueBoxHighLight(
			"res/imgs/PokemonMenuContinueSelected.png"),

	WelcomeBG("res/imgs/WelcomeBG.png"),

	Professor("res/imgs/Professor.png"),

	// Tiles
	GrassTile("res/imgs/GrassTile.png"), DirtTile("res/imgs/DirtTile.png"), FenceLTile(
			"res/imgs/FenceLTile.png"), FenceUTile("res/imgs/FenceUTile.png"), FenceRTile(
			"res/imgs/FenceRTile.png"), FenceDTile("res/imgs/FenceDTile.png"),

	
	//Battle Screen things + GUI
	BattleScreenMenu(MENU_BATTLE_PATH + "/BattleMenu2.png"),
	PlayerPokemonStatBar(MENU_BATTLE_PATH + "/HpBarAlly.png"),
	EnemyPokemonStatBar(MENU_BATTLE_PATH + "/HpBarEnemy.png"),
	GrassBattleSetting(MENU_BATTLE_PATH + "/GreenBackground.png"),
	
	
	;
	private String filePath;
	private Image image;
	private Texture texture;
	private boolean graphicLoaded;

	private Graphic(String imagePath) {
		filePath = imagePath;
		graphicLoaded = false;

	}

	public Image getImage() {
		if (!graphicLoaded) {
			loadGraphic();
		}
		return image;

	}
	
	public Texture getTexture(){
		if (!graphicLoaded){
			loadGraphic();
		}
		return texture;
	}

	public void loadGraphic() {
		try {
			image = ImageIO.read(new File(filePath));
			texture = new Texture(filePath);
		} catch (IOException e) {
			System.err.println("Failed to load image!");
			e.printStackTrace();
		}
		graphicLoaded = true;
	}
}
