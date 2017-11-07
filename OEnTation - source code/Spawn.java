/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oentation;

import static oentation.HUD.score;

/**
 *
 * @author ulise
 */
public class Spawn{
    private boolean sem = true;

	private Handler handler;
	private HUD hud;
	
	//private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick(){
        if ( (score < 2) && (BasicPoint.getDisappearedPoints() == 2) ){
            HUD.gameOver = true;
            if (sem){
                new GameOverMessage();
                sem = false;
            }
        }
        else if ( (score < 5) && (BasicPoint.getDisappearedPoints() == 5) ){
            HUD.gameOver = true;
            if (sem){
                new GameOverMessage();
                sem = false;
            }
        }
        else if ( (score < 10) && (BasicPoint.getDisappearedPoints() == 10)){
            HUD.gameOver = true;
            if (sem){
                new GameOverMessage();
                sem = false;
            }
        }

        if (score >= 50){
            HUD.gameOver = true;
            handler.object.remove();
        }
        else if ((hud.getLevel() == 1) && (score == 2)){
            hud.setLevel(hud.getLevel() + 1);
            handler.addObject(new BasicPoint(BasicPoint.randomWidthGen(), BasicPoint.randomHeightGen(), ID.BasicPoint, BasicPoint.randomLifeTime(), handler));
            handler.addObject(new BasicPoint(BasicPoint.randomWidthGen(), BasicPoint.randomHeightGen(), ID.BasicPoint, BasicPoint.randomLifeTime(), handler));
            handler.addObject(new BasicPoint(BasicPoint.randomWidthGen(), BasicPoint.randomHeightGen(), ID.BasicPoint, BasicPoint.randomLifeTime(), handler));
        }
        else if ((hud.getLevel() == 2) && (score == 5)){
            hud.setLevel(hud.getLevel() + 1);
            handler.addObject(new BasicPoint(BasicPoint.randomWidthGen(), BasicPoint.randomHeightGen(), ID.BasicPoint, BasicPoint.randomLifeTime(), handler));
            handler.addObject(new BasicPoint(BasicPoint.randomWidthGen(), BasicPoint.randomHeightGen(), ID.BasicPoint, BasicPoint.randomLifeTime(), handler));
            handler.addObject(new MovingPoint(MovingPoint.randomWidthGen(), MovingPoint.randomHeightGen(), ID.MovingPoint, MovingPoint.randomLifeTime(), handler, MovingPoint.randomVelocityGen(), MovingPoint.randomVelocityGen()));
            handler.addObject(new MovingPoint(MovingPoint.randomWidthGen(), MovingPoint.randomHeightGen(), ID.MovingPoint, MovingPoint.randomLifeTime(), handler, MovingPoint.randomVelocityGen(), MovingPoint.randomVelocityGen()));
            handler.addObject(new MovingPoint(MovingPoint.randomWidthGen(), MovingPoint.randomHeightGen(), ID.MovingPoint, MovingPoint.randomLifeTime(), handler, MovingPoint.randomVelocityGen(), MovingPoint.randomVelocityGen()));
        }
        else if ((hud.getLevel() == 3) && (score >= 8)){
            handler.addObject(new MovingPoint(MovingPoint.randomWidthGen(), MovingPoint.randomHeightGen(), ID.MovingPoint, MovingPoint.randomLifeTime(), handler, MovingPoint.randomVelocityGen(), MovingPoint.randomVelocityGen()));
        }
	}
}