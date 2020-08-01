package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import user.domain.User;
import user.domain.companies;

public class companiesDao {
	
    public static void insertCompanies(companies company) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");
								
			String sql = "insert into companies values(?,?,?,?)";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, company.getId());
	        statement.setString(2, company.getName());
	        statement.setString(3, company.getCategory());
	        statement.setString(4, company.getJobtype());
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
			
			String sql = "select * from companies";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			System.out.print("here2");
			while(resultSet.next()){
				companies comp = new companies();
				comp.setId(resultSet.getInt("company_id"));
				comp.setName(resultSet.getString("company_name"));
	    		comp.setCategory(resultSet.getString("company_category"));
	    		comp.setJobtype(resultSet.getString("company_jobtype"));
	    		list.add(comp);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;	
	}
    
    
    public static boolean deleteCompanies(companies company) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");
								
			String sql = "DELETE FROM companies where company_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,company.getId());
		    boolean deleteComp = preparestatement.executeUpdate() > 0;
		    return deleteComp;
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
    
    public static boolean updateCompanies(companies company) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");
								
			String sql = "UPDATE companies SET company_id = ?, company_name = ?, company_category = ?, company_jobtype= ? WHERE company_id = ?";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, company.getId());
			statement.setString(2, company.getName());
	        statement.setString(3, company.getCategory());
	        statement.setString(4, company.getJobtype());
	        statement.setInt(5, company.getId());
		    boolean updated = statement.executeUpdate() > 0; 
		    return updated;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
    }

    
    public static companies getCompanyByID(int company_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
    	companies comp = new companies();
    	try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/csjobdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"Tanmay@01");

		    String sql = "SELECT * FROM companies WHERE company_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,company_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	int cid = resultSet.getInt("company_id");
		    	if(cid == company_id){
		    		comp.setId(resultSet.getInt("company_id"));
		    		comp.setName(resultSet.getString("company_name"));
		    		comp.setCategory(resultSet.getString("company_category"));
		    		comp.setJobtype(resultSet.getString("company_jobtype"));  		
		    	}
		    }
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
    	return comp;
    }
		
}
