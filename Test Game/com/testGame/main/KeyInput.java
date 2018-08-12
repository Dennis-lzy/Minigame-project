package com.testGame.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i<handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);
			
			if (tempObj.getId() == ID.Player) {
				//key events for player 1
				
				
				if (key == KeyEvent.VK_W) {
					//action for W key
					tempObj.setVelY(-10);
				}
				
				if (key == KeyEvent.VK_S) {
					//action for S key
					tempObj.setVelY(10);
				}
				
				if (key == KeyEvent.VK_A) {
					//action for A key
					tempObj.setVelX(-10);
				}
				
				if (key == KeyEvent.VK_D) {
					//action for D key
					tempObj.setVelX(10);
				}
				
				if (key == KeyEvent.VK_W && key == KeyEvent.VK_A) {
					//action for W and A key
					tempObj.setVelY(-10);
					tempObj.setVelX(-10);
				}
				
				if (key == KeyEvent.VK_W && key == KeyEvent.VK_D) {
					//action for W and D key
					tempObj.setVelY(-10);
					tempObj.setVelX(10);
				}
				
				if (key == KeyEvent.VK_S && key == KeyEvent.VK_A) {
					//action for W and A key
					tempObj.setVelY(10);
					tempObj.setVelX(-10);
				}
				
				if (key == KeyEvent.VK_S && key == KeyEvent.VK_D) {
					//action for W and A key
					tempObj.setVelY(10);
					tempObj.setVelX(10);
				}
				
							
			}
			
			if (tempObj.getId() == ID.Player2) {
				//key events for player 2
				if (key == KeyEvent.VK_UP) {
					//action for W key
					tempObj.setVelY(tempObj.getVelY() - 3);
				}
				
				if (key == KeyEvent.VK_DOWN) {
					//action for S key
					tempObj.setVelY(tempObj.getVelY()+3);
				}
				
				if (key == KeyEvent.VK_LEFT) {
					//action for A key
					tempObj.setVelX(tempObj.getVelX()-3);
				}
				
				if (key == KeyEvent.VK_RIGHT) {
					//action for D key
					tempObj.setVelX(tempObj.getVelX()+3);
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		
		for (int i = 0; i<handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);
			
			if (tempObj.getId() == ID.Player) {
				
				if (key == KeyEvent.VK_W && key == KeyEvent.VK_A) {
					//action for W and A key
					tempObj.setVelY(0);
					tempObj.setVelX(0);
				}
				
				if (key == KeyEvent.VK_W && key == KeyEvent.VK_D) {
					//action for W and D key
					tempObj.setVelY(0);
					tempObj.setVelX(0);
				}
				
				if (key == KeyEvent.VK_S && key == KeyEvent.VK_A) {
					//action for W and A key
					tempObj.setVelY(0);
					tempObj.setVelX(0);
				}
				
				if (key == KeyEvent.VK_S && key == KeyEvent.VK_D) {
					//action for W and A key
					tempObj.setVelY(0);
					tempObj.setVelX(0);
				}
				//key events for player 1
				if (key == KeyEvent.VK_W) {
					//action for W key
					tempObj.setVelY(0);
				}
				
				if (key == KeyEvent.VK_S) {
					//action for S key
					tempObj.setVelY(0);
				}
				
				if (key == KeyEvent.VK_A) {
					//action for A key
					tempObj.setVelX(0);
				}
				
				if (key == KeyEvent.VK_D) {
					//action for D key
					tempObj.setVelX(0);
				}
				
				
			}
			
			if (tempObj.getId() == ID.Player2) {
				//key events for player 1
				if (key == KeyEvent.VK_UP) {
					//action for W key
					tempObj.setVelY(0);
				}
				
				if (key == KeyEvent.VK_DOWN) {
					//action for S key
					tempObj.setVelY(0);
				}
				
				if (key == KeyEvent.VK_LEFT) {
					//action for A key
					tempObj.setVelX(0);
				}
				
				if (key == KeyEvent.VK_RIGHT) {
					//action for D key
					tempObj.setVelX(0);
				}
			}
			
			
		}
	}
	
}
