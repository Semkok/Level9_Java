import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
 *ChoiceButton class is a JButton on which the player can click to give an answer
 * */

public class ChoiceButton extends JButton {
	
	// boolean for knowing if the button is the correct button for the quiz question
	private boolean isAnswerButton;
	
	private String fillerAnswer;
	
	private QuizPanel quizPanel;
	
	ChoiceButton(String fillerAnswer, String answer, QuizPanel quizPanel){
		this.quizPanel = quizPanel;
		this.fillerAnswer = fillerAnswer;
		
		// if the button its fillerAnswer text is equals to the answer then this button is the answerButton
		if(answer.equals(fillerAnswer)) {
			this.isAnswerButton = true;
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
	
	private void getChoiceButton() {
		// assigns the clicked button value of the button its quizPanel
		this.quizPanel.clickedButton = this;
	}
	
	public String getButtonValue() {
		return this.fillerAnswer;
	}
	
	
}
