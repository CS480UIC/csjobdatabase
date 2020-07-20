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



/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class ApplicationsDao {
	
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ApplicationsDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?", "root", "Tanmay@01");
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    
    public boolean insertApplications(Applications application) throws SQLException {
        String sql = "INSERT INTO application (location, position, jobdescription, estimatedSalary) VALUES (?, ?, ?,?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, application.getLocation());
        statement.setString(2, application.getPosition());
        statement.setString(3, application.getJobDescription());
        statement.setFloat(4, application.getEstimatedSalary());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public List<Applications> listAllApplications() throws SQLException {
        List<Applications> listapplication = new ArrayList<>();
         
        String sql = "SELECT * FROM application";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("application_id");
            String location = resultSet.getString("location");
            String position = resultSet.getString("position");
            String jobdescription = resultSet.getString("job_description");
            float estimatedSalary = resultSet.getFloat("estimated_salary");
             
            Applications application = new Applications(id, location, position, jobdescription, estimatedSalary);
            listapplication.add(application);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listapplication;
    }
    
    public boolean deleteApplications(Applications application) throws SQLException {
        String sql = "DELETE FROM application where application_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, application.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateApplications(Applications application) throws SQLException {
        String sql = "UPDATE company SET location = ?, position = ?, jobdescription = ?, esitmatedSalary = ?";
        sql += " WHERE company_id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, application.getLocation());
        statement.setString(2, application.getPosition());
        statement.setString(3, application.getJobDescription());
        statement.setFloat(4, application.getEstimatedSalary());
        statement.setInt(5, application.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    public Applications getApplications(int id) throws SQLException {
        Applications application = null;
        String sql = "SELECT * FROM application WHERE application_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String location = resultSet.getString("location");
            String position = resultSet.getString("position");
            String jobdescription = resultSet.getString("jobdescription");
            float estimatedSalary = resultSet.getFloat("esitmated_salary");
             
            application = new Applications(id, location, position, jobdescription, estimatedSalary);
        }
         
        resultSet.close();
        statement.close();
         
        return application;
    }
		
}
