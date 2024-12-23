package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Skull extends SuperObject{

	GamePanel gp;
	
	public OBJ_Skull(GamePanel gp) {
		this.gp = gp;
	
		name = "Skull";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/skull.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
