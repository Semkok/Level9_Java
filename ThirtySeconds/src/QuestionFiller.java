/*
 * The Question class is a class that fills the question,answer and fillerAnswer lists
 * with the contents of a text file with the values in it 
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionFiller {
	
	// list for keeping track of the amount of values in the text file
	final ArrayList<Question> questionsList = new ArrayList<Question>();
	final ArrayList<Answer> answerList = new ArrayList<Answer>();
	final ArrayList<FillerAnswer> fillerAnswerList = new ArrayList<FillerAnswer>();
	
	// the provided path for the questionFile
	private final String questionFilePath;
	
	
	QuestionFiller(String questionFilePath){
		// files all the ArrayLists with questions,answers and fillerAnswers 
		this.questionFilePath = questionFilePath;
		fillQuestionsAndAnswers();
	}
	
	private void fillQuestionsAndAnswers() {
		// this method gets all the questions and answers and fillerAnswers from the text file
		
		try {
			File myObj = new File(questionFilePath);
		    Scanner myReader = new Scanner(myObj);
		    
		    
		    while (myReader.hasNextLine()) {
		      String data = myReader.nextLine();
		      
		      // if its a question make a new question object and add it to the questionList ArrayList 
		      if(data.startsWith("question:")) {
		    	  // strip the question: word from the string so the question text is leftover 
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
		    // if the scanner is done with reading it will stop the myReader object
		    myReader.close();
		      
		} catch(FileNotFoundException e){
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public ArrayList getQuestionsList() {
		return questionsList;
	}
	
	public ArrayList getAnswerList() {
		return answerList;
	}
	
	public ArrayList getFilleranswerList() {
		return fillerAnswerList;
	}
	
}