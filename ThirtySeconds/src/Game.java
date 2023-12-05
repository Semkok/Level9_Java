import javax.swing.Timer;

public class Game {
	
	boolean gameStarted = false;
	
	int questionNumber;
	
	private Timer countdownTimer;
	
	GameFrame gameFrame;
	QuestionHandler questionHandler;
	
	
	public int timeRemaining = 30;
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
			
				if(timeRemaining > 0) {
					timeRemaining--;
					 System.out.println("Time remaining: " + timeRemaining );
					 gameFrame.timerPanel.updateTimerLabel(timeRemaining);  // Update the timer label
				}
				else {
					System.out.println("Time's up!");
	                timeRemaining = 30;  // Reset the timer for the next execution
	                timerExecutionCount++;
	                questionHandler.removeAndSetNewQuestion(gameFrame.gamePanel);
				}	
            	
            	if (timerExecutionCount == questionHandler.allQuestions.size() - 1) {
                	// stops the timer
                    countdownTimer.stop();
                }
        });
        
	}
}
