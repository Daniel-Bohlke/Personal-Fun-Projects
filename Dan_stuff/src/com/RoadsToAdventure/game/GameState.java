package com.RoadsToAdventure.game;

import java.util.ArrayList;
import java.util.List;

import action.EnterCaveAction;
import action.EnterDifferentTileAction;
import action.EnterDungeonAction;
import action.PlayerAction;
import action.RestAction;
import action.WalkAction;
import com.RoadsToAdventure.enums.*;
import com.RoadsToAdventure.model.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public class GameState {
	
	private Player player;
	
	
	private Tile currentTile;
	public Tile getCurrentTile( ) { return currentTile; }
	public void setCurrentTile(Tile tile) { currentTile = tile; }
	
	//available player actions
	private ArrayList<PlayerAction> apa = preLoadList();
	
	//private Tile lastTile;
	
	
	private Location currentLocation;
	private Location locInFrontOfPlayer;
	
	private Square squareInFrontOfPlayer;
	
	
	private List<PlayerAction> availablePlayerActions;
	
	
	private GameViewState gameViewState;
	
	public GameState(Player player, Tile tile, Location location) {
		this.player = player;
		currentTile = tile;
		currentLocation = location;
		
		locInFrontOfPlayer = location.getLocationInFront();
		squareInFrontOfPlayer = location.getSquareInFront();
	}

	
	public void move(Direction direction) {
		currentLocation.move(direction);
	}
	
	private ArrayList<PlayerAction> preLoadList(){
		ArrayList<PlayerAction> pa = new ArrayList<PlayerAction>();
		
		pa.add(new EnterDifferentTileAction());
		pa.add(new EnterCaveAction());
		pa.add(new EnterDungeonAction());
		pa.add(new EnterDungeonAction());
		pa.add(new RestAction());
		pa.add(new WalkAction());
		
		return pa;
	}
	
	public Location getCurrentLocation() { return currentLocation; }
	public void setCurrentLocation(Location location) { currentLocation = location; }
	
}

