import java.awt.Color;

import javax.swing.JPanel;

public class QuizPanel extends JPanel {
	final static int WIDTH = 700;
	final static int HEIGHT = 400;
	
	CurrentQuestion question;
	
	InputPanel inputPanel;
	
	QuizPanel(CurrentQuestion currentQuestion){
		this.question = currentQuestion;
		this.inputPanel = new InputPanel(this.question);
		setBounds(0,0,WIDTH,HEIGHT);
		setBackground(new Color(133, 93, 20));
		add(inputPanel);
	}

}
