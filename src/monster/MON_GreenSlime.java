package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MON_GreenSlime extends Entity{

	GamePanel gp;
	public MON_GreenSlime(GamePanel gp) {
		super(gp);
		this.gp = gp;
		type = 2;
		direction = "down";
		speed = 1;
		maxLife = 4;
		life = maxLife;
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		
		up1 = setup("/monster/green_slime_1",gp.tileSize,gp.tileSize);
		up2 = setup("/monster/green_slime_2",gp.tileSize,gp.tileSize);
		up3 = setup("/monster/green_slime_3",gp.tileSize,gp.tileSize);
		up4 = setup("/monster/green_slime_4",gp.tileSize,gp.tileSize);
		up5 = setup("/monster/green_slime_5",gp.tileSize,gp.tileSize);
		up6 = setup("/monster/green_slime_6",gp.tileSize,gp.tileSize);
		up7 = setup("/monster/green_slime_7",gp.tileSize,gp.tileSize);
		up8 = setup("/monster/green_slime_8",gp.tileSize,gp.tileSize);
		down1 = setup("/monster/green_slime_1",gp.tileSize,gp.tileSize);
		down2 = setup("/monster/green_slime_2",gp.tileSize,gp.tileSize);
		down3 = setup("/monster/green_slime_3",gp.tileSize,gp.tileSize);
		down4 = setup("/monster/green_slime_4",gp.tileSize,gp.tileSize);
		down5 = setup("/monster/green_slime_5",gp.tileSize,gp.tileSize);
		down6 = setup("/monster/green_slime_6",gp.tileSize,gp.tileSize);
		down7 = setup("/monster/green_slime_7",gp.tileSize,gp.tileSize);
		down8 = setup("/monster/green_slime_8",gp.tileSize,gp.tileSize);
		left1 = setup("/monster/green_slime_1",gp.tileSize,gp.tileSize);
		left2 = setup("/monster/green_slime_2",gp.tileSize,gp.tileSize);
		left3 = setup("/monster/green_slime_3",gp.tileSize,gp.tileSize);
		left4 = setup("/monster/green_slime_4",gp.tileSize,gp.tileSize);
		left5 = setup("/monster/green_slime_5",gp.tileSize,gp.tileSize);
		left6 = setup("/monster/green_slime_6",gp.tileSize,gp.tileSize);
		left7 = setup("/monster/green_slime_7",gp.tileSize,gp.tileSize);
		left8 = setup("/monster/green_slime_8",gp.tileSize,gp.tileSize);
		right1 = setup("/monster/green_slime_1",gp.tileSize,gp.tileSize);
		right2 = setup("/monster/green_slime_2",gp.tileSize,gp.tileSize);
		right3 = setup("/monster/green_slime_3",gp.tileSize,gp.tileSize);
		right4 = setup("/monster/green_slime_4",gp.tileSize,gp.tileSize);
		right5 = setup("/monster/green_slime_5",gp.tileSize,gp.tileSize);
		right6 = setup("/monster/green_slime_6",gp.tileSize,gp.tileSize);
		right7 = setup("/monster/green_slime_7",gp.tileSize,gp.tileSize);
		right8 = setup("/monster/green_slime_8",gp.tileSize,gp.tileSize);
	}
	public void setAction() {
		
	actionLockCounter++; 
	
	if(actionLockCounter == 120) {
		
		Random random = new Random();
		int i = random.nextInt(100)+1; // pick a number between 1 to 100
		
		if(i <= 25) {
			direction = "up";
		}
		if(i > 25 && i <= 50) {
			direction = "down";
		}
		if(i > 50 && i <= 75) {
			direction = "left";
		}
		if(i > 75 && i <= 100) {
			direction = "right";
		}
		
		actionLockCounter = 0;
	}
	}

}
