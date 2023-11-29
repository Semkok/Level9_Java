import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import java.util.Random;

public class QuestionPanel extends JPanel {
	
	JLabel questionLabel, fillerAnswer;
	Questions questions = new Questions();
	
	Random random = new Random();
	
	int randomQuestionNum;
	int randomFillerNum[] = new int[4];
	
	String currentAnswer = "";
	
	QuestionPanel(){
		setBackground(new Color(133, 93, 20));
		setVisible(true);
		setCurrentText(questionLabel);
	}
	
	private void setCurrentText(JLabel questionLabel) {
		questionLabel = new JLabel();
		questionLabel.setForeground(Color.white);
		questionLabel.setFont(new Font("Serif", Font.PLAIN, 24));
		questionLabel.setBounds(0, 10, 400, 200);	
		randomizeQuestions();
		System.out.println(currentAnswer);
		questionLabel.setText("<html>"+ questions.questionsList.get(randomQuestionNum) + "<br>" 
		        +questions.fillerAnswerList.get(randomFillerNum[0]) + "<br>" 
				+questions.fillerAnswerList.get(randomFillerNum[1]) + "<br>"
				+questions.fillerAnswerList.get(randomFillerNum[2]) + "<br>"
				+questions.fillerAnswerList.get(randomFillerNum[3]) + "<br>" 
				+ "</html>");
		this.add(questionLabel);
	}
	
	private void randomizeQuestions() {
		 randomQuestionNum = random.nextInt(0,questions.questionsList.size());
		 currentAnswer = questions.answerList.get(randomQuestionNum);
		 for(int i = 0; i < randomFillerNum.length; i++ ) {
			 randomFillerNum[i] = (randomQuestionNum *4) + i;
		 }
		 
	}
	
}
