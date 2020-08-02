package user.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.domain.Results;
import user.domain.User;
import user.domain.companies;
import user.service.ResultsService;
import user.service.UserService;
import user.service.companiesService;

/**
 * Servlet implementation class findAll
 */

public class updateResults extends HttpServlet {
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
		ResultsService resultservice = new ResultsService();
		try {
			int results_id = Integer.parseInt(request.getParameter("results_id"));
			int application_id = Integer.parseInt(request.getParameter("application_id"));
			String application_link = request.getParameter("application_link");
			String interview_progress = request.getParameter("interview_progress");
			
			Results hosp = new Results(results_id, application_id, application_link, interview_progress);
			
			resultservice.updateResults(hosp);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Object> li = resultservice.listAllResults();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/Requests/Requests_item.jsp").forward(request, response);
	}

}
