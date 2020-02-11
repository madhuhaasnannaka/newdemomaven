package net.guides.springboot2.crud.demo1.model;



import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import net.guides.springboot2.crud.status.*;
//import net.guides.springboot2.crud.status.Status.RemindTask;

@Entity
@Table(name = "reports")
public class DetailsFromOrm {

	
	@Id
	@Column(name ="doctorid")
    private int doctorid;
	
	public int getDoctorid() {
		return doctorid;
	}


	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}



	//new column patient ID
	@Column(name ="id")
    private String ID;

	/*
	 * public String getID() { return pid; }
	 * 
	 * 
	 * public void setID(String iD) { = iD; }
	 */



	//new column
	@Column(name ="eqp_id")
    private int eqp_id;
	
	


	/*
	 * public String getID() { return ID; }
	 * 
	 * 
	 * public void setID(String iD) { this.ID = iD; }
	 */



	//change to firstName to Dname
	@Column(name = "firstName")
    private String firstName;
	
	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}



	@Column(name = "lastName")
    private String lastName;
	
	
	//new report description
	@Column(name = "report_desc")
    private String report_desc;
	
	
	//email address removed
	/*
	 * @Column(name = "emailaddress") private String emailId;
	 */
	
	@Column(name = "status")
    private String status;
    
	
	public DetailsFromOrm() {
		
	}
  //@Column(name = "approverid")
  //  private String approverId;
    
 
   // public Report(int id2, int p_Id2, int eqp_Id2, String firstName2, String lastName2, String report_desc2, String string) {
  
    //}
 
    
    //@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    
   
  //  public Report(int id2, int p_Id2, int eqp_Id2, String firstName2, String lastName2, String report_desc2,
			//String getstatus) {
		// TODO Auto-generated constructor stub
	//}

	/*
	 * public int getId() { return id; } public void setId(int id) { this.id = id;
	 * 
	 * }
	 */
    

	/*
	 * public String getPID() { return PID; } public void setID(String PID) {
	 * this.PID = PID;
	 * 
	 * }
	 */
 
    
    public int getEqp_Id() {
        return eqp_id;
    }
    public void setEqp_Id(int eqp_id) {
        this.eqp_id = eqp_id;
        
    }
 
    
    
    
   //report description 
    public String getReport_desc() {
		return report_desc;
	}

	public void setReport_desc(String report_desc) {
		this.report_desc = report_desc;
	}

	
	
	public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    

    
    
   
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
   
	/*
	 * public String getEmailId() { return emailId; } public void setEmailId(String
	 * emailId) { this.emailId = emailId; }
	 */
   
    
 
    public String getstatus() {
    	 
		return status;
	}

	public void setstatus(String status) {
		
		
		this.status = status;
	}


	@Override
	public String toString() {
		return "Report [doctorid=" + doctorid + ", ID=" + ID + ", eqp_id=" + eqp_id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", report_desc=" + report_desc + ", status=" + status + "]";
	}
 
    
   
	/*
	 * public String getApproverId() { return approverId; }
	 * 
	 * public void setApproverId(String approverId) { this.approverId = approverId;
	 * }
	 */
	
}