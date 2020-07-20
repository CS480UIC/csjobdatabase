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

import user.dao.ApplicationsDao;
import user.dao.ResultsDao;
import user.dao.UserDao;
import user.dao.companiesDao;
import user.domain.Applications;
import user.domain.Results;
import user.domain.User;
import user.domain.companies;
import user.service.UserException;
import user.service.UserService;

/**
 * Servlet implementation class UserServlet
 */

public class UserServletResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ResultsDao resultDAO;
	 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        resultDAO = new ResultsDao(jdbcURL, jdbcUsername, jdbcPassword);
 
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
            case "/insert":
                insertResults(request, response);
                break;
            case "/delete":
                deleteResults(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateResults(request, response);
                break;
            default:
                listResults(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listResults(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Results> listResult = resultDAO.listAllResults();
        request.setAttribute("listResult", listResult);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ResultsList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Results.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Results existingBook = resultDAO.getResult(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Results.jsp");
        request.setAttribute("Result", existingBook);
        dispatcher.forward(request, response);
 
    }
 
    private void insertResults(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String interviewCall = request.getParameter("interview_call");
 
        Results newResult = new Results(interviewCall);
        resultDAO.insertResults(newResult);
        response.sendRedirect("list");
    }
 
    private void updateResults(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	String interviewCall = request.getParameter("interview_call");
    	 
        Results newResult = new Results(interviewCall);
        resultDAO.updateResults(newResult);
        response.sendRedirect("list");
    }
 
    private void deleteResults(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Results result= new Results(id);
        resultDAO.deleteResults(result);
        response.sendRedirect("list");
 
    }

}
