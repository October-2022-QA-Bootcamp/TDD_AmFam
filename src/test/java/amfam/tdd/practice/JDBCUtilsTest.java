package amfam.tdd.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class JDBCUtilsTest {

	/*
	 * 1. register the driver using DriverManger
	 * 2. create connection object from driverManager object
	 * 3. require for connection object url, user, pass
	 * 4. statement object from connection object
	 * 5. send query using statement.createStatement obj
	 * 6. create resultSet from statement obj
	 * 7. extract your result using data structure
	 * 8. close the connection
	 */
	
	@Test
	public void jdbc_postgresql_connection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/employees_db", "postgres", "hr");
		
		Statement statement = connection.createStatement();
		statement.execute("select * from countries");
		
		ResultSet resultSet = statement.getResultSet();
		
		while(resultSet.next()) {
			System.out.println("Country Id : " + resultSet.getString(1) + ". Country Name : " 
					+ resultSet.getString(2) + ". Region Id : " + resultSet.getInt(3));
		}
		
		connection.close();
	}
}
