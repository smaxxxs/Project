package admission.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import admission.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	Faculty findByName(String name);
}
