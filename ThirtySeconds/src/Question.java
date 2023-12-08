/*
 * The Question class is a class for making a new question value
 * */
public class Question {
	
	private String name;

	Question(String question){
		this.name = question;
	}
	
	public String getQuestion(){
		return this.name;
	}
	
}
