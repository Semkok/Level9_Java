import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class GameFrame extends JFrame {
	
	static final int WIDTH = 1200;
	static final int HEIGHT = 1000;
	
	Game game;
	GamePanel gamePanel = new GamePanel();
	
	GameFrame(Game game){
		
		this.game = game;
		setSize(WIDTH,HEIGHT);
		getContentPane().setBackground(new Color(19,200,120));
		setTitle("Quiz game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("dice.png").getImage());
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		add(gamePanel);
		add(new TimerPanel());
		add(new StartGameButton(this.game,gamePanel));
	}
	

	
	
}
