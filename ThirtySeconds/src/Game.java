import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
		
		JButton startGameButton = new JButton();
		
		startGameButton.addActionListener(new StartGame());
		
		startGameButton.setBounds(290,300,200,80);
		
		gameFrame.gamePanel.add(startGameButton);
	}
	
	
	private class StartGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			questionHandler.setFirstQuestion(gameFrame.gamePanel);
	        createCountDownTimer();
	        countdownTimer.start();
		}
		
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
