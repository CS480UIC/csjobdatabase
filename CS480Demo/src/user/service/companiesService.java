package user.service;

import java.util.List;
import user.dao.UserDao;
import user.domain.User;
import user.domain.companies;
import user.dao.companiesDao;

public class companiesService {
	private companiesDao companyDao = new companiesDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void registCompany(companies form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		companies comp = companiesDao.getCompanyByID(form.getId());
		int compID = comp.getId();
		int formID = form.getId();
		
		if(compID == formID)
			throw new UserException("This Company ID has already been in your Database!");
		
		companiesDao.insertCompanies(form);
	}
	
 
	public List<Object> listAllCompanies() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return companiesDao.listAllCompanies();
	}
	
	public boolean deleteCompanies(companies comp) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean delete = companiesDao.deleteCompanies(comp);
		return delete;
	}
	
	public boolean updateCompanies(companies comp) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean update = companiesDao.updateCompanies(comp);
		return update;
	}
	public companies getCompanyByID(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		companies finding = companiesDao.getCompanyByID(id);
		return finding;
	}
}
