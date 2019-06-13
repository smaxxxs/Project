package admission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import admission.dao.UserRepository;
import admission.domain.Applicant;
import admission.domain.Role;
import admission.domain.User;

@Service("userService")
public class UserService {
	 @Autowired
	    private UserRepository userRepository;
	 

	    @Autowired
	    private PasswordEncoder bCryptPasswordEncoder;
	    
	    @Autowired
	    private ApplicantService applicantService;


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
	    public List <User> findAll(){
	    	return userRepository.findAll();
	    }
	    public void cleanEmptyApplicants() {
	    	List <User> users =findAll();
	    	for (User user : users) {
	    		String nickName = user.getNickName();
				if (applicantService.findByNickName(nickName)==null && user.getRole()==Role.USER) {
					deleteByNickName(nickName);
				}
			}
	    }

		public User findByNickName(String nickName) {
			
			return userRepository.findByNickName(nickName);
		}
		
		public void deleteByNickName(String nick) {
			userRepository.delete(findByNickName(nick));
		}
}
