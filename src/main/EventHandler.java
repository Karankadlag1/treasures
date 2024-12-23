package main;

import java.awt.Rectangle;

public class EventHandler {

	GamePanel gp;
	Rectangle eventRect;
	int eventRectDefaultX, eventRectDefaultY;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventRect = new Rectangle();
		eventRect.x  = 23;
		eventRect.y = 23;
		eventRect.width = 2;
		eventRect.height = 2;
		eventRectDefaultX = eventRect.x;
		eventRectDefaultY = eventRect.y;	
	}
	public void checkEvent() {
		if(hit(25,12,"right") == true) { damagePit(gp.playState); }
		if(hit(25,12,"left") == true) { damagePit(gp.playState); }
		if(hit(22,12,"left") == true) { damagePit(gp.playState); }
		if(hit(21,21,"up") == true) { healingPit(gp.playState); }
		if(hit(21,21,"left") == true) { healingPit(gp.playState); }
		if(hit(25,21,"up") == true) { healingPit(gp.playState); }
		if(hit(25,21,"right") == true) { healingPit(gp.playState); }
//		if(hit(21,26,"down") == true) { healingPit(gp.playState); }
//		if(hit(21,26,"left") == true) { healingPit(gp.playState); }
		if(hit(25,26,"down") == true) { healingPit(gp.playState); }
		if(hit(25,26,"right") == true) { healingPit(gp.playState); }
		if(hit(21,26,"down") == true) { teleport(gp.playState); }
		if(hit(21,26,"left") == true) { teleport(gp.playState); }
	}
	public boolean hit(int eventCol, int eventRow, String reqDirection) {
		
		boolean hit = false;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		eventRect.x = eventCol * gp.tileSize + eventRect.x;
		eventRect.y = eventRow * gp.tileSize + eventRect.y;
		
		if(gp.player.solidArea.intersects(eventRect)) {
			if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
				hit = true;
			}
		}
		
		gp.player.solidArea.x =  gp.player.solidAreaDefaultX;
		gp.player.solidArea.y =  gp.player.solidAreaDefaultY;
		eventRect.x = eventRectDefaultX;
		eventRect.y = eventRectDefaultY;
		
		return hit;
	}
	public void damagePit(int gameState) {
		
		gp.gameState = gameState;
		gp.ui.showMessage("You fall in pit!");
		gp.player.life -= 0000000.25;
	}
	public void healingPit(int gameState) {
		gp.gameState = gameState;
		if(gp.player.life < 6) {
			gp.ui.showMessage("You have healed through torch.\nYour Life has been recovered.");
		}
	
		gp.player.life = gp.player.maxLife;
	}
	public void teleport(int gameState) {
		gp.gameState = gameState;
		gp.ui.showMessage("Teleport!");
		gp.player.worldX = gp.tileSize*25;
		gp.player.worldY = gp.tileSize*12;
	}
//	gp.keyH.enterPressed = false;
}
