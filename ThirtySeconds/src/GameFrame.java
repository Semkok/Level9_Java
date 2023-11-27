import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class GameFrame extends JFrame {
	GameFrame(){
		setSize(1024,768);
		setTitle("30 Seconds!");
		getContentPane().setBackground(new Color(13,171,19));
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		add(new GamePanel());
		add(new Context());
	}
	
	private class GamePanel extends JPanel{
		GamePanel(){
			setBounds(268,384,500,300);
			setBackground(Color.gray);
		}
	}
	
	private class Context extends JLabel{
		Context(){
			setText("30 seconds!");
			setForeground(Color.WHITE);
			setFont(new Font("Courier", Font.PLAIN, 40));
			setBounds(392,100,225,50);
		}
	}
	
	private class StartGame extends JButton{
		
	}
	
	public static void main(String[] args) {
		GameFrame gameFrame = new GameFrame();

	}
	
	
}
