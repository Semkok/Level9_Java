import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateToDoItemPanel extends BasicPanel implements ActionListener{
	JTextField textFieldName = new JTextField();
	JTextField textFieldID = new JTextField();
	
	LocalToDoItemHandler localToDoItemHandler = new LocalToDoItemHandler();
	
	CreateToDoItemPanel(){
		JLabel dummy = new JLabel("Create panel");
		setLayout(null);
		add(dummy);
		JButton submitButton = new JButton();
		JLabel nameLabel = new JLabel("Name:");
		JLabel iDLabel = new JLabel("ID:");
		nameLabel.setBounds(0,0,50,50);
		iDLabel.setBounds(0,100,50,50);
		textFieldName.setBounds(0, 75, 300, 30);
		textFieldID.setBounds(0,150,300,30);
		submitButton.setBounds(0,225,120,60);
		submitButton.setText("Submit");
		add(textFieldName);
		add(textFieldID);
		add(submitButton);
		add(nameLabel);
		add(iDLabel);
		submitButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = textFieldName.getText(); 
		String iD = textFieldID.getText();
		localToDoItemHandler.createToDoItem(name, iD);
		
	}
}
