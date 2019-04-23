package admission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admission.dao.FacultyRepository;
import admission.domain.Faculty;

@Service
public class FacultyService {
	 @Autowired
	    private FacultyRepository facultyRepository;


	    public Faculty save(Faculty faculty) {
	    	return facultyRepository.save(faculty);
	    	    }
	    
	    public List<Faculty> getAllFuculties(){
	    	return facultyRepository.findAll();
	    }
	    
	    public Faculty findById(Integer Id) {
	    	return facultyRepository.findById(Id).get();
	    }
			
	    	
	    
	    
}
