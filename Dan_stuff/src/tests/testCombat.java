package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.RoadsToAdventure.model.*;
import com.RoadsToAdventure.enums.*;
import com.RoadsToAdventure.game.Handler;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class testCombat {

	@Test
	public void test() {
		//Testing a lvl 1 mage vs a lvl 1 Goblin (mage should win)
		try {
			Monster goblin = new Monster("Goblin", 0, 0);
			Player mage1 = new Player(PlayerClass.MAGE, 0, 0, new Handler());
			System.out.println("BEGIN: MAGE LVL 1 VS GOBLIN LVL 1");
			while(goblin.isAlive() && mage1.isAlive()){
				System.out.println(goblin.interact(mage1));
			}
			assertEquals(mage1.isAlive(), true);
			assertEquals(mage1.getExp(), 10, 0.0);
			assertEquals(mage1.getGold(), 505, 0.0);
			assertEquals(mage1.getMaxHP(), mage1.getHP());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Testing a lvl 10 rogue vs lvl 25 Punisher Boss (Punisher should definitely win)
			try {
				Equipable reward = new Equipable("Punisher's Axe", "Weapon");
				Boss punisher = new Boss("The Punisher (Boss)", reward, 0, 0);
				Player rogue10 = new Player(PlayerClass.ROGUE, 10, 0, 0, new Handler());
				System.out.println("BEGIN: ROGUE LVL 10 VS THE PUNISHER LVL 25");
				while(punisher.isAlive() && rogue10.isAlive()){
					System.out.println(punisher.interact(rogue10));
				}
			assertEquals(punisher.isAlive(), true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//Testing a lvl 60 paladin vs lvl 25 Punisher Boss (Paladin should win)
			try {
				Equipable reward = new Equipable("Punisher's Axe", "Weapon");
				Boss punisher = new Boss("The Punisher (Boss)", reward, 0, 0);
				Player paladin60 = new Player(PlayerClass.PALADIN, 60, 0, 0, new Handler());
				//Adding Attack and Speed to Paladin as in some tests, there was an infinite loop because the paladin's attack was too low or was killed instantly
				paladin60.setAttack(paladin60.getAttack() + 200);
				paladin60.setSpeed(paladin60.getSpeed() + 200);
				System.out.println("BEGIN: PALADIN LVL 60 VS THE PUNISHER LVL 25");
				while(punisher.isAlive() && paladin60.isAlive()){
					System.out.println(punisher.interact(paladin60));
				}
			assertEquals(paladin60.isAlive(), true);
			assertEquals(paladin60.getExp(), 3500, 0.0);
			assertEquals(paladin60.getGold(), 1130, 0.0);
			assertNotSame(paladin60.getHP(), paladin60.getMaxHP());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
