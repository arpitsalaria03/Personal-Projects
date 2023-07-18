/*
1. A window for user to login into the game via username and password.
2. Contains buttons to switch to new user page or welcome window. 
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
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JPasswordField;
import java.awt.Font;
public class login extends JFrame {

	private JPanel contentPane;
	private JTextField tname;
	private JPasswordField tid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(182, 10, 61, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setBounds(57, 60, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(57, 128, 85, 13);
		contentPane.add(lblNewLabel_2);
		
		tname = new JTextField();
		tname.setBounds(259, 57, 96, 19);
		contentPane.add(tname);
		tname.setColumns(10);
		/*
		 * Gets the player's credentials from Name and Password field
		 * and logs into the player's account. 
		 */
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str;
				int count;
				String wins="0",loses="0";
				String name=tname.getText();
				String id=tid.getText();
				boolean flag=false;
				try {
				FileReader read=new FileReader("player_data.txt");
				BufferedReader br=new BufferedReader(read);
				while((str=br.readLine())!=null)
				{
					if(str.equals("Name:"+name+"\t"+"ID:"+id)) {
						flag=true;
						count=0;
						while((str=br.readLine())!=null)
						{
							count++;
							if(count==2)
							{
								wins=str;
							}
							if(count==4)
							{
								loses=str;
							}
						}
						break;
					}
				}
				read.close();
				}catch(Exception f) {}
				if(flag)
				{
				game_page game=new game_page();
				game.name=name;
				game.id=id;
				game.wins=Integer.parseInt(wins);
				game.loses=Integer.parseInt(loses);
				game.setVisible(true);
				game.setScore();
				dispose();
				}else
				{
					JOptionPane.showMessageDialog(null,"Invalid user");
				}
			}
		});
		btnNewButton.setBounds(17, 194, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NEW PLAYER/SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new_player pl=new new_player();
				pl.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(122, 194, 173, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome wel=new welcome();   /*Brings user back to welcome page*/
				wel.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(313, 194, 85, 21);
		contentPane.add(btnNewButton_2);
		
		tid = new JPasswordField();
		tid.setBounds(259, 125, 96, 19);
		contentPane.add(tid);
	}
}
