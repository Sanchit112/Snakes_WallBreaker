package snake;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class StartMenuSnake extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public StartMenuSnake() {
		setTitle("Snake\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds( 0,0, 434, 275);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton_1 = new JButton("New Game");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame obj =new JFrame();
				Sgameplay gameplay= new Sgameplay();
				obj.setBounds(10,10,905,700);
				obj.setBackground(Color.DARK_GRAY);
				obj.setResizable(false);
				obj.setVisible(true);
				obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj.getContentPane().add(gameplay);
			}
		});
		btnNewButton_1.setBounds(24, 199, 115, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Quit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(291, 199, 115, 29);
		contentPane.add(btnNewButton_2);
		

		JButton button = new JButton("High Score");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			HighScore obj=new HighScore();
			obj.setVisible(true);
			}
		});
		button.setBounds(149, 199, 132, 29);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sanch\\eclipse-workspace\\snake\\snakemenu.jpg"));
		lblNewLabel.setBounds(0, 0, 428, 244);
		contentPane.add(lblNewLabel);
		
	}
	
	public static void main(String args[])
	{
		try {
			StartMenuSnake frame = new StartMenuSnake();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
	
