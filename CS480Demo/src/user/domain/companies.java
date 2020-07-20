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
	protected int id;
	protected String name;
	protected String category;
	protected String jobtype;
	
	
	public companies() {
    }
 
    public companies(int id) {
        this.id = id;
    }
 
    public companies(int id, String name, String category, String jobtype) {
        this(name, category, jobtype);
        this.id = id;
    }
     
    public companies(String name, String category, String jobtype) {
        this.name = name;
        this.category = category;
        this.jobtype = jobtype;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getCategory() {
        return category;
    }
 
    public void setCategory(String category) {
        this.category = category;
    }
 
    public String getJobtype() {
        return jobtype;
    }
 
    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }
}
