package com.RoadsToAdventure.model;

import java.io.File;
import java.util.Scanner;

//TODO: Not yet implemented, currently just empty template
public class Item {

	String name;
	
	int Level;
	
	int price;
	
	int sellprice;
	
	char mod;
	
	String stat;
	
	int amount;
	
	String description;
	
	boolean used = false;
	
	
	@SuppressWarnings("resource")
	public Item(String name) throws Exception{
		this.name = name;
			File list = new File("ItemList.txt");
			Scanner read = new Scanner(list);
			String find = read.nextLine();
			while(read.hasNextLine() && !find.equals(name)){
				find = read.nextLine();
			}
			if(!find.equals(name)){
				throw new Exception("Item not found, please remember that Item names are case-sensitive");
			}
			else{
				this.Level = read.nextInt();
				this.price = read.nextInt();
				this.sellprice = read.nextInt();
				this.mod = read.next().charAt(0);
				this.stat = read.next();
				this.amount = read.nextInt();
				read.nextLine();
				read.nextLine();
				this.description = read.next();
			}
			read.close();
	}
	/*
	Item(String n, int price, int sellprice){
		this.name = n;
		this.price = price;
		this.sellprice = sellprice;
	}
	*/
	public void use(CharacterClass user){
		if(this.mod == '+'){
			if(this.stat.equals("HP")){
				user.HP += this.amount;
			}
			else if(this.stat.equals("Spd")){
				user.Speed += this.amount;
			}
			else if(this.stat.equals("Atk")){
				user.Attack += this.amount;
			}
			else if(this.stat.equals("Def")){
				user.Defense += this.amount;
			}
		}
		else{
			if(this.stat.equals("HP")){
				user.HP -= this.amount;
			}
			else if(this.stat.equals("Spd")){
				user.Speed -= this.amount;
			}
			else if(this.stat.equals("Atk")){
				user.Attack -= this.amount;
			}
			else if(this.stat.equals("Def")){
				user.Defense -= this.amount;
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSellprice() {
		return sellprice;
	}

	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}

	public char getMod() {
		return mod;
	}

	public void setMod(char mod) {
		this.mod = mod;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
}

