package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.RoadsToAdventure.enums.*;
import com.RoadsToAdventure.game.Handler;
import com.RoadsToAdventure.model.*;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class testCharacters {

	//Monster Tests
	@Test
	public void testMonster() {
		try {
			Monster goblin = new Monster("Goblin", 0, 0);
			assertEquals(goblin.Level, 3);
			assertEquals(goblin.getMaxHP(), 10);
			assertEquals(goblin.getAttack(), 10);
			assertEquals(goblin.getDefense(), 10);
			assertEquals(goblin.getSpeed(), 10);
			assertEquals(goblin.getExpGain(), 10, 0);
			assertEquals(goblin.Gold, 5, 0);
			assertEquals(goblin.getDescription(), "A goblin warrior, roaming the lands and ravaging villages. Surprising given how weak it is...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Boss the_punisher = new Boss("The Punisher (Boss)", new Equipable("Punisher's Axe", "Weapon"), 0, 0);
			assertEquals(the_punisher.Level, 25);
			assertEquals(the_punisher.getMaxHP(), 300);
			assertEquals(the_punisher.getAttack(), 170);
			assertEquals(the_punisher.getDefense(), 100);
			assertEquals(the_punisher.getSpeed(), 80);
			assertEquals(the_punisher.getExpGain(), 3500, 0);
			assertEquals(the_punisher.Gold, 630, 0);
			assertEquals(the_punisher.getDescription(), "A brutal warlord who has wandered the plains in search of revenge for his entire race of giant brutal creatures that were wiped out by the Elves. As the only survivor, he continues to hunt all who stand in his way (but Elves are his favorite to punish)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Player Tests
	@Test
	public void testPlayer() {
		Handler handler = new Handler();
		Player mage = new Player(PlayerClass.MAGE, 0, 0, handler);
		Player rogue = new Player(PlayerClass.ROGUE, 0, 0, handler);
		Player paladin = new Player(PlayerClass.PALADIN, 0, 0, handler);
		Player cleric = new Player(PlayerClass.CLERIC, 0, 0, handler);
		assertEquals(mage.Level, 1);
		assertEquals(rogue.Level, 1);
		assertEquals(paladin.Level, 1);
		assertEquals(cleric.Level, 1);
		assertEquals(mage.Gold, 500, 0.0);
		assertEquals(rogue.Gold, 500, 0.0);
		assertEquals(paladin.Gold, 500, 0.0);
		assertEquals(cleric.Gold, 500, 0.0);
		assertEquals(mage.Exp, 0, 0.0);
		assertEquals(rogue.Exp, 0, 0.0);
		assertEquals(paladin.Exp, 0, 0.0);
		assertEquals(cleric.Exp, 0, 0.0);
		assertEquals(mage.getAttack(), 14);
		assertEquals(mage.getMaxHP(), 8);
		assertEquals(mage.getDefense(), 7);
		assertEquals(mage.getSpeed(), 10);
		assertEquals(mage.getMaxMana(), 150, 0.0);
		assertEquals(rogue.getAttack(), 12);
		assertEquals(rogue.getMaxHP(), 8);
		assertEquals(rogue.getDefense(), 7);
		assertEquals(rogue.getSpeed(), 15);
		assertEquals(rogue.getMaxStamina(), 120, 0.0);
		assertEquals(paladin.getAttack(), 12);
		assertEquals(paladin.getMaxHP(), 12);
		assertEquals(paladin.getDefense(), 13);
		assertEquals(paladin.getSpeed(), 6);
		assertEquals(paladin.getMaxStamina(), 150, 0.0);
		assertEquals(cleric.getAttack(), 7);
		assertEquals(cleric.getMaxHP(), 14);
		assertEquals(cleric.getDefense(), 13);
		assertEquals(cleric.getSpeed(), 8);
		assertEquals(cleric.getMaxMana(), 120, 0.0);
		//This let's us control how many times we want to level up the characters for testing
		for(int i = 0; i < 24; i++){
		mage.LevelUp();
		rogue.LevelUp();
		paladin.LevelUp();
		cleric.LevelUp();
		}
		//These new stats are printed as the change when leveling up is random
		System.out.println("Mage: " + mage.getStats());
		System.out.println("Rogue: " + rogue.getStats());
		System.out.println("Paladin: " + paladin.getStats());
		System.out.println("Cleric: " + cleric.getStats());
		String test_name = "#360noscope";
		String test_appearance = "Baller af";
		String test_backstory = "One Backstory to rule them all...";
		mage.setName(test_name);
		mage.setAppearance(test_appearance);
		mage.setBackStory(test_backstory);
		assertEquals(mage.getName(), test_name);
		assertEquals(mage.getAppearance(), test_appearance);
		assertEquals(mage.getBackStory(), test_backstory);
		//Testing high level Player Constructor
		Player mage90 = new Player(PlayerClass.MAGE, 90, 0, 0, handler);
		Player rogue75 = new Player(PlayerClass.ROGUE, 75, 0, 0, handler);
		Player paladin50 = new Player(PlayerClass.PALADIN, 50, 0, 0, handler);
		Player cleric30 = new Player(PlayerClass.CLERIC, 30, 0, 0, handler);
		System.out.println("Mage: " + mage90.getStats());
		System.out.println("Rogue: " + rogue75.getStats());
		System.out.println("Paladin: " + paladin50.getStats());
		System.out.println("Cleric: " + cleric30.getStats());
	}

	//NPC Tests
	@Test
	public void testNPCs(){
		Civilian bob = new Civilian(0 ,0);
		System.out.println(bob.getDialogue());
		Item test_item;
		try {
			test_item = new Item("A Small Health Potion");
			ItemBearer jim = new ItemBearer(1, 0, 0, test_item);
			assertEquals(jim.getItem(), test_item);
			QuestGiver frank = new QuestGiver("Test message", test_item, 0, 0);
			assertEquals(frank.getQuestItem(), test_item);
			assertEquals(frank.isQuestGiven(), false);
			assertEquals(frank.isQuestCompleted(), false);
			assertEquals(frank.isItemGiven(), false);
			assertEquals(frank.getTalk(), "Test message");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ShopOwner weapons = new ShopOwner(OwnerType.WEAPONS, 0, 0);
		ShopOwner potions = new ShopOwner(OwnerType.POTIONS, 0, 0);
		ShopOwner equipment = new ShopOwner(OwnerType.EQUIPMENT, 0, 0);
		ShopOwner upgrader = new ShopOwner(OwnerType.UPGRADER, 0, 0);
		String test = "Hello! What can I get for you today?";
		assertEquals(weapons.getDialogue(), test);
		assertEquals(potions.getDialogue(), test);
		assertEquals(equipment.getDialogue(), test);
		assertEquals(upgrader.getDialogue(), test);
	}
}
















