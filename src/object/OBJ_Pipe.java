package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Pipe extends SuperObject{

	GamePanel gp;
	
	public OBJ_Pipe(GamePanel gp) {
		this.gp = gp;
	
		name = "Pipe";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/wall_pipe_1.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	
}
}