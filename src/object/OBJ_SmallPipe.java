package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_SmallPipe extends SuperObject{

	GamePanel gp;
	
	public OBJ_SmallPipe(GamePanel gp) {
		this.gp = gp;
	
		name = "SmallPipe";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/wall_pipe_small.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
