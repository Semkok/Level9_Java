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
	public String getCurrentfillerAnswers(){
		return "<html>" + this.fillerAnswers[0].getFillerAnswer() +  "<br>" + this.fillerAnswers[1].getFillerAnswer() +  "<br>" + this.fillerAnswers[2].getFillerAnswer() +  "<br>" + this.fillerAnswers[3].getFillerAnswer() +  "<br>" + "</html>";
	}
	public String getCurrentAnswer() {
		return this.answer.getAnswer();
	}
}
