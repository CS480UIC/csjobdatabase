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



/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class ResultsDao {
	
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ResultsDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
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
    
    public boolean insertResults(Results result) throws SQLException {
        String sql = "INSERT INTO result (interviewCall) VALUES (?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, result.getInterviewCall());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public List<Results> listAllResults() throws SQLException {
        List<Results> listresults = new ArrayList<>();
         
        String sql = "SELECT * FROM result";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String interviewCall = resultSet.getString("Interview_Call");
             
            Results result = new Results(id, interviewCall);
            listresults.add(result);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listresults;
    }
    
    public boolean deleteResults(Results result) throws SQLException {
        String sql = "DELETE FROM result where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, result.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateResults(Results result) throws SQLException {
        String sql = "UPDATE result SET interviewCall = ?";
        sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, result.getInterviewCall());
        statement.setInt(4, result.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    public Results getResult(int id) throws SQLException {
        Results result = null;
        String sql = "SELECT * FROM result WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String interviewCall = resultSet.getString("interview_call");
             
            result = new Results(id, interviewCall);
        }
         
        resultSet.close();
        statement.close();
         
        return result;
    }
		
}
