import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField; 

public class ClientGUI extends JFrame {

	private final int windowWidth = 300;
	private final int windowHeight = 300; // lungime/latime default, variabile
	private JButton login, register; // declarare butoane
	private JLabel title; // declarare label
	
	public ClientGUI()
	{
		
		JFrame frame = new JFrame("Menu"); // frame = obiect - container
		try{
			
			frame.setContentPane(new JLabel((Icon) new ImageIcon(ImageIO.read(new File("Poza2.jpg")))));
			}
			catch(IOException e)
			{
				System.out.println("Image doesn't exist!");
				
			}
		
		login = new JButton("Login"); // nou buton text
		register = new JButton("Register"); 
		title = new JLabel("Welcome to Stories"); // nou buton 
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Arial", Font.PLAIN, 14));
		
		frame.setLayout(null); // layout
		
		login.setBounds(100, 80, 90, 20); // unde apare - coordonate
		register.setBounds(100, 120, 90, 20); 
		title.setBounds(90, 40, 150, 20); // unde apare 
		frame.setBounds(250, 150, windowWidth, windowHeight); // frame 
		
		login.setFocusable(false); // sa nu fie selectate
		register.setFocusable(false);
		title.setFocusable(false);
		
		frame.add(login); // adaugare in frame
		frame.add(register);
		frame.add(title);
		
		register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				registerInterface();
			}
		});
		
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				loginInterface();
			}
		});
		
		frame.setResizable(false);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // inchidere
	}
	
	public void registerInterface()
	{
		JFrame frame = new JFrame("Register"); // frame = obiect - container
		
		JLabel usernameText = new JLabel("Username");
		JLabel passwordText = new JLabel("Password");
		JLabel message = new JLabel("");
		
		JTextField username = new JTextField(10);
		JTextField password = new JTextField(10);
	
		
		JButton send = new JButton("Send");
		send.setFocusable(false);
		
		usernameText.setBounds(50, 80, 90, 20);
		passwordText.setBounds(50, 120, 90, 20);
		
		username.setBounds(150, 80, 90, 20);
		password.setBounds(150, 120, 90, 20);
		send.setBounds(100, 175, 90, 20);
		message.setBounds(75, 225, 150, 20);
		
		frame.setLayout(null); // layout
		

		frame.setBounds(700, 150, windowWidth, windowHeight); // frame 
		

		frame.add(usernameText);
		frame.add(passwordText);
		frame.add(username);
		frame.add(password);
		frame.add(send);
		frame.add(message);
	
		send.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					int ok = 1;
					if(ok == 1)
					{	message.setForeground(Color.GREEN);
						message.setText("Registration succesfull.");
						username.setText("");
						password.setText("");
					}
					else
					{	message.setForeground(Color.RED);
						message.setText("Error occured.");
					}
				}
		});
		
		frame.setResizable(false);
		frame.setVisible(true); 
	}
	
	public void loginInterface()
	{
JFrame frame = new JFrame("Login"); // frame = obiect - container
		
		JLabel usernameText = new JLabel("Username");
		JLabel passwordText = new JLabel("Password");
		JLabel message = new JLabel("");
		
		JTextField username = new JTextField(10);
		JTextField password = new JTextField(10);
	
		
		JButton send = new JButton("Send");
		send.setFocusable(false);
		
		usernameText.setBounds(50, 80, 90, 20);
		passwordText.setBounds(50, 120, 90, 20);
		
		username.setBounds(150, 80, 90, 20);
		password.setBounds(150, 120, 90, 20);
		send.setBounds(100, 175, 90, 20);
		message.setBounds(75, 225, 150, 20);
		
		frame.setLayout(null); // layout
		

		frame.setBounds(700, 150, windowWidth, windowHeight); // frame 
		

		frame.add(usernameText);
		frame.add(passwordText);
		frame.add(username);
		frame.add(password);
		frame.add(send);
		frame.add(message);
	
		send.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					int ok = 1;
					if(ok == 1)
					{	
						lobbyInterface();
					}
					else
					{	message.setForeground(Color.RED);
						message.setText("Invalid username.");
					}
				}
		});
		
		frame.setResizable(false);
		frame.setVisible(true); 
	}
	
	public void lobbyInterface()
	{
		int windowWidth2=600;
		int windowHeight2=500;
		
		JFrame frame = new JFrame("Lobby"); // frame = obiect - container
		
		//JLabel usernameText = new JLabel("Username");
		JPanel panel = new JPanel();
		//usernameText.setBounds(50, 80, 90, 20);
		String data[][]={ {"101","Amit","670000"},    
                {"102","Jai","780000"},    
                {"101","Sachin","700000"}};    
		String column[]={"ID","NAME","SALARY"};         
		JTable jt=new JTable(data,column);    
		       
		JScrollPane sp=new JScrollPane(jt);  
		panel.add(sp);
		frame.setLayout(null); // layout
		
		panel.setBounds(10, 10, 600, 500);
		frame.setBounds(500, 200, windowWidth2, windowHeight2); // frame 
		
		//frame.add(usernameText);
		frame.add(panel);  
	

		
		frame.setResizable(false);
		frame.setVisible(true); 
	}
	
}
