package brickbreaker;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HighScore extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String[] Name={"Snake" , "Tetris" , "Flappy Birds" , "Brick Breaker"};
	String[] highscore=new String[4];
	String[] PlayerName=new String[4];
	
	
	public HighScore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 558);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSnakes = new JLabel("SNAKES  :-");
		lblSnakes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSnakes.setForeground(Color.WHITE);
		lblSnakes.setHorizontalAlignment(SwingConstants.LEFT);
		lblSnakes.setBounds(12, 110, 124, 38);
		contentPane.add(lblSnakes);
		
		JLabel lblTetris = new JLabel("TETRIS   :-");
		lblTetris.setForeground(Color.WHITE);
		lblTetris.setHorizontalAlignment(SwingConstants.LEFT);
		lblTetris.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTetris.setBounds(12, 207, 124, 38);
		contentPane.add(lblTetris);
		
		JLabel lblFlappyBird = new JLabel("FLAPPY BIRD   :-");
		lblFlappyBird.setForeground(Color.WHITE);
		lblFlappyBird.setHorizontalAlignment(SwingConstants.LEFT);
		lblFlappyBird.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFlappyBird.setBounds(12, 314, 191, 38);
		contentPane.add(lblFlappyBird);
		
		JLabel lblBrickBreaker = new JLabel("BRICK BREAKER   :-");
		lblBrickBreaker.setForeground(Color.WHITE);
		lblBrickBreaker.setHorizontalAlignment(SwingConstants.LEFT);
		lblBrickBreaker.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBrickBreaker.setBounds(12, 415, 218, 38);
		contentPane.add(lblBrickBreaker);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(250, 121, 124, 38);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(250, 207, 124, 38);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(250, 314, 124, 38);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(250, 425, 124, 38);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_5.setBounds(400, 121, 124, 38);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel((String) null);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_6.setBounds(400, 207, 124, 38);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel((String) null);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_7.setBounds(400, 314, 124, 38);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel((String) null);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_8.setBounds(400, 415, 124, 38);
		contentPane.add(label_8);
		
		JLabel lblHighScore = new JLabel("HIGH SCORE");
		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblHighScore.setBounds(223, 32, 197, 78);
		contentPane.add(lblHighScore);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sanch\\eclipse-workspace\\snake\\images.jfif"));
		lblNewLabel.setBounds(0, 0, 642, 520);
		contentPane.add(lblNewLabel);
		
		String line;
		try 
		{ 
			FileReader fileReader =  new FileReader("tmp_HighScore.txt");
			try (BufferedReader bufferedReader = new BufferedReader(fileReader)) 
			{
				while((line = bufferedReader.readLine()) != null)
				{
					String[] parts = line.split(":");
					for(int i=0;i<parts.length;i++)
					{
						if(parts[i].equals(Name[0]))
						{    
							highscore[0]=parts[i+2];
							PlayerName[0]=parts[i+1];
						}
						else if(parts[i].equals(Name[1]))
						{    
							highscore[1]=parts[i+2];
							PlayerName[1]=parts[i+1];
						}
						else if(parts[i].equals(Name[2]))
						{    
							highscore[2]=parts[i+2];
							PlayerName[2]=parts[i+1];
						}
						else if(parts[i].equals(Name[3]))
						{    
							highscore[3]=parts[i+2];
							PlayerName[3]=parts[i+1];
						}
					}
                }
			} 
	   	}	
	   	
	   	
		catch(FileNotFoundException ex){}
		catch(IOException ex){}
 		
		label_1.setText(PlayerName[0]);
		label_5.setText(highscore[0]);
		
		label_2.setText(PlayerName[1]);
		label_6.setText(highscore[0]);
		
		label_3.setText(PlayerName[2]);
		label_7.setText(highscore[0]);
		
		label_4.setText(PlayerName[3]);
		label_8.setText(highscore[0]);
		
	}

}

