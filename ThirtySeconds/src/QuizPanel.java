import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class QuizPanel extends JPanel {
	final static int WIDTH = 700;
	final static int HEIGHT = 400;
	
	CurrentQuestion question;
	ChoiceButton[] choiceButtons = new ChoiceButton[4];
	
	// default value so if the choiceButton gets compared it won't bring a nullPointerException
	ChoiceButton clickedButton = new ChoiceButton("", "", null);
	
	QuizPanel(CurrentQuestion currentQuestion){
		setLayout(new FlowLayout());
		this.question = currentQuestion;
		int index = 0;
		setBounds(0,0,WIDTH,HEIGHT);
		setBackground(new Color(133, 93, 20));
		for(FillerAnswer fillerAnswer : question.getCurrentfillerAnswersArray()) {
			// strip and remove the - so the value can be compared with the answer
			choiceButtons[index] = new ChoiceButton(fillerAnswer.getFillerAnswer().replace("-", "").strip(),question.getCurrentAnswer(), this);
			add(choiceButtons[index]);
			index++;
		}
		
	}
	
	public String getClickedButton() {
		
		return this.clickedButton.getButtonValue();
	}

}
