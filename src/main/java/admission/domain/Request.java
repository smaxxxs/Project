package admission.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requests")
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer faculty_id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "applicant_id", nullable = false)
	private Applicant applicant;
	
	@Enumerated(EnumType.STRING)
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
