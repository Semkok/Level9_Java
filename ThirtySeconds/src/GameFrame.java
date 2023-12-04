import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class GameFrame extends JFrame {
	
	static final int WIDTH = 1200;
	static final int HEIGHT = 1000;
	
	
	GamePanel gamePanel = new GamePanel();
	
	GameFrame(){
		setSize(WIDTH,HEIGHT);
		getContentPane().setBackground(new Color(19,200,120));
		setTitle("30 Seconds");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("dice.png").getImage());
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		add(gamePanel);
	}
	
	
}
