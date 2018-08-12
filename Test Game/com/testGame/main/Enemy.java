package com.testGame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObject{

	private Random r;
	
	public Enemy(int x, int y, ID id) {
		super(x, y, id);
		r= new Random();
		
		int speed = r.nextInt(9)+1;
		velX= speed;
		velY = speed;
		
	}
	
	public Rectangle getArea() {
		return new Rectangle(x,y, 25, 25);
	}

	@Override
	public void tick() {
		r= new Random();
		
		x += velX;
		y += velY;
		
		if (x<=0 || x >= Game.WIDTH-20) {
			velX *= -1; 
			
		}
		
		if (y<=0 || y >= Game.HEIGHT -50) {
			
			velY *= -1;
		}
		

		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, 25, 25);
		
	}
	
	
}
