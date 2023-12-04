import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class QuestionHandler {
	
	// the current question that is present 
	public CurrentQuestion question;
	
	// begin at the 0 question
	private int currentQuestionNumber = 0;
	
	// different quizPanels to show different screens with questions 
	private ArrayList<QuizPanel> quizPanels = new ArrayList<QuizPanel>();
	
	// for holding all of the questions which are accessed for JLabels and input answer
	private ArrayList<CurrentQuestion> allQuestions =  new ArrayList<CurrentQuestion>();
	
	
	
	// gets the questions,answers,filleranswers from the text file 
	private QuestionFiller filler = new QuestionFiller();
	
	QuestionHandler(){
		// when an instance is created it will fill all the question attributes in the allQuestions ArrayList
		fillQuestions();
		
		// fill the arrayList of quizPanels
		fillQuizPanels();
		
		// shuffles the quizpanels ArrayList so the questions are in random order
		randomizeOrderQuestions();
		
		for(QuizPanel quiz : quizPanels) {
			System.out.println(quiz.question.getCurrentQuestion());
			System.out.println(quiz.question.getCurrentAnswer());
			
		}
		System.out.println();
		System.out.println(quizPanels.get(currentQuestionNumber).question);
		
	}
	
	// removes the current question and goes to the next one 
	public void setFirstQuestion(GamePanel gamePanel) {
		gamePanel.add(quizPanels.get(currentQuestionNumber));
	}
	
	// removes the currentQuestion from the gamePanel and gets the next one
	public void removeAndSetNewQuestion(GamePanel gamePanel) {
		gamePanel.removeAll();
		gamePanel.repaint();
		gamePanel.revalidate();
		currentQuestionNumber++;
		gamePanel.add(quizPanels.get(currentQuestionNumber));
	}
	
	private void setNewAttributes() {
		question = quizPanels.get(currentQuestionNumber).question;
	}
	
	// randomises the order of currentQuestions in the ArrayList
	public void randomizeOrderQuestions() {
		Collections.shuffle(quizPanels);
	}
	
	private void fillQuizPanels() {
		for(CurrentQuestion question : allQuestions) {
			
			QuizPanel quizPanel =  new QuizPanel(question);
			
			QuestionLabel questionLabel = new QuestionLabel();
			
			questionLabel.setText(question.getFormattedQuestion() + question.getCurrentfillerAnswers());
			
			quizPanel.add(questionLabel);
			
			quizPanels.add(quizPanel);
		}
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
