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



/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class companiesDao {
	
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public companiesDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    
    public boolean insertCompanies(companies company) throws SQLException {
        String sql = "INSERT INTO company (name, category, jobtype) VALUES (?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, company.getName());
        statement.setString(2, company.getCategory());
        statement.setString(3, company.getJobtype());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public List<companies> listAllcompanies() throws SQLException {
        List<companies> listcompany = new ArrayList<>();
         
        String sql = "SELECT * FROM company";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("company_id");
            String name = resultSet.getString("company_name");
            String category = resultSet.getString("category");
            String jobtype = resultSet.getString("job_type");
             
            companies company = new companies(id, name, category, jobtype);
            listcompany.add(company);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listcompany;
    }
    
    public boolean deleteCompanies(companies company) throws SQLException {
        String sql = "DELETE FROM company where company_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, company.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateCompanies(companies company) throws SQLException {
        String sql = "UPDATE company SET title = ?, author = ?, price = ?";
        sql += " WHERE company_id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, company.getName());
        statement.setString(2, company.getCategory());
        statement.setString(3, company.getJobtype());
        statement.setInt(4, company.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    public companies getCompany(int id) throws SQLException {
        companies company = null;
        String sql = "SELECT * FROM company WHERE company_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String name = resultSet.getString("company_name");
            String category = resultSet.getString("category");
            String jobtype = resultSet.getString("jobtype");
             
            company = new companies(id, name, category, jobtype);
        }
         
        resultSet.close();
        statement.close();
         
        return company;
    }
		
}
