package admission.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admission.dao.FacultyRepository;
import admission.domain.Applicant;
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
	    
	    public void deleteById (Integer id) {
	    	facultyRepository.deleteById(id);
	    }
			
	public Faculty saveAndRate(Faculty faculty, Applicant applicant) {
		List<Applicant> applicants = faculty.getApplicants();
		applicants.add(applicant);
	//	applicants.forEach(System.out::println);
	
		if (applicant.getScore() != null) {
			List<Applicant> sortedApplicants = applicants.stream()
					.sorted((a1, a2) -> a2.getScore().compareTo(a1.getScore())).collect(Collectors.toList());
			for (int i = 0; i < sortedApplicants.size(); i++) {
				sortedApplicants.get(i).setRate(i + 1);
			}

			faculty.setApplicants(sortedApplicants);
			facultyRepository.save(faculty);
			
		}
		return faculty;
	}
	    
	public Faculty deleteAndRate(Faculty faculty, Applicant applicant) {
		List<Applicant> applicants = faculty.getApplicants();
		
		applicants.remove(applicant);
			if (applicant.getScore() != null) {
			List<Applicant> sortedApplicants = applicants.stream()
					.sorted((a1, a2) -> a2.getScore().compareTo(a1.getScore())).collect(Collectors.toList());
			for (int i = 0; i < sortedApplicants.size(); i++) {
				sortedApplicants.get(i).setRate(i + 1);
			}
			facultyRepository.save(faculty);
		}
		return faculty;
	}
}
