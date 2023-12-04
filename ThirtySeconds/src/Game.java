import java.awt.BorderLayout;

import javax.swing.JPanel;
public class Game {
	Game(){
		GameFrame gameFrame = new GameFrame();
		QuestionHandler questionHandler = new QuestionHandler();
		questionHandler.setFirstQuestion(gameFrame.gamePanel);
		
		
	}
}
