import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class TimerPanel extends JPanel {
	
	private final int WIDTH = 200;
	private final int HEIGHT = 100;
	private JLabel timerLabel;
	
	TimerPanel(){
		setBounds(1000,0,WIDTH,HEIGHT);
		setBackground(Color.cyan);
		setVisible(true);
		timerLabel = new JLabel("Time remaining: ");
        timerLabel.setBounds(10, 10, 200, 30);
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timerLabel.setForeground(Color.BLACK);
        add(timerLabel);
	}
	
	public void updateTimerLabel(int timeRemaining) {
        timerLabel.setText("Time remaining: "  + timeRemaining );
    }
	
}
