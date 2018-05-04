package daybreak_model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import daybreak_game.Handler;
import daybreak_game.ID;
import daybreak_game.SpriteSheet;

//import java.util.*;
//why is this here^

public abstract class NPC extends CharacterClass {
	
	//This is what the NPC will say when interacted with
	private String talk;
	
	public NPC(int x, int y, Handler handler, SpriteSheet ss){
		super(x, y, ID.NPC, ss);
		this.handler = handler;
	}
	/*
	public NPC(int lvl){
		Level = lvl;
		Attack = 10;
		HP = 10;
		Defense = 10;
		Speed = 10;
		Stamina = 100.0;
		maxStamina = 100.0;
		Mana = 100.0;
		maxMana = 100.0;
		Gold = 0;
		Exp = 0.0;
	}
	*/
	
	public NPC(int lvl, int x, int y, Handler handler, SpriteSheet ss) {
		super(10, 10, 10, 10, 100, 100, 0, lvl, 0, x, y, ID.NPC, ss);
		this.handler = handler;
	}
	
	public void tick(){
		this.x += velX;
		this.y += velY;
	}
	
	public void render(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 32, 32);
	}
	
	public Rectangle getBounds(){
		return null;
	}
	
	//public abstract String interact(Player player);
	//why was this here? ^
	
	public abstract String getDialogue();

	/**
	 * @return the talk
	 */
	public String getTalk() {
		return talk;
	}

	/**
	 * @param value of talk to set
	 */
	public void setTalk(String talk) {
		this.talk = talk;
	}
}

