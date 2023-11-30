import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import java.util.Random;

public class QuestionLabel extends JLabel {
	
	Questions questions = new Questions();
	
	int randomQuestionNum;
	int randomFillerNum[] = new int[4];
	String currentAnswer = "";
	
	Random random = new Random();
	
	QuestionLabel(){
		setForeground(Color.white);
		setFont(new Font("Serif", Font.PLAIN, 24));
		setBounds(0, 10, 400, 200);
		setCurrentText(this);
	}
	
	private void setCurrentText(JLabel questionLabel) {
		
		randomizeQuestions();
		this.setText("<html>"+ questions.questionsList.get(randomQuestionNum) + "<br>" 
		        +questions.fillerAnswerList.get(randomFillerNum[0]) + "<br>" 
				+questions.fillerAnswerList.get(randomFillerNum[1]) + "<br>"
				+questions.fillerAnswerList.get(randomFillerNum[2]) + "<br>"
				+questions.fillerAnswerList.get(randomFillerNum[3]) + "<br>" 
				+ "</html>");
	}
	
	private void randomizeQuestions() {
		 randomQuestionNum = random.nextInt(0,questions.questionsList.size());
		 currentAnswer = questions.answerList.get(randomQuestionNum);
		 for(int i = 0; i < randomFillerNum.length; i++ ) {
			 randomFillerNum[i] = (randomQuestionNum *4) + i;
		 }
		 
	}
	
	public String getAnswer() {
		return this.currentAnswer;
	}
}
