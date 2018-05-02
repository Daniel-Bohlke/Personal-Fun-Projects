package com.RoadsToAdventure.model;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class Boss extends Monster{

	private Item itemdrop;
	//The Boss class will be very similar to the Monster however all the names in the Monster List
	//will be shown as Dark Wing The Giant Crow (Boss) and yes Boss monsters are kept within the MonsterList.txt
	public Boss(String name, Item i, int x, int y) throws Exception {
		super(name, x, y);
		itemdrop = i;
	}
	
	public Item getItemdrop() {
		return itemdrop;
	}
	public void setItemdrop(Item itemdrop) {
		this.itemdrop = itemdrop;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 64, 64);
		
	}
}
