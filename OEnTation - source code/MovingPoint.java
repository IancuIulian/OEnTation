/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oentation;

/**
 *
 * @author ulise
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import static oentation.OEnTation.HEIGHT;
import static oentation.OEnTation.WIDTH;


public class MovingPoint extends GameObject {

	private Handler handler;
        
        private int lifeTime;
        private long startSec = System.currentTimeMillis();
        private long currentMilliSec;
	
        private int greenValue;
        
	public MovingPoint(int x, int y, ID id, int lifeTime, Handler handler, int velX, int velY) {
            super(x, y, id);
            this.handler = handler;
            this.lifeTime = lifeTime;
            this.velX = velX;
            this.velY = velY;
        }	
	
	public Rectangle getBounds(){
            return new Rectangle((int)x, (int)y, 16, 16);
	}


	public void tick() {
            x += velX;
            y += velY;
            
            if ((x >= WIDTH-20) || (x <= 0)) velX *= -1;
            if ((y >= HEIGHT-42) || (y <= 0)) velY *= -1;
            
            currentMilliSec = System.currentTimeMillis() - startSec;
                        
            if (lifeTime == currentMilliSec/1000){
                handler.removeObject(this);
                BasicPoint.setDisappearedPoints(BasicPoint.getDisappearedPoints()+1);
            }
            
            greenValue = 255 - (int)(currentMilliSec/(lifeTime*10) * 2.5) ;
            
            greenValue = (int) OEnTation.clamp(greenValue,0,255);
	}

	public void render(Graphics g) {
		g.setColor(new Color(255,greenValue,0));
		//g.fillRect((int)x, (int)y, 16, 16);
        g.fillOval((int)x, (int)y, 16, 16);
	}

        public static int randomWidthGen(){
            return (50 + (int)(Math.random() * (WIDTH-100)));
        }
        
        public static int randomHeightGen(){
             return (50 + (int)(Math.random() * (HEIGHT-100)));
        }
        
        public static int randomLifeTime(){
            return (6 + (int)(Math.random() * (13-6)));
        }
        
        public static int randomVelocityGen(){
            return (-1 +(int)(Math.random() * (2-(-1))));
        }
}

