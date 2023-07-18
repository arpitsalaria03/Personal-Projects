package win_a_car;

import java.awt.EventQueue;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
public class game_page extends JFrame {
	public String name;
	public String id;
	public int wins;
	public int loses;
	int random;
	/*
	 * Random class is used to generate a random number
	 * to set the goats and car behind the doors.
	 */
	Random ran=new Random();
	JTextArea ta = new JTextArea();
	JLabel label = new JLabel("NAME");
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game_page frame = new game_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*
	 * Sets the current as well as updated score on the specified text area.
	 * Updates the score in the player_data file.
	 */
	public void setScore()
	{
		label.setText("Welcome, "+name);
		try {
			StringBuffer buffer=new StringBuffer();
			String win=Integer.toString(wins);
			String lose=Integer.toString(loses);
			Scanner sc = new Scanner(new File("player_data.txt"));
			FileReader read=new FileReader("player_data.txt");
			BufferedReader br=new BufferedReader(read);
			String str;	
			int count;
			while((str=br.readLine())!=null)
			{
			buffer.append(sc.nextLine()+System.lineSeparator());
				if(str.equals("Name:"+name+"\t"+"ID:"+id)) {
					count=0;
					while((str=br.readLine())!=null)
					{
						count++;
						if(count==2)
						{
							sc.nextLine();
;							buffer.append(win+System.lineSeparator());
						}else if(count==4)
						{
							sc.nextLine();
							buffer.append(lose+System.lineSeparator());
						}else
						{
							buffer.append(sc.nextLine()+System.lineSeparator());
						}
					}
					break;
				}
			}
			while (sc.hasNextLine()) {
		         buffer.append(sc.nextLine()+System.lineSeparator());
		      }
		      String fileContents = buffer.toString();
		      FileWriter writer=new FileWriter("player_data.txt");
		      writer.append(fileContents);
		      writer.close();
			read.close();
			}catch(Exception f) {}
		ta.setText("SCORE\r\n\r\nWINS: "+wins+"\r\nLOSES: "+loses);
	}
	/**
	 * Create the frame.
	 */
	public game_page()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WIN A CAR");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(269, 10, 128, 31);
		contentPane.add(lblNewLabel);
		
