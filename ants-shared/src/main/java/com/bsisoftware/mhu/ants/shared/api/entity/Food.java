package com.bsisoftware.mhu.ants.shared.api.entity;

public class Food extends GameObject {

	private int amount = 1;
	
	public void take() {
		amount--;
	}
	
	public boolean isEmpty() {
		return amount < 1;
	}
}
