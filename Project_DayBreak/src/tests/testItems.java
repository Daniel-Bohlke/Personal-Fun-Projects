package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import daybreak_enums.PlayerClass;
import daybreak_game.Handler;
import daybreak_model.Equipable;
import daybreak_model.Item;
import daybreak_model.Player;
/**
 * 
 * @author Daniel Bohlke
 *
 */
public class testItems {

	//Testing basic Item Constructor
	@Test
	public void testItem() {
		try {
			Item test = new Item("A Small Health Potion");
			assertEquals(test.getLevel(), 1);
			assertEquals(test.getPrice(), 100);
			assertEquals(test.getSellprice(), 20);
			assertEquals(test.getMod(), '+');
			assertEquals(test.getStat(), "HP");
			assertEquals(test.getAmount(), 30);
			assertEquals(test.getDescription(), "This is a small potion used for healing minor wounds. Restores 30 HP");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Testing Equipable Constructor
	@Test
	public void testEquipable() {
			try {
				Equipable axe = new Equipable("Punisher's Axe", "Weapon");
				assertEquals(axe.getLevel(), 25);
				assertEquals(axe.getPrice(), 9000);
				assertEquals(axe.getSellprice(), 1200);
				assertEquals(axe.getMod(), '+');
				assertEquals(axe.getStat(), "Atk");
				assertEquals(axe.getAmount(), 35);
				assertEquals(axe.getDescription(), "A large hulking double-sided axe once belonging to the fierce Punisher. Legend says this Axe still holds the souls of it's many victims.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	//Testing Item Usage
	@Test
	public void testItemUsage() {
			try {
				Item test = new Item("A Small Health Potion");
				Player cleric45 = new Player(PlayerClass.CLERIC, 45, 0, 0, new Handler());
				int HP_check = cleric45.getHP();
				cleric45.setHP(cleric45.getHP() - 30);
				test.use(cleric45);
				assertEquals(HP_check, cleric45.getHP());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//Testing Equipable Usage
	public void testEquipableUsage() {
				try {
					Equipable axe = new Equipable("Punisher's Axe", "Weapon");
					Player paladin25 = new Player(PlayerClass.PALADIN, 25, 0, 0, new Handler());
					paladin25.setAttack(100);
					axe.wear(paladin25);
					assertEquals(paladin25.getAttack(), 135);
					paladin25.remove(axe);
					assertEquals(paladin25.getAttack(), 100);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
