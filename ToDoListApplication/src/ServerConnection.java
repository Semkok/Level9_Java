import java.sql.*;
/*
 * CLASS FOR MAKING A CONNECTION WITH THE SERVER AND RECEIVING THE VALUES
 * */
public class ServerConnection {
	
	Connection connection;
	Statement statement;
	ToDoListBuilder toDoListBuilder;
	
	ServerConnection(){
		
			ConnectionProperties connectionProperties = new ConnectionProperties();
			
			this.toDoListBuilder = new ToDoListBuilder();
			try {
				this.connection = DriverManager.getConnection(connectionProperties.getConnectionURL(), connectionProperties.getServerUsername(), connectionProperties.getServerPassword());
				this.statement = connection.createStatement();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public void getValuesFromTable() throws SQLException {
		String query = "SELECT * FROM ToDoList_Items";
		ResultSet resultSet = statement.executeQuery(query);
		int row = 0;
		
		while(resultSet.next()) {
			toDoListBuilder.getToDoList().addToDoItem(new ToDoItem(resultSet.getString("name"),resultSet.getBoolean("status"),resultSet.getInt("id")));
			row++;
		}
		
		toDoListBuilder.storeToDoListLocally();
		
	}
	public void stopConnection() throws SQLException {
		connection.close(); //IMPORTANT!!!
	}
	

	
}
