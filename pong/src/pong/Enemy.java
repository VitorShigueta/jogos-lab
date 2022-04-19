package pong;

import java.awt.*;

public class Enemy {
    public double x, y ;
    public int w, h;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.w = 40;
        this.h = 5;
    }

    public void tick() {
        x+=((Game.ball.x-x-6)*0.1);
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x,(int) y, w, h);
    }
}
