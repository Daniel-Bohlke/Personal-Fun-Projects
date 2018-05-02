package com.RoadsToAdventure.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.RoadsToAdventure.enums.PlayerClass;
import com.RoadsToAdventure.game.Handler;
import com.RoadsToAdventure.game.ID;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class Player extends CharacterClass {
	
	//There are 4 class types: Mage, Rogue, Paladin, and Cleric
	public PlayerClass playerClass;
	//This is the Physical Description of the Player's character
	public String appearance;
	//This is the BackStory behind a Player's character, giving others and idea of what this character has done before now
	public String backStory;
	//Player name
	public String name;
	//Checks if Player is alive
	public boolean alive = true;
	//Handler
	public Handler handler;
	
	Location location;
	
	public Player(PlayerClass playerClass, int level, int x, int y, Handler handler){
		super(x, y, ID.Player);
		this.handler = handler;
		Level = 1;
		Attack = 10;
		HP = 10;
		Defense = 10;
		Speed = 10;
		maxStamina = 100.0;
		maxMana = 100.0;
		Gold = 500;
		Exp = 0.0;
		this.playerClass = playerClass;
		if(playerClass.equals(PlayerClass.MAGE)){
			Attack += 4;
			HP -= 2;
			Defense -= 3;
			Speed = Speed + 0;
			maxMana += 50.0;
		}
		else if(playerClass.equals(PlayerClass.ROGUE)){
			Attack += 2;
			HP -= 2;
			Defense -= 3;
			Speed += 5;
			maxStamina += 20.0;
		}
		//NOTE: Paladins should have very little access to Skills
		else if(playerClass.equals(PlayerClass.PALADIN)){
			Attack += 2;
			HP += 2;
			Defense += 3;
			Speed -= 4;
			maxStamina += 50.0;
		}
		else{
			Attack -= 3;
			HP += 4;
			Defense += 3;
			Speed -= 2;
			maxMana += 20.0;
		}
		Stamina = maxStamina;
		Mana = maxMana;
		setMaxHP(HP);
		for(int i = 1; i < level; i++){
			this.LevelUp();
		}
	}
	
	public Player(PlayerClass playerClass, int x, int y, Handler handler){
		super(x, y, ID.Player);
		this.handler = handler;
		Level = 1;
		Attack = 10;
		HP = 10;
		Defense = 10;
		Speed = 10;
		maxStamina = 100.0;
		maxMana = 100.0;
		Gold = 500;
		Exp = 0.0;
		this.playerClass = playerClass;
		if(playerClass.equals(PlayerClass.MAGE)){
			Attack += 4;
			HP -= 2;
			Defense -= 3;
			Speed = Speed + 0;
			maxMana += 50.0;
		}
		else if(playerClass.equals(PlayerClass.ROGUE)){
			Attack += 2;
			HP -= 2;
			Defense -= 3;
			Speed += 5;
			maxStamina += 20.0;
		}
		//NOTE: Paladins should have very little access to Skills
		else if(playerClass.equals(PlayerClass.PALADIN)){
			Attack += 2;
			HP += 2;
			Defense += 3;
			Speed -= 4;
			maxStamina += 50.0;
		}
		else{
			Attack -= 3;
			HP += 4;
			Defense += 3;
			Speed -= 2;
			maxMana += 20.0;
		}
		Stamina = maxStamina;
		Mana = maxMana;
		setMaxHP(HP);
	}
	
	public void LevelUp(){
		Level++;
		Random rand = new Random(System.currentTimeMillis());
		if(playerClass.equals(PlayerClass.MAGE)){
			Attack += rand.nextInt(5) + 2;
			setMaxHP(getMaxHP() + rand.nextInt(3) + 1);
			Defense += rand.nextInt(3);
			Speed += rand.nextInt(3) + 1;
			maxMana += (rand.nextInt(10) + 1) * 5;
			Mana = maxMana;
		}
		else if(playerClass.equals(PlayerClass.ROGUE)){
			Attack += rand.nextInt(4) + 1;
			setMaxHP(getMaxHP() + rand.nextInt(3));
			Defense += rand.nextInt(3);
			Speed += rand.nextInt(5) + 2;
			maxStamina += (rand.nextInt(4) + 1) * 5;
			Stamina = maxStamina;
		}
		else if(playerClass.equals(PlayerClass.PALADIN)){
			Attack += rand.nextInt(3) + 1;
			setMaxHP(getMaxHP() + rand.nextInt(4) + 1);
			Defense += rand.nextInt(5) + 1;
			Speed += rand.nextInt(3);
			maxStamina += (rand.nextInt(10) + 1) * 5;
			Stamina = maxStamina;
		}
		else if(playerClass.equals(PlayerClass.CLERIC)){
			Attack += rand.nextInt(3);
			setMaxHP(getMaxHP() + rand.nextInt(5) + 2);
			Defense += rand.nextInt(4) + 1;
			Speed += rand.nextInt(3);
			maxMana += (rand.nextInt(4) + 1) * 5;
			Mana = maxMana;
		}
		else{
			Attack += rand.nextInt(3);
			setMaxHP(getMaxHP() + rand.nextInt(3));
			Defense += rand.nextInt(3);
			Speed += rand.nextInt(3);
			maxMana += (rand.nextInt(4) + 1) * 5;
			maxStamina += (rand.nextInt(4) + 1) * 5;
		}
	}
	
	public void gameOver(){
		this.alive = false;
		System.out.println("Game Over, sorry Loser");
	}
	
	public String itemObtained(Item t){
		return "You have obtained " + t.name + "!";
	}
	
	@Override
	public String interact(Player player) {
		boolean open = true;
		char[][] menu = {{'>', ' ', 'V', 'i', 'e', 'w', ' ', ' '},
				 		 {' ', ' ', 'T', 'r', 'a', 'd', 'e', ' '},
				 		 {' ', ' ', 'C', 'a', 'n', 'c', 'e', 'l'}};
		return "Yes?";
	}
	
	public String getView(){
		return "This is " + this.name + " they appear to be " + appearance;
}

	//TODO
	public char[][] getTrade(Player player){
	char[][] temp = null;
	
		return temp;
}

	public void cancel(boolean open){
	open = false;
}
	
	public void moveCursorDown(char[][] menu){
		int cursorlocation = 0;
		for(int i = 0; i < menu[0].length; i++){
			if(menu[i][0] == '>'){
				cursorlocation = i;
			}
		}
		if((cursorlocation + 1) < menu[0].length){
		menu[cursorlocation][0] = ' ';
		menu[cursorlocation + 1][0] = '>';
		}
	}

	public void moveCursorUp(char[][] menu){
		int cursorlocation = 0;
		for(int i = 0; i < menu[0].length; i++){
			if(menu[i][0] == '>'){
				cursorlocation = i;
			}
		}
		if((cursorlocation - 1) >= 0){
		menu[cursorlocation][0] = ' ';
		menu[cursorlocation - 1][0] = '>';
		}
	}
	
	public String getStats(){
		String s = "Level: " + this.Level + " Atk: " + this.Attack + " HP: " + this.getMaxHP() + " Def: " + this.Defense + " Spd: " + this.Speed + " maxMana: "
				+ this.maxMana + " maxStamina: " + this.maxStamina;
		return s;
	}

	/**
	 * @return the playerClass
	 */
	public PlayerClass getplayerClass() {
		return playerClass;
	}

	/**
	 * @param class1 the class to set
	 */
	public void setPlayerClass(PlayerClass class1) {
		playerClass = class1;
	}

	/**
	 * @return the appearance
	 */
	public String getAppearance() {
		return appearance;
	}

	/**
	 * @param appearance the appearance to set
	 */
	public void setAppearance(String appearance1) {
		appearance = appearance1;
	}

	/**
	 * @return the backStory
	 */
	public String getBackStory() {
		return backStory;
	}

	/**
	 * @param backStory the backStory to set
	 */
	public void setBackStory(String backStory) {
		this.backStory = backStory;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public PlayerClass getPlayerClass() {
		return playerClass;
	}

	@Override
	public void tick() {
		this.x += velX;
		this.y += velY;
		
		if(handler.isDown()) velY = 5;
		else if(!handler.isUp()) velY = 0;
		
		if(handler.isUp()) velY = -5;
		else if(!handler.isDown()) velY = 0;
		
		if(handler.isLeft()) velX = -5;
		else if(!handler.isRight()) velX = 0;
		
		if(handler.isRight()) velX = 5;
		else if(!handler.isLeft()) velX = 0;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 32, 32);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}
