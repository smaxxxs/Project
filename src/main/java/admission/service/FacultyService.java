package admission.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admission.dao.FacultyRepository;
import admission.domain.Applicant;
import admission.domain.Faculty;

@Service("facultyService")
public class FacultyService {
	private Logger log = LoggerFactory.getLogger(FacultyService.class);
	@Autowired
	private FacultyRepository facultyRepository;

	public Faculty save(Faculty faculty) {
		log.debug("New faculty was saved -->>" + faculty);
		return facultyRepository.save(faculty);
	}

	public List<Faculty> getAllFuculties() {
		return facultyRepository.findAll();
	}

	public Faculty findById(Integer Id) {
		return facultyRepository.findById(Id).get();
	}

	public void deleteById(Integer id) {
		log.debug(findById(id) + " was deleted");
		facultyRepository.deleteById(id);
	}

	public void deleteByName(String name) {
		facultyRepository.delete(findByName(name));
	}

	private Faculty findByName(String name) {

		return facultyRepository.findByName(name);
	}

	public Faculty saveAndRate(Faculty faculty, Applicant applicant) {
		log.debug(applicant + " was added to " + faculty);
		List<Applicant> applicants = faculty.getApplicants();
		applicants.add(applicant);

		if (applicant.getScore() != null) {
			List<Applicant> sortedApplicants = applicants.stream()
					.sorted((a1, a2) -> a1.getScore().compareTo(a2.getScore())).collect(Collectors.toList());
			faculty.setApplicants(sortedApplicants);
			faculty.setGrade((double) (sortedApplicants.size() > faculty.getPlaces()
					? sortedApplicants.get(faculty.getPlaces() - 1).getScore()
					: 0));
			facultyRepository.save(faculty);

		}
		return faculty;
	}

	public Faculty deleteAndRate(Faculty faculty, Applicant applicant) {
		List<Applicant> applicants = faculty.getApplicants();
		log.debug(applicant + " was deleted from " + faculty);
		applicants.remove(applicant);
		if (applicant.getScore() != null) {
			List<Applicant> sortedApplicants = applicants.stream()
					.sorted((a1, a2) -> a1.getScore().compareTo(a2.getScore())).collect(Collectors.toList());
			faculty.setApplicants(sortedApplicants);
			faculty.setGrade((double) (sortedApplicants.size() >= faculty.getPlaces()
					? sortedApplicants.get(faculty.getPlaces() - 1).getScore()
					: 0));

			facultyRepository.save(faculty);
		}
		return faculty;
	}
}
