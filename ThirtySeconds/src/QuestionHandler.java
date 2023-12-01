import java.util.ArrayList;

import javax.swing.JPanel;

public class QuestionHandler {
	
//	private ArrayList<String> currentQuestion = new ArrayList<String>();
	
	CurrentQuestion question;
	
	private ArrayList<CurrentQuestion> allQuestions =  new ArrayList<CurrentQuestion>();
	
	QuestionFiller filler = new QuestionFiller();
	
	QuestionHandler(){
		fillQuestions();
		for(CurrentQuestion a : allQuestions) {
			System.out.println(a.getCurrentQuestion());
			System.out.println(a.getCurrentAnswer());
			System.out.println(a.getCurrentfillerAnswers());
			System.out.println();
			
		}
		
	}
	
	
	public void changeQuestion() {
		
	}
	
	public void getCurrentQuestionValues(QuestionLabel questionLabel) {
		questionLabel.setText("");
		
	}
	
	public void setLabel(QuestionLabel questionLabel) {
		
	}
	
	private void randomizeOrder() {
		
	}
	
	private void fillQuestions() {
		
		for(int i = 0; i < filler.questionsList.size(); i++) {
			// every question has a four filler answers so if the index of the question is equal to 0 then (i *4 ) + 1 = 1
			// this way every quetion its filler answers can be added to an array in a specific question 
			FillerAnswer[] fillerAnswers = {filler.fillerAnswerList.get((i * 4)),filler.fillerAnswerList.get((i * 4) + 1),filler.fillerAnswerList.get((i * 4) + 2),filler.fillerAnswerList.get((i * 4) + 3)};
			this.allQuestions.add(new CurrentQuestion(filler.questionsList.get(i), filler.answerList.get(i),fillerAnswers));
		}
		
	}
	
}
