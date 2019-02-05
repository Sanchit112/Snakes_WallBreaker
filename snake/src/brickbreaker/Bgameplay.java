package brickbreaker;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Bgameplay extends JPanel implements KeyListener,ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean play=false;
	public int score =0;
	
	private int totalBricks=21;
	
	private Timer timer;
	private int delay=6;
	
	private int playerX=310;

	private int ballposX=120;
	private int ballposY=350;
	private int ballXdir=-1;
	private int ballYdir=-2;
	
	private boolean left=false;
	private boolean right=false;

	private MapGenerator map;
	private ImageIcon Background;
	
	public Bgameplay()
	{
		map=new MapGenerator(3,7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer=new Timer(delay,this);
		timer.start();
		
		
	}
	
	public void paint(Graphics g)
	{

		//background
		Background=new ImageIcon("brickbreaker.png");
		Background.paintIcon(this,g,1,1);
		g.setColor(Color.BLACK);
		
		//map
		map.draw((Graphics2D)g);
		
		
		//borders
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		//ball
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(ballposX,ballposY, 20, 20);
		
		//help display
		g.setColor(Color.WHITE);
		g.setFont(new Font("Times New Roman",Font.BOLD,25));
		g.drawString("SCORE:"+score,500,30);
		g.drawString("P:PAUSE",10 ,30 );
		g.drawString("SPACE:RESET",190,30);
		
		//ball goes down
		if(ballposY>570)
		{
			play=false;
			ballXdir=0;
			ballYdir=0;
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Times New Roman",Font.BOLD,30));
			g.drawString("GAME OVER   SCORE : "+score, 150,300);
			g.drawString("PRESS ENTER TO RESET ",150,350);
			timer.stop();
			this.calculateHighscore(score);
			g.dispose();
			System.exit(0);
			
		}
		//game won
		if(totalBricks<=0)
		{
			play=false;
			ballXdir=0;
			ballYdir=0;
			g.setColor(Color.WHITE);
			g.setFont(new Font("Times New Roman",Font.BOLD,30));
			g.drawString("GAME OVER YOU WON 	  SCORE : "+score, 150,300);
			g.drawString("PRESS SPACE TO RESET ",150,350);
			timer.stop();
			this.calculateHighscore(score);
			g.dispose();
			System.exit(0);
		
		}
		
		//movement of paddle
		if(right)
		{	
			if(left)
				left=false;
			
			if(playerX>600)
			{
				playerX=600;
				left=true;
			}
			
			playerX+=1;
		}
		
		if(left)
		{
			if(right)
				right=false;
			
			if(playerX<10)
			{
				playerX=10;
				right=true;
			}
			
			playerX-=1;	
		}	
		
		//difficulty
		if(totalBricks%3==0)
		{
			delay--;
		}
		
		g.dispose();
	}
	
	public void calculateHighscore(int Rscore)
	{
		int score=Rscore;
		HighScoreCalculator obj=new HighScoreCalculator();
		obj.Check_highscore(score, "Brick Breaker");		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
        if(play)
        {
        	if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8)))
        	{
        		ballYdir=-ballYdir;
        	}
        	
        A:	for(int i=0;i<map.map.length;i++)
        	{
        		for(int j=0;j<map.map[0].length;j++)
        		{
        			if(map.map[i][j]>0)
        			{
        				int brickX=j*map.brickWidth+80;
        				int brickY=i*map.brickHeight+50;
        				int brickWidth=map.brickWidth;
        				int brickHeight=map.brickHeight;
        				
        				Rectangle rect=new Rectangle(brickX,brickY,brickWidth,brickHeight);
        				Rectangle ballRect=new Rectangle(ballposX,ballposY,20,20);
        				Rectangle brickRect=rect;
        				
        				if(ballRect.intersects(brickRect))
        				{
        					map.setBrickValue(0, i, j);
        					totalBricks--;
        					score=score+(21-totalBricks)*10;
        					
        					if(ballposX+19<=brickRect.x||ballposX+1>=brickRect.x+brickRect.width)
        					{
        						ballXdir=-ballXdir;
        					}
        					else
        					{
        						ballYdir=-ballYdir;
        					}
        					break A;
        				}
        			}
        		}
        	}
        	
        	
        	ballposX+=ballXdir;
        	ballposY+=ballYdir;
        	if(ballposX<0)
        	{
        		ballXdir=-ballXdir;
        	}
        	if(ballposY<0)
        	{
        		ballYdir=-ballYdir;
        	}
        	if(ballposX>670)
        	{
        		ballXdir=-ballXdir;
        	}
        }
           
		repaint();
	}

	public void moveRight()
	{
		left=false;
		right=true;
		playerX+=30;
			
	}
	
	public void moveLeft()
	{
		right=false;
		left=true;
		playerX-=30;
	}
	
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			play=true;
			moveRight();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{

			play=true;
			moveLeft();
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
				play=true;
				right=false;
				left=false;
				ballposX=120;
				ballposY=350;
				ballXdir=-1;
				ballYdir=-2;
				playerX=310;
				score=0;
				totalBricks=21;
				map=new MapGenerator(3,7);
				repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
			System.exit(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_P)
		{
			if(timer.isRunning())
				timer.stop();
			else
				timer.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			play=true;
			right=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			play=true;
			left=true;
		}
		
	}
	
}


