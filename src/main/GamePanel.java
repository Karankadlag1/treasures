package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

// WORK AS GAME SCREEN
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{

	// SCREEN SETTINGS
	final int orignalTileSize = 16; // 16x16 tile
	final int scale = 3; // 16x3 = 48 tile
	
	public final int tileSize = orignalTileSize * scale; // 48x48 tile
	public final int maxScreenCol = 20;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; // 48x16 = 768 pixels
	public final int screenHeight = tileSize * maxScreenRow; // 48x12 = 576 pixels
	
	// WORLD SETTINGS
    public final int maxWorldCol = 50;   //50
    public final int maxWorldRow = 50;   //50
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

	
	TileManager tileM = new TileManager(this);
 	public KeyHandler keyH = new KeyHandler(this);
	Sound music = new Sound();
	Sound se = new Sound();
	
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	public EventHandler eHandler = new EventHandler(this);
	Thread gameThread;
	
	// ENTITY AND OBJECT
	public Player player = new Player(this,keyH);
	public SuperObject obj[] = new SuperObject[30];
    public Entity npc[] = new Entity[10];
    public Entity monster[] = new Entity[10];
	
	// FPS
	int FPS = 60;
	
	// SET PLAYER'S DEFAULT POSITION
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
    // GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int gameOverState = 3;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	 
	public void setupGame() {
		
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonster();
//		playMusic(0);
//		stopMusic();
		gameState = titleState;
	}
	
	 public void retry() {
	    	player.setDefaultValues();
//	    	player.restoreLife();
	    }
	 
	    public void restart() {
	    	player.setDefaultValues();
//	    	player.restoreLife();
	    	player.hasKey = 0;
	    } 
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double drawInterval = 1_000_000_000/FPS; //0.0166666 SECONDS
		double nextDrawTime = System.nanoTime() + drawInterval;

		
		while(gameThread != null) {   // ala this gameThread exists its repeat the process that is written inside this bracket 
			
			long currentTime = System.nanoTime(); // 1MILLION(1000000000) NANO SEC = 1 SEC
//			System.out.println("The Game Loop is Running"+currentTime);
			
			// 1. UPDATE: update information such as Character Position
			update();
			// 2. DRAW: draw the Screen with updated information
			repaint();
			
			try {
                double remainingTime = nextDrawTime - currentTime;
                remainingTime = remainingTime / 1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
		}
	}
	
	public void update() {
		if(gameState == playState) {
			// PLAYER
			player.update();
			// NPC
			for(int i = 0; i < npc.length; i++) {
				if(npc[i] != null) {
					npc[i].update();
				}
			}
			for(int i = 0; i < monster.length; i++) {
				if(monster[i] != null) {
					monster[i].update();
				}
			}
			
		}
		if(gameState == pauseState) {
			// nothing 
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		// DEBUG
		long drawStart = 0;
		if(keyH.checkDrawTime == true) {
			drawStart = System.nanoTime();
		}

		 // TITLE SCREEN
        if(gameState == titleState) {
        	ui.draw(g2);
        }
        
        // OTHERS
        else {
        	 // TILE
            tileM.draw(g2);
            
            //OBJECT
            for(int i = 0; i < obj.length; i++) {
            	if(obj[i] != null) {
            		obj[i].draw(g2, this);
            	}
            }
            
            // NPC 
            for(int i = 0; i < npc.length; i++) {
            	if(npc[i] != null) {
            		npc[i].draw(g2);
            	}
            }
            
            // MONSTER
            for(int i = 0; i < monster.length; i++) {
            	if(monster[i] != null) {
            		monster[i].draw(g2);
            	}
            }
            
            // PLAYER
            player.draw(g2);
            
            //UI
            ui.draw(g2);
        }
		
		// DEBUG
		if(keyH.checkDrawTime == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("Draw Time: " +passed, 10, 400);
			System.out.println("Draw Time: " +passed);
		}
	}
	
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();
	}
	public void stopMusic() {
		
		music.stop();
	}
	public void playSE(int i) {
		
		se.setFile(i);
		se.play();
	}
}
