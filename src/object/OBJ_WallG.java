package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_WallG extends SuperObject{
	
	GamePanel gp;
	
	public OBJ_WallG(GamePanel gp) {
		this.gp = gp;
	
		name = "WallG";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/wall_gratings.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
