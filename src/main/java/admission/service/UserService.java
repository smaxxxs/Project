package admission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import admission.dao.UserRepository;
import admission.domain.Applicant;
import admission.domain.Role;
import admission.domain.User;

@Service
public class UserService {
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordEncoder bCryptPasswordEncoder;


	    public void save(User user) {
	    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	    	userRepository.save(user);
	    }
	    
	    public void save(Applicant applicant) {
	    	User user = new User();
//	    	initAdmin();
	    	user.setNickName(applicant.getNickName());
	    	user.setPassword(applicant.getPassword());
	    	user.setRole(Role.USER);
	    	userRepository.save(user);
	    }
	    
	    public void  initAdmin() {
	    	if (userRepository.findByNickName("admin")==null) {
	    		User admin = new User();
	    		admin.setNickName("admin");
	    		admin.setPassword("admin");
	    		admin.setRole(Role.ADMIN);
	    		userRepository.save(admin);
	    	}
			
	    	
	    }
}
