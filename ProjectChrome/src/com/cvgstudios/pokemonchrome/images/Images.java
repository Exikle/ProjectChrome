package com.cvgstudios.pokemonchrome.images;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Method to import Images.
 * 
 * @param needs
 *            to be in the Pictures folder at least for the image to be imported
 *            must be an operation that has registered itself with the object
 * @return imported Images that are imported
 */
public enum Images implements ImgPathConstants{

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
			"res/imgs/FenceRTile.png"), FenceDTile("res/imgs/FenceDTile.png");

	private String filePath;
	private Image image;
	private boolean imageLoaded;

	private Images(String imagePath) {
		filePath = imagePath;
		imageLoaded = false;

	}

	public Image getImage() {
		if (!imageLoaded) {
			loadImage();
		}
		return image;

	}

	public void loadImage() {
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("Failed to load image!");
			e.printStackTrace();
		}
		imageLoaded = true;
	}
}
