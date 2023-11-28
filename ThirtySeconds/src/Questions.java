import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Questions {
	ArrayList<String> questionsList = new ArrayList<String>();
	ArrayList<String> answerList = new ArrayList<String>();
	
	
	Questions(){
		getQuestionsFile();
	}
	
	
	private void getQuestionsFile() {
		try {
			File myObj = new File("QuestionsAndAnswers.txt");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		      String data = myReader.nextLine();
		      System.out.println(data);
		    }
		    
		    myReader.close();
		      
		} catch(FileNotFoundException e){
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	private void getAnswersFile() {
		
	}
	
}
