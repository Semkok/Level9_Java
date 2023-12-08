/*
 * The CurrentQuestion class is a class used for grouping all the questions and answers and fillerAnswers
 * so that they can be treated as one CurrentQuestion
 * */

public class CurrentQuestion {
	private Question question;
	private Answer answer;
	private FillerAnswer[] fillerAnswers;
	
	CurrentQuestion(Question question,Answer answer,FillerAnswer[] fillerAnswers){
		this.question = question;
		this.answer = answer;
		this.fillerAnswers = fillerAnswers;
	}
	
	public String getCurrentQuestion(){
		return this.question.getQuestion();
	}
	
	// in HTML format so that the text can have a layout under each other
	public String getQuestionInHTML() {
		return "<html>" + this.question.getQuestion() + "<br>" +
		this.fillerAnswers[0].getFillerAnswer() +  "<br>" +
		this.fillerAnswers[1].getFillerAnswer() +  "<br>" +
		this.fillerAnswers[2].getFillerAnswer() +  "<br>" + 
		this.fillerAnswers[3].getFillerAnswer() +  "<br>" + "</html>";
	}
	
	public FillerAnswer[] getCurrentfillerAnswersArray(){
		// in HTML format for QuestionLabel
		return  this.fillerAnswers;
	}
	
	public FillerAnswer[] getCurrentfillerAnswers(){
		// in HTML format for QuestionLabel
		return  this.fillerAnswers;
	}
	public String getCurrentAnswer() {
		return this.answer.getAnswer();
	}
}
