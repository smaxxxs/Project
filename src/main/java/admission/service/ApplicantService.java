package admission.service;

import java.util.List;
import java.util.Optional;

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
	private UserService userService;
	@Autowired
	private RequestService requestService;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(Applicant applicant) {
		applicant.setPassword(bCryptPasswordEncoder.encode(applicant.getPassword()));
		if (userService.findByNickName(applicant.getNickName()) == null)
			userService.save(applicant);
		applicantRepository.save(applicant);
	}

	public Applicant findByNickName(String nickName) {
		return applicantRepository.findByNickName(nickName);
	}
	public Optional<Applicant> findById(Integer id) {
		return applicantRepository.findById(id);
	}

	public List<Applicant> getAllApplicants() {
		return applicantRepository.findAll();
	}

	public void deleteById(Integer id) {
		userService.deleteByNickName(findById(id).get().getNickName());
		requestService.deleteByApplicant(applicantRepository.getOne(id));
		applicantRepository.deleteById(id);
//		userService.cleanEmptyApplicants();
	}
//	   public Applicant update (Applicant applicant) {
//		return applicantRepository.update(applicant);
//		   
//	   }
}
