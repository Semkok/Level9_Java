import java.sql.*;

public class ServerConnection {
	
	ServerConnection(String connectionURL, String serverUsername, String serverPassword){
		try {
			Connection connection = DriverManager.getConnection(connectionURL, serverUsername, serverPassword);
			
			
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
