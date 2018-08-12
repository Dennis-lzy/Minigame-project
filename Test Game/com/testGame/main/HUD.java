package com.testGame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	public static int Health = 100;
	
	public void tick() {
		
		
		Health = Game.crop(Health, 0, 100);
	}

public void gameOver (Graphics g) {
	if(Health == 0) {
	g.setFont(new Font("TimesRoman", Font.BOLD, 100));
	g.drawString("GAME OVER", Game.WIDTH/2-300, Game.HEIGHT/2);
	
	}
}
/**
 * @param g
 */
public void render(Graphics g) {
	g.setColor(Color.gray);
	g.fillRect(15,15,200,16);
	g.setColor(Color.GREEN);
	g.fillRect(15, 15, Health*2, 16);
	g.setColor(Color.WHITE);
	g.drawRect(15, 15, 200, 16);
	
  }
}