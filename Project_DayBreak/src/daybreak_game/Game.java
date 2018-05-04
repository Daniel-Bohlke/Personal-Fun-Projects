package daybreak_game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import daybreak_enums.PlayerClass;
import daybreak_model.Boss;
import daybreak_model.Equipable;
import daybreak_model.Item;
import daybreak_model.Monster;
import daybreak_model.Player;

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
	private Camera camera;
	private SpriteSheet ss;
	
	private BufferedImage level1 = null;
	private BufferedImage sprite_sheet = null;
	private BufferedImage floor = null;
	
	public Game(){
		new Window(1000, 563, "Roads To Adventure", this);
		start();
		
		this.handler = new Handler();
		this.camera = new Camera(0,0);
		this.addKeyListener(new KeyInput(handler));
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level1 = loader.loadImage("/Level.png");
		sprite_sheet = loader.loadImage("/SpriteSheet.png");
		
		ss = new SpriteSheet(sprite_sheet);
		
		floor = ss.grabImage(1, 1, 32, 32);
		
		loadLevel(level1);
		
		/**
		this.handler.addObject(new Player(PlayerClass.MAGE, 100, 100, this.handler));
		this.handler.addObject(new Civilian(200, 100));
		try {
			this.handler.addObject(new Monster("Goblin", 500, 400));
			this.handler.addObject(new Boss("The Punisher (Boss)", new Equipable("Punisher's Axe", "Weapon"), 600, 100));
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
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
		
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getId() == ID.Player){
				camera.tick(handler.object.get(i));
			}
		}
			
		handler.tick();
	}
	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		////////////////////////////////////////
		
		//g.setColor(Color.WHITE);
		//g.fillRect(0, 0, 1000, 563);
		
		g2d.translate(-camera.getX(), -camera.getY());
		
		for(int xx = 0; xx < 30*72; xx += 32){
			for(int yy = 0; yy < 30*72; yy += 32){
				g.drawImage(floor, xx, yy, null);
			}
		}
		
		//Important that handler renders after background or else background will be on top of everything
		handler.render(g);
		
		g2d.translate(camera.getX(), camera.getY());
		
		////////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	//Load Level Screen
	private void loadLevel(BufferedImage image){
		int w = image.getWidth();
		int h = image.getHeight();
		
		
		for(int xx = 0; xx < w; xx++){
			for(int yy = 0; yy < h; yy++){
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255){
					handler.addObject(new Block(xx*32, yy*32, ID.Block, ss));
				}
				if(blue == 255 && green == 0){
					handler.addObject(new Player(PlayerClass.MAGE, xx*32, yy*32, this.handler, ss));
				}
				if(green == 255 && blue == 0){
					try {
						handler.addObject(new Monster("Goblin", xx*32, yy*32, this.handler, ss));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(blue == 255 && green == 255){
					try {
						handler.addObject(new Boss("The Punisher (Boss)", new Equipable("Punisher's Axe", "Weapon", -5, -5, this.handler, ss), xx*32, yy*32, this.handler, ss));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(blue == 100 && green == 100){
					try {
						handler.addObject(new Item("A Small Health Potion", xx*32, yy*32, this.handler, ss));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
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

