package admission.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "faculties")
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="faculty_seq_gen")
	@SequenceGenerator(name="faculty_seq_gen", sequenceName="FACULTY_SEQ")
	private Integer id;
	private String name;
//needed subjects to enter this faculty
	@OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "subjectId")
	private List<Subject> subjects;
//allowed number of places
	private Integer places;
	@ElementCollection
	private List<Applicant> applicants;
//passing grade on this faculty.Automatically counted.
	private Double grade;

	public Faculty() {

	}

	public Faculty(Integer id, String name, List<Subject> subjects, Integer places, List<Applicant> applicants,
			Double grade) {
		this.id = id;
		this.name = name;
		this.subjects = subjects;
		this.places = places;
		this.applicants = applicants;
		this.grade = grade;
	}

	public Faculty(String name, List<Subject> subjects, Integer places) {
		this.name = name;
		this.subjects = subjects;
		this.places = places;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Integer getPlaces() {
		return places;
	}

	public void setPlaces(Integer places) {
		this.places = places;
	}

	public List<Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<Applicant> applicants) {
		this.applicants = applicants;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", subjects=" + subjects + ", places=" + places
				+ ", applicants=" + applicants + ", grade=" + grade + "]";
	}

}
