package user.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.domain.User;
import user.domain.companies;
import user.service.UserService;
import user.service.companiesService;

/**
 * Servlet implementation class findAll
 */

public class updatecompanies extends HttpServlet {
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
		companiesService companyservice = new companiesService();
		try {
			int id = Integer.parseInt(request.getParameter("company_id"));
			String name = request.getParameter("company_name");
			String category = request.getParameter("company_category");
			String jobtype = request.getParameter("company_jobtype");
			
			companies hosp = new companies(id, name, category, jobtype);
			
			companyservice.updateCompanies(hosp);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Object> li = companyservice.listAllCompanies();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/companies/companies_item.jsp").forward(request, response);
	}

}
