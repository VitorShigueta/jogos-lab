package pong;

import java.awt.*;

public class Player {

    public int w, h;
    public boolean right, left ;
    public int x, y;

    public Player(int x , int y) {
        this.x = x;
        this.y = y;
        this.w = 40;
        this.h = 5;
    }

    public void tick(){
        if(right) {
            x++;
        }else if (left) {
            x--;
        }
        if(x+w >= Game.width) {
            x = Game.width - w;
        }else if (x < 0) {
            x = 0;
        }
    }

    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x, y, w, h);
    }
}
