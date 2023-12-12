import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.Border;

public class GamePanel extends JPanel {
	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	
	JLabel titleText; 
	
	GamePanel(){
		setBounds(200,200,WIDTH,HEIGHT);
		setBackground(new Color(133, 93, 20));
		titleText = new JLabel("Welkom bij de quiz!!!");
		titleText.setFont(new Font("Arial", Font.PLAIN, 32));
		titleText.setForeground(Color.WHITE);
		titleText.setBounds(225, 0, 400, 200);
		add(titleText);
		setLayout(null);
	}
	
}