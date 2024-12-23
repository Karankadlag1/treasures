package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_WallGoo extends SuperObject{
	
	GamePanel gp;
	
	public OBJ_WallGoo(GamePanel gp) {
		this.gp = gp;
	
		name = "WallGoo";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/wall_goo.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	
	}
}
