import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegisterInterface {

	private final int windowWidth = 300;
	private final int windowHeight = 300;

	public RegisterInterface() {
		JFrame frame = new JFrame("Register");

		try {
			frame.setContentPane(new JLabel((Icon) new ImageIcon(ImageIO.read(new File("black.png")))));
		} catch (IOException e) {
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
		JButton back = new JButton("Back");
		send.setFocusable(false);
		back.setFocusable(false);

		usernameText.setBounds(50, 80, 90, 20);
		passwordText.setBounds(50, 120, 90, 20);

		username.setBounds(150, 80, 90, 20);
		password.setBounds(150, 120, 90, 20);
		send.setBounds(100, 175, 90, 20);
		back.setBounds(100, 215, 90, 20);
		message.setBounds(90, 30, 150, 20);

		frame.setLayout(null);

		frame.setBounds(700, 150, windowWidth, windowHeight);

		frame.add(usernameText);
		frame.add(passwordText);
		frame.add(username);
		frame.add(password);
		frame.add(send);
		frame.add(back);
		frame.add(message);

		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sql sql = new Sql();
				int ok = 0;
				String string = sql.register(username.getText(), password.getText());
				// aici o sa vina functia din server
				if (string.equals("User added")) {
					ok = 1;
				}
				if (ok == 1) {
					message.setForeground(Color.GREEN);
					message.setText("Registration succesful.");
					username.setText("");
					password.setText("");
				} else {
					message.setForeground(Color.RED);
					message.setText(string);
				}
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				ClientGUI client = new ClientGUI();
			}

		});
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
