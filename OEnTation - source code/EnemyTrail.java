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
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class EnemyTrail extends GameObject {

    private float alpha = 1;
    private Handler handler;
    private Color color;

    private int width, height;
    private float life;

	
    public EnemyTrail(float x, float y, ID id, Color color, int width, int height, float life, Handler handler){
        super(x, y, id);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;
    }

    public void tick() {
        if(alpha > life){
            alpha -= (life - 0.001f);
        }else
            handler.removeObject(this);
    }

    public void render(Graphics g) {	
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));

        g.setColor(color);
        g.fillOval((int)x, (int)y, width, height);
        g.setColor(Color.black);
        g.fillOval((int)x+10, (int)y+10, 10, 10);
        g.fillOval((int)x+26, (int)y+10, 10, 10);
        g.fillOval((int)x+18, (int)y+25, 10, 12);

        g2d.setComposite(makeTransparent(1));
    }
	
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    public Rectangle getBounds() {
        return null;
    }

}