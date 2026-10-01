import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
public class main {
    public static JFrame f= new JFrame();
    public static ArrayList<wall> walls= new ArrayList<wall>();
    public static void main(String[] args) {
        //creating instance of JFrame
        
        
        //Setting up frame
        f.getContentPane().setBackground(Color.DARK_GRAY); 
        f.setSize(400, 400);
        f.setLayout(null);
        
        //Creating ball
        ball pongBall = new ball(200,100, 1, 1);  
        pongBall.setBounds(0,0, 10, 10);
        pongBall.setLocation(200, 100);

        //Creating Walls
        walls.add(new wall(0, 0, 400, 1));
        walls.add(new wall(0, 399, 400, 1));
        walls.add(new wall(0, 0, 1, 400));
        walls.add(new wall(399, 0, 1, 400));

        //Putting walls on the display
        for(wall w: walls)
        {
            w.setBounds(0,0, w.getDX(), w.getDY());
            f.add(w);
        }
        f.add(pongBall);
        f.revalidate();
        f.repaint();

        //Setting up left 
        paddle leftPaddle = new paddle(20, 10, 10, 60, true);
        f.add(leftPaddle);
        leftPaddle.setBounds(20,10, 10, 60);
        leftPaddle.setLocation(20,10);
        f.revalidate();
        f.repaint();

        //Key Detects
        main.f.addKeyListener(new KeyAdapter() {
            @Override 
            public void keyPressed(KeyEvent e) {
                

                if(e.getKeyCode() == KeyEvent.VK_UP)
                    {
                        leftPaddle.move(-3);
                    }
                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    {
                        leftPaddle.move(3);
                    }    
                leftPaddle.keepInBounds(); 
                leftPaddle.setLocation(leftPaddle.getX(), leftPaddle.getY());
            }
        });



        //Main game loop
        Timer gameLoop = new Timer(25, e -> {

            pongBall.move();
            pongBall.testBorder();
            
            
            f.repaint();
            f.setVisible(true);
            
        });


        gameLoop.start();


    }
}