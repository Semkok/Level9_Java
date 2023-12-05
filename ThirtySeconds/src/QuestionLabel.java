import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import java.util.Random;

public class QuestionLabel extends JLabel {
	
	QuestionLabel(){
		setFont(new Font("Serif", Font.PLAIN, 24));
		setForeground(Color.white);
		setBounds(80,0,120,120);
		setVisible(true);
	}
	
}
