package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Menu {

	private JFrame frmPwAssignment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmPwAssignment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPwAssignment = new JFrame();
		frmPwAssignment.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\asus\\Downloads\\images1.jpg"));
		frmPwAssignment.setTitle("Games Hub");
		frmPwAssignment.setBounds(new Rectangle(0, 0, 700, 550));
		frmPwAssignment.getContentPane().setLayout(null);
		
		JButton btntetris = new JButton("");
		btntetris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			new Window(); 
			}
		});
		
		JButton btnbird = new JButton("");
		btnbird.setIcon(new ImageIcon("C:\\Users\\asus\\Downloads\\Flappy_Birdnew.jpg"));
		btnbird.setBounds(47, 341, 141, 90);
		frmPwAssignment.getContentPane().add(btnbird);
		
		JButton btnsnake = new JButton("");
		btnsnake.setIcon(new ImageIcon("C:\\Users\\asus\\Downloads\\snakenew.jpg"));
		btnsnake.setBounds(47, 196, 141, 90);
		frmPwAssignment.getContentPane().add(btnsnake);
		btntetris.setBounds(47, 82, 154, 55);
		frmPwAssignment.getContentPane().add(btntetris);
		btntetris.setIcon(new ImageIcon("C:\\Users\\asus\\Downloads\\terisnew.jpg"));
		btntetris.setSelectedIcon(new ImageIcon("C:\\Users\\asus\\Downloads\\terisnew.jpg"));
		
		JLabel lblBackground = new JLabel("Background");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\asus\\Downloads\\z1.png"));
		lblBackground.setBounds(0, 0, 682, 503);
		frmPwAssignment.getContentPane().add(lblBackground);
	}
}
