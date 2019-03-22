package admission.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import admission.domain.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

}
