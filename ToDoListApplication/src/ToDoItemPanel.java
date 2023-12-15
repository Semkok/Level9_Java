import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class ToDoItemPanel extends JPanel implements ActionListener{
	
	private String name;
	private boolean status;
	private int id;
	
	JLabel jlabel = new JLabel();
	JRadioButton radioButton = new JRadioButton();
	
	
	
	ToDoItemPanel(String name, boolean status, int id){
		this.name = name;
		this.status = status;
		this.id = id;
		
		String text = String.format("<html>%s<br>%b<br>%d</html>",this.name,this.status,this.id);
		setPreferredSize(new Dimension(400,300));
		// every JPanel has a JRadiobutton for checking if the toDoItem is done
		radioButton.addActionListener(this);
		add(radioButton);
		jlabel.setText(text);
		add(jlabel);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(radioButton.isSelected()) {
			status = true;
			String text = String.format("<html>%s<br>%b<br>%d</html>",this.name,this.status,this.id);
			jlabel.setText(text);
		}
		
		else {
			status = false;
			String text = String.format("<html>%s<br>%b<br>%d</html>",this.name,this.status,this.id);
			jlabel.setText(text);
		}
		
	}
	
}
