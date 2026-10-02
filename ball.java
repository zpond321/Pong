import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
public class ball extends JPanel{
    private int x;
    private int y;
    private double speed;
    private double angle;
    private int amountofHits;
    public ball(int intX, int intY, double speeed,double angled)
    {
        x= intX;
        y=intY;
        speed=speeed;
        angle=angled;
    }
    public void bounceHorizontally()
    {

        angle=360-angle;
    }
    public void bounceVertically()
    {
        angle=180-angle;
    }
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 10, 10);
    }
    public void move()
    {
        x+=(int) Math.round(speed*Math.cos(Math.toRadians(angle)));
        y+=(int) Math.round(speed*Math.sin(Math.toRadians(angle)));
        System.out.println(Math.round(speed*Math.cos(Math.toRadians(angle))));
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }    
    public void testBounce()
    {
        //Point Conditions
        if(x<=0)
        {
            x=200;
            y=200;
            main.pointRight();
        }
        if(x>=390)
        {
            x=200;
            y=200;
            main.pointLeft();
            main.score.setText(main.getLeftPoints() + " | " + main.getRightPoints());
        }
        //Bounce on top and bottom
        if(y<=0)
        {
            y=1;
            bounceHorizontally();
        }
        if(y>=390)
        {   
            y=389;
            bounceHorizontally();   
        }


        //left paddle bounce
        if(x>=main.leftPaddle.getX() && x<=main.leftPaddle.getX()+10 &&
           y<=main.leftPaddle.getY()+60 && y+10>=main.leftPaddle.getY())
        {
            if((y - main.leftPaddle.getY())<15)
            {
                angle = 300;
            }
            else if((y - main.leftPaddle.getY())<30)
            {
                angle = 315;
            }
            else if((y - main.leftPaddle.getY())<45)
            {
                angle = 45;
            }
            else if((y - main.leftPaddle.getY())<60)
            {
                angle = 60;
            }
            amountofHits++;
            if(amountofHits>2)
            {
                speed+=0.25;
                amountofHits=0;
            }
        }
        //right paddle bounce
        if(x+10<=main.rightPaddle.getX()+10 && x+10>=main.rightPaddle.getX() &&
           y<=main.rightPaddle.getY()+60 && y+10>=main.rightPaddle.getY())
        {
            if((y - main.rightPaddle.getY())<15)
            {
                angle = 240;
            }
            else if((y - main.rightPaddle.getY())<30)
            {
                angle = 225;
            }
            else if((y - main.rightPaddle.getY())<45)
            {
                angle = 135;
            }
            else if((y - main.rightPaddle.getY())<60)
            {
                angle = 120;
            }
            amountofHits++;
            if(amountofHits>2)
            {
                speed+=0.25;
                amountofHits=0;
            }
        }
    }

}