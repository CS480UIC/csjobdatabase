package user.domain;

/**
 * Applications.java
 * This class represents the applications entity
 * 
 */
public class Applications {
	/*
	 * Correspond to the user table
	 */
	protected int id;
	protected int company_id;
	protected String location;
	protected String position;
	protected String jobdescription;
	protected float estimatedSalary;
	
	
	public Applications() {
    }
 
    public Applications(int id) {
        this.id = id;
    }

    public Applications(int id, String location, String position, String jobdescription, float estimatedSalary, int company_id) {
        this.id = id;
        this.company_id = company_id;
    	this.location = location;
        this.position = position;
        this.jobdescription = jobdescription;
        this.estimatedSalary = estimatedSalary;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    public int getCompanyId() {
    	return company_id;
    }
    
    public void setCompanyId(int company_id) {
    	this.company_id = company_id;
    }
 
    public String getLocation() {
        return location;
    }
 
    public void setLocation(String location) {
        this.location = location;
    }
 
    public String getPosition() {
        return position;
    }
 
    public void setPosition(String position) {
        this.position = position;
    }
 
    public String getJobDescription() {
        return jobdescription;
    }
 
    public void setJobDescription(String jobdescription) {
        this.jobdescription = jobdescription;
    }
    
    public float getEstimatedSalary() {
        return estimatedSalary;
    }
 
    public void setEstimatedSalary(float estimatedSalary) {
        this.estimatedSalary = estimatedSalary;
    }
}
