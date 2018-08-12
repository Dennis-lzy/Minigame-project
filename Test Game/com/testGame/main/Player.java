package com.testGame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	Handler handler;
	private static int w = 50;
	private static int h = 50;
	
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getArea() {
		return new Rectangle(x,y,50, 50);
	}

	@Override
	public void tick() {
	 x+= velX;
	 y+= velY;
	 
	 if (x <= 0 || x >= Game.WIDTH-50) {
		 
			 x+= -velX;
		 
	 }
	 
	 if (y <= 0||y>= Game.HEIGHT-80) {
		 y+=-velY;
	 }
	 
	 collision();
		
	}
	
	private void collision() {
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);
			
			if(tempObj.getId() == ID.Enemy) {
				if(getArea().intersects(tempObj.getArea())){
					HUD.Health -= 4;
					w -= 1;
					h -= 1;
					
						
					}
					
					
				}
			}
			
		}
	
	
	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (id == ID.Player) {
				g.setColor(Color.WHITE);
			} else if (id == ID.Player2) {
				g.setColor(Color.RED);
			}
		g.fillRect(x, y, w, h);
		
//		g.setColor(Color.YELLOW);
//		g2d.draw(getArea());
		
	}
	


}
