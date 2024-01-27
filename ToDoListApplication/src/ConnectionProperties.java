
/*
 * CLASS FOR HOLDING THE CONNECTION LOGIN DATA
 * */
public class ConnectionProperties {
	
	final private String serverPassword = "";
	final private String serverUsername = "root";
	final private String connectionURL = "jdbc:mysql://127.0.0.1/toDoList";
	
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
