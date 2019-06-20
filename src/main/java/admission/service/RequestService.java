package admission.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admission.dao.RequestRepository;
import admission.domain.Applicant;
import admission.domain.Faculty;
import admission.domain.Request;

@Service("requestService")
public class RequestService {
	private Logger log = LoggerFactory.getLogger(RequestService.class);
	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	ApplicantService applicantService;

	public Request save(Request req) {
		log.info(" request was saved" + req);
		return requestRepository.save(req);
	}

	public List<Request> getAllRequests() {
		return requestRepository.findAll();
	}

	public Request findById(Integer Id) {
		return requestRepository.findById(Id).get();
	}

	public List<Request> findByApplicantNick(String nickName) {
		List<Request> requests = new ArrayList<Request>();
		try {
			requests = getAllRequests().stream()
					.filter(r -> r.getApplicant().equals(applicantService.findByNickName(nickName)))
					.collect(Collectors.toList());

		} catch (Exception e) {

		}
		return requests;
	}

	public void deleteByApplicant(Applicant app) {
		log.info(" request was deleted applicant - " + app);
		getAllRequests().forEach(r -> {
			if (r.getApplicant().equals(app)) {
				requestRepository.delete(r);
			}
		});
	}

	public void deleteByFaculty(Faculty fac) {

		getAllRequests().forEach(r -> {
			if (r.getFaculty().equals(fac)) {
				requestRepository.delete(r);
			}
		});
	}

	public void deleteById(Integer id) {
		log.info(" request " + findById(id) + " was deleted");
		requestRepository.deleteById(id);

	}

}
