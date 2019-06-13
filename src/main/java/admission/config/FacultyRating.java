package admission.config;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import admission.domain.Applicant;
import admission.domain.Faculty;

@Entity
@Table(name="faculty_rating")
public class FacultyRating {

	@EmbeddedId
    FacultyRatingKey id;
 
    @ManyToOne
    @MapsId("applicant_id")
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
 
    @ManyToOne
    @MapsId("faculty_id")
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
 
    private  int rating;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicant == null) ? 0 : applicant.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + rating;
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
		FacultyRating other = (FacultyRating) obj;
		if (applicant == null) {
			if (other.applicant != null)
				return false;
		} else if (!applicant.equals(other.applicant))
			return false;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}

	public FacultyRating() {
	}

	public FacultyRatingKey getId() {
		return id;
	}

	public void setId(FacultyRatingKey id) {
		this.id = id;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "["+ applicant.getNickName() + "||" + faculty.getName()+"||" +rating
				+ "]";
	}
    
}
