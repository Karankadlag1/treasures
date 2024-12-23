package main;

import entity.NPC_Goblin;
import monster.MON_GreenSlime;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Pipe;
import object.OBJ_Skull;
import object.OBJ_SmallPipe;
import object.OBJ_Torch;
import object.OBJ_WallG;
import object.OBJ_WallGoo;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp =  gp;
	}
	
	public void setObject() {
		
//		gp.obj[122] = new Tile();
//		gp.obj[122].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor_gargoyle_green_basin.png"));
//		gp.obj[122].collision = true;
		gp.obj[0] = new OBJ_Key(gp);
		gp.obj[0].worldX = 23 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key(gp);
		gp.obj[1].worldX = 23 * gp.tileSize;
		gp.obj[1].worldY = 40 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Key(gp);
		gp.obj[2].worldX = 37 * gp.tileSize;
		gp.obj[2].worldY = 11 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Door(gp);
		gp.obj[3].worldX = 10 * gp.tileSize;
		gp.obj[3].worldY = 14 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Door(gp);
		gp.obj[4].worldX = 7 * gp.tileSize;
		gp.obj[4].worldY = 32 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Door(gp);
		gp.obj[5].worldX = 12 * gp.tileSize;
		gp.obj[5].worldY = 26 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Chest(gp);
		gp.obj[6].worldX = 10 * gp.tileSize;
		gp.obj[6].worldY = 7 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Boots(gp);
		gp.obj[7].worldX = 37 * gp.tileSize;
		gp.obj[7].worldY = 45 * gp.tileSize;
		
		gp.obj[8] = new OBJ_Torch(gp);
		gp.obj[8].worldX = 21 * gp.tileSize;
		gp.obj[8].worldY = 21 * gp.tileSize;
		
		gp.obj[9] = new OBJ_Torch(gp);
		gp.obj[9].worldX = 25 * gp.tileSize;
		gp.obj[9].worldY = 21 * gp.tileSize;
		
		gp.obj[10] = new OBJ_Torch(gp);
		gp.obj[10].worldX = 21 * gp.tileSize;
		gp.obj[10].worldY = 26 * gp.tileSize;
		
		gp.obj[11] = new OBJ_Torch(gp);
		gp.obj[11].worldX = 25 * gp.tileSize;
		gp.obj[11].worldY = 26 * gp.tileSize;
		
		gp.obj[12] = new OBJ_Skull(gp);
		gp.obj[12].worldX = 16 * gp.tileSize;
		gp.obj[12].worldY = 23 * gp.tileSize;
		
		gp.obj[13] = new OBJ_Skull(gp);
		gp.obj[13].worldX = 30 * gp.tileSize;
		gp.obj[13].worldY = 25 * gp.tileSize;
		
		gp.obj[14] = new OBJ_Skull(gp);
		gp.obj[14].worldX = 19 * gp.tileSize;
		gp.obj[14].worldY = 39 * gp.tileSize;
		
		gp.obj[15] = new OBJ_Skull(gp);
		gp.obj[15].worldX = 35 * gp.tileSize;
		gp.obj[15].worldY = 15 * gp.tileSize;
		
		gp.obj[16] = new OBJ_Skull(gp);
		gp.obj[16].worldX = 25 * gp.tileSize;
		gp.obj[16].worldY = 9 * gp.tileSize;
		
		gp.obj[17] = new OBJ_WallG(gp);
		gp.obj[17].worldX = 13 * gp.tileSize;
		gp.obj[17].worldY = 22 * gp.tileSize;
		
		gp.obj[18] = new OBJ_WallG(gp);
		gp.obj[18].worldX = 36 * gp.tileSize;
		gp.obj[18].worldY = 9 * gp.tileSize;
		
		gp.obj[19] = new OBJ_WallG(gp);
		gp.obj[19].worldX = 30 * gp.tileSize;
		gp.obj[19].worldY = 42 * gp.tileSize;
		
		gp.obj[20] = new OBJ_SmallPipe(gp);
		gp.obj[20].worldX = 18 * gp.tileSize;
		gp.obj[20].worldY = 22 * gp.tileSize;
		
		gp.obj[21] = new OBJ_SmallPipe(gp);
		gp.obj[21].worldX = 25 * gp.tileSize;
		gp.obj[21].worldY = 3 * gp.tileSize;
		
		gp.obj[22] = new OBJ_SmallPipe(gp);
		gp.obj[22].worldX = 11 * gp.tileSize;
		gp.obj[22].worldY = 32 * gp.tileSize;
		
		gp.obj[23] = new OBJ_SmallPipe(gp);
		gp.obj[23].worldX = 25 * gp.tileSize;
		gp.obj[23].worldY = 3 * gp.tileSize;
		
		gp.obj[24] = new OBJ_Pipe(gp);
		gp.obj[24].worldX = 12 * gp.tileSize;
		gp.obj[24].worldY = 6 * gp.tileSize;
		
		gp.obj[26] = new OBJ_Pipe(gp);
		gp.obj[26].worldX = 34 * gp.tileSize;
		gp.obj[26].worldY = 22 * gp.tileSize;
		
		gp.obj[27] = new OBJ_WallGoo(gp);
		gp.obj[27].worldX = 28 * gp.tileSize;
		gp.obj[27].worldY = 22 * gp.tileSize;
		
		gp.obj[28] = new OBJ_WallGoo(gp);
		gp.obj[28].worldX = 21 * gp.tileSize;
		gp.obj[28].worldY = 3 * gp.tileSize;
//		
	}
	
	public void setNPC() {
		
		gp.npc[0] = new NPC_Goblin(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*22;
	}
	
	public void setMonster() {
		
		gp.monster[0] = new MON_GreenSlime(gp);
		gp.monster[0].worldX = gp.tileSize*23;
		gp.monster[0].worldY = gp.tileSize*36;
		
		gp.monster[1] = new MON_GreenSlime(gp);
		gp.monster[1].worldX = gp.tileSize*23;
		gp.monster[1].worldY = gp.tileSize*37;
	}
}
