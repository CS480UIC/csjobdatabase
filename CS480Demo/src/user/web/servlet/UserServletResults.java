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
import user.domain.Results;
import user.domain.User;
import user.domain.companies;
import user.service.ResultsService;
import user.service.UserException;
import user.service.UserService;
import user.service.companiesService;

/**
 * Servlet implementation class UserServlet
 */

public class UserServletResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public UserServletResults() {
		super();
	}
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	ResultsService resultservice = new ResultsService();  
		Results form = new Results();	

		String application_link = request.getParameter("application_link");
        int results_id = Integer.parseInt(request.getParameter("results_id"));
        int application_id = Integer.parseInt(request.getParameter("application_id"));
        String interview_progress = request.getParameter("interview_progress");
        
		form.setApplicationId(application_id);
		form.setResultsId(results_id);
		form.setApplicationLink(application_link);
		form.setInterviewProgress(interview_progress);
		
		try {
			resultservice.registResults(form);
			request.getRequestDispatcher("/jsps/Results/Results_item.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
        

}
