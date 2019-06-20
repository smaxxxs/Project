package admission.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import admission.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer>{

	Subject findByName(String name);

}
