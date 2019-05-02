package admission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import admission.dao.ApplicantRepository;
import admission.domain.Applicant;

@Service
public class ApplicantService {
	 @Autowired
	    private ApplicantRepository applicantRepository;
	 @Autowired
	    private UserService userRepository;

	    @Autowired
	    private PasswordEncoder bCryptPasswordEncoder;


	    public void save(Applicant applicant) {
	    	applicant.setPassword(bCryptPasswordEncoder.encode(applicant.getPassword()));
	    	applicantRepository.save(applicant);
	    	userRepository.save(applicant);
	    }
	   public Applicant findByNickName(String nickName) {
	    	return applicantRepository.findByNickName(nickName);
	    }
	   
	   public List<Applicant> getAllApplicants(){
		   return applicantRepository.findAll();
	   }
	   
//	   public Applicant update (Applicant applicant) {
//		return applicantRepository.update(applicant);
//		   
//	   }
}
