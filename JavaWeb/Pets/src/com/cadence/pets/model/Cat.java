package com.cadence.pets.model;

public class Cat extends Animal implements Pet{

	public Cat(String name, String breed, int weight) {
		super(name, breed, weight);
	}

	@Override
	public String showAffection() {
		return getName() + " looks at you";
	}

}
