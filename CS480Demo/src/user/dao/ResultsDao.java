package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.domain.Results;
import user.domain.User;
import user.domain.companies;

public class ResultsDao {
	
    public static void insertResults(Results result) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");
								
			String sql = "insert into results values(?,?,?,?)";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, result.getResultsId());
	        statement.setInt(2, result.getApplicationId());
	        statement.setString(3, result.getApplicationLink());
	        statement.setString(4, result.getInterviewProgress());
		    statement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
    
    public static List<Object> listAllCompanies() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			System.out.print("here");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");
			
			String sql = "select * from results";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			System.out.print("here2");
			while(resultSet.next()){
				Results comp = new Results();
				comp.setResultsId(resultSet.getInt("results_id"));
				comp.setApplicationId(resultSet.getInt("application_id"));
	    		comp.setApplicationLink(resultSet.getString("application_link"));
	    		comp.setInterviewProgress(resultSet.getString("interview_progress"));
	    		list.add(comp);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;	
	}
    
    
    public static boolean deleteResults(Results result) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");
								
			String sql = "DELETE FROM results where results_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,result.getResultsId());
		    boolean deleteComp = preparestatement.executeUpdate() > 0;
		    return deleteComp;
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
    
    public static boolean updateResults(Results result) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");
								
			String sql = "UPDATE results SET results_id = ?, application_id = ?, application_link = ?, interview_progress= ? WHERE results_id = ?";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, result.getResultsId());
			statement.setInt(2, result.getApplicationId());
	        statement.setString(3, result.getApplicationLink());
	        statement.setString(4, result.getInterviewProgress());
	        statement.setInt(5, result.getResultsId());
		    boolean updated = statement.executeUpdate() > 0; 
		    return updated;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
    }

    
    public static Results getResultsByID(int results_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
    	Results comp = new Results();
    	try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");

		    String sql = "SELECT * FROM results WHERE results_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,results_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	int cid = resultSet.getInt("results_id");
		    	if(cid == results_id){
		    		comp.setResultsId(resultSet.getInt("results_id"));
		    		comp.setApplicationId(resultSet.getInt("application_id"));
		    		comp.setApplicationLink(resultSet.getString("application_link"));
		    		comp.setInterviewProgress(resultSet.getString("interview_progress"));  		
		    	}
		    }
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
    	return comp;
    }
		
}
