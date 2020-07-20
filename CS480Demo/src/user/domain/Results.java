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
	protected int id;
	protected String interviewCall;
	
	
	public Results() {
    }
 
    public Results(int id) {
        this.id = id;
    }
 
    public Results(int id, String interviewCall) {
        this(interviewCall);
        this.id = id;
    }
     
    public Results(String interviewCall) {
        this.interviewCall = interviewCall;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getInterviewCall() {
        return interviewCall;
    }
 
    public void setInterviewCall(String interviewCall) {
        this.interviewCall = interviewCall;
    }

}
