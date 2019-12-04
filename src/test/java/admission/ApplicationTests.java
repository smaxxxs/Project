package admission;
import java.util.List;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import admission.dao.UserRepository;
import admission.domain.Role;
import admission.domain.User;
import admission.service.ApplicantService;
import admission.service.FacultyService;
import admission.service.RequestService;
import admission.service.SubjectService;
import admission.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationTests {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void saveUser() {
	List<User> users = userRepository.findAll();
	assertThat(users,hasSize(0));
	
	User user = new User();
	user.setId(1);
	user.setNickName("user");
	user.setPassword("password");
	user.setRole(Role.USER);
	
	userService.save(user);
	
	users = userRepository.findAll();
	assertThat(users,hasSize(1));
	
	}
}