		label.setBounds(10, 10, 159, 13);
		contentPane.add(label);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(102, 205, 170));
		panel1.setBounds(108, 64, 125, 179);
		contentPane.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(102, 205, 170));
		panel2.setBounds(241, 64, 125, 179);
		contentPane.add(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(102, 205, 170));
		panel3.setBounds(376, 64, 125, 179);
		contentPane.add(panel3);
		JRadioButton r1 = new JRadioButton("DOOR 1");
		r1.setEnabled(false);
		r1.setBounds(118, 249, 103, 21);
		contentPane.add(r1);
		
		JRadioButton r2 = new JRadioButton("DOOR 2");
		r2.setEnabled(false);
		r2.setBounds(251, 249, 103, 21);
		contentPane.add(r2);
		
		JRadioButton r3 = new JRadioButton("DOOR 3");
		r3.setEnabled(false);
		r3.setBounds(386, 249, 103, 21);
		contentPane.add(r3);
		
		
		JButton switch_button = new JButton("SWITCH DOOR");
		switch_button.setEnabled(false);
		switch_button.setBounds(206, 287, 148, 21);
		contentPane.add(switch_button);
		
		JButton retain_button = new JButton("RETAIN DOOR");
		retain_button.setEnabled(false);
		retain_button.setBounds(368, 287, 133, 21);
		contentPane.add(retain_button);
		
		JButton start_button = new JButton("START");
		start_button.setBackground(Color.WHITE);
		start_button.setBounds(95, 287, 85, 21);
		contentPane.add(start_button);
		
		JTextArea txtrRedGoat = new JTextArea();
		txtrRedGoat.setEditable(false);
		txtrRedGoat.setText("RED - GOAT IS \r\nBEHIND THE\r\nDOOR");
		txtrRedGoat.setBounds(525, 142, 118, 73);
		contentPane.add(txtrRedGoat);
		ta.setEditable(false);
		ta.setText("SCORE\r\n\r\nWINS: "+wins+"\r\nLOSES: "+loses);
		ta.setBounds(525, 21, 107, 88);
		contentPane.add(ta);
		
		
		JButton btnNewButton_3 = new JButton("LOG OUT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome wel=new welcome();
				wel.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(15, 33, 103, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("HELP");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"\tInstructions\nThere are 3 doors, behind which are two goats and a car.\r\n"
						+ "You pick a door (call it door A). You’re hoping for the car of course.\r\n"
						+ "Game examines the other doors (B & C) and opens one with a goat. (If both doors have goats, game picks randomly)\r\n"
						+ "Here’s the game: Do you stick with door A (original guess) or switch to the unopened door?");
			}
		});
		btnNewButton_4.setBounds(15, 70, 85, 21);
		contentPane.add(btnNewButton_4);

		start_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r1.setEnabled(true);
				r2.setEnabled(true);
				r3.setEnabled(true);
				panel1.setBackground(Color.MAGENTA);
				panel2.setBackground(Color.MAGENTA);
				panel3.setBackground(Color.MAGENTA);
				switch_button.setEnabled(true);
				retain_button.setEnabled(true);
				start_button.setEnabled(false);
				random=ran.nextInt(1,4);
			}
		});

		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r2.setEnabled(false);
				r3.setEnabled(false);
				if(random==1)
				{
					int random2=ran.nextInt(2, 4);
					if(random2==2)
					{
						panel2.setBackground(Color.red);
					}
					if(random2==3)
					{
						panel3.setBackground(Color.red);
					}
				}else if(random==2)
				{
					panel3.setBackground(Color.red);
				}
				else if(random==3)
				{
					panel2.setBackground(Color.red);
				}
				r1.setEnabled(false);
			}
		});
		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r2.setEnabled(false);
				r3.setEnabled(false);
				if(random==2)
				{
					int random2=ran.nextInt(2, 4);
					if(random2==2)
					{
						panel1.setBackground(Color.red);
					}
					if(random2==3)
					{
						panel3.setBackground(Color.red);
					}
				}else if(random==1)
				{
					panel3.setBackground(Color.red);
				}
				else if(random==3)
				{
					panel1.setBackground(Color.red);
				}
				r1.setEnabled(false);
			}
		});
		r3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r2.setEnabled(false);
				r3.setEnabled(false);
				if(random==3)
				{
					int random2=ran.nextInt(2, 4);
					if(random2==2)
					{
						panel1.setBackground(Color.red);
					}
					if(random2==3)
					{
						panel2.setBackground(Color.red);
					}
				}else if(random==2)
				{
					panel1.setBackground(Color.red);
				}
				else if(random==1)
				{
					panel2.setBackground(Color.red);
				}
				r1.setEnabled(false);
			}
		});
		switch_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r1.setEnabled(false);
				r2.setEnabled(false);
				r3.setEnabled(false);
				retain_button.setEnabled(false);
				start_button.setEnabled(true);
				switch_button.setEnabled(false);
				if((r1.isSelected() && random==1) || (r2.isSelected() && random==2) || (r3.isSelected() && random==3))
				{
					loses++;
					JOptionPane.showMessageDialog(null,"YOU LOSE");
				}else
				{
					wins++;
					JOptionPane.showMessageDialog(null,"YOU WIN");
				}
				setScore();
				r1.setSelected(false);
				r2.setSelected(false);
				r3.setSelected(false);
			}
		});
		retain_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r1.setEnabled(false);
				r2.setEnabled(false);
				r3.setEnabled(false);
				retain_button.setEnabled(false);
				start_button.setEnabled(true);
				switch_button.setEnabled(false);
				if((r1.isSelected() && random==1) || (r2.isSelected() && random==2) || (r3.isSelected() && random==3))
				{
					wins++;
					JOptionPane.showMessageDialog(null,"YOU WIN");
				}else
				{
					loses++;
					JOptionPane.showMessageDialog(null,"YOU LOSE");
				}

				setScore();
				r1.setSelected(false);
				r2.setSelected(false);
				r3.setSelected(false);
			}
		});
	}
}
