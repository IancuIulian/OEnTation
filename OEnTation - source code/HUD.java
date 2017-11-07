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

public class HUD {
   
    private long startTime = System.currentTimeMillis();
    private long seconds;
    private int minutes;
    private int level = 1;

    public static int score = 0;
    public static int positionHint=-100;

    public static boolean gameOver = false;

    public void tick(){
        if (!gameOver){
            positionHint++;
            seconds = (System.currentTimeMillis() - startTime) / 1000;
            minutes = (int) Math.abs(seconds/60);
        }

    }

    public void render(Graphics g){
        g.setColor(Color.white);
        if(!gameOver){
            g.drawString("Level: " +level, 15, 20);
            g.drawString("Score: " +score, 15, 40);

            //drawing time as mm:ss
            if ((minutes<10)&&((seconds-60*minutes)<10))
                g.drawString("0"+minutes+ " : 0" +(seconds-60*minutes), 15, OEnTation.HEIGHT-40);
            else if ((minutes<10)&&((seconds-60*minutes)>=10))
                g.drawString("0"+minutes+ " : " +(seconds-60*minutes), 15, OEnTation.HEIGHT-40);
            else if ((minutes>=10)&&((seconds-60*minutes)<10))
                g.drawString(minutes+ " : 0" +(seconds-60*minutes), 15, OEnTation.HEIGHT-40);
            else 
                g.drawString(minutes+ " : " +(seconds-60*minutes), 15, OEnTation.HEIGHT-40);
        }else{
            g.setColor(Color.red);
            g.drawString("Congratulations!", (OEnTation.WIDTH / 2)-56, 200);
            g.setColor(Color.white);
            g.drawString("You`ve reached Level: " + level, (OEnTation.WIDTH / 2)-72, 240);
            g.drawString("Score: " + score, (OEnTation.WIDTH / 2)-36, 280);
            g.drawString("This was just a trial. To get the full version, please wait a couple of years :D", (OEnTation.WIDTH / 2)-200,350);
            //g.setColor(Color.white);
            //g.drawString("Having fun ? :))", (OEnTation.WIDTH / 2)-42, 200);
        }
    }

    public void score(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return level;
    }

}
