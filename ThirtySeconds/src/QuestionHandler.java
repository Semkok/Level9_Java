import java.util.ArrayList;

import javax.swing.JPanel;

public class QuestionHandler {
	
	// the current question that is present 
	CurrentQuestion question;
	
	// for holding all of the questions which are accessed for JLabels and input answer
	private ArrayList<CurrentQuestion> allQuestions =  new ArrayList<CurrentQuestion>();
	
	QuestionFiller filler = new QuestionFiller();
	
	QuestionHandler(){
		fillQuestions();
		
	}
	
	// removes the current question and goes to the next one 
	public void changeQuestion() {
		
	}
	
	private void removeQuestion() {
		
	}
	
	// sets the label for the JLabel
	public void setLabel(QuestionLabel questionLabel) {
		
	}
	
	// randomises the order of currentQuestions in the arraylist
	public void randomizeOrderQuestions() {
		
	}
	
	// fills the arrayList of currentQuestion objects 
	private void fillQuestions() {
		int numberOfFillerAnswers = 4;
		
		for(int i = 0; i < filler.questionsList.size(); i++) {
			// every question has a four filler answers so if the index of the loop is equal to 1 then (i * numberOfFillerAnswers ) + 1 = 5 of the fillerAnswerList
			// this way every question its filler answers can be added to an array in a specific question 
			FillerAnswer[] fillerAnswers = {filler.fillerAnswerList.get((i * numberOfFillerAnswers)),filler.fillerAnswerList.get((i * numberOfFillerAnswers) + 1),filler.fillerAnswerList.get((i * numberOfFillerAnswers) + 2),filler.fillerAnswerList.get((i * numberOfFillerAnswers) + 3)};
			
			// add this new question to the allQuestions list 
			this.allQuestions.add(new CurrentQuestion(filler.questionsList.get(i), filler.answerList.get(i),fillerAnswers));
		}
		
	}
	
}
