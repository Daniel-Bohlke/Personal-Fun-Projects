package com.RoadsToAdventure.model;

import java.awt.Rectangle;

import com.RoadsToAdventure.game.Handler;
import com.RoadsToAdventure.game.SpriteSheet;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class ItemBearer extends NPC {

	private Item item;
	
	private boolean itemGiven;
	
	
	public ItemBearer(int lvl, int x, int y, Item i, Handler handler, SpriteSheet ss){
		super(lvl, x, y, handler, ss);
		this.item = i;
		inventory.add(this.item);
		itemGiven = false;
	}
	
	public String interact(Player player){
		setTalk(getDialogue());
		if(!this.itemGiven){
		this.TransferItem(player, this.item);
		this.itemGiven = true;
		System.out.println(player.itemObtained(this.item));
		}
		return getTalk();
	}
		
	@Override
	public String getDialogue() {
		if(!this.itemGiven){
		setTalk("Please take good care of this item.");
		}
		else{
		setTalk("What do you want? I'm not giving you another one!");
		}
		return getTalk();
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return the itemGiven
	 */
	public boolean isItemGiven() {
		return itemGiven;
	}

	/**
	 * @param itemGiven the itemGiven to set
	 */
	public void setItemGiven(boolean itemGiven) {
		this.itemGiven = itemGiven;
	}


}
