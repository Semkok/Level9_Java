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
		connection.close();
		toDoListBuilder.storeToDoListLocally();
	}
	
	public void AddNewItems() throws SQLException {
		String removeQuery = "DELETE FROM ToDoList_Items";
		statement.executeUpdate(removeQuery);
		
		ToDoList toDoList = new ToDoList();
		
		new LocalToDoItemHandler().getToDoItems(toDoList);
		
		for(ToDoItem toDoItem : toDoList) {
			String inputNewToDoItem = String.format("INSERT INTO ToDoList_Items VALUES (%d,'%s',%b)",toDoItem.getId(),toDoItem.getName(),toDoItem.getStatus());
			statement.executeUpdate(inputNewToDoItem);
		}
		
		
		
		connection.close();
	}
	
	

	
}
