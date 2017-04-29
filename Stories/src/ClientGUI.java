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
 
public class ClientGUI extends JFrame {

	private final int windowWidth = 300;
	private final int windowHeight = 300; // lungime/latime default, variabile
	private JButton login, register; // declarare butoane
	private JLabel title; // declarare label
	
	public ClientGUI()
	{
		
		JFrame frame = new JFrame("Menu"); // frame = obiect - container
		try{
			
			frame.setContentPane(new JLabel((Icon) new ImageIcon(ImageIO.read(new File("background3.jpg")))));
			}
			catch(IOException e)
			{
				System.out.println("Image doesn't exist!");
				
			}
		
		login = new JButton("Login"); // nou buton text
		register = new JButton("Register"); 
		title = new JLabel("Welcome to Stories"); // nou buton 
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Arial", Font.BOLD, 16));
		
		frame.setLayout(null); // layout
		
		login.setBounds(100, 120, 90, 20); // unde apare - coordonate
		register.setBounds(100, 160, 90, 20); 
		title.setBounds(70, 60, 200, 20); // unde apare 
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
				RegisterInterface register = new RegisterInterface();
			}
		});
		
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				LoginInterface login = new LoginInterface();
			}
		});
		
		frame.setResizable(false);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // inchidere
	}
	
}