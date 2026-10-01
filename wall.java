import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
public class wall extends JPanel{
    private int x;
    private int y;
    private int dX;
    private int dY;
    
    public wall(int intX, int intY, int dimensionX, int dimensionY)
    {
        x= intX;
        y=intY;
        dX=dimensionX;
        dY=dimensionY;
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, dX, dY);
    }

    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }    
    public int getDX()
    {
        return dX;
    }
    public int getDY()
    {
        return dY;
    }
}