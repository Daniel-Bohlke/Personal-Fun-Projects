package com.RoadsToAdventure.model;

import com.RoadsToAdventure.game.Handler;
import com.RoadsToAdventure.game.SpriteSheet;

public class Equipable extends Item{

	String type;
	
	public Equipable(String n, String t, int x, int y, Handler handler, SpriteSheet ss) throws Exception {
		super(n, x, y, handler, ss);
		this.type = t;
	}

	public void wear(CharacterClass user){
		for(int i = 0; i < 6; i++){
			if(user.Equipment[i].type.equals(this.type)){
				user.remove(user.Equipment[i]);
				user.Equipment[i] = this;
			}
		}
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
}
