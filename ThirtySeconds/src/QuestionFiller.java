import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;

public class QuestionFiller {
	
	final ArrayList<Question> questionsList = new ArrayList<Question>();
	final ArrayList<Answer> answerList = new ArrayList<Answer>();
	final ArrayList<FillerAnswer> fillerAnswerList = new ArrayList<FillerAnswer>();
	
	QuestionFiller(){
		// files all the ArrayLists with questions,answers and fillerAnswers 
		fillQuestionsAndAnswers();
	}
	
	private void fillQuestionsAndAnswers() {
		// this method gets all the questions and answers and fillerAnswers from the text file
		
		try {
			File myObj = new File("QuestionsAndAnswers.txt");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		      String data = myReader.nextLine();
		      if(data.startsWith("question:")) {
		    	  String question = data.replace("question:","");
		    	  // Trim to remove the unneeded whitespace
		    	  questionsList.add(new Question(question.trim()));
		    	 
		      }
		      else if(data.startsWith("answer:")) {
		    	  String answer = data.replace("answer:","");   	  
		    	  answerList.add(new Answer(answer.trim()));
		      }
		      else if(data.startsWith("-")) {
		    	  String fillerAnswer = data;    	  
		    	  fillerAnswerList.add(new FillerAnswer(fillerAnswer.trim()));
		      }
		    }
		    myReader.close();
		      
		} catch(FileNotFoundException e){
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
}