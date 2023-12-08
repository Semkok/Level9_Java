import java.util.ArrayList;
import java.util.Collections;

public class QuestionHandler {
	
	// the current question that is present 
	public CurrentQuestion question;
	
	// begin at the 0 question
	public int currentQuestionNumber = 0;
	
	// different quizPanels to show different screens with questions 
	private ArrayList<QuizPanel> quizPanels = new ArrayList<QuizPanel>();
	
	// for holding all of the questions which are accessed for JLabels and input answer
	public ArrayList<CurrentQuestion> allQuestions =  new ArrayList<CurrentQuestion>();
	
	// gets the questions,answers,filleranswers from the text file 
	private QuestionFiller filler = new QuestionFiller("QuestionsAndAnswers.txt");
	
	public ScoreHandler scoreHandler;
	
	
	QuestionHandler(){
		// when an instance is created it will fill all the question attributes in the allQuestions ArrayList
		fillQuestions();
		
		// fill the arrayList of quizPanels
		fillQuizPanels();
		
		// make a new ScoreHandler object
		scoreHandler = new ScoreHandler();
		
		// shuffles the quizpanels ArrayList so the questions are in random order
		randomizeOrderQuestions();
		
	}
	
	// removes the current question and goes to the next one 
	public void setFirstQuestion(GamePanel gamePanel) {
		clearQuestionPanel(gamePanel);
		gamePanel.add(quizPanels.get(currentQuestionNumber));
		setNewQuestion();
		System.out.println(question.getCurrentAnswer());
	}
	
	// removes the currentQuestion from the gamePanel and gets the next one
	public void removeAndSetNewQuestion(GamePanel gamePanel) {
		
		System.out.println(currentQuestionNumber);
		
		checkScore(quizPanels.get(currentQuestionNumber));
		
		clearQuestionPanel(gamePanel);
		if(currentQuestionNumber < allQuestions.size() -1) {
			currentQuestionNumber++;
		}
		
		gamePanel.add(quizPanels.get(currentQuestionNumber));
		// set the new question 
		setNewQuestion();
		
		System.out.println(question.getCurrentAnswer());
	}
	
	private void checkScore(QuizPanel quizPanel) {
		scoreHandler.checkQuestion(quizPanel,this.question);
	}
	
	private void clearQuestionPanel(GamePanel gamePanel) {
		gamePanel.removeAll();
		gamePanel.repaint();
		gamePanel.revalidate();
	}
	
	// updates the question attributes for the questionHandler
	private void setNewQuestion() {
		question = quizPanels.get(currentQuestionNumber).question;
	}
	
	// randomises the order of currentQuestions in the ArrayList
	public void randomizeOrderQuestions() {
		Collections.shuffle(quizPanels);
	}
	
	private void fillQuizPanels() {
		for(CurrentQuestion question : allQuestions) {
			
			QuizPanel quizPanel =  new QuizPanel(question, new QuestionLabel(question.getFormattedQuestion() + question.getCurrentfillerAnswers()));
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
