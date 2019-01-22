import java.awt.*;
import javax.swing.*;

public class TicTacSquare extends JPanel
{
	private static final int OFFSET = 10;
	private int value = 0; // -1 for X, 0 for nothing, 1 for O
	private int win = 0; // 1-4 corresponds to vertical, horizontal, diagonal down right, diagonal down left
	
	public TicTacSquare(String name)
	{
		super();
		setName(name);
	}
	
	public void setValue(int n)
	{
		value = n;
		repaint();
	}
	
	public int getValue() { return value; }
	
	public void setWin(int n)
	{
		win = n;
		repaint();
	}
	
	private void drawWin(Graphics g)
	{
		switch(win)
		{
			case 1:
				g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
				break;
			case 2:
				g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
				break;
			case 3:
				g.drawLine(0, 0, getWidth(), getHeight());
				break;
			case 4:
				g.drawLine(getWidth(), 0, 0, getHeight());
				break;
		}
	}
	
	public void paintComponent(Graphics g)
	{
		int w = getWidth();
		int h = getHeight();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w, h);
		g.setColor(Color.BLACK);
		if(value == -1) // Draw X
		{
			g.drawLine(OFFSET, OFFSET, w-OFFSET, h-OFFSET);
			g.drawLine(w-OFFSET, OFFSET, OFFSET, h-OFFSET);
		}
		else if(value == 1) // Draw O
		{
			g.drawOval(OFFSET, OFFSET, w-2*OFFSET, h-2*OFFSET);
		}
		
		drawWin(g);
	}
}
