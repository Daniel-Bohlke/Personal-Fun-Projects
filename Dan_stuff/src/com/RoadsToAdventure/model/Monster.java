package com.RoadsToAdventure.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.util.Scanner;

import com.RoadsToAdventure.game.ID;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class Monster extends CharacterClass {

	//exp gained by defeating this monster
	public double expGain;
	//name of the monster
	public String name;
	//monster description
	public String description;
	//checks if monster is still alive
	public boolean alive;
	
	//All of the monster's traits are determined by level
	@SuppressWarnings("resource")
	public Monster(String name, int x, int y) throws Exception{
		super(x, y, ID.Monster);
		this.name = name;
		File list = new File("MonsterList.txt");
		Scanner read = new Scanner(list);
		String find = read.nextLine();
		while(read.hasNextLine() && !find.equals(name)){
			find = read.nextLine();
		}
		if(!find.equals(name)){
			throw new Exception("Monster not found, please remember that monster names are case-sensitive");
		}
		else{
			this.Level = read.nextInt();
			this.setMaxHP(read.nextInt());
			this.HP = getMaxHP();
			this.Attack = read.nextInt();
			this.Defense = read.nextInt();
			this.Speed = read.nextInt();
			this.expGain = read.nextInt();
			this.Gold = read.nextInt();
			read.nextLine();
			read.nextLine();
			this.description = read.nextLine();
			this.alive = true;
		}
		read.close();
	}
	
	@Override
	public String interact(Player player) {
		int attacks = 0;
		int totaldmg = 0;
		String faster = "Player";
		String t1 = "";
		String t2 = "";
		String t3 = "";
		String end = null;
		if(this.Speed >= player.Speed){
			attacks = (this.Speed - player.Speed) / 10;
			faster = "Monster";
		}
		else{
			attacks = (player.Speed - this.Speed) / 10;
		}
		if(faster.equals("Player")){
		totaldmg = attacks * (player.Attack - this.Defense);
		if(totaldmg < 0){
			totaldmg = 0;
			}
		this.HP -= totaldmg;
		t1 = "You hit the " + this.name + " " + attacks + " times for " + totaldmg + " damage!";
		totaldmg = this.Attack - player.Defense;
		if(totaldmg < 0){
			totaldmg = 0;
			}
		if(this.HP > 0){
			player.HP -= totaldmg;
		t2 = "\nThen you were hit by the " + this.name + " for " + totaldmg + " damage!";
		if(player.HP <= 0){
			player.gameOver();
		}
			}
		else{
			this.alive = false;
			player.Exp += this.expGain;
			player.Gold += this.Gold;
		t2 = "\nYou slayed the " + this.name + "! You received " + this.expGain + " exp points and " + this.Gold + " gold!";
			}
		}
		else{
			totaldmg = attacks * (this.Attack - player.Defense);
			if(totaldmg < 0){
				totaldmg = 0;
			}
		player.HP -= totaldmg;
		t1 = "You were hit by the " + this.name + " " + attacks + " times for " + totaldmg + " damage!";
			totaldmg = player.Attack - this.Defense;
			if(totaldmg < 0){
				totaldmg = 0;
			}
			if(player.HP > 0){
				this.HP -= totaldmg;
				t2 = "\nYou then hit the " + this.name + " for " + totaldmg + " damage!";
				if(this.HP <= 0){
					this.alive = false;
					player.Exp += this.expGain;
					player.Gold += this.Gold;
				t3 = "\nYou slayed the " + this.name + "! You received " + this.expGain + " exp points and " + this.Gold + " gold!";
				t2 = t2 + t3;
				}
			}
			else{
				player.gameOver();
			}
		}
		end = t1 + t2;
		return end;
	}

	public double getExpGain() {
		return expGain;
	}

	public void setExpGain(double expGain) {
		this.expGain = expGain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public void tick() {
		this.x += velX;
		this.y += velY;
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 32, 32);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}

