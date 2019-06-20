package admission.domain;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "faculties")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "faculty_seq_gen")
	@SequenceGenerator(name = "faculty_seq_gen", sequenceName = "FACULTY_SEQ")
	private Integer id;
	private String name;
//needed subjects to enter this faculty
	@ElementCollection
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicants == null) ? 0 : applicants.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((places == null) ? 0 : places.hashCode());
		result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		if (applicants == null) {
			if (other.applicants != null)
				return false;
		} else if (!applicants.equals(other.applicants))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (places == null) {
			if (other.places != null)
				return false;
		} else if (!places.equals(other.places))
			return false;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", subjects=" + subjects + ", places=" + places
				+ ", applicants=" + applicants + ", grade=" + grade + "]";
	}

}
