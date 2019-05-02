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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "requests")
public class Request {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="request_seq_gen")
	@SequenceGenerator(name="request_seq_gen", sequenceName="REQUEST_SEQ")
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "faculty_id", nullable = false)
	private Faculty faculty;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "applicant_id", nullable = false)
	private Applicant applicant;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public Request() {

	}

	public Request(Faculty faculty, Applicant applicant, Status status) {

		this.faculty = faculty;
		this.applicant = applicant;
		this.status = status;
	}

	public Request(Integer id, Faculty faculty, Applicant applicant, Status status) {
		this.id = id;
		this.faculty = faculty;
		this.applicant = applicant;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
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
		return "Request [faculty_id=" + faculty + ", applicant=" + applicant + ", status=" + status + "]";
	}

}
