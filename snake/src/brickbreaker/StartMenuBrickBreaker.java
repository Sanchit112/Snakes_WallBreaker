package brickbreaker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartMenuBrickBreaker extends JFrame {

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
	public StartMenuBrickBreaker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JButton btnQuit = new JButton("QUIT");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(101, 272, 115, 29);
		contentPane.add(btnQuit);
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame obj=new JFrame();
				Bgameplay gameplay=new Bgameplay();
				obj.setBounds(10,10,700,600);
				obj.setTitle("BRICK BREAKER");
				obj.setResizable(false);
				obj.setVisible(true);
				obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj.add(gameplay);
			}
		});
		btnNewButton.setBounds(101, 237, 115, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sanch\\eclipse-workspace\\snake\\bbmenu.png"));
		lblNewLabel.setBounds(0, -19, 319, 515);
		contentPane.add(lblNewLabel);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenuBrickBreaker frame = new StartMenuBrickBreaker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}



}


