import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	
	JLabel titleText; 
	
	
	GamePanel(){
		setBounds(200,200,WIDTH,HEIGHT);
		setBackground(new Color(133, 93, 20));
		titleText = new JLabel("Welcome to the Quiz!!!");
		titleText.setFont(new Font("Arial", Font.PLAIN, 32));
		titleText.setForeground(Color.WHITE);
		titleText.setBounds(225, 50, 400, 200);
		add(titleText);
		
		setLayout(null);
	}
	
	
	


}