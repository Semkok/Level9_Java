import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class ScorePanel extends JPanel {
	
	private JLabel scoreText;
	
	public JButton startAgainButton;
	
	
	ScorePanel(GameFrame gameFrame, int timesRight, int timesWrong, Timer countdownTimer){
		gameFrame.gamePanel.removeAll();
		gameFrame.gamePanel.repaint();
		gameFrame.gamePanel.revalidate();
		gameFrame.gamePanel.add(this);
		scoreText = new JLabel();
		setBackground(new Color(133, 93, 20));
		setScore(timesRight,timesWrong);
		setSize(300,200);
		setVisible(true);
		add(scoreText);
		startAgainButton = new JButton();
		startAgainButton.setText("Opnieuw");
		startAgainButton.setBounds(0,100,100,100);
		
		add(startAgainButton);
		
	}
	
	
	private void setScore(int timesRight, int timesWrong) {
		scoreText.setText("je hebt er " + timesRight + " goed" + " van de vragen en " + timesWrong + "fout");
		scoreText.setBounds(0,0,200,200);
	}

}
