package user.service;

import java.util.List;

import user.dao.ApplicationsDao;
import user.dao.UserDao;
import user.domain.Applications;
import user.domain.User;
import user.domain.companies;
import user.dao.companiesDao;

public class ApplicationsService {
	private ApplicationsDao applicationDao = new ApplicationsDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void registApplication(Applications form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		Applications comp = ApplicationsDao.getApplicationByID(form.getId());
		int compID = comp.getId();
		int formID = form.getId();
		
		if(compID == formID)
			throw new UserException("This Application ID has already been in your Database!");
		
		ApplicationsDao.insertApplications(form);
	}
	
 
	public List<Object> listAllApplications() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return ApplicationsDao.listAllApplications();
	}
	
	public boolean deleteApplications(Applications comp) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean delete = ApplicationsDao.deleteApplications(comp);
		return delete;
	}
	
	public boolean updateApplications(Applications comp) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean update = ApplicationsDao.updateApplications(comp);
		return update;
	}
	public Applications getApplicationByID(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Applications finding = ApplicationsDao.getApplicationByID(id);
		return finding;
	}
}
