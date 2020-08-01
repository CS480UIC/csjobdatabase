package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.domain.Applications;
import user.domain.User;
import user.domain.companies;


public class ApplicationsDao {
	
	public static void insertApplications(Applications application) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");
								
			String sql = "insert into Applications values(?,?,?,?,?,?)";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, application.getId());
	        statement.setString(2, application.getLocation());
	        statement.setString(3, application.getPosition());
	        statement.setString(4, application.getJobDescription());
	        statement.setFloat(5,  application.getEstimatedSalary());
	        statement.setInt(6, application.getCompanyId());
		    statement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
    
    public static List<Object> listAllApplications() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			System.out.print("here");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");
			
			String sql = "select * from Applications";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Applications comp = new Applications();
				comp.setId(resultSet.getInt("Id"));
				comp.setLocation(resultSet.getString("Location"));
	    		comp.setPosition(resultSet.getString("Position"));
	    		comp.setJobDescription(resultSet.getString("jobDescription"));
	    		comp.setEstimatedSalary(resultSet.getFloat("estimatedSalary"));
	    		comp.setCompanyId(resultSet.getInt("company_id"));
	    		list.add(comp);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;	
	}
    
    
    public static boolean deleteApplications(Applications application) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");
								
			String sql = "DELETE FROM Applications where id = ?";//////
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,application.getId());
		    boolean deleteComp = preparestatement.executeUpdate() > 0;
		    return deleteComp;
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
    
    public static boolean updateApplications(Applications application) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");
								
			String sql = "UPDATE Applications SET id = ?, location = ?, position = ?, jobDescription= ?, estimatedSalary = ? WHERE id = ?";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, application.getId());
	        statement.setString(2, application.getLocation());
	        statement.setString(3, application.getPosition());
	        statement.setString(4, application.getJobDescription());
	        statement.setFloat(5,  application.getEstimatedSalary());
	        statement.setInt(6, application.getCompanyId());
	        statement.setInt(7, application.getId());
		    boolean updated = statement.executeUpdate() > 0; 
		    return updated;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
    }

    
    public static Applications getApplicationByID(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
    	Applications comp = new Applications();
    	try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");

		    String sql = "SELECT * FROM Applications WHERE id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	int cid = resultSet.getInt("id");
		    	if(cid == id){
		    		comp.setId(resultSet.getInt("Id"));
		    		comp.setLocation(resultSet.getString("Location"));
		    		comp.setPosition(resultSet.getString("Position"));
		    		comp.setJobDescription(resultSet.getString("jobDescription"));
		    		comp.setEstimatedSalary(resultSet.getFloat("estimatedSalary"));
		    		comp.setCompanyId(resultSet.getInt("company_id"));
		    	}
		    }
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
    	return comp;
    }
		
}
