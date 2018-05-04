package daybreak_model;

import daybreak_enums.*;
import daybreak_game.*;

public class Location {

	private int x, y;
	private int priorx, priory;
	private Direction direction;
	
	private Tile tile;
	public Square square;
	
	public Location() {}
	
	public Location(int x, int y, Direction direction, Tile tile) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.tile = tile;
		updateSquare();
		priorx = -1;
		priory = -1;
	}
	
	public Location(int x, int y, Tile tile) {
		this.x = x;
		this.y = y;
		this.direction = Direction.SOUTH;
		this.tile = tile;
		updateSquare();
		priorx = -1;
		priory = -1;
	}
	
	public void move(Direction direction) {
		switch(direction) {
		case NORTH: setY(y+1);
		case SOUTH: setY(y-1);
		case EAST: setX(x+1);
		case WEST: setX(x-1);
		}
	}
	
	public int getX() { return x; }
	public void setX(int x) { 
		priorx = this.x;
		this.x = x; 
		updateSquare(); 
		}
	
	public int getY() { return y; }
	public void setY(int y) { 
		priory = this.y;
		this.y = y; 
		updateSquare(); 
		}
	
	public Direction getDirection() { return direction; }
	public void setDirection(Direction direction) { this.direction = direction; }
	
	public void updateDirection() {
		if(priorx < 0 || priory < 0) return;
		
		int xdif = x - priorx;
		int ydif = y - priory;
		
		if(ydif == 0) {
			if(xdif > 0) { direction = Direction.EAST; return; }
			if(xdif < 0) { direction = Direction.WEST; return; }
		}
		if(xdif == 0) {
			if(ydif < 0) { direction = Direction.SOUTH; return; }
			if(ydif < 0) { direction = Direction.NORTH; return; }
		}
	}
	
	public void updateSquare() { square = tile.getSquare(x, y); updateDirection();}
	
	public Location getLocationInFront() {
		int tmpx = x;
		int tmpy = y;
		Direction tmpdir = null;
		
		switch(this.direction) {
		case EAST: { tmpx++; tmpdir = Direction.WEST; }
		case WEST: { tmpx--; tmpdir = Direction.EAST; }
		case NORTH: { tmpy++; tmpdir = Direction.SOUTH; }
		case SOUTH: { tmpy--; tmpdir = Direction.NORTH; }
		}
		
		Location rl = new Location(tmpx, tmpy, tmpdir, this.tile);
		return rl;
	}
	
	public Square getSquareInFront() {
		Location loc = getLocationInFront();
		Square sq = tile.tileMap[loc.getX()][loc.getY()];
		return sq;
	}
	
	public Square getSquareByDirection(Direction direction) {
		if(direction == null) return null;
		
		Square toRet = null;
		
		if(direction == Direction.NORTH) { toRet = tile.getSquare(x, y+1); }
		if(direction == Direction.SOUTH) { toRet = tile.getSquare(x, y-1); }
		if(direction == Direction.EAST) { toRet = tile.getSquare(x+1, y); }
		if(direction == Direction.WEST) { toRet = tile.getSquare(x-1, y); }
		
		return toRet;
	}

	public int getPriorx() {
		return priorx;
	}

	public void setPriorx(int priorx) {
		this.priorx = priorx;
	}

	public int getPriory() {
		return priory;
	}

	public void setPriory(int priory) {
		this.priory = priory;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}
}
