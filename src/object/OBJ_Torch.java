package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Torch extends SuperObject{

	GamePanel gp;
	
public OBJ_Torch(GamePanel gp) {
	this.gp = gp;
	
	name = "Torch";
	try {
		image = ImageIO.read(getClass().getResourceAsStream("/objects/torch_1.png"));
		uTool.scaleImage(image, gp.tileSize, gp.tileSize);
	}catch(IOException e) {
		e.printStackTrace();
	}
//		collision = true;
	}
}
