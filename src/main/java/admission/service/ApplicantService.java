package admission.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import admission.dao.ApplicantRepository;
import admission.domain.Applicant;

@Service
public class ApplicantService {
	private Logger log = LoggerFactory.getLogger(ApplicantService.class);
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
		log.debug("New applicant registered -->> "+applicant);
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
		log.debug(applicantRepository.findById(id)+" was deleted");
		userService.deleteByNickName(findById(id).get().getNickName());
		requestService.deleteByApplicant(applicantRepository.getOne(id));
		applicantRepository.deleteById(id);
		
	}

}
