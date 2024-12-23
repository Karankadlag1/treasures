package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	KeyHandler keyH;
	public int standCounter = 0;
	
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		super(gp);
		
		this.gp = gp;
		
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		attackArea.width = 36;
		attackArea.width = 36;
		
		setDefaultValues();
		getPlayerImage();
		getPlayerAttackImage();
	}
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 4;
		direction = "down";
		
		// PLAYER STATUS
		maxLife = 6;
		life = maxLife;
	}
	
	public void getPlayerImage() {
		
		up1 = setup("/player/player_up_1",gp.tileSize,gp.tileSize);
		up2 = setup("/player/player_up_2",gp.tileSize,gp.tileSize);
		up3 = setup("/player/player_up_3",gp.tileSize,gp.tileSize);
		up4 = setup("/player/player_up_4",gp.tileSize,gp.tileSize);
		up5 = setup("/player/player_up_5",gp.tileSize,gp.tileSize);
		up6 = setup("/player/player_up_6",gp.tileSize,gp.tileSize);
		up7 = setup("/player/player_up_7",gp.tileSize,gp.tileSize);
		up8 = setup("/player/player_up_8",gp.tileSize,gp.tileSize);
		down1 = setup("/player/player_down_1",gp.tileSize,gp.tileSize);
		down2 = setup("/player/player_down_2",gp.tileSize,gp.tileSize);
		down3 = setup("/player/player_down_3",gp.tileSize,gp.tileSize);
		down4 = setup("/player/player_down_4",gp.tileSize,gp.tileSize);
		down5 = setup("/player/player_down_5",gp.tileSize,gp.tileSize);
		down6 = setup("/player/player_down_6",gp.tileSize,gp.tileSize);
		down7 = setup("/player/player_down_7",gp.tileSize,gp.tileSize);
		down8 = setup("/player/player_down_8",gp.tileSize,gp.tileSize);
		left1 = setup("/player/player_left_1",gp.tileSize,gp.tileSize);
		left2 = setup("/player/player_left_2",gp.tileSize,gp.tileSize);
		left3 = setup("/player/player_left_3",gp.tileSize,gp.tileSize);
		left4 = setup("/player/player_left_4",gp.tileSize,gp.tileSize);
		left5 = setup("/player/player_left_5",gp.tileSize,gp.tileSize);
		left6 = setup("/player/player_left_6",gp.tileSize,gp.tileSize);
		left7 = setup("/player/player_left_7",gp.tileSize,gp.tileSize);
		left8 = setup("/player/player_left_8",gp.tileSize,gp.tileSize);
		right1 = setup("/player/player_right_1",gp.tileSize,gp.tileSize);
		right2 = setup("/player/player_right_2",gp.tileSize,gp.tileSize);
		right3 = setup("/player/player_right_3",gp.tileSize,gp.tileSize);
		right4 = setup("/player/player_right_4",gp.tileSize,gp.tileSize);
		right5 = setup("/player/player_right_5",gp.tileSize,gp.tileSize);
		right6 = setup("/player/player_right_6",gp.tileSize,gp.tileSize);
		right7 = setup("/player/player_right_7",gp.tileSize,gp.tileSize);
		right8 = setup("/player/player_right_8",gp.tileSize,gp.tileSize);
	}
	
	public void getPlayerAttackImage() {
		
//		attackUp1 = setup("/player/player_up_sword_1",gp.tileSize,gp.tileSize);
//		attackUp2 = setup("/player/player_up_sword_2",gp.tileSize,gp.tileSize);
		attackUp3 = setup("/player/player_up_sword_3",gp.tileSize,gp.tileSize);
		attackUp4 = setup("/player/player_up_sword_4",gp.tileSize,gp.tileSize);
//		attackDown1 = setup("/player/player_down_sword_1",gp.tileSize,gp.tileSize);
//		attackDown2 = setup("/player/player_down_sword_2",gp.tileSize,gp.tileSize);
		attackDown3 = setup("/player/player_down_sword_3",gp.tileSize,gp.tileSize);
		attackDown4 = setup("/player/player_down_sword_4",gp.tileSize,gp.tileSize);
//		attackLeft1 = setup("/player/player_left_sword_1",gp.tileSize,gp.tileSize);
//		attackLeft2 = setup("/player/player_left_sword_2",gp.tileSize,gp.tileSize);
		attackLeft3 = setup("/player/player_left_sword_3",gp.tileSize,gp.tileSize);
		attackLeft4 = setup("/player/player_left_sword_4",gp.tileSize,gp.tileSize);
//		attackRight1 = setup("/player/player_right_sword_1",gp.tileSize,gp.tileSize);
//		attackRight2 = setup("/player/player_right_sword_2",gp.tileSize,gp.tileSize);
		attackRight3 = setup("/player/player_right_sword_3",gp.tileSize,gp.tileSize);
		attackRight4 = setup("/player/player_right_sword_4",gp.tileSize,gp.tileSize);
	}

	public void update() {
		
		if(attacking == true) {
			attacking();
		}
		else if(keyH.upPressed == true || keyH.downPressed == true ||
				keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed == true)
		{
			if(keyH.upPressed == true) {
				direction = "up";
			}
			else if(keyH.downPressed == true) {
				direction = "down";
			}
			else if(keyH.leftPressed == true) {
				direction = "left";
			}
			else if(keyH.rightPressed == true) {
				direction = "right";
			}
			
			// CHECK TILE COLLISION
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			// CHECK OBJECT COLLISION
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			// CHECK NPC COLLISION
			int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
			interactNPC(npcIndex);
			
			// CHECK MONSTER COLLISION
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			interactMonster(monsterIndex);
			
			// CHECK EVENT
			gp.eHandler.checkEvent();
			
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			if(collisionOn == false) {
				
				switch(direction) {
				case "up": worldY -= speed; break;
				case "down": worldY += speed; break;
				case "left": worldX -= speed; break;
				case "right": worldX += speed; break;
				}
			}
			
			spriteCounter++;
		 	if(spriteCounter > 10) {
		 	    if(spriteNum == 1) { spriteNum = 2; }
		 		else if(spriteNum == 2) { spriteNum = 3; }
		 		else if(spriteNum == 3) { spriteNum = 4; }
		 		else if(spriteNum == 4) { spriteNum = 5; }
		 		else if(spriteNum == 5) { spriteNum = 6; }
		 		else if(spriteNum == 6) { spriteNum = 7; }
		 		else if(spriteNum == 7) { spriteNum = 8; }
		 		else if(spriteNum == 8) { spriteNum = 1; }
		 		spriteCounter = 0;
		 	}
		
	}
	else {
		standCounter++;
		if(standCounter == 20) {
			spriteNum = 1;
			standCounter = 0;
		}
	}
	// This needs to be outside of key if Statement
		if(invisible == true) {
			invisibleCounter++;
			if(invisibleCounter > 60) {
				invisible = false;
				invisibleCounter = 0;
			}
		}
		
}
	public void attacking() {
		
		spriteCounter++;
		if(spriteCounter <= 5) { 
			spriteNum = 1;
		}
		if(spriteCounter > 5 && spriteCounter <= 25) {
		  spriteNum = 2;
		  
		  // Save the current worldX, worldY, solidArea
		  int currentWorldX = worldX;
		  int currentWorldY = worldY;
		  int solidAreaWidth = solidArea.width;
		  int solidAreaHeight = solidArea.height;
		  
		  //Adjust player's worldX/Y for the attackArea
		}
		if(spriteCounter > 25) {
		  spriteNum = 1;
		  spriteCounter = 0;
		  attacking = false;
		}
	}
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
//			gp.obj[i] = null;
			
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Key":
				gp.playSE(1);
				hasKey++;
				gp.obj[i] = null;
			    System.out.println("Key:"+hasKey);
				gp.ui.showMessage("You got a Key!");
				break;
			case "Door":
				gp.playSE(3);
				if(hasKey > 0) {
					gp.obj[i] = null;
					hasKey--;
					gp.ui.showMessage("You Opened the door!");
				    System.out.println("Key:"+hasKey);
				}
				else {
					gp.ui.showMessage("You need a key!");
				}
				break;
			case "Boots":
				gp.playSE(2);
				speed += 4;
				gp.obj[i] = null;
				gp.ui.showMessage("Speed up!");
				break;
			case "Chest":
				gp.ui.gameFinished = true;
				gp.stopMusic();
				gp.obj[i] = null;
				gp.playSE(4);
				break;
			case "heart":
				
				
			}
		}
	}

	public void interactNPC(int i) {
		if(i != 999) {
			gp.ui.showMessage("you are hitting an NPC!");
		}
		
	}
	public void interactMonster(int i) {
		if(i != 999) {
			if(invisible == false) {
				life -= 1;
				invisible = true;
			}
			gp.ui.showMessage("you are hitting an Monster!");
		}
		if(gp.keyH.enterPressed == true) {
			attacking = true;
		}
	}
	public void draw(Graphics2D g2) {
		
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(attacking == false) {
				if(spriteNum == 1) { image = up1;	}
				if(spriteNum == 2) { image = up2;	}
				if(spriteNum == 3) { image = up3;	}
				if(spriteNum == 4) { image = up4;	}
				if(spriteNum == 5) { image = up5;	}
				if(spriteNum == 6) { image = up6;	}
				if(spriteNum == 7) { image = up7;	}
				if(spriteNum == 8) { image = up8;	}
			}
			if(attacking == true) {
//				if(spriteNum == 1) { image = attackUp1;	}
//				if(spriteNum == 2) { image = attackUp2;	}
				if(spriteNum == 1) { image = attackUp3;	}
				if(spriteNum == 2) { image = attackUp4;	}
			}
			break;
			
		case "down":
			if(attacking == false) {
				if(spriteNum == 1) { image = down1;	}
				if(spriteNum == 2) { image = down2;	}
				if(spriteNum == 3) { image = down3;	}
				if(spriteNum == 4) { image = down4;	}
				if(spriteNum == 5) { image = down5;	}
				if(spriteNum == 6) { image = down6;	}
				if(spriteNum == 7) { image = down7;	}
				if(spriteNum == 8) { image = down8;	}
			}
			if(attacking == true) {			
//				if(spriteNum == 1) { image = attackDown1;	}
//				if(spriteNum == 2) { image = attackDown2;	}
				if(spriteNum == 1) { image = attackDown3;	}
				if(spriteNum == 2) { image = attackDown4;	}
			}
			break;

			
		case "left":
			if(attacking == false) {
				if(spriteNum == 1) { image = left1;	}
				if(spriteNum == 2) { image = left2;	}
				if(spriteNum == 3) { image = left3;	}
				if(spriteNum == 4) { image = left4;	}
				if(spriteNum == 5) { image = left5;	}
				if(spriteNum == 6) { image = left6;	}
				if(spriteNum == 7) { image = left7;	}
				if(spriteNum == 8) { image = left8;	}
			}
			if(attacking == true) {			
//				if(spriteNum == 1) { image = attackLeft1;	}
//				if(spriteNum == 2) { image = attackLeft2;	}
				if(spriteNum == 1) { image = attackLeft3;	}
				if(spriteNum == 2) { image = attackLeft4;	}
			}
			break;
			
		case "right":
			if(attacking == false) {
				if(spriteNum == 1) { image = right1; }
				if(spriteNum == 2) { image = right2; }
				if(spriteNum == 3) { image = right3; }
				if(spriteNum == 4) { image = right4; }
				if(spriteNum == 5) { image = right5; }
				if(spriteNum == 6) { image = right6; }
				if(spriteNum == 7) { image = right7; }
				if(spriteNum == 8) { image = right8; }
			}
			if(attacking == true) {			
//				if(spriteNum == 1) { image = attackRight1; }
//				if(spriteNum == 2) { image = attackRight2; }
				if(spriteNum == 1) { image = attackRight3; }
				if(spriteNum == 2) { image = attackRight4; }
			}
			break;
		}
		
		int x = screenX;
		int y = screenY;
		
		if(screenX > worldX) {
			x = worldX;
		}
		if(screenY > worldY) { 
			y = worldY;
		}
		
		int rightOffset = gp.screenWidth - screenX;
		if(rightOffset > gp.worldWidth - worldX) {
			x = gp.screenWidth - (gp.worldWidth - worldX);
		}
		int bottomOffset = gp.screenHeight - screenY;
		if(bottomOffset > gp.worldHeight - worldY) {
			y = gp.screenHeight - (gp.worldHeight - worldY);
		}
		
		if(invisible == true) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
		// RESET ALPHA
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		
		// DEBUG
//		g2.setFont(new Font("Arial",Font.PLAIN, 26));
//		g2.setColor(Color.white);
//		g2.drawString("Invisible :"+invisibleCounter, 10, 400);
//		g2.setColor(Color.red);
//		g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
	}
}
