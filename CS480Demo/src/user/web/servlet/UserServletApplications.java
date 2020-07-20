package user.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.ApplicationsDao;
import user.domain.Applications;


/**
 * Servlet implementation class UserServlet
 */
public class UserServletApplications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ApplicationsDao applicationDAO;
	 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        applicationDAO = new ApplicationsDao(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/UserServletApplications/new":
                showNewForm(request, response);
                break;
            case "/UserServletApplications/insert":
                insertApplications(request, response);
                break;
            case "/UserServletApplications/delete":
                deleteApplications(request, response);
                break;
            case "/UserServletApplications/edit":
                showEditForm(request, response);
                break;
            case "/UserServletApplications/update":
                updateApplications(request, response);
                break;
            default:
                listApplications(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listApplications(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Applications> listApplications = applicationDAO.listAllApplications();
        request.setAttribute("listApplications", listApplications);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ApplicationsList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Applications.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Applications existingBook = applicationDAO.getApplications(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Applications.jsp");
        request.setAttribute("Application", existingBook);
        dispatcher.forward(request, response);
 
    }
 
    private void insertApplications(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String location = request.getParameter("location");
        String position = request.getParameter("position");
        String jobdescription = request.getParameter("jobdescription");
        float estimatedSalary = Float.parseFloat(request.getParameter("estimatedSalary"));
 
        Applications newApplication = new Applications(location, position, jobdescription, estimatedSalary);
        applicationDAO.insertApplications(newApplication);
        response.sendRedirect("list");
    }
 
    private void updateApplications(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	String location = request.getParameter("location");
        String position = request.getParameter("position");
        String jobdescription = request.getParameter("jobdescription");
        float estimatedSalary = Float.parseFloat(request.getParameter("estimatedSalary"));
 
        Applications newApplication = new Applications(location, position, jobdescription, estimatedSalary);
        applicationDAO.updateApplications(newApplication);
        response.sendRedirect("list");
    }
 
    private void deleteApplications(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Applications application = new Applications(id);
        applicationDAO.deleteApplications(application);
        response.sendRedirect("list");
 
    }

}
