package admission.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admission.dao.RequestRepository;
import admission.domain.Applicant;
import admission.domain.Faculty;
import admission.domain.Request;

@Service
public class RequestService {
	 @Autowired
	    private RequestRepository requestRepository;
	 
	 @Autowired
		ApplicantService applicantService;

	    public Request save(Request faculty) {
	    	return requestRepository.save(faculty);
	    	    }
	    
	    public List<Request> getAllRequests(){
	    	return requestRepository.findAll();
	    }
	    
	    public Request findById(Integer Id) {
	    	return requestRepository.findById(Id).get();
	    }
	    public List <Request> findByApplicantNick(String nickName) {
	    	List <Request> requests =new ArrayList <Request> ();
	    	try {
				requests = getAllRequests().stream()
				.filter(r->r.getApplicant().equals(applicantService.findByNickName(nickName))).collect(Collectors.toList());
				
			} catch (Exception e) {
				
			}
	    	return requests;
	    }
	    	
	    public void deleteByApplicant(Applicant app) {
	    	
	    	getAllRequests().forEach(r->{if (r.getApplicant().equals(app)) {requestRepository.delete(r);} });
	    }
	    public void deleteByFaculty(Faculty fac) {
	    	
	    	getAllRequests().forEach(r->{if (r.getFaculty().equals(fac)) {requestRepository.delete(r);} });
	    }

		public void deleteById(Integer id) {
			requestRepository.deleteById(id);
			
		}
	    
}
