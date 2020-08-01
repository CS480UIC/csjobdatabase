package user.domain;

/**
 * Results.java
 * This class represents a companies entity
 * 
 */
public class Results {
	/*
	 * Correspond to the results table
	 */
	protected int results_id;
	protected int application_id;
	protected String application_link;
	protected String interview_progress;
	
	
	public Results() {
    }
 
    public Results(int results_id) {
        this.results_id = results_id;
    }
     
    public Results(int results_id, int application_id, String application_link, String interview_progress) {
    	this.results_id = results_id;
    	this.application_id = application_id;
    	this.application_link = application_link;
    	this.interview_progress = interview_progress;
    }
 
    public int getResultsId() {
        return results_id;
    }
 
    public void setResultsId(int results_id) {
        this.results_id = results_id;
    }
 
    public int getApplicationId() {
        return application_id;
    }
 
    public void setApplicationId(int application_id) {
        this.application_id = application_id;
    }
    
    public String getApplicationLink() {
    	return application_link;
    }
    
    public void setApplicationLink(String application_link) {
    	this.application_link = application_link;
    }
    
    public String getInterviewProgress() {
    	return interview_progress;
    }
    
    public void setInterviewProgress(String interview_progress) {
    	this.interview_progress = interview_progress;
    }

}
