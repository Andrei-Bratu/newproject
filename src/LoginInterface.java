import java.awt.Color;
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
import javax.swing.JTextField;

public class LoginInterface {
	
	private final int windowWidth = 300;
	private final int windowHeight = 300; 
	
	public LoginInterface()
	{
		JFrame frame = new JFrame("Login");
		
		try
		{
			frame.setContentPane(new JLabel((Icon) new ImageIcon(ImageIO.read(new File("black.png")))));
		}
			catch(IOException e)
			{
				System.out.println("Image doesn't exist!");
				
			}
		
		JLabel usernameText = new JLabel("Username");
		JLabel passwordText = new JLabel("Password");
		JLabel message = new JLabel("");
		
		usernameText.setForeground(Color.WHITE);
		passwordText.setForeground(Color.WHITE);
		message.setForeground(Color.WHITE);
		
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
		
		frame.setLayout(null); 
		

		frame.setBounds(700, 150, windowWidth, windowHeight);  
		

		frame.add(usernameText);
		frame.add(passwordText);
		frame.add(username);
		frame.add(password);
		frame.add(send);
		frame.add(message);
	
		send.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					int ok = 1; // aici o sa vina functia din server
					if(ok == 1)
					{	
						HubInterface lobby = new HubInterface();
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
}