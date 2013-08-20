package com.cvgstudios.pokemonchrome.tweenaccessors;

import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class SpriteTween implements TweenAccessor<Sprite> {

	public static final int POS_XY = 1;

	public static final int CPOS_XY = 2;

	public static final int SCALE_XY = 3;

	public static final int ROTATION = 4;

	public static final int OPACITY = 5;

	public static final int TINT = 6;

	@Override
	public int getValues(Sprite target, int tweenType,
			float[] returnValues) {
		switch (tweenType) {
			case POS_XY:
				returnValues[0] = target.getX();
				returnValues[1] = target.getY();
				return 2;
		}
		return 0;
	}

	@Override
	public void setValues(Sprite target, int tweenType,
			float[] newValues) {
		switch (tweenType) {
			case POS_XY:
				target.setPosition(newValues[0], newValues[1]);
				break;
		}
	}
}