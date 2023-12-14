import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ToDoItemPanel extends JPanel{
	
	ToDoItemPanel(String text){
		JLabel jlabel = new JLabel(text);
		add(jlabel);
		setPreferredSize(new Dimension(100,100));
		setVisible(true);
	}
	
}
