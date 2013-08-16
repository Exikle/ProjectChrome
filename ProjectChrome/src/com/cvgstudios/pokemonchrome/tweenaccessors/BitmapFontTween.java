package com.cvgstudios.pokemonchrome.tweenaccessors;

import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class BitmapFontTween implements TweenAccessor<BitmapFont> {

	public static final int ALPHA = 1, BETA = 2;

	@Override
	public int getValues(BitmapFont target, int tweenType,
			float[] returnValues) {
		switch (tweenType) {
			case ALPHA:
				returnValues[0] = target.getColor().a;
				return 1;
			default:
				return 2;
		}
	}

	@Override
	public void setValues(BitmapFont target, int tweenType,
			float[] newValues) {
		switch (tweenType) {
			case ALPHA:
				target.setColor(0, 0, 0, newValues[0]);
				break;
			case BETA:
				target.setColor(1, 1, 1, newValues[0]);
				break;
		}
	}

}
