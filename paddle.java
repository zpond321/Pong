import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class paddle extends JPanel{
    private int x;
    private int y;
    private int dX;
    private int dY;
    public paddle(int intX, int intY, int dimensionX, int dimensionY)
    {
        x = intX;
        y = intY;
        dX = dimensionX;
        dY = dimensionY;
    }
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, dX, dY);
    }
    public void move(int speedY)
    {
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
    public void keepInBounds()
    {
        if (y<0){
            y = 0;
        }
        if(y+dY>399)
        {
            y=399-dY;

        }
    }
}
