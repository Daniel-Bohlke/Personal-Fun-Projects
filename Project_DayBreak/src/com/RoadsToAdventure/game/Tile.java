package com.RoadsToAdventure.game;

import com.RoadsToAdventure.enums.OwnerType;
import com.RoadsToAdventure.model.Location;
import com.RoadsToAdventure.model.ShopOwner;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class Tile {

	//This is the Tile itself
	public Square[][] tileMap;
	//This is the type of Tile
	public TileType type;
	//Does it have a cave
	public boolean cave;
	//Does it have a Pyramid
	public boolean pyramid;
	
	Tile(TileType t, boolean c, boolean p){
		tileMap = new Square[20][20];
		type = t;
		cave = c;
		pyramid = p;
		if(type == TileType.TOWN){
			genTown();
		}
	}

	private void genTown() {
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				this.tileMap[i][j] = new Square(false, true, null);
			}
		}
		for(int a = 15; a < 20; a++){
			for(int b = 0; b < 5; b++){
				this.tileMap[a][b] = new Square(false, true, null);
			}
		}
		for(int c = 0; c < 5; c++){
			for(int d = 15; d < 20; d++){
				this.tileMap[c][d] = new Square(false, true, null);
			}
		}
		for(int e = 15; e < 20; e++){
			for(int f = 15; f < 20; f++){
				this.tileMap[e][f] = new Square(false, true, null);
			}
		}
		//All ShopOwners are currently the same but won't be normally, this is for simple testing
		
		//ShopOwner s1 = new ShopOwner(5, new Location(5, 4, this), OwnerType.WEAPONS);
		
		/*
		//this.tileMap[5][4] = new Square(true, false, s1);
		//this.tileMap[5][15] = new Square(true, false, s1);
		//this.tileMap[14][4] = new Square(true, false, s1);
		//this.tileMap[14][15] = new Square(true, false, s1);
		 *
		 */
		for(int g = 0; g < 20; g++){
			for(int h = 0; h < 20; h++){
				if(this.tileMap[g][h] == null){
					tileMap[g][h] = new Square(false, false, null);
				}
				if(((tileMap[g][h].isInaccessible() != true) && (tileMap[g][h].isOccupied() != true))){
					tileMap[g][h] = new Square(false, false, null);
				}
			}
		}
	}

	/**
	 * @return the tile
	 */
	public Square[][] getTileMap() {
		return tileMap;
	}

	/**
	 * @param tile the tile to set
	 */
	public void setTile(Square[][] tile) {
		this.tileMap = tile;
	}

	/**
	 * @return the type
	 */
	public TileType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TileType type) {
		this.type = type;
	}

	/**
	 * @return the cave
	 */
	public boolean isCave() {
		return cave;
	}

	/**
	 * @param cave the cave to set
	 */
	public void setCave(boolean cave) {
		this.cave = cave;
	}

	/**
	 * @return the pyramid
	 */
	public boolean isPyramid() {
		return pyramid;
	}

	/**
	 * @param pyramid the pyramid to set
	 */
	public void setPyramid(boolean pyramid) {
		this.pyramid = pyramid;
	}
	
	public Square getSquare(int x, int y) { return tileMap[x][y]; }
	
}

