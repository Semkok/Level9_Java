import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
/*
 * JLabel QuestionLabel for displaying the questions in the quizPanel
 * */
public class QuestionLabel extends JLabel {
	QuestionLabel(String text){
		setText(text);
		setFont(new Font("Serif", Font.PLAIN, 24));
		setForeground(Color.white);
		setPreferredSize(new Dimension(700,300));
		setVisible(true);
	}
	
}
