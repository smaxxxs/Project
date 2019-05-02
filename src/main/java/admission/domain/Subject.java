package admission.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="subject_seq_gen")
	@SequenceGenerator(name="subject_seq_gen", sequenceName="SUBJECT_SEQ")
	private Integer subjectId;
	private String name;
	@ManyToOne
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public Subject() {
	}
	public Subject(Integer subjectId, String name) {
		this.subjectId = subjectId;
		this.name = name;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", name=" + name + "]";
	}
	
	
	
	
}
