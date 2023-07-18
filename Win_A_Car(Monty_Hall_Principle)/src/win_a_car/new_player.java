/*
1. Programm frame to create anew gamer's account
   by setting up credentials like username and password/game id.
2. Contains a button to switch to login window if already a player.
3. Contains a back button to return to welcome window.
*/
package win_a_car;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class new_player extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new_player frame = new new_player();
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
	public new_player() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NEW PLAYER");
		lblNewLabel.setBounds(171, 10, 109, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setBounds(57, 71, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setBounds(57, 133, 86, 13);
		contentPane.add(lblNewLabel_2);
		
		t1 = new JTextField();
		t1.setBounds(261, 68, 96, 19);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("CONTINUE");
		btnNewButton_1.addActionListener(new ActionListener() {
			/*
			 * Checks whether player already has an account or not.
			 * IF yes, Player is asked to go to login page.
			 * If not, A new Player account is created.
			 */
			public void actionPerformed(ActionEvent e) {
				String str;
				boolean flag=false;
				try {
				FileReader read=new FileReader("player_data.txt");
				BufferedReader br=new BufferedReader(read);
				while((str=br.readLine())!=null)
				{
					if(str.equals("Name:"+t1.getText()+"\t"+"ID:"+t2.getText())) {
						flag=true;
						break;
					}
				}
				read.close();
				}catch(Exception f) {}
				if(flag)
				{
					JOptionPane.showMessageDialog(null, "Already a Player.\nGo to Login Page");
				}
				else
				{
				try
				{
				FileWriter fw=new FileWriter("player_data.txt",true);
				fw.write("Name:"+t1.getText()+"\t"+"ID:"+t2.getText()+"\n"+"Wins:"+"\n"+"0"+"\n"+"Loses:"+"\n"+"0"+"\n");
				fw.close();
				}catch(Exception g) {}
				game_page game=new game_page();
				game.name=t1.getText();
				game.id=t2.getText();
				game.wins=0;
				game.loses=0;
				game.setVisible(true);
				game.setScore();
				dispose();
				}
			}
		});
		btnNewButton_1.setBounds(23, 206, 103, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ALREADY A PLAYER/LOGIN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login log=new login();
				log.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(126, 206, 206, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome wel=new welcome();
				wel.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(334, 206, 85, 21);
		contentPane.add(btnNewButton_3);
		
		t2 = new JPasswordField();
		t2.setBounds(261, 130, 96, 19);
		contentPane.add(t2);
	}
}
