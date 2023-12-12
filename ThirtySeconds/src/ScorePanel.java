import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;

public class ScorePanel extends JPanel {
	
	private JLabel scoreText;
	
	public JButton startAgainButton;
	
	ScorePanel(Game game, GameFrame gameFrame, int timesRight, int timesWrong, Timer countdownTimer){
		removeOldLayout(gameFrame);
		setBackground(new Color(133, 93, 20));
		setScore(timesRight,timesWrong);
		setSize(800,600);
		setVisible(true);
		add(scoreText);
		
		// set reset button values 
		startAgainButton = new JButton();
		startAgainButton.setText("Opnieuw");
		startAgainButton.setBounds(0,200,100,100);
		
		// if the button is clicked reset the game 
		startAgainButton.addActionListener(e -> game.resetGame());
		add(startAgainButton);
	}
	
	// makes place for the ScorePanel in the gameFrame
	private void removeOldLayout(GameFrame gameFrame) {
		gameFrame.gamePanel.removeAll();
		gameFrame.gamePanel.repaint();
		gameFrame.gamePanel.revalidate();
		gameFrame.gamePanel.add(this);
	}
	
	private void setScore(int timesRight, int timesWrong) {
		scoreText = new JLabel();
		scoreText.setFont(new Font("Arial", Font.PLAIN, 16));
		scoreText.setText("<html>" + "Van de 8 vragen heb je : " + "<br>" + timesRight + " vragen goed!" + "<br>"  + "En " + timesWrong + " vragen fout!" + "</html>");
		scoreText.setBounds(0,0,200,200);
		scoreText.setForeground(Color.white);
	}

}
