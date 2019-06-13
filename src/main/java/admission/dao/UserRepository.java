package admission.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import admission.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByNickName(String nickName);
}
