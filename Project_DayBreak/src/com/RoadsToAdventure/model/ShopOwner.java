package com.RoadsToAdventure.model;

import java.util.ArrayList;

import com.RoadsToAdventure.enums.*;
import com.RoadsToAdventure.game.Handler;
import com.RoadsToAdventure.game.SpriteSheet;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class ShopOwner extends NPC{
	
	//menu type ie. Buy, Sell, etc.
	private MenuType menuType;
	//type of Shop Owner, there are 4 types: Weapons, Potions, Equipment, and Upgrader(levels up weapons and equipment)
	private OwnerType ownerType;
	
	public ShopOwner(OwnerType type, int x, int y, Handler handler, SpriteSheet ss){
		super(x, y, handler, ss);
		this.ownerType = type;
	}
	
	public ShopOwner(int lvl, OwnerType type, int x, int y, Handler handler, SpriteSheet ss){
		super(lvl, x, y, handler, ss);
		menuType = MenuType.CLOSED;
		ownerType = type;
	}	

	public String interact(Player player){
		setTalk(getDialogue());
		//char[][] currentMenu = getSelection();
		return getTalk();
		}
	
	@Override
	public String getDialogue() {
		setTalk("Hello! What can I get for you today?");
		return getTalk();
	}

	public void Select(char[][] menu){
		int cursorlocation = 0;
		for(int i = 0; i < menu[0].length; i++){
			if(menu[i][0] == '>'){
				cursorlocation = i;
			}
		}
		if(menuType.equals(MenuType.SELECTION)){
			if(cursorlocation == 0){
				getBuy();
			}
			else if(cursorlocation == 1){
				getSell();
			}
			else{
				Cancel();
			}
		}
		else{
			
		}
	}
	public char[][] getSelection(){
		char[][] temp = {{'>', ' ', 'B', 'u', 'y', ' ', ' ', ' '},
 		  				 {' ', ' ', 'S', 'e', 'l', 'l', ' ', ' '},
 		  				 {' ', ' ', 'C', 'a', 'n', 'c', 'e', 'l'}};
		menuType = MenuType.SELECTION;
		return temp;
	}
	
	public char[][] getBuy(){
		menuType = MenuType.BUY;
		Item[] list = getStoreList("Weapon");
		char[][] temp = new char[50][list.length + 1];
		for(int i = 0; i < list.length; i++){
			String price = String.valueOf(list[i].price);
			temp[i][0] = ' ';
			temp[i][1] = ' ';
			for(int j = 2; j < list[i].name.length(); j++){
				temp[i][j] = list[i].name.charAt(j);
			}
			for(int k = list[i].name.length() + 2; k < list[i].name.length() + 2 + price.length() && k < 50; k++){
				for(int l = 0; l < price.length(); l++){
				temp[i][k] = price.charAt(l);
				}
			}
		}
			return temp;
	}
	
	public char[][] getSell(){
		menuType = MenuType.SELL;
		Item[] list = new Item[inventory.size()];
		inventory.toArray(list);
		char[][] temp = new char[50][list.length + 1];
		for(int i = 0; i < list.length; i++){
			String price = String.valueOf(list[i].sellprice);
			temp[i][0] = ' ';
			temp[i][1] = ' ';
			for(int j = 2; j < list[i].name.length(); j++){
				temp[i][j] = list[i].name.charAt(j);
			}
			for(int k = list[i].name.length() + 2; k < list[i].name.length() + 2 + price.length() && k < 50; k++){
				for(int l = 0; l < price.length(); l++){
				temp[i][k] = price.charAt(l);
				}
			}
		}
			return temp;
	}
	
	public void Cancel(){
		if(!menuType.equals(MenuType.SELECTION)){
			menuType = MenuType.SELECTION;
		}
		else{
			menuType = MenuType.CLOSED;
		}
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
	//TODO: Currently only works for the first town and for Weapon Sellers
	public Item[] getStoreList(String l){
		ArrayList<Item> list = new ArrayList<Item>();
		if((Level == 5) && (ownerType.equals(OwnerType.WEAPONS))){
			try{
				/**
			list.add(new Item("Training Sword"));
			list.add(new Item("Training Bow"));
			list.add(new Item("Training Staff"));
			list.add(new Item("Training Shield"));
			list.add(new Item("Training Stave"));
			list.add(new Item("Training Axe"));
			list.add(new Item("Arrows x 5"));
			*/}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		Item[] a = new Item[list.size()];
		return list.toArray(a);
	}


	/**
	 * @return the menuType
	 */
	public MenuType getMenutype() {
		return menuType;
	}


	/**
	 * @param menuType the menuType to set
	 */
	public void setMenutype(MenuType menuType) {
		this.menuType = menuType;
	}


	/**
	 * @return the ownerType
	 */
	public OwnerType getOwnerType() {
		return ownerType;
	}


	/**
	 * @param ownerType the ownerType to set
	 */
	public void setOwnertype(OwnerType ownerType) {
		this.ownerType = ownerType;
	}
}

