import java.awt.Dimension;

import javax.swing.JButton;

public class ChoiceButton extends JButton {
	
	boolean isAnswerButton;
	
	String fillerAnswer;
	
	ChoiceButton(String fillerAnswer){
		this.fillerAnswer = fillerAnswer;
		setPreferredSize(new Dimension(325,40));
		setText(fillerAnswer);
	}
	
	
	
	
	
	
	
}
