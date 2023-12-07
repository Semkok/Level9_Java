import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class GameFrame extends JFrame {
	
	static final int WIDTH = 1200;
	static final int HEIGHT = 1000;
	
	GamePanel gamePanel = new GamePanel();
	TimerPanel timerPanel = new TimerPanel();
	
	GameFrame(){
		setSize(WIDTH,HEIGHT);
		getContentPane().setBackground(Color.black);
		setTitle("Quiz game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("dice.png").getImage());
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		add(gamePanel);
		add(timerPanel);
		
	}
	

	
	
}
