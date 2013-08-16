package com.cvgstudios.pokemonchrome;

enum Direction {
	DOWN(1, -2, "VERTICAL"), UP(2, 2, "VERTICAL"), RIGHT(3, 2,
			"HORIZONTAL"), LEFT(4, -2, "HORIZONTAL");

	float speed;

	int directionVal;

	String axis;

	Direction(int d, float s, String a) {
		speed = s;
		directionVal = d;
		axis = a;
	}

	float getSpeed() {
		return speed;

	}

	int getDirection() {
		return directionVal;

	}

	String getXis() {
		return axis;

	}
}
