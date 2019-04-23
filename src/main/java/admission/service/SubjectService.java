package admission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admission.dao.SubjectRepository;
import admission.domain.Subject;

@Service
public class SubjectService {
	 @Autowired
	    private SubjectRepository subjectRepository;


	    public Subject save(Subject faculty) {
	    	return subjectRepository.save(faculty);
	    	    }
	    
	    public List<Subject> getAllSubjectss(){
	    	return subjectRepository.findAll();
	    }
	    
	    public Subject findById(Integer Id) {
	    	return subjectRepository.findById(Id).get();
	    }
			
	    	
	    
}
