import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Questions {
	ArrayList<String> questionsList = new ArrayList<String>();
	ArrayList<String> answerList = new ArrayList<String>();
	
	
	Questions(){
		getQuestionsFile();
//		getAnswersFile();
		System.out.println(questionsList.get(0));
	}
	
	
	private void getQuestionsFile() {
		try {
			File myObj = new File("QuestionsAndAnswers.txt");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		      String data = myReader.nextLine();
		      
		      
		      if(data.startsWith("question")) {
		    	  
		    	  String question = data.replace("question","");
		    	  questionsList.add(question);
		    	  System.out.println(question);
		      }
		    }
		    
		    myReader.close();
		      
		} catch(FileNotFoundException e){
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	private void getAnswersFile() {
		try {
			File myObj = new File("QuestionsAndAnswers.txt");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		      String data = myReader.nextLine();
		      
		      
		      if(data.startsWith("answer:")) {
		    	  
		    	  String answer = data.replace("answer: ","");
		    	  answerList.add(answer);
		    	  System.out.println(answer);
		      }
		    }
		    
		    myReader.close();
		      
		} catch(FileNotFoundException e){
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
}
