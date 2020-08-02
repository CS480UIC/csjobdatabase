package user.service;

import java.util.List;

import user.dao.ResultsDao;
import user.dao.UserDao;
import user.domain.Results;
import user.domain.User;
import user.domain.companies;
import user.dao.companiesDao;

public class ResultsService {
	private ResultsDao resultDao = new ResultsDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void registResults(Results form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		Results comp = ResultsDao.getResultsByID(form.getResultsId());
		int compID = comp.getResultsId();
		int formID = form.getResultsId();
		
		if(compID == formID)
			throw new UserException("This Results ID has already been in your Database!");
		
		ResultsDao.insertResults(form);
	}
	
 
	public List<Object> listAllResults() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return ResultsDao.listAllResults();
	}
	
	public boolean deleteResults(Results comp) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean delete = ResultsDao.deleteResults(comp);
		return delete;
	}
	
	public boolean updateResults(Results comp) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean update = ResultsDao.updateResults(comp);
		return update;
	}
	public Results getResultByID(int result_id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Results finding = ResultsDao.getResultsByID(result_id);
		return finding;
	}
}
