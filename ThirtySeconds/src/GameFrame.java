import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class GameFrame extends JFrame {
	
	static final int WIDTH = 1200;
	static final int HEIGHT = 1000;
	
	GameFrame(){
		setSize(WIDTH,HEIGHT);
		getContentPane().setBackground(new Color(19,200,120));
		setTitle("30 Seconds");
		setIconImage(new ImageIcon("dice.png").getImage());
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		add(new GamePanel());
		setResizable(false);
	}
	
	
}
