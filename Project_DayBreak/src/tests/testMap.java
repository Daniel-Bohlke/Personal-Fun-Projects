package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import daybreak_enums.OwnerType;
import daybreak_game.Map;
import daybreak_game.TileType;
import daybreak_model.Location;
import daybreak_model.ShopOwner;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class testMap {

	//Testing important parts of the map
	@Test
	public void test() {
		Map game_map = new Map();
		/*
		ShopOwner s1 = new ShopOwner(5, new Location(5, 4, game_map.map[9][1]), OwnerType.WEAPONS);
		assertEquals(s1, game_map.map[9][1].tileMap[6][5].character);
		*/
		assertEquals(TileType.SAVANNAH, game_map.map[0][0].type);
		assertEquals(TileType.MOUNTAIN, game_map.map[0][4].type);
		assertEquals(true, game_map.map[0][3].cave);
		assertEquals(TileType.DUNGEON, game_map.map[0][5].type);
		assertEquals(TileType.DESERT, game_map.map[2][1].type);
		assertEquals(true, game_map.map[2][0].pyramid);
		assertEquals(true, game_map.map[3][0].pyramid);
		assertEquals(true, game_map.map[3][0].cave);
		assertEquals(TileType.TOWN, game_map.map[3][4].type);
		assertEquals(TileType.PLAINS, game_map.map[3][6].type);
		assertEquals(true, game_map.map[3][6].cave);
		assertEquals(false, game_map.map[3][6].pyramid);
		assertEquals(TileType.FOREST, game_map.map[4][3].type);
		assertEquals(TileType.BEACH, game_map.map[5][0].type);
		assertEquals(TileType.FOREST, game_map.map[5][3].type);
		assertEquals(true, game_map.map[5][3].cave);
		assertEquals(TileType.COAST, game_map.map[6][1].type);
		//Ensuring no Towns or Dungeons have caves or pyramids
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 7; j++){
				if(game_map.map[i][j] != null){
				if((game_map.map[i][j].type == TileType.TOWN) || (game_map.map[i][j].type == TileType.DUNGEON)){
					//System.out.println("x: " + i + " y: " + j);
					assertEquals(false, game_map.map[i][j].cave);
					assertEquals(false, game_map.map[i][j].pyramid);
				}
				}
			}
		}
	}

}
