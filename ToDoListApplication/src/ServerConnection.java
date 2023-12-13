import java.sql.*;

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
				getValuesFromTable();
				
				
				
				stopConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}
	
	private void getValuesFromTable() throws SQLException {
		
		String query = "SELECT * FROM ToDoList_Items";
		ResultSet resultSet = statement.executeQuery(query);
		int row = 0;
		
		while(resultSet.next()) {
			toDoListBuilder.getToDoList().addToDoItem(new ToDoItem(resultSet.getString("name"),resultSet.getBoolean("status"),resultSet.getInt("id")));
			row++;
		}
		
		System.out.println(toDoListBuilder.getToDoList().getToDoItem(0).getName());
		
	}
	private void stopConnection() throws SQLException {
		connection.close(); //IMPORTANT!!!
	}
}
