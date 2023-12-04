import java.awt.Color;
import javax.swing.JPanel;
import java.util.ArrayList;
public class GamePanel extends JPanel {
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	
	GamePanel(){
		setBounds(200,200,WIDTH,HEIGHT);
		setBackground(new Color(133, 93, 20));
		setLayout(null);
		
	}
}
