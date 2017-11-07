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

import static oentation.HUD.positionHint;
import static oentation.HUD.score;


public class Player extends GameObject{

	Handler handler;
        
    private static int transparency;

    int randomValue;

	public Player(float x, float y, ID id, Handler handler){
            super(x , y, id);
            this.handler = handler;		
	}

	public Rectangle getBounds(){
            return new Rectangle((int)x, (int)y, 32, 32);
	}

	public void tick() {
            x += velX;
            y += velY;

            x = OEnTation.clamp(x, 0, OEnTation.WIDTH - 37);
            y = OEnTation.clamp(y, 0, OEnTation.HEIGHT - 60);
            
            transparency = (int) OEnTation.clamp(transparency, 5, 95);
            
            randomValue=(int)(20+ (Math.random() * (180)));
            
            if (positionHint<0)
                transparency = 95;
            else
                //when positionHint = 170 --> transparency = 5
                //when positionHint = 200 --> transparency = 95
                transparency = 3*positionHint - 505;
                     
            if ((positionHint>=170)&&(positionHint<210))
                //the trail is normal
                handler.addObject(new Trail(x, y, ID.Trail, new Color(215, 215, 215, transparency), 32, 32, 0.05f, handler));
            
            if ((positionHint<0)||((positionHint>210)&&(positionHint<=230)))
                //the trail flickers
               handler.addObject(new Trail(x, y, ID.Trail, new Color(randomValue, randomValue, randomValue, transparency), 32, 32, 0.05f, handler));
               
                
            if (positionHint>=230)
                positionHint=0;
            
            collision();
	}

	
	private void collision(){
            for (int i = 0; i < handler.object.size(); i++){

                GameObject tempObject = handler.object.get(i);

                if ((tempObject.getId() == ID.BasicPoint )	
                  || (tempObject.getId() == ID.MovingPoint )){ //tempObject is now BasicPoint or MovingPoint    
                    if(getBounds().intersects(tempObject.getBounds()) ){
                        //collision code
                        score++;
                        positionHint = -30;
                        handler.removeObject(tempObject);
                        BasicPoint.setDisappearedPoints(BasicPoint.getDisappearedPoints()+1);
                    }
                }
//                if ((tempObject.getId() == ID.EnemyOne)
//                    && (getBounds().intersects(tempObject.getBounds())) ){
//                    HUD.gameOver = true;
//                }
                
            }//.for
	}
		

	public void render(Graphics g) {
            g.setColor(Color.black);
            //g.setColor(new Color(0,125,125));
            g.drawRect((int)x, (int)y, 32, 32);
	}
}