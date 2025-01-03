package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {


	GamePanel gp;
	public BufferedImage up1, up2, up3, up4, up5, up6, up7, up8,
     down1, down2, down3, down4, down5, down6, down7, down8,
	 left1, left2, left3, left4, left5, left6, left7, left8,
	 right1, right2, right3, right4, right5, right6, right7, right8;
	public BufferedImage attackUp1, attackUp2, attackUp3, attackUp4,
	attackDown1, attackDown2, attackDown3, attackDown4, attackLeft1,
	attackLeft2, attackLeft3, attackLeft4, attackRight1, attackRight2,
	attackRight3, attackRight4;
	public Rectangle solidArea = new Rectangle(0, 0 ,48, 48);
	public Rectangle attackArea = new Rectangle(0, 0 ,0, 0);
	public int solidAreaDefaultX, solidAreaDefaultY;
	
	// STATE
	public int worldX, worldY;
	public String direction = "down";
    public int spriteNum = 1;
	public boolean collisionOn = false;
	public boolean invisible = false;
	boolean attacking = false;
	
	// COUNTER
	public int spriteCounter = 0;
	public int actionLockCounter = 0;
	public int invisibleCounter = 0;
	
	// CHARACTER STATUS
	public int type; // 0 - player, 1 - NPC, 2 - monster
	public int speed;
	public int maxLife;
	public int life;
	
	public Entity(GamePanel gp) {
		 this.gp = gp;
	}
    public void setAction() {
		
	}
	public void update() {
		setAction();
		
		collisionOn = false;
		gp.cChecker.checkTile(this); 
		gp.cChecker.checkObject(this, false);
		gp.cChecker.checkEntity(this, gp.npc);
		gp.cChecker.checkEntity(this, gp.monster);
		boolean contactPlayer = gp.cChecker.checkPlayer(this);
		
		if(this.type == 2 && contactPlayer == true) {
			if(gp.player.invisible == false) {
				// we can give damage
				gp.player.life -= 1;
				gp.player.invisible = true;
			}
		}
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
	 	else {
	 		int standCounter = 0;
			standCounter ++;
	 		if(standCounter == 20) {
	 			spriteNum = 1;
	 			standCounter = 0;
	 		}
	 	}
}
	public void draw (Graphics2D g2) {
	
	BufferedImage image = null;
	int screenX = worldX - gp.player.worldX + gp.player.screenX;
	int screenY = worldY - gp.player.worldY + gp.player.screenY;
	
	if(gp.player.screenX > gp.player.worldX) {
		screenX = worldX;
	}
	if(gp.player.screenY > gp.player.worldY) {
		screenY = worldY;
	}
	int rightOffset = gp.screenWidth - gp.player.screenX;
	if(rightOffset > gp.worldWidth - gp.player.worldX) {
		screenX = gp.screenWidth - (gp.worldWidth - worldX);
	}
	int bottomOffset = gp.screenHeight - gp.player.screenY;
	if(bottomOffset > gp.worldHeight - gp.player.worldY) {
		screenY = gp.screenHeight - (gp.worldHeight - worldY);
	}
	if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
	   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
       worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
	   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

		switch(direction) {
		case "up":
			if(spriteNum == 1) { image = up1;	}
			if(spriteNum == 2) { image = up2;	}
			if(spriteNum == 3) { image = up3;	}
			if(spriteNum == 4) { image = up4;	}
			if(spriteNum == 5) { image = up5;	}
			if(spriteNum == 6) { image = up6;	}
			if(spriteNum == 7) { image = up7;	}
			if(spriteNum == 8) { image = up8;	}
			break;
			
		case "down":
			if(spriteNum == 1) { image = down1;	}
			if(spriteNum == 2) { image = down2;	}
			if(spriteNum == 3) { image = down3;	}
			if(spriteNum == 4) { image = down4;	}
			if(spriteNum == 5) { image = down5;	}
			if(spriteNum == 6) { image = down6;	}
			if(spriteNum == 7) { image = down7;	}
			if(spriteNum == 8) { image = down8;	}
			break;
			
		case "left":
			if(spriteNum == 1) { image = left1;	}
			if(spriteNum == 2) { image = left2;	}
			if(spriteNum == 3) { image = left3;	}
			if(spriteNum == 4) { image = left4;	}
			if(spriteNum == 5) { image = left5;	}
			if(spriteNum == 6) { image = left6;	}
			if(spriteNum == 7) { image = left7;	}
			if(spriteNum == 8) { image = left8;	}
			
			break;
			
		case "right":
			if(spriteNum == 1) { image = right1; }
			if(spriteNum == 2) { image = right2; }
			if(spriteNum == 3) { image = right3; }
			if(spriteNum == 4) { image = right4; }
			if(spriteNum == 5) { image = right5; }
			if(spriteNum == 6) { image = right6; }
			if(spriteNum == 7) { image = right7; }
			if(spriteNum == 8) { image = right8; }
			break;
		}
		
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
	else if(gp.player.screenX > gp.player.worldX ||
			gp.player.screenY > gp.player.worldY ||
			rightOffset > gp.worldWidth - gp.player.worldX ||
			bottomOffset > gp.worldHeight - gp.player.worldY) {
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
	public BufferedImage setup(String imagePath, int width, int height) {
		
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
			image = uTool.scaleImage(image, width, height); 
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}


