import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Questions {
	final ArrayList<String> questionsList = new ArrayList<String>();
	final ArrayList<String> answerList = new ArrayList<String>();
	final ArrayList<String> fillerAnswerList = new ArrayList<String>();
	
	Questions(){
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
		    	  questionsList.add(question.trim());
		      }
		      else if(data.startsWith("answer:")) {
		    	  String answer = data.replace("answer:","");   	  
		    	  answerList.add(answer.trim());
		      }
		      else if(data.startsWith("-")) {
		    	  String fillerAnswer = data;
		    	  fillerAnswerList.add(fillerAnswer.trim());
		      }
		    }
		    myReader.close();
		      
		} catch(FileNotFoundException e){
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
}
