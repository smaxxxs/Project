package admission.domain;

public class Request {
	private Integer id;
	private Integer faculty_id;
	private Applicant applicant;
	private Status status;
	
	public Request() {
		
	}

	public Request(Integer faculty_id, Applicant applicant, Status status) {
		
		this.faculty_id = faculty_id;
		this.applicant = applicant;
		this.status = status;
	}

	
	public Request(Integer id, Integer faculty_id, Applicant applicant, Status status) {
		this.id = id;
		this.faculty_id = faculty_id;
		this.applicant = applicant;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(Integer faculty_id) {
		this.faculty_id = faculty_id;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Request [faculty_id=" + faculty_id + ", applicant=" + applicant + ", status=" + status + "]";
	}

	
}
