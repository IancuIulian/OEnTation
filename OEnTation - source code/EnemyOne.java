/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import static oentation.OEnTation.HEIGHT;
import static oentation.OEnTation.WIDTH;

/**
 *
 * @author ulise
 */
public class EnemyOne extends GameObject{
    
    Handler handler;
    
    public EnemyOne(float x, float y, ID id, Handler handler, int velX, int velY) {
        super(x, y, id);
        this.handler = handler;
        this.velX = velX;
        this.velY = velY;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        handler.addObject(new EnemyTrail(x, y, ID.EnemyTrail, new Color(0, 150, 150), 46, 46, 0.01f, handler));
        
        if ((x >= WIDTH+40) || (x <= -85)) velX *= -1;
        if ((y >= HEIGHT+40) || (y <= -85)) velY *= -1;
    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.pink);
        g.setColor(new Color(0,150,150));
        g.fillOval((int)x, (int)y, 46, 46);
        g.setColor(Color.black);
        g.fillOval((int)x+10, (int)y+10, 10, 10);
        g.fillOval((int)x+26, (int)y+10, 10, 10);
        g.fillOval((int)x+18, (int)y+25, 10, 12);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 46, 46);
    }
    
    public void setEnemyOneVelX(int velX){
        this.velX = velX;
    }
    public void setEnemyOneVelY(int velY){
        this.velY = velY;
    }
    
}
