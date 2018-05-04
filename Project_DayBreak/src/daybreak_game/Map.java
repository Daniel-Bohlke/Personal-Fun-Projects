package daybreak_game;

import daybreak_game.TileType;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class Map {

	//This is the Map itself
	public Tile[][] map;
	
	public Map(){
		//Creating World Map
		map = new Tile[10][7];
		map[0][0] = new Tile(TileType.SAVANNAH, true, false);
		map[0][1] = new Tile(TileType.TOWN, false, false);
		map[0][2] = new Tile(TileType.MOUNTAIN, false, false);
		map[0][3] = new Tile(TileType.MOUNTAIN, true, false);
		map[0][4] = new Tile(TileType.MOUNTAIN, false, false);
		map[0][5] = new Tile(TileType.DUNGEON, false, false);
		map[1][1] = new Tile(TileType.SAVANNAH, false, false);
		map[1][2] = new Tile(TileType.MOUNTAIN, false, false);
		map[1][3] = new Tile(TileType.MOUNTAIN, false, false);
		map[2][0] = new Tile(TileType.DESERT, false, true);
		map[2][1] = new Tile(TileType.DESERT, false, false);
		map[2][2] = new Tile(TileType.DESERT, false, false);
		map[2][3] = new Tile(TileType.SAVANNAH, false, false);
		map[2][4] = new Tile(TileType.DUNGEON, false, false);
		map[2][6] = new Tile(TileType.PLAINS, false, false);
		map[3][0] = new Tile(TileType.DESERT, true, true);
		map[3][1] = new Tile(TileType.DESERT, false, false);
		map[3][2] = new Tile(TileType.SAVANNAH, false, false);
		map[3][3] = new Tile(TileType.SAVANNAH, false, false);
		map[3][4] = new Tile(TileType.TOWN, false, false);
		map[3][5] = new Tile(TileType.PLAINS, false, false);
		map[3][6] = new Tile(TileType.PLAINS, true, false);
		map[4][2] = new Tile(TileType.SAVANNAH, false, false);
		map[4][3] = new Tile(TileType.FOREST, false, false);
		map[5][0] = new Tile(TileType.BEACH, false, false);
		map[5][1] = new Tile(TileType.TOWN, false, false);
		map[5][2] = new Tile(TileType.FOREST, false, false);
		map[5][3] = new Tile(TileType.FOREST, true, false);
		map[6][0] = new Tile(TileType.BEACH, false, false);
		map[6][1] = new Tile(TileType.COAST, false, false);
		map[6][2] = new Tile(TileType.FOREST, false, false);
		map[6][3] = new Tile(TileType.FOREST, false, false);
		map[6][4] = new Tile(TileType.DUNGEON, false, false);
		map[7][0] = new Tile(TileType.BEACH, false, false);
		map[7][1] = new Tile(TileType.COAST, false, false);
		map[7][2] = new Tile(TileType.PLAINS, false, false);
		map[7][3] = new Tile(TileType.FOREST, false, false);
		map[7][4] = new Tile(TileType.FOREST, false, false);
		map[7][5] = new Tile(TileType.TOWN, false, false);
		map[8][0] = new Tile(TileType.BEACH, false, false);
		map[8][1] = new Tile(TileType.COAST, false, false);
		map[8][2] = new Tile(TileType.TOWN, false, false);
		map[8][3] = new Tile(TileType.PLAINS, false, false);
		map[8][4] = new Tile(TileType.PLAINS, false, false);
		map[9][1] = new Tile(TileType.TOWN, false, false);
		map[9][2] = new Tile(TileType.PLAINS, false, false);
		map[9][3] = new Tile(TileType.PLAINS, false, false);
		map[9][4] = new Tile(TileType.PLAINS, true, false);
		map[9][5] = new Tile(TileType.PLAINS, false, false);
		map[9][6] = new Tile(TileType.DUNGEON, false, false);
	}

	/**
	 * @return the map
	 */
	public Tile[][] getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Tile[][] map) {
		this.map = map;
	}
}

