import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JLabel;
public class main {
    public static JFrame f= new JFrame();
    public static ArrayList<wall> walls= new ArrayList<wall>();
    private static boolean up = false;
    private static boolean down = false;
    private static boolean w = false;
    private static boolean s = false;
    public static paddle leftPaddle = new paddle(20, 10, 10, 60);
    public static paddle rightPaddle = new paddle(370, 10, 10, 60);
    private static int leftPoints = 0;
    private static int rightPoints = 0;
    public static JLabel score = new JLabel(leftPoints + " | " + rightPoints);
    public static void main(String[] args) {
  
        
        
        //Setting up frame
        f.getContentPane().setBackground(Color.BLACK); 
        f.setSize(400, 400);
        f.setLayout(null);
        
        //Creating ball
        ball pongBall = new ball(200,100, 2, 45);  
        pongBall.setBounds(0,0, 10, 10);
        pongBall.setLocation(200, 100);

        //Add the score text
        score.setBounds(175,0,75,75);
        score.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 25));
        score.setForeground(Color.WHITE);
        f.add(score);
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

        //Setting up left 
        
        f.add(leftPaddle);
        leftPaddle.setBounds(20,10, 10, 60);
        leftPaddle.setLocation(20,10);
        

        //Setting up right
        f.add(rightPaddle);
        rightPaddle.setBounds(370, 10, 10, 60);
        rightPaddle.setLocation(20, 10);
        f.revalidate();
        f.repaint();
        //Key Detects
        
        main.f.addKeyListener(new KeyAdapter() {
            @Override 
            public void keyPressed(KeyEvent e) {
                

                switch(e.getKeyCode()) {
                    case KeyEvent.VK_UP -> up = true;
                    case KeyEvent.VK_DOWN -> down = true;
                    case KeyEvent.VK_W -> w = true;
                    case KeyEvent.VK_S -> s = true;
                }

            }
            @Override 
            public void keyReleased(KeyEvent e) {

                switch(e.getKeyCode()) {
                    case KeyEvent.VK_UP -> up = false;
                    case KeyEvent.VK_DOWN -> down = false;
                    case KeyEvent.VK_W -> w = false;
                    case KeyEvent.VK_S -> s = false;
                }
            }    
        });



        //Main game loop
        Timer gameLoop = new Timer(25, e -> {
            //Move ball
            pongBall.move();
            pongBall.testBounce();
            //Move left paddle up
            if(w)
            {
                leftPaddle.move(-3);
                leftPaddle.keepInBounds(); 
                leftPaddle.setLocation(leftPaddle.getX(), leftPaddle.getY());
            }
            //Move left paddle down
            if(s)
            {
                leftPaddle.move(3);
                leftPaddle.keepInBounds(); 
                leftPaddle.setLocation(leftPaddle.getX(), leftPaddle.getY());
            }
            //move right paddle up
            if(up)
            {
                rightPaddle.move(-3);
                rightPaddle.keepInBounds();
                leftPaddle.setLocation(rightPaddle.getX(), rightPaddle.getY());
            }
            //move right paddle down
            if(down)
            {
                rightPaddle.move(3);
                rightPaddle.keepInBounds();
                leftPaddle.setLocation(rightPaddle.getX(), rightPaddle.getY());
            }


            //Refresh the frame
            f.repaint();
            f.setVisible(true);
            
        });
        gameLoop.start();
    }
    //Add 1 point to left
    public static void pointLeft()
    {
        leftPoints++;
    }
    //Add 1 point to the right
    public static void pointRight()
    {
        rightPoints++;
    }
    public static int getRightPoints()
    {
        return rightPoints;
    }
    public static int getLeftPoints()
    {
        return leftPoints;
    }
}