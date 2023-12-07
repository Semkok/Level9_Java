import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import java.util.Random;

public class QuestionLabel extends JLabel {
	
	
	
	QuestionLabel(String text){
		setText(text);
		setFont(new Font("Serif", Font.PLAIN, 24));
		setForeground(Color.white);
		setBounds(0,0,800,600);
		setVisible(true);
	}
	
}
