import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class InputPanel extends JPanel {
	final int WIDTH = 800;
	final int HEIGHT = 200;
	
	// question for checking user input has all the attributes including the current answer 
	CurrentQuestion question;
	
	// the user input
	String input;
	
	// the answer that is from the question object 
	String answer;
	
	InputPanel(CurrentQuestion question){
		this.question = question;
		this.answer = this.question.getCurrentAnswer();
		setBounds(0,500,800,100);
		setVisible(true);
		setBackground(Color.BLACK);
		
	}
}
