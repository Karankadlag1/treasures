package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel  gp) {
		
		this.gp = gp;
		
		tile = new Tile[1000];		
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];	
		
		getTileImage();
		loadMap("/maps/world01.txt");
	}
	public void getTileImage() {
		
			setup(100, "floor_plain", false);
			setup(101, "wall_top_center", true);
			setup(102, "door_open", false);
			setup(103, "floor_edge_2", true);
			setup(104, "black", true);
			setup(105, "floor_plain", false);
			setup(106, "door_open", false);
			setup(107, "boxes_stacked", true);
			setup(108, "wall_left", true);
			setup(109, "wall_center", true);
			setup(110, "wall_floor_top)", false);
			setup(111, "floor_stain_1", false);
			setup(112, "floor_stain_2", false);
			setup(113, "floor_stain_3", false);
			setup(114, "wall_gargoyle_red_1", true);
			setup(115, "floor_gargoyle_red_basin", true);
			setup(116, "gargoyle_top_1", false);
			setup(117, "wall_flag_red", true);
			setup(118, "wall_gargoyle_blue_1", true);
			setup(119, "gargoyle_top_black", true);
			setup(120, "floor_gargoyle_blue_basin", true);
			setup(121, "wall_gargoyle_green_1", true);
			setup(122, "floor_gargoyle_green_basin", false);
			setup(123,"chest_golden_open_full", false);
		
	}
	
 public void setup(int index, String imagePath, boolean collision) {
		
		UtilityTool uTool = new UtilityTool();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+imagePath+".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void loadMap(String filePath) {
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			
		}
	}
	public void draw(Graphics2D g2) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			// Stop moving the camera at the edge
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
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}
			else if(gp.player.screenX > gp.player.worldX ||
					gp.player.screenY > gp.player.worldY ||
					rightOffset > gp.worldWidth - gp.player.worldX ||
					bottomOffset > gp.worldHeight - gp.player.worldY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}
			worldCol++;
//			x += gp.tileSize;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
//				x = 0;
				worldRow++;
//				y += gp.tileSize;
			}
		}
//		g2.drawImage(tile[100].image, 0, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[101].image,48, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[102].image, 96, 0, gp.tileSize, gp.tileSize, null);
	}
}
