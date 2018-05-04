package daybreak_model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import daybreak_game.GameObject;
import daybreak_game.Handler;
import daybreak_game.ID;
import daybreak_game.SpriteSheet;

//TODO: Not yet implemented, currently just empty template
public class Item extends GameObject{

	String name;
	
	int Level;
	
	int price;
	
	int sellprice;
	
	char mod;
	
	String stat;
	
	int amount;
	
	String description;
	
	boolean used = false;
	
	Handler handler;
	
	BufferedImage item_sprite[] = new BufferedImage[2];
	
	BufferedImage curr_img;
	
	int count;
	
	//Animation animate;
	
	
	@SuppressWarnings("resource")
	public Item(String name, int x, int y, Handler handler, SpriteSheet ss) throws Exception{
		super(x, y, ID.Item, ss);
		this.handler = handler;
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
				this.item_sprite[0] = ss.grabImage(3, 1, 32, 32);
				this.item_sprite[1] = ss.grabImage(4, 1, 32, 32);
				this.curr_img = item_sprite[0];
				
				//animate = new Animation(3, item_sprite[0], item_sprite[1]);
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
	@Override
	public void tick() {
		count ++;
		if(count == 30 && curr_img == item_sprite[0]){
			curr_img = item_sprite[1];
			count = 0;
		}
		else if(count == 30){
			curr_img = item_sprite[0];
			count = 0;
		}
		
	}
	@Override
	public void render(Graphics g) {
		//g.setColor(Color.CYAN);
		//g.fillRect(x, y, 32, 32);
		g.drawImage(curr_img, x, y, null);
	}
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}

