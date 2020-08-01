package user.domain;

/**
 * companies.java
 * This class represents a companies entity
 * 
 */
public class companies {
	/*
	 * Correspond to the user table
	 */
	protected int company_id;
	protected String company_name;
	protected String company_category;
	protected String company_jobtype;
	
	
	public companies() {
    }
 
    public companies(int company_id) {
        this.company_id = company_id;
    }

    public companies(int company_id, String company_name, String company_category, String company_jobtype) {
        this.company_id = company_id;
    	this.company_name = company_name;
        this.company_category = company_category;
        this.company_jobtype = company_jobtype;
    }
 
    public int getId() {
        return company_id;
    }
 
    public void setId(int company_id) {
        this.company_id = company_id;
    }
 
    public String getName() {
        return company_name;
    }
 
    public void setName(String name) {
        this.company_name = name;
    }
 
    public String getCategory() {
        return company_category;
    }
 
    public void setCategory(String category) {
        this.company_category = category;
    }
 
    public String getJobtype() {
        return company_jobtype;
    }
 
    public void setJobtype(String jobtype) {
        this.company_jobtype = jobtype;
    }
}
