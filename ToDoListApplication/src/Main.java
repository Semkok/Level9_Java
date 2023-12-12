public class Main {
	
	public static void main(String[] args) {
		final String connectionURL = "jdbc:mysql://127.0.0.1:3306/toDoList?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		final String serverUsername = "root";
		final String serverPassword = "";
		
		ServerConnection serverConnection = new ServerConnection(connectionURL,serverUsername, serverPassword);
		
	}

}
