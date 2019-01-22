import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TicTacToe extends JFrame
		implements MouseListener
{
	private TicTacSquare[][] board = new TicTacSquare[3][3];
	private TicTacSquare[] winSpots = new TicTacSquare[3];
	
	private boolean turn = false; // false for X, true for O; X goes first
	private boolean won = false;
	
	public TicTacToe()
	{
		super("Tic Tac Toe");
		
		loadBoard();
		
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(new GridLayout(3, 3));
		fillContentPane(c);
	}
	
	private void loadBoard()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				board[i][j] = new TicTacSquare("test");
				board[i][j].setBorder(new LineBorder(Color.BLACK, 1));
				board[i][j].addMouseListener(this);
			}
		}
	}
	
	private void fillContentPane(Container c)
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				c.add(board[i][j]);
			}
		}
	}
	
	private boolean detectWin()
	{
		// Horizontal
		for(int i = 0; i < 3; i++)
		{
			if(board[i][0].getValue() == board[i][1].getValue() && board[i][0].getValue() == board[i][2].getValue())
			{
				if(board[i][0].getValue() + board[i][1].getValue() + board[i][2].getValue() != 0)
				{
					board[i][0].setWin(2);
					board[i][1].setWin(2);
					board[i][2].setWin(2);
					won = true;
					break;
				}
			}
		}
		// Vertical
		for(int i = 0; i < 3; i++)
		{
			if(board[0][i].getValue() == board[1][i].getValue() && board[0][i].getValue() == board[2][i].getValue())
			{
				if(board[0][i].getValue() + board[1][i].getValue() + board[2][i].getValue() != 0)
				{
					board[0][i].setWin(1);
					board[1][i].setWin(1);
					board[2][i].setWin(1);
					won = true;
					break;
				}
			}
		}
		// Diagonal Down Right
		if(board[0][0].getValue() == board[1][1].getValue() && board[0][0].getValue() == board[2][2].getValue())
		{
			if(board[0][0].getValue() + board[1][1].getValue() + board[2][2].getValue() != 0)
			{
				board[0][0].setWin(3);
				board[1][1].setWin(3);
				board[2][2].setWin(3);
				won = true;
			}
		}
		// Diagonal Down Left
		if(board[0][2].getValue() == board[1][1].getValue() && board[0][2].getValue() == board[2][0].getValue())
		{
			if(board[0][2].getValue() + board[1][1].getValue() + board[2][0].getValue() != 0)
			{
				board[0][2].setWin(4);
				board[1][1].setWin(4);
				board[2][0].setWin(4);
				won = true;
			}
		}
		return won;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		if(!won)
		{
			if (e.getButton() == MouseEvent.BUTTON1)
			{
				TicTacSquare s = (TicTacSquare) e.getSource();
				if (s.getValue() == 0)
				{
					s.setValue(turn ? 1 : -1);
					turn = !turn;
					if (detectWin())
					{
					
					}
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		TicTacToe ttt = new TicTacToe();
		ttt.setBounds(100, 100, 300, 300);
		ttt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ttt.setVisible(true);
	}
	
	// Required for MouseListener interface
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
}
