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
		
		login = new JButton("Login"); // nou buton text
		register = new JButton("Register"); 
		title = new JLabel("Welcome to Stories"); // nou buton 
		
		frame.setLayout(null); // layout
		
		login.setBounds(100, 80, 90, 20); // unde apare - coordonate
		register.setBounds(100, 120, 90, 20); 
		title.setBounds(100, 40, 150, 20); // unde apare 
		frame.setBounds(250, 150, windowWidth, windowHeight); // frame 
		
		login.setFocusable(false); // sa nu fie selectate
		register.setFocusable(false);
		title.setFocusable(false);
		
		frame.add(login); // adaugare in frame
		frame.add(register);
		frame.add(title);
		
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // inchidere
	}
	
	
	
	
}
