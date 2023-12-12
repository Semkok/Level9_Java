import java.awt.Color;
import javax.swing.JPanel;

/*
 * QuizPanel class for displaying a panel with the fillerAnswers and the ChoiceButtons
 * */
public class QuizPanel extends JPanel {
	private final int WIDTH = 700;
	private final int HEIGHT = 400;
	
	CurrentQuestion question;
	
	ChoiceButton[] choiceButtons = new ChoiceButton[4]; // TODO: 4 is a magic number it needs to be replaced
	
	// default value so if the choiceButton gets compared it won't bring a nullPointerException
	ChoiceButton clickedButton = new ChoiceButton("", "", null);
	
	QuizPanel(CurrentQuestion currentQuestion,QuestionLabel questionLabel){
		add(questionLabel);
		this.question = currentQuestion;
		int index = 0;
		setBounds(20,0,WIDTH,HEIGHT);
		setBackground(new Color(133, 93, 20));
		for(FillerAnswer fillerAnswer : question.getCurrentfillerAnswers()) {
			// strip and remove the - so the value can be compared with the answer
			choiceButtons[index] = new ChoiceButton(fillerAnswer.getFillerAnswer().replace("-", "").strip(),question.getCurrentAnswer(), this);
			add(choiceButtons[index]);
			index++;
		}
		
	}

}
