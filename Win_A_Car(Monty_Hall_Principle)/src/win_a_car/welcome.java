/*
1. The very first window that appears on beginning of the programm.
2. Contains two buttons to login into the game or create a new game account.
 */


package win_a_car;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class welcome extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome frame = new welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(181, 39, 152, 84);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("NEW PLAYER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new_player pl = new new_player();
				pl.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(56, 170, 137, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ALREADY A PLAYER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login log = new login();
				log.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(261, 170, 166, 43);
		contentPane.add(btnNewButton_1);
	}
}
