import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/*
 * The GameFrame class is used for holding all of the Panels for the QuizGame
 * */

public class GameFrame extends JFrame {
	
	private final int WIDTH = 1200;
	private final int HEIGHT = 1000;
	
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
