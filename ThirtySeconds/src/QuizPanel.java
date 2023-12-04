import java.awt.Color;

import javax.swing.JPanel;

public class QuizPanel extends JPanel {
	final static int WIDTH = 700;
	final static int HEIGHT = 400;
	
	CurrentQuestion question;

	QuizPanel(CurrentQuestion currentQuestion){
		
		this.question = currentQuestion;
		setBounds(0,0,WIDTH,HEIGHT);
		setBackground(new Color(133, 93, 20));
	}

}
