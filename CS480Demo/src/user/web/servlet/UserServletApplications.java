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
import user.domain.companies;
import user.service.ApplicationsService;
import user.service.UserException;
import user.service.companiesService;


/**
 * Servlet implementation class UserServlet
 */
public class UserServletApplications extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public UserServletApplications() {
		super();
	}
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	ApplicationsService companyservice = new ApplicationsService();  
		Applications form = new Applications();	

		String location = request.getParameter("location");
        int id = Integer.parseInt(request.getParameter("id"));
        String position = request.getParameter("position");
        String jobDescription = request.getParameter("jobDescription");
        Float estimatedSalary = Float.parseFloat(request.getParameter("estimatedSalary"));
        int company_id = Integer.parseInt(request.getParameter("comany_name"));
        
		form.setLocation(location);
		form.setId(id);
		form.setJobDescription(jobDescription);
		form.setPosition(position);
		form.setEstimatedSalary(estimatedSalary);
		form.setCompanyId(company_id);
		
		try {
			companyservice.registApplication(form);
			request.getRequestDispatcher("/jsps/Applications/Applications_item.jsp").forward(request, response);
			
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
