package com.RoadsToAdventure.model;

import java.util.ArrayList;

import com.RoadsToAdventure.game.GameObject;
import com.RoadsToAdventure.game.Handler;
import com.RoadsToAdventure.game.ID;

/**
 * 
 * @author Daniel Bohlke
 *
 */
//import logic.Skill;

public abstract class CharacterClass extends GameObject {
	
	//Attack Represents a character's Attack Power, used for calculating both Melee and Spell Attacks
	protected int Attack;
	//HP Represents a character's Hit Points, generally scaled 3:1 compared to other stats
	protected int HP;
	private int maxHP;
	//Defense Represents a character's Defense, Mitigates damage taken
	protected int Defense;
	//Speed Represents a character's Speed, used when calculating who goes first and number of actions
	protected int Speed;
	//Stamina Represents a character's physical Stamina, used for making melee attacks and some skills
	protected double Stamina;
	protected double maxStamina;
	//Mana Represents a character's Magical stamina, used for spells and most skills
	protected double Mana;
	protected double maxMana;
	//inventory is a list of all of the items that a character can hold
	public ArrayList<Item> inventory = new ArrayList<Item>(50);
	//Equipment is the Array of Equip Items the user is wearing (6 for head, torso, pants, 2 for hands, and boots)w
	public Equipable[] Equipment = new Equipable[6];
	//Gold is to show how much money is currently in the player's possession
	public double Gold;
	//This is to show the character's level
	public int Level;
	//This shows the character's current Experience Points
	public double Exp;
	//Handler
	protected Handler handler;
	//These are the Character's Skills
	//public ArrayList<Skill> Skills = new ArrayList<Skill>();
	
	//public Location location;
	
	public CharacterClass(int x, int y, ID id){
		super(x, y, id);
	}
	
	public CharacterClass(int atk, int HP, int def, int Spd, double maxStam, 
			double maxMana, double Gold, int Lvl, double Exp, int x, int y, ID id){
		super(x, y, id);
		Attack = atk;
		this.HP = HP;
		Defense = def;
		Speed = Spd;
		maxStamina = maxStam;
		this.maxMana = maxMana;
		this.Gold = Gold;
		Level = Lvl;
		this.Exp = Exp;
		//this.location = location;
		//this.location.square.character = this;
	}
	
	/**
	 * This method works so that when a player interacts with another character
	 * some sort of event happens. The way you call it is you get the Character that
	 * the player is interacting with and use them to call it with the Player's parameters given.
	 * Example: If Player A walks up to an NPC B, the call would be B.Interact(A);
	 * This may seem counter-intuitive as the Player is doing the interacting but makes much more sense
	 * for the code.
	 * @param Player This is the Player that is interacting
	 */
	public abstract String interact(Player player);
	
	//This method will allow any character to give an item to another character
	public void TransferItem(CharacterClass target, Item t){
		for(int i = 0; i < inventory.size() && inventory.get(i) != null; i++){
			if(inventory.get(i) == t){
				target.inventory.add(t);
				inventory.remove(t);
			}
		}
	}
	
	public void remove(Equipable r){
		if(r.mod == '-'){
			if(r.stat.equals("HP")){
				this.HP += r.amount;
			}
			else if(r.stat.equals("Spd")){
				this.Speed += r.amount;
			}
			else if(r.stat.equals("Atk")){
				this.Attack += r.amount;
			}
			else if(r.stat.equals("Def")){
				this.Defense += r.amount;
			}
		}
		else{
			if(r.stat.equals("HP")){
				this.HP -= r.amount;
			}
			else if(r.stat.equals("Spd")){
				this.Speed -= r.amount;
			}
			else if(r.stat.equals("Atk")){
				this.Attack -= r.amount;
			}
			else if(r.stat.equals("Def")){
				this.Defense -= r.amount;
			}
		}
		for(int i = 0; i < 6; i++){
			if(this.Equipment[i].name.equals(r.name)){
				this.Equipment[i] = null;
			}
		}
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return Attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		Attack = attack;
	}

	/**
	 * @return the hP
	 */
	public int getHP() {
		return HP;
	}

	/**
	 * @param hP the hP to set
	 */
	public void setHP(int hP) {
		HP = hP;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return Defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		Defense = defense;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return Speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		Speed = speed;
	}

	/**
	 * @return the stamina
	 */
	public double getStamina() {
		return Stamina;
	}

	/**
	 * @param stamina the stamina to set
	 */
	public void setStamina(double stamina) {
		Stamina = stamina;
	}

	/**
	 * @return the maxStamina
	 */
	public double getMaxStamina() {
		return maxStamina;
	}

	/**
	 * @param maxStamina the maxStamina to set
	 */
	public void setMaxStamina(double maxStamina) {
		this.maxStamina = maxStamina;
	}

	/**
	 * @return the mana
	 */
	public double getMana() {
		return Mana;
	}

	/**
	 * @param mana the mana to set
	 */
	public void setMana(double mana) {
		Mana = mana;
	}

	/**
	 * @return the maxMana
	 */
	public double getMaxMana() {
		return maxMana;
	}

	/**
	 * @param maxMana the maxMana to set
	 */
	public void setMaxMana(double maxMana) {
		this.maxMana = maxMana;
	}

	/**
	 * @return the inventory
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the equipment
	 */
	public Equipable[] getEquipable() {
		return Equipment;
	}

	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipable(Equipable[] equipment) {
		Equipment = equipment;
	}

	/**
	 * @return the gold
	 */
	public double getGold() {
		return Gold;
	}

	/**
	 * @param gold the gold to set
	 */
	public void setGold(double gold) {
		Gold = gold;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return Level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		Level = level;
	}

	/**
	 * @return the exp
	 */
	public double getExp() {
		return Exp;
	}

	/**
	 * @param exp the exp to set
	 */
	public void setExp(double exp) {
		Exp = exp;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	/*
	/**
	 * @return the skills
	 
	public ArrayList<Skill> getSkills() {
		return Skills;
	}

	/**
	 * @param skills the skills to set
	 
	public void setSkills(ArrayList<Skill> skills) {
		Skills = skills;
	}
	*/
}

