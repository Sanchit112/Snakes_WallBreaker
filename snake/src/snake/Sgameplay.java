package snake;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Sgameplay extends JPanel implements KeyListener,ActionListener,MouseListener
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] snakeXlength=new int[750];
	private int[] snakeYlength=new int[750];
	private int[] barrierXposition=new int[100];
	private int[] barrierYposition=new int[100];
	
	private int[] fruitXposition= {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int[] fruitYposition= {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	
	private Random random=new Random();
	private int Xpos=random.nextInt(34);
	private int Ypos=random.nextInt(23);
	
	private boolean left=false;
	private boolean right=false;
	private boolean up=false;
	private boolean down=false;
	private boolean Quit=false;
	
	private ImageIcon fruit;
	private ImageIcon leftmouth;
	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon barrier;
	private ImageIcon snakeimage;
	private ImageIcon titleImage;
	private ImageIcon background;
	
	private int lengthofsnake=1;
	private int Score=0;
	private int moves=0;
	
	private Timer timer;
	public int delay=100;
	
	public Sgameplay()
	{
	   addKeyListener(this);
	   addMouseListener(this);
	   setFocusable(true);//default
	   setFocusTraversalKeysEnabled(false);//?
	   timer=new Timer(delay, this);
	   timer.start();   
	}
	
	public void paint(Graphics g)
	{
		if(moves==0)//start of game
		{
				snakeXlength[0]=100;
				snakeYlength[0]=100;
				
			    barrierXposition[0]=fruitXposition[9];
			    barrierYposition[0]=fruitXposition[9];  
		}
		
		//intializing all backgrounds
		background=new ImageIcon("background.jpg");
		background.paintIcon(this, g,0,0);
		
		g.setColor(Color.BLACK);
		g.drawRect(24, 10, 851, 55);
		
		titleImage=new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		g.setColor(Color.darkGray);
		g.drawRect(24, 74, 851, 577);
		g.fillRect(24, 70, 6, 577);
		g.fillRect(24, 70, 851-4,6);
		g.fillRect(24, 70+577,851,6);
		g.fillRect(20+851,70,6,577);
		
		g.setColor(Color.GREEN);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("SCORE:"+Score, 780, 30);
		
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("LENGTH: "+lengthofsnake, 780, 50);
		
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Q:QUIT", 50, 30);
		
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("P:PAUSE", 50, 50);
		
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("SPACE:RESET", 150, 30);
		
		rightmouth= new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
		leftmouth= new ImageIcon("leftmouth.png");
		upmouth= new ImageIcon("upmouth.png");
		downmouth= new ImageIcon("downmouth.png");
		snakeimage=new ImageIcon("snakeimage.png");
		fruit=new ImageIcon("fruit.png");
		barrier=new ImageIcon("timebomb.png");
				
		//various states in the game
		if(Quit)
		{
			System.exit(0);
		}
		
		//display snake
		for(int a=0; a<lengthofsnake;a++)
		{
			if(a==0 && left)
			{
			
				leftmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
			}
			if(a==0 && right)
			{
			
				rightmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
			}
			if(a==0 && up)
			{
			
				upmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
			}
			if(a==0 && down)
			{
			
				downmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
			}
			if(a!=0)
			{	
				snakeimage.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);	
			}
		}
		
		//barriers
		if(Score>=50)
		{
			for(int i=0;i<=lengthofsnake;i++)
			{
				if(barrierXposition[i]==snakeXlength[0] && barrierYposition[i]==snakeYlength[0])
				{
					right=false;
					left=false;
					up=false;
					down=false;
				
					g.setColor(Color.BLACK);
					g.setFont(new Font("arial",Font.BOLD,50));
					g.drawString("GAME OVER", 300, 300);
					
					HighScoreCalculator obj=new HighScoreCalculator();
					obj.Check_highscore(Score, "Snake");
					
					g.dispose();
				}
			}
		}	
	
		//check if fruit is eaten
		if(fruitXposition[Xpos]==snakeXlength[0] && fruitYposition[Ypos]==snakeYlength[0])
		{
			if(lengthofsnake==1)
				Score=Score+20;
			else
				Score=Score+(lengthofsnake*3);

				Xpos=random.nextInt(34);
				Ypos=random.nextInt(23);
		
				lengthofsnake++;
				
			barrierXposition[lengthofsnake]=fruitXposition[random.nextInt(34)];
			barrierYposition[lengthofsnake]=fruitYposition[random.nextInt(23)];
			
			delay--;
		}
		
		//barrier
		if(Score>50)
		{
				for(int i=0;i<=lengthofsnake;i++)
				{	
					
					g.fillRect(barrierXposition[i], barrierYposition[i],25,25);
					if(barrierXposition[i]==fruitXposition[Xpos]&&barrierYposition[i]==fruitYposition[Ypos])
					{
						while(barrierXposition[i]!=fruitXposition[Xpos]&&barrierYposition[i]!=fruitYposition[Ypos])
						{
							barrierXposition[i]=fruitXposition[random.nextInt(34)];
							barrierYposition[i]=fruitYposition[random.nextInt(23)];
						}
					}
					barrier.paintIcon(this, g, barrierXposition[i], barrierYposition[i]);
				}
		}
		
		fruit.paintIcon(this, g, fruitXposition[Xpos], fruitYposition[Ypos]);
		
		//snake touches itself
		for(int b=1;b<lengthofsnake;b++)
		{
			if(snakeXlength[b]==snakeXlength[0] && snakeYlength[b]==snakeYlength[0]) 
			{
				right=false; 
				left=false;
				up=false;
				down=false;
				
				g.setColor(Color.BLACK);
				g.setFont(new Font("arial",Font.BOLD,50));
				g.drawString("GAME OVER", 300, 300);
				//how to go back to menu
				
				HighScoreCalculator obj=new HighScoreCalculator();
				obj.Check_highscore(Score, "Snake");
				
			}
		}
		
		g.dispose();
	
	}
	
	//action listeners
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		
		if(right)
		{
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				snakeYlength[r+1]=snakeYlength[r];
			}
			for(int r=lengthofsnake;r>=0;r--)
			{
				if(r==0)
				{
					snakeXlength[r]=snakeXlength[r]+25;
				}
				else
				{
					snakeXlength[r]=snakeXlength[r-1];
				}
				if(snakeXlength[r]>850)
				{
					snakeXlength[r]=25;
				}
			} 
			repaint();
		}
		if(left)
		{
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				snakeYlength[r+1]=snakeYlength[r];
			}
			for(int r=lengthofsnake;r>=0;r--)
			{
				if(r==0)
				{
					snakeXlength[r]=snakeXlength[r]-25;
				}
				else
				{
					snakeXlength[r]=snakeXlength[r-1];
				}
				if(snakeXlength[r]<25)
				{
					snakeXlength[r]=850;
				}
			} 
			repaint();
		}
		if(up)
		{
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				snakeXlength[r+1]=snakeXlength[r];
			}
			for(int r=lengthofsnake;r>=0;r--)
			{
				if(r==0)
				{
					snakeYlength[r]=snakeYlength[r]-25;
				}
				else
				{
					snakeYlength[r]=snakeYlength[r-1];
				}
				if(snakeYlength[r]<75)
				{
					snakeYlength[r]=625;
				}
			} 
			repaint();
		}
		if(down)
		{
			for(int r=lengthofsnake-1;r>=0;r--)
			{
				snakeXlength[r+1]=snakeXlength[r];
			}
			for(int r=lengthofsnake;r>=0;r--)
			{
				if(r==0)
				{
					snakeYlength[r]=snakeYlength[r]+25;
				}
				else
				{
					snakeYlength[r]=snakeYlength[r-1];
				}
				if(snakeYlength[r]>625)
				{
					snakeYlength[r]=75;
				}
			} 
			repaint();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()==KeyEvent.VK_P)
		{
			if(timer.isRunning())
				timer.stop();
			else
				timer.start();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_Q)
		{
		    Quit=true;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			moves=0;
			Score=0;
			lengthofsnake=3;	
		}
		
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			moves++;
			right=true;
			if(!left)
			{
				right=true;
			}
			else
			{
				right=false;
				left=true;
			}
			up=false;
			down=false;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			moves++;
			left=true;
			if(!right)
			{
				left=true;
			}
			else
			{
				left=false;
				right=true;
			}
			up=false;
			down=false;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			moves++;
			up=true;
			if(!down)
			{
				up=true;
			}
			else
			{
				up=false;
				down=true;
			}
			left=false;
			right=false;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			moves++;
			down=true;
			if(!up)
			{
				down=true;
			}
			else
			{
				down=false;
				up=true;
			}
			left=false;
			right=false;
		}
		
	}

	public void keyReleased(KeyEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

}
