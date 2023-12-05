import javax.swing.JPanel;
import java.awt.Color;

public class TimerPanel extends JPanel {
	
	final int WIDTH = 200;
	final int HEIGHT = 100;
	
	TimerPanel(){
		setBounds(1000,0,WIDTH,HEIGHT);
		setBackground(Color.cyan);
		setVisible(true);
	}
}
