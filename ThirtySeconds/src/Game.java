import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Game {

    int questionNumber;
    private Timer countdownTimer;
    GameFrame gameFrame;
    QuestionHandler questionHandler;
    public int timeRemaining = 12;
    public int timerExecutionCount = 0;

    Game() {
        gameFrame = new GameFrame();
        JButton startGameButton = new JButton("Start het spel!");
        startGameButton.addActionListener(new StartGame());
        startGameButton.setBounds(290, 300, 200, 80);
        gameFrame.gamePanel.add(startGameButton);
    }

    public class StartGame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            questionHandler = new QuestionHandler();
            questionHandler.setFirstQuestion(gameFrame.gamePanel);
            createCountdownTimer();
            countdownTimer.start();
        }
    }

    private void createCountdownTimer() {
        countdownTimer = new Timer(1000, e -> {
        	// if all the 8 questions have been iterated then stop the timer and set the scorePanel
            if (timerExecutionCount == (questionHandler.allQuestions.size() + 1) / 2) {
                countdownTimer.stop();
                ScorePanel scorePanel = new ScorePanel(this, gameFrame, questionHandler.scoreHandler.getTimesRight(), questionHandler.scoreHandler.getTimesWrong(), countdownTimer);
                questionHandler.scoreHandler.getTimesRight();
                
            // if the time Counter is zero then reset the timer    
            } else if (timeRemaining > 0) { 
                gameFrame.timerPanel.updateTimerLabel(timeRemaining);
                timeRemaining--;
                System.out.println("Time remaining: " + timeRemaining);
            } else {
                System.out.println("Time's up!");
                timeRemaining = 12;
                timerExecutionCount++;
                questionHandler.removeAndSetNewQuestion(gameFrame.gamePanel);
            }
        });
    }
    
   
    // two methods for reset button    
   private void startGame() {
       questionHandler = new QuestionHandler();
       questionHandler.setFirstQuestion(gameFrame.gamePanel);
       createCountdownTimer();
       countdownTimer.start();
   }

   public void resetGame() {
        questionNumber = 0;
        timeRemaining = 1;
        timerExecutionCount = 0;
        startGame();
        
    }
}