package com.RoadsToAdventure.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import com.RoadsToAdventure.game.GameObject;
import com.RoadsToAdventure.game.Handler;
import com.RoadsToAdventure.game.ID;
import com.RoadsToAdventure.game.SpriteSheet;

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
	//Handler
	//private Handler handler;
	Random r = new Random();
	int choose = 0;
	//sprite
	public BufferedImage monster_sprite[] = new BufferedImage[3];
	//count
	int count;
	//current img
	BufferedImage curr_img;
	
	//All of the monster's traits are determined by level
	@SuppressWarnings("resource")
	public Monster(String name, int x, int y, Handler handler, SpriteSheet ss) throws Exception{
		super(x, y, ID.Monster, ss);
		this.handler = handler;
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
			if(this.name.equals("Goblin")){
				this.monster_sprite[0] = ss.grabImage(8, 1, 32, 32);
				this.monster_sprite[1] = ss.grabImage(9, 1, 32, 32);
				this.monster_sprite[2] = ss.grabImage(10, 1, 32, 32);
			}
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
		count++;
		this.x += velX;
		this.y += velY;
		
		choose = r.nextInt(10);
		
		for(int i = 0; i < this.handler.getObject().size(); i++){
			GameObject temp = handler.getObject().get(i);
			
			if(temp.getId() == ID.Block){
				if(getBoundsBig().intersects(temp.getBounds())){
					x += (velX*5) * -1;
					y += (velY*5) * -1;
					velX *= -1;
					velY *= -1;
				}
				else if(choose == 0){
					velX = (r.nextInt(2 - -2) + - 2);
					velY = (r.nextInt(2 - -2) + - 2);
				}
			}
			
			if(temp.getId() == ID.Player){
				//TODO: Call combat window
			}
		}
		
		if(velX == 0 && velY == 0){
			count = 0;
			curr_img = monster_sprite[0];
		}
		else if (curr_img == monster_sprite[0]){
			curr_img = monster_sprite[1];
		}
		
		if(count == 10 && curr_img == monster_sprite[1]){
			curr_img = monster_sprite[2];
			count = 0;
		}
		else if(count == 10){
			curr_img = monster_sprite[1];
			count = 0;
		}
		
	}

	@Override
	public void render(Graphics g) {
		//g.setColor(Color.RED);
		//g.fillRect(x, y, 32, 32);
		g.drawImage(curr_img, x, y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	public Rectangle getBoundsBig() {
		return new Rectangle(x-16, y-16, 64, 64);
	}
}

