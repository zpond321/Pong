import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
public class main {
    public static JFrame f= new JFrame();
    public static void main(String[] args) {
        //creating instance of JFrame
        
        
        
        f.getContentPane().setBackground(Color.DARK_GRAY); 
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        
        ball pongBall = new ball(200,100, 1, 1);  
        pongBall.setBounds(0,0, 10, 10);
        pongBall.setLocation(200, 100);
        walls.add(new wall(0, 0, 400, 1));
        walls.add(new wall(0, 399, 400, 1));
        walls.add(new wall(0, 0, 1, 400));
        walls.add(new wall(399, 0, 1, 400));
        f.add(pongBall);
        f.revalidate();
        f.repaint();
        
        Timer gameLoop = new Timer(25, e -> {

            pongBall.move();
            pongBall.testBorder();
            f.repaint();

        });
        Timer speedIncrease = new Timer(5000, e -> {
            
        });
        gameLoop.start();
        speedIncrease.start();
    }
}