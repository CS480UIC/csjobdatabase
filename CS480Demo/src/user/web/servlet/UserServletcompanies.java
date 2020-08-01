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
import user.service.companiesService;

/**
 * Servlet implementation class UserServlet
 */

public class UserServletcompanies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public UserServletcompanies() {
		super();
	}
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	companiesService companyservice = new companiesService();  
		companies form = new companies();	

		String name = request.getParameter("company_name");
        int id = Integer.parseInt(request.getParameter("company_id"));
        String jobtype = request.getParameter("company_jobtype");
        String category = request.getParameter("company_category");
        
		form.setName(name);
		form.setId(id);
		form.setJobtype(jobtype);
		form.setCategory(category);
		
		try {
			companyservice.registCompany(form);
			request.getRequestDispatcher("/jsps/companies/companies_item.jsp").forward(request, response);
			
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
