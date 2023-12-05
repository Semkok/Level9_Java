import javax.swing.Timer;

public class Game {
	
	boolean gameStarted = false;
	
	int questionNumber;
	
	private Timer countdownTimer;
	
	GameFrame gameFrame;
	QuestionHandler questionHandler;
	
	
	public int timeRemaining = 5;
	public int timerExecutionCount = 0;
	
	Game(){
		gameFrame = new GameFrame();
		questionHandler = new QuestionHandler();		
		questionHandler.setFirstQuestion(gameFrame.gamePanel);
        createCountDownTimer();
        countdownTimer.start();

	}
	
	private void createCountDownTimer() {
		
		countdownTimer = new Timer(1000, e -> {
            	
            	if (timerExecutionCount == questionHandler.allQuestions.size()) {
                	// stops the timer
                    countdownTimer.stop();
                }
            	else if(timeRemaining > 0) {
					gameFrame.timerPanel.updateTimerLabel(timeRemaining);// Update the timer label
					timeRemaining--;
					 System.out.println("Time remaining: " + timeRemaining );
					   
				}
				else {
					System.out.println("Time's up!");
	                timeRemaining = 5;  // Reset the timer for the next execution
	                timerExecutionCount++;
	                questionHandler.removeAndSetNewQuestion(gameFrame.gamePanel);
				}	
        });
        
	}
}
