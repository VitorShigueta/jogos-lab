package pong;

import java.awt.*;
import java.util.Random;

public class Ball {
    public double x, y ;
    public int w, h;
    public double dx, dy;
    public double speed = 1.1;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.w = 3;
        this.h = 3;

        int angle = new Random().nextInt(120-45)+45+1;

        dx=Math.cos(Math.toRadians(angle));
        dy=Math.sin(Math.toRadians(angle));
	/*
	dx=Math.toRadians(90);
	dy=Math.toRadians(90);

	this.dx = new Random().nextGaussian();
	this.dy = new Random().nextGaussian();
	*/
    }

    public void tick() {
        if(x+(dx*speed)+w >=Game.width) {
            dx*=-1;
        }else if(x+(dx*speed)<0) {
            dx*=-1;
        }
        if(y>= Game.width) {
            //Ponto do inimigo
            new Game();
            return;
        }else if(y<0) {
            // Ponto do jogador
            new Game();
            return;
        }

        Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)), w, h);
        Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.w, Game.player.h);
        Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.w, Game.enemy.h);

        if(bounds.intersects(boundsPlayer)) {
            int angle = new Random().nextInt(120-45)+45+1;
            dx=Math.cos(Math.toRadians(angle));
            dy=Math.sin(Math.toRadians(angle));
            if(dy>0) {
                dy*=-1;
            }
        }else if(bounds.intersects(boundsEnemy)) {
            int angle = new Random().nextInt(120-45)+45+1;
            dx=Math.cos(Math.toRadians(angle));
            dy=Math.sin(Math.toRadians(angle));
            if(dy<0) {
                dy*=-1;
            }
        }

        x += dx*speed;
        y += dy*speed;
    }

    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect((int)x,(int) y, w, h);
    }
}
