import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StartGameButton extends JButton {
	
	
	
	StartGameButton(){
		
		setBounds(300,300,200,100);
		setText("Start the quiz!");
		addActionListener(new StartGame());
	}
	
	
	private class StartGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("w");
		}
		
	}
}
