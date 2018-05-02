package com.RoadsToAdventure.game;

import com.RoadsToAdventure.model.*;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.RoadsToAdventure.enums.*;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private boolean isRunning = false;
	private Thread thread;
	private Handler handler;
	
	public Game(){
		new Window(1000, 563, "Roads To Adventure", this);
		start();
		
		this.handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		this.handler.addObject(new Player(PlayerClass.MAGE, 100, 100, this.handler));
		this.handler.addObject(new Civilian(200, 100));
		try {
			this.handler.addObject(new Monster("Goblin", 500, 400));
			this.handler.addObject(new Boss("The Punisher (Boss)", new Equipable("Punisher's Axe", "Weapon"), 600, 100));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void start(){
		this.isRunning = true;
		this.thread = new Thread(this);
		this.thread.start();
	}
	
	private void stop(){
		this.isRunning = false;
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}
	
	public void tick(){
		handler.tick();
	}
	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		////////////////////////////////////////
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 563);
		
		//Important that handler renders after background or else background will be on top of everything
		handler.render(g);
		
		////////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]){
		new Game();
	}
	
	
	//map
	/**
	public Map gameMap;
	
	private GameState state;
	
	public Game(){
		gameMap = new Map();
		Player player1 = new Player(PlayerClass.MAGE);
		state = new GameState(player1, gameMap.map[8][2], new Location(10, 9, 
				Direction.SOUTH, gameMap.map[8][2]));
		state.getCurrentTile().tileMap[10][9].character = player1;
		
	}

	public Map getGameMap() {
		return gameMap;
	}

	public void setGameMap(Map gameMap) {
		this.gameMap = gameMap;
	}
	
	public Tile getCurrentTile() { return state.getCurrentTile(); }
	public void setCurrentTile(Tile tile) { this.state.setCurrentTile(tile); }
	
	public GameState getGameState() { return state; }
	public void setGameState(GameState state) { this.state = state; }
*/
}

