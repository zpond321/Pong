import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
public class ball extends JPanel{
    private int x;
    private int y;
    private int speedX;
    private int speedY;
    
    public ball(int intX, int intY, int speedHorizontal,int speedVertical)
    {
        x= intX;
        y=intY;
        speedX=speedHorizontal;
        speedY=speedVertical;
    }
    public void bounceHorizontally()
    {
        speedY*=-1;
    }
    public void bounceVertically()
    {
        speedX*=-1;
    }
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 10, 10);
    }
    public void move()
    {
        x+=speedX;
        y+=speedY;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }    
    public void testBorder()
    {
        
    }
    public void increaseSpeed()
    {
        if(speedX>=0)
        {
            speedX++;
        }
        if(speedY>=0)
        {
            speedY++;
        }
        if(speedX<0)
        {
            speedX--;
        }
        if(speedY<0)
        {
            speedY--;
        }
    }
}