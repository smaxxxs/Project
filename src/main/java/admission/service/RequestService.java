package admission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admission.dao.RequestRepository;
import admission.domain.Request;

@Service
public class RequestService {
	 @Autowired
	    private RequestRepository requestRepository;


	    public Request save(Request faculty) {
	    	return requestRepository.save(faculty);
	    	    }
	    
	    public List<Request> getAllRequests(){
	    	return requestRepository.findAll();
	    }
	    
	    public Request findById(Integer Id) {
	    	return requestRepository.findById(Id).get();
	    }
			
	    	
	    
	    
}
