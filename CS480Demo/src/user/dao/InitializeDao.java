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
		    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    
			//Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            statement.executeUpdate("DROP TABLE IF EXISTS companies");
			
			String sqlstmt2 = "CREATE TABLE IF NOT EXISTS companies " + 
							"(company_id INTEGER not NULL AUTO_INCREMENT, " +
							"company_name VARCHAR(50), " +
							"company_category VARCHAR(50), "+
							"company_jobtype VARCHAR(50), " +
							"PRIMARY KEY ( company_id ))";
			statement.executeUpdate(sqlstmt2);
			
			PreparedStatement preparedStatement = connect
			        .prepareStatement("insert into  companies(company_id, company_name, company_category, company_jobtype) values(?,?,?,?)");
				preparedStatement.setString(1, "1");
				preparedStatement.setString(2, "Google");
				preparedStatement.setString(3, "FAANG");
				preparedStatement.setString(4, "Full-Time");
				preparedStatement.executeUpdate(); // Add some data
			
			preparedStatement = connect
			    .prepareStatement("insert into  companies(company_id, company_name, company_category, company_jobtype) values(?,?,?,?)");
				preparedStatement.setString(1, "2");
				preparedStatement.setString(2, "Facebook");
				preparedStatement.setString(3, "FAANG");
				preparedStatement.setString(4, "Internship");
				preparedStatement.executeUpdate(); // Add some data
			    
			preparedStatement = connect
			    .prepareStatement("insert into  companies(company_id, company_name, company_category, company_jobtype) values(?,?,?,?)");
				preparedStatement.setString(1, "3");
				preparedStatement.setString(2, "Cadence");
				preparedStatement.setString(3, "Fortune-500");
				preparedStatement.setString(4, "Traineeship");
				preparedStatement.executeUpdate(); // Add some data
                
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			

			statement.executeUpdate("DROP TABLE IF EXISTS applications");
			
			String sqlstmt = "CREATE TABLE IF NOT EXISTS applications " + 
							"(id INTEGER not NULL AUTO_INCREMENT, " + //Added integer id
							"location VARCHAR(50), " +                //Added varchar location
							"position VARCHAR(100), " +           //Added varchar position
							"jobDescription VARCHAR (500), " +        //Added varchar job description
							"estimatedSalary INTEGER," +                //Added money for estimatedSalary
							"company_id INTEGER, " +                    //Added company_id as a foreign key
							"FOREIGN KEY ( company_id ) REFERENCES companies( company_id ) " +
							"ON DELETE SET NULL " +
							"ON UPDATE CASCADE, " +
							"PRIMARY KEY ( id ))";
			statement.executeUpdate(sqlstmt);
			
			//PreparedStatement 
			preparedStatement = connect
                    .prepareStatement("insert into  applications(id, location, position, jobDescription, estimatedSalary, company_id) values(?,?,?,?,?,?)");
					preparedStatement.setString(1, "1");
					preparedStatement.setString(2, "Chicago");
					preparedStatement.setString(3, "Entry Level Engineer");
					preparedStatement.setString(4, "python developer");
					preparedStatement.setString(5, "100");
					preparedStatement.setString(6, "1");
					preparedStatement.executeUpdate(); // Add some data
				
				preparedStatement = connect
				    .prepareStatement("insert into  applications(id, location, position, jobDescription, estimatedSalary, company_id) values(?,?,?,?,?,?)");
					preparedStatement.setString(1, "2");
					preparedStatement.setString(2, "San Francisco");
					preparedStatement.setString(3, "medium Level Engineer");
					preparedStatement.setString(4, "java developer");
					preparedStatement.setString(5, "200");
					preparedStatement.setString(6, "2");
					preparedStatement.executeUpdate(); // Add some data
				    
				preparedStatement = connect
				    .prepareStatement("insert into  applications(id, location, position, jobDescription, estimatedSalary, company_id) values(?,?,?,?,?,?)");
					preparedStatement.setString(1, "3");
					preparedStatement.setString(2, "New York");
					preparedStatement.setString(3, "Senior Level Engineer");
					preparedStatement.setString(4, "c++ developer");
					preparedStatement.setString(5, "300");
					preparedStatement.setString(6, "3");
					preparedStatement.executeUpdate(); // Add some data
                
                
    			
    			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                statement.executeUpdate("DROP TABLE IF EXISTS results");
                String sqlstmt1 = "CREATE TABLE IF NOT EXISTS results " + 
    							"(results_id INTEGER not NULL AUTO_INCREMENT, " +
    							"application_link VARCHAR(100), " +
    							"interview_progress VARCHAR(50), " +
    							"application_id INTEGER, " +
    							"FOREIGN KEY ( application_id ) REFERENCES applications( id ) " +
    							"ON DELETE SET NULL " +
    							"ON UPDATE CASCADE, " +
    							"PRIMARY KEY ( results_id ))";
    			statement.executeUpdate(sqlstmt1);
    			
				preparedStatement = connect
				        .prepareStatement("insert into  results(results_id, application_link, interview_progress, application_id) values(?,?,?,?)");
					preparedStatement.setString(1, "1");
					preparedStatement.setString(2, "link1");
					preparedStatement.setString(3, "coding interview rouond 1");
					preparedStatement.setString(4, "1");
					preparedStatement.executeUpdate(); // Add some data
				
				preparedStatement = connect
				    .prepareStatement("insert into  results(results_id, application_link, interview_progress, application_id) values(?,?,?,?)");
					preparedStatement.setString(1, "2");
					preparedStatement.setString(2, "link2");
					preparedStatement.setString(3, "phone interview rouond 1");
					preparedStatement.setString(4, "2");
					preparedStatement.executeUpdate(); // Add some data
				    
				preparedStatement = connect
				    .prepareStatement("insert into  results(results_id, application_link, interview_progress, application_id) values(?,?,?,?)");
					preparedStatement.setString(1, "3");
					preparedStatement.setString(2, "link3");
					preparedStatement.setString(3, "rejected");
					preparedStatement.setString(4, "3");
					preparedStatement.executeUpdate(); // Add some data
                

                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            statement.executeUpdate("DROP TABLE IF EXISTS tb_user"); //PART2
            String sqlstmt4 = "CREATE TABLE IF NOT EXISTS tb_user" +
                            " ( username VARCHAR(50) primary key," +
                            " password VARCHAR(50) NOT NULL, " +
                            " email VARCHAR(50) NOT NULL)";
            statement.executeUpdate(sqlstmt4);
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                
                
			
			
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
