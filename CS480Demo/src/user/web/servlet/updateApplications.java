package user.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.domain.Applications;
import user.domain.User;
import user.domain.companies;
import user.service.ApplicationsService;
import user.service.UserService;
import user.service.companiesService;

/**
 * Servlet implementation class findAll
 */

public class updateApplications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationsService companyservice = new ApplicationsService();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String location = request.getParameter("location");
			String position = request.getParameter("position");
			String jobDescription = request.getParameter("jobDescription");
			float estimatedSalary = Float.parseFloat(request.getParameter("estimatedSalary"));
			int company_id = Integer.parseInt(request.getParameter("compan_id"));
			
			Applications hosp = new Applications(id, location, position, jobDescription, estimatedSalary, company_id);
			
			companyservice.updateApplications(hosp);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Object> li = companyservice.listAllApplications();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/Applications/Applications_item.jsp").forward(request, response);
	}

}
