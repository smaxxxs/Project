package admission.domain;

import org.springframework.web.multipart.MultipartFile;

public class ApplicantCard {
	Applicant applicant;
	MultipartFile photo;

	public ApplicantCard() {
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "ApplicantCard [applicant=" + applicant + ", photo=" + photo + "]";
	}

}
