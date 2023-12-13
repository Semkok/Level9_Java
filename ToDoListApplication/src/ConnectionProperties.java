public class ConnectionProperties {
	final private String serverPassword = "";
	final private String serverUsername = "root";
	final private String connectionURL = "jdbc:mysql://127.0.0.1:3306/toDoList";
	
	public String getServerPassword() {
		return this.serverPassword;
	}
	public String getServerUsername(){
		return this.serverUsername;
	}
	public String getConnectionURL() {
		return this.connectionURL;
	}
	
}
