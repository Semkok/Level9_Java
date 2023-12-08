public class ScoreHandler {
	private int timesRight = 0;
	private int timesWrong = 0;
	
	ScoreHandler(){
		
	}
	
	public void checkQuestion(QuizPanel quizPanel,CurrentQuestion currentQuestion) {
		String correctAnswer = currentQuestion.getCurrentAnswer(); 
		String inputValue = quizPanel.clickedButton.getButtonValue();
		
		if(inputValue.equals(correctAnswer)) {
			System.out.println("you guessed right!!!");
			timesRight++;
			System.out.println(timesRight);
		}
		else{
			System.out.println("Wrong!");
			timesWrong++;
			System.out.println(timesWrong);
		}
		
		System.out.println("answered with: " + inputValue + " Correct answer was: " + correctAnswer);
	
	}
	
	public int getTimesRight() {
		return this.timesRight;
	}
	
	public int getTimesWrong() {
		return this.timesWrong;
	}
	
}
