package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import user.domain.User;
import java.sql.Statement;




public class InitializeDao {
	
	
	public void initDB() {
		Statement statement;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect1 = DriverManager
//			          .getConnection("\"jdbc:mysql://localhost:3306/bookstore?"
//				              + "user=root&password=Tanmay@01");
					.getConnection("jdbc:mysql://localhost:3306/bookstore?"
				              , "root", "Tanmay@01");
			statement = connect1.createStatement();
			statement.executeUpdate("DROP DATABASE IF EXISTS csJobDatabase");
		    statement.executeUpdate("CREATE DATABASE IF NOT EXISTS csJobDatabase"); //PART 1
		    
		    connect1.close();
		    Connection connect = DriverManager
//			          .getConnection("\"jdbc:mysql://localhost:3306/bookstore?"
//				              + "user=root&password=Tanmay@01");
					.getConnection("jdbc:mysql://localhost:3306/csJobDatabase?"
				              , "root", "Tanmay@01");
		    
			//Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS applications");
			
			String sqlstmt = "CREATE TABLE IF NOT EXISTS applications " + 
							"(id INTEGER not NULL AUTO_INCREMENT, " +
							"location VARCHAR(50), " +
							"PRIMARY KEY ( id ))";
			statement.executeUpdate(sqlstmt);
			
			PreparedStatement preparedStatement = connect
                    .prepareStatement("insert into  applications(id, location) values(?,?)");
                preparedStatement.setString(1, "1");
                	preparedStatement.setString(2, "Chicago");
                preparedStatement.executeUpdate(); // Add some data
                
                preparedStatement = connect
                    .prepareStatement("insert into  applications(id, location) values(?,?)");
                preparedStatement.setString(1, "2");
                	preparedStatement.setString(2, "San Francisco");
                preparedStatement.executeUpdate(); // Add some data
                    
                preparedStatement = connect
                    .prepareStatement("insert into  applications(id, location) values(?,?)");
                preparedStatement.setString(1, "3");
                	preparedStatement.setString(2, "New York");
                preparedStatement.executeUpdate(); // Add some data
                
                
    			
    			///////////////////////////////////////////////////////
                statement.executeUpdate("DROP TABLE IF EXISTS results");
                String sqlstmt1 = "CREATE TABLE IF NOT EXISTS results " + 
    							"(id INTEGER not NULL AUTO_INCREMENT, " +
    							"interviewCall VARCHAR(50), " +
    							"PRIMARY KEY ( id ))";
    			statement.executeUpdate(sqlstmt1);
    			
    			preparedStatement = connect
                        .prepareStatement("insert into  results(id, interviewCall) values(?,?)");
                    preparedStatement.setString(1, "1");
                    	preparedStatement.setString(2, "Yes");
                    preparedStatement.executeUpdate(); // Add some data
                    
                    preparedStatement = connect
                        .prepareStatement("insert into  results(id, interviewCall) values(?,?)");
                    preparedStatement.setString(1, "2");
                    	preparedStatement.setString(2, "No");
                    preparedStatement.executeUpdate(); // Add some data
                        
                    preparedStatement = connect
                        .prepareStatement("insert into  results(id, interviewCall) values(?,?)");
                    preparedStatement.setString(1, "3");
                    	preparedStatement.setString(2, "Yes");
                    preparedStatement.executeUpdate(); // Add some data
                
                    
                ////////////////////////////////////////////////////////
                    statement.executeUpdate("DROP TABLE IF EXISTS companies");
        			
        			String sqlstmt2 = "CREATE TABLE IF NOT EXISTS companies " + 
        							"(id INTEGER not NULL AUTO_INCREMENT, " +
        							"name VARCHAR(50), " +
        							"PRIMARY KEY ( id ))";
        			statement.executeUpdate(sqlstmt2);
        			
        			preparedStatement = connect
                            .prepareStatement("insert into  companies(id, name) values(?,?)");
                        preparedStatement.setString(1, "1");
                        	preparedStatement.setString(2, "Google");
                        preparedStatement.executeUpdate(); // Add some data
                        
                        preparedStatement = connect
                            .prepareStatement("insert into  companies(id, name) values(?,?)");
                        preparedStatement.setString(1, "2");
                        	preparedStatement.setString(2, "Facebook");
                        preparedStatement.executeUpdate(); // Add some data
                            
                        preparedStatement = connect
                            .prepareStatement("insert into  companies(id, name) values(?,?)");
                        preparedStatement.setString(1, "3");
                        	preparedStatement.setString(2, "Cadence");
                        preparedStatement.executeUpdate(); // Add some data
                        
                    /////////////////////////////////////////////////////////
            statement.executeUpdate("DROP TABLE IF EXISTS tb_user"); //PART2
            String sqlstmt4 = "CREATE TABLE IF NOT EXISTS tb_user" +
                            " ( username VARCHAR(50) primary key," +
                            " password VARCHAR(50) NOT NULL, " +
                            " email VARCHAR(50) NOT NULL)";
            statement.executeUpdate(sqlstmt4);
                
                
			
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
