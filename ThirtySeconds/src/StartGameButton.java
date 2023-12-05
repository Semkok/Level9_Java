import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StartGameButton extends JButton {
	
	
	Game game;
	
	GamePanel gamePanel;
	
	StartGameButton(Game game, GamePanel gamePanel){
		this.game = game;
		this.gamePanel = gamePanel;
		setBounds(300,300,200,100);
		setText("Start the quiz!");
		addActionListener(new StartGame());
	}
	
	
	private class StartGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			game.gameStarted = true;
			gamePanel.removeAll();
			gamePanel.repaint();
			gamePanel.revalidate();
		}
		
	}
}
