package admission.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import admission.domain.Request;

public interface RequestRepository extends JpaRepository<Request,Integer>{

}
