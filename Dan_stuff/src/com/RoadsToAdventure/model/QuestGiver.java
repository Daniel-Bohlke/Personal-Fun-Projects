package com.RoadsToAdventure.model;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class QuestGiver extends NPC{

	//Checks if a quest has been given
	private boolean questGiven = false;
	//Checks if a quest has been completed
	private boolean QuestCompleted = false;
	//Quest Item
	private Item questItem;
	//Checks if the item has been given
	private boolean itemGiven;
	
	public QuestGiver(String message, Item questItem, int x, int y){
		super(x, y);
		setTalk(message);
		this.questItem = questItem;
		inventory.add(this.questItem);
		itemGiven = false;
	}
	
	public QuestGiver(int lvl, String message, Item questItem, int x, int y){
		super(lvl, x, y);
		setTalk(message);
		this.questItem = questItem;
		inventory.add(questItem);
		itemGiven = false;
	}
		
	@Override
	public String interact(Player player) {
		setTalk(getDialogue());
		if(QuestCompleted && !itemGiven){
		TransferItem(player, questItem);
		itemGiven = true;
		}
		return getTalk();
	}

	@Override
	public String getDialogue() {
		if(!questGiven){
			questGiven = true;
		}
		else if(QuestCompleted){
			setTalk("Thank you very much!");
		}
		return getTalk();
	}

	/**
	 * @return the questGiven
	 */
	public boolean isQuestGiven() {
		return questGiven;
	}

	/**
	 * @param questGiven the questGiven to set
	 */
	public void setQuestGiven(boolean questGiven) {
		this.questGiven = questGiven;
	}

	/**
	 * @return the questCompleted
	 */
	public boolean isQuestCompleted() {
		return QuestCompleted;
	}

	/**
	 * @param questCompleted the questCompleted to set
	 */
	public void setQuestCompleted(boolean questCompleted) {
		QuestCompleted = questCompleted;
	}

	/**
	 * @return the questItem
	 */
	public Item getQuestItem() {
		return questItem;
	}

	/**
	 * @param questItem the questItem to set
	 */
	public void setQuestItem(Item questItem) {
		this.questItem = questItem;
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

