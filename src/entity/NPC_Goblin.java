package entity;

import java.util.Random;

import main.GamePanel;


public class NPC_Goblin extends Entity {

	public NPC_Goblin(GamePanel gp) {
		super(gp);
		
//		type = 1;
		direction = "down";
		speed = 1;
		
		getImage();
	}
	public void getImage() {
		
		up1 = setup("/npc/goblin_up_1",gp.tileSize,gp.tileSize);
		up2 = setup("/npc/goblin_up_2",gp.tileSize,gp.tileSize);
		up3 = setup("/npc/goblin_up_3",gp.tileSize,gp.tileSize);
		up4 = setup("/npc/goblin_up_4",gp.tileSize,gp.tileSize);
		up5 = setup("/npc/goblin_up_5",gp.tileSize,gp.tileSize);
		up6 = setup("/npc/goblin_up_6",gp.tileSize,gp.tileSize);
		up7 = setup("/npc/goblin_up_6",gp.tileSize,gp.tileSize);
		up8 = setup("/npc/goblin_up_8",gp.tileSize,gp.tileSize);
		down1 = setup("/npc/goblin_down_1",gp.tileSize,gp.tileSize);
		down2 = setup("/npc/goblin_down_2",gp.tileSize,gp.tileSize);
		down3 = setup("/npc/goblin_down_3",gp.tileSize,gp.tileSize);
		down4 = setup("/npc/goblin_down_4",gp.tileSize,gp.tileSize);
		down5 = setup("/npc/goblin_down_5",gp.tileSize,gp.tileSize);
		down6 = setup("/npc/goblin_down_6",gp.tileSize,gp.tileSize);
		down7 = setup("/npc/goblin_down_7",gp.tileSize,gp.tileSize);
		down8 = setup("/npc/goblin_down_7",gp.tileSize,gp.tileSize);
		left1 = setup("/npc/goblin_left_1",gp.tileSize,gp.tileSize);
		left2 = setup("/npc/goblin_left_2",gp.tileSize,gp.tileSize);
		left3 = setup("/npc/goblin_left_3",gp.tileSize,gp.tileSize);
		left4 = setup("/npc/goblin_left_4",gp.tileSize,gp.tileSize);
		left5 = setup("/npc/goblin_left_5",gp.tileSize,gp.tileSize);
		left6 = setup("/npc/goblin_left_6",gp.tileSize,gp.tileSize);
		left7 = setup("/npc/goblin_left_7",gp.tileSize,gp.tileSize);
		left8 = setup("/npc/goblin_left_7",gp.tileSize,gp.tileSize);
		right1 = setup("/npc/goblin_right_1",gp.tileSize,gp.tileSize);
		right2 = setup("/npc/goblin_right_2",gp.tileSize,gp.tileSize);
		right3 = setup("/npc/goblin_right_3",gp.tileSize,gp.tileSize);
		right4 = setup("/npc/goblin_right_4",gp.tileSize,gp.tileSize);
		right5 = setup("/npc/goblin_right_5",gp.tileSize,gp.tileSize);
		right6 = setup("/npc/goblin_right_6",gp.tileSize,gp.tileSize);
		right7 = setup("/npc/goblin_right_7",gp.tileSize,gp.tileSize);
		right8 = setup("/npc/goblin_right_7",gp.tileSize,gp.tileSize);
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
