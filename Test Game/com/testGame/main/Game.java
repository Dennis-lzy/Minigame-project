package com.testGame.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4978361300847603602L;

	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private HUD hud;
	
	private Random r;
	
	public static final int WIDTH = 1024, HEIGHT = WIDTH/12*9;
	
	public Game() {
		requestFocus(true);
		handler = new Handler();
		r = new Random();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "test game", this);	
		
		hud = new HUD();
		
				
		handler.addObject(new Player(WIDTH/2+32, HEIGHT/2-32, ID.Player, handler));
		handler.addObject(new Enemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Enemy));
		//handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player2));
	
		 for (int i=0; i < 15; i++) {
			                  
                 handler.addObject(new Enemy(r.nextInt(WIDTH-25), r.nextInt(HEIGHT-25), ID.Enemy));
                 try {
					Thread.sleep(5000+(i*1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                	
		 }
		 
		 
		
	}	
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try{
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	


	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				tick();
				delta--;
			}
			
			if (running) {
				render();
				frames++;
			}
			
			 if(System.currentTimeMillis() - timer > 1000)
             {
                 timer += 1000;
                 System.out.println("FPS: "+ frames);
                 frames = 0;
		}
	}
	 stop();	
	}
	
	private void tick() {
		handler.tick();
		hud.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		hud.render(g);
		hud.gameOver(g);
		g.dispose();
		bs.show();
		
	}
	
	public static int crop (int var, int min, int max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		} else {
			return var;
		}
	}

	public static void main(String[] args) {
		new Game();

	}

}


