import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class QuestionPanel extends JPanel {
	
	Questions questions = new Questions();
	Random random = new Random();
	
	int randomQuestionNum;
	int randomFillerNum[] = new int[4];
	
	String currentAnswer = "";
	
	// for keeping track of the current labels 
	ArrayList<QuestionLabel> questionLabels = new ArrayList<QuestionLabel>();
	
	QuestionPanel(){
		setBackground(new Color(133, 93, 20));
		setVisible(true);
		addLabelsToArrayList();
		add(questionLabels.get(0)); // TODO: randomizen
		
	}
	
	private void addLabelsToArrayList() {
		for(int i = 0; i < 5; i++) {
			questionLabels.add(new QuestionLabel());
		}
		
		questionLabels = removeEqualLabels(questionLabels);
	}
	
	private ArrayList<QuestionLabel> removeEqualLabels(ArrayList<QuestionLabel> questionLabels) {
		
		// linkedHashSet for keeping its elements at the same place
		Set<String> answerList = new LinkedHashSet<String>();
		
	
		while(answerList.size() != questionLabels.size()) {
			
			for(int i = 0; i < questionLabels.size(); i++) {
				
				answerList.add(questionLabels.get(i).getAnswer());
				
				
				if(answerList.add(questionLabels.get(i).getAnswer()) == false) {
					questionLabels.remove(i);
					questionLabels.add(new QuestionLabel());
				}
				
			}
			
		}
		
		// add question answers from the arraylist 		
		
		
		
		
		for(String a : answerList ) {
			System.out.println(a);
		}
		
		return questionLabels;
		
	}
	
}