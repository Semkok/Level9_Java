import javax.swing.JPanel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class QuestionPanel extends JPanel {
	
//	Question questions = new Question();
//
//	String currentAnswer = "";
//	
//	// for keeping track of the current labels 
//	ArrayList<QuestionLabel> questionLabels = new ArrayList<QuestionLabel>();
//	
//	QuestionPanel(){
//		
//		
//		
//		
//		setBackground(new Color(133, 93, 20));
//		setVisible(true);
//		this.addLabelsToArrayList();
//		currentAnswer = questionLabels.get(0).getAnswer(); //  get the current question to geuss
//		add(questionLabels.get(0)); // TODO: timer for displaying the text
//		System.out.println(currentAnswer);
//	}
//	
//	private void addLabelsToArrayList() {
//		for(int i = 0; i < questions.numberOfQuestions; i++) {
//			questionLabels.add(new QuestionLabel());
//		}
//		
//		// removes the labels that are duplicates 
//		questionLabels = removeEqualLabels(questionLabels);
//	}
//	
//	private ArrayList<QuestionLabel> removeEqualLabels(ArrayList<QuestionLabel> questionLabels) {
//		
//		// linkedHashSet for keeping its elements at the same place and removing duplicated answer entries
//		Set<String> answerList = new LinkedHashSet<String>();
//		
//		
//		while(answerList.size() != questionLabels.size()) {
//			
//			for(int i = 0; i < questionLabels.size(); i++) {
//				
//				answerList.add(questionLabels.get(i).getAnswer());
//				
//				// if answerlist entry is empty 
//				if(answerList.add(questionLabels.get(i).getAnswer()) == false) {
//					
//					// remove the 
//					questionLabels.remove(i);
//					questionLabels.add(new QuestionLabel());
//				}
//				
//			}
//			
//		}
//		
//		// add question answers from the arraylist 		
//		
//		return questionLabels;
//		
//	}
	
}