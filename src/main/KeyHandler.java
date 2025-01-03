package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;

    // DEBUG
    boolean checkDrawTime = false;
    
    public KeyHandler(GamePanel gp) {
    	this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        // TITLE STATE
        if(gp.gameState == gp.titleState) {
        	
        	if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0) {
                	gp.ui.commandNum = 1;
                }
            }

            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            	gp.ui.commandNum++;
                if(gp.ui.commandNum > 1) {
                	gp.ui.commandNum = 0;
                }
            }
            
            if(code == KeyEvent.VK_ENTER) {
                if(gp.ui.commandNum == 0) {
                	gp.gameState = gp.playState;
                	gp.playMusic(0);
                }
                if(gp.ui.commandNum == 1) {
                	System.exit(0);
                }
            }
            
        }
        
        // PLAY STATE
        if(gp.gameState == gp.playState) {
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                upPressed = true;
            }

            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                downPressed = true;
            }

            if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }

            if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
            
            if(code == KeyEvent.VK_SPACE || code == KeyEvent.VK_F) {
            	rightPressed = true;
            }
            
        	if(code == KeyEvent.VK_P ) {
        		gp.gameState = gp.pauseState;
        	}
        	
        	if(code == KeyEvent.VK_ENTER) {
        		enterPressed = true;
        	}
        	
            //DEBUG
            if(code == KeyEvent.VK_T) {
            	if(checkDrawTime == false) {
            		checkDrawTime = true;
            	}
            	else if(checkDrawTime == true) {
            		checkDrawTime = false;
            	}
            }
        }
    	// PAUSE STATE
    	else if(gp.gameState == gp.pauseState) {
    		if(code == KeyEvent.VK_P) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
    			gp.gameState = gp.playState;
    		}
    	}
        // GAME OVER STATE
    	else if(gp.gameState == gp.gameOverState) {
    		
        	if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0) {
                	gp.ui.commandNum = 1;
                }
            }

            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            	gp.ui.commandNum++;
                if(gp.ui.commandNum > 1) {
                	gp.ui.commandNum = 0;
                }
            }
            
            if(code == KeyEvent.VK_ENTER) {
                if(gp.ui.commandNum == 0) {
                	gp.gameState = gp.playState;
                	gp.playMusic(0);
                	gp.retry();
                }
                if(gp.ui.commandNum == 1) {
                	System.exit(0);
                	gp.restart();
                }
            }
    	}
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            upPressed = false;
        }

        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }

        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        
        if(code == KeyEvent.VK_SPACE || code == KeyEvent.VK_F) {
        	rightPressed = false;
        }
        
        if(code == KeyEvent.VK_ENTER) {
    		enterPressed = false;
    	}
    }
}
