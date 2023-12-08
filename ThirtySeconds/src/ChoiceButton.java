import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class ChoiceButton extends JButton {
	
	// boolean for knowing if the button is the correct button for the quiz question
	private boolean isAnswerButton;

	private String fillerAnswer;
	
//	private ArrayList<Boolean> buttonInfo = new ArrayList<Boolean>();
	
	private QuizPanel quizPanel;
	
	ChoiceButton(String fillerAnswer, String answer, QuizPanel quizPanel){
		this.quizPanel = quizPanel;
		this.fillerAnswer = fillerAnswer;
		// if the button its fillerAnswer text is equals to the answer then this button is the answerButton
		if(answer.equals(fillerAnswer)) {
			isAnswerButton = true;
		}
		setPreferredSize(new Dimension(325,40));
		setText(fillerAnswer);
		addActionListener(new ActionButton());
	}
	
	private class ActionButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			getChoiceButton();
			setBackground(Color.blue);
		}
		
	}
	
	public String getButtonValue() {
		return this.fillerAnswer;
	}
	
	
	
	private void getChoiceButton() {
		// assigns the clicked button value of the button its quizPanel
		this.quizPanel.clickedButton = this;
	}
	
	
	
	
	
	
	
}
