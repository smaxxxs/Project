package admission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admission.dao.SubjectRepository;
import admission.domain.Subject;

@Service("subjectService")
public class SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;

	public Subject save(Subject faculty) {
		return subjectRepository.save(faculty);
	}

	public List<Subject> getAllSubjectss() {
		return subjectRepository.findAll();
	}

	public Subject findById(Integer Id) {
		return subjectRepository.findById(Id).get();
	}

	public void deleteById(Integer id) {
		subjectRepository.deleteById(id);

	}

	public void deleteByName(String name) {
		subjectRepository.delete(findByName(name));

	}

	private Subject findByName(String name) {
		return subjectRepository.findByName(name);
	}

}
