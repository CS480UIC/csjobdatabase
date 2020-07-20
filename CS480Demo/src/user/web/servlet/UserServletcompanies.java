package user.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.dao.companiesDao;
import user.domain.User;
import user.domain.companies;
import user.service.UserException;
import user.service.UserService;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet("/")
public class UserServletcompanies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private companiesDao companyDAO;
	 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        companyDAO = new companiesDao(jdbcURL, jdbcUsername, jdbcPassword);
 
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
            case "/new":
                showNewForm(request, response);
                break;
            case "/jsps/user/insert":
                insertCompany(request, response);
                break;
            case "/delete":
                deleteCompany(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateCompany(request, response);
                break;
            default:
                listCompanies(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listCompanies(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<companies> listBook = companyDAO.listAllcompanies();
        request.setAttribute("listCompany", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("companiesList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("companies.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        companies existingBook = companyDAO.getCompany(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("companies.jsp");
        request.setAttribute("company", existingBook);
        dispatcher.forward(request, response);
 
    }
 
    private void insertCompany(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String jobtype = request.getParameter("jobtype");
 
        companies newCompany = new companies(name, category, jobtype);
        companyDAO.insertCompanies(newCompany);
        response.sendRedirect("list");
    }
 
    private void updateCompany(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String jobtype = request.getParameter("jobtype");
 
        companies company = new companies(id, name, category, jobtype);
        companyDAO.updateCompanies(company);
        response.sendRedirect("list");
    }
 
    private void deleteCompany(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        companies company = new companies(id);
        companyDAO.deleteCompanies(company);
        response.sendRedirect("list");
 
    }

}
