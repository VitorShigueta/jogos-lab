package pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable, KeyListener {

    private Thread thread;
    private static JFrame frame;
    private boolean isRunning;
    public static int width = 240;
    public static int height = 120;
    public static int scale = 3;
    public static Player player;
    public static Enemy enemy;
    public static Ball ball;
    private BufferedImage layer;

    public Game(){
        this.setPreferredSize(new Dimension(width*scale, height*scale));
        layer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        this.addKeyListener(this);
        player = new Player(100, height-5);
        enemy = new Enemy(100, 0);
        ball = new Ball(100, (height/2)-2);

    }

	/*public void initFrame() {
		frame = new JFrame("Jogo Pong");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
	    frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}*/

    public synchronized void start() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public static void main(String[] args) {

        Game game = new Game();
        frame = new JFrame("Jogo Pong");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();

    }

    public void tick() {
        player.tick();
        enemy.tick();
        ball.tick();
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = layer.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);
        player.render(g);
        enemy.render(g);
        ball.render(g);
        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, width*scale, height*scale,null);
        bs.show();
    }

    public void run() {
        while(isRunning) {
            requestFocus();
            tick();
            render();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }

    @Override
    public void keyPressed(KeyEvent e ) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = true;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = false;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = false;
        }
    }
}
