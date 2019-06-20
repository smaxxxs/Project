package admission;

import java.util.List;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import admission.dao.UserRepository;
import admission.domain.Applicant;
import admission.domain.Faculty;
import admission.domain.Role;
import admission.domain.Subject;
import admission.domain.User;
import admission.service.ApplicantService;
import admission.service.FacultyService;
import admission.service.SubjectService;
import admission.service.UserService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTests {

	@Qualifier("facultyService")
	@Autowired
	private FacultyService facultyService;

	@Qualifier("applicantService")
	@Autowired
	private ApplicantService applicantService;

	@Qualifier("subjectService")
	@Autowired
	private SubjectService subjectService;

	@Qualifier("userService")
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void saveAndDeleteUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setNickName("userOK");
		user.setPassword("password");
		user.setRole(Role.USER);

		userService.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		userService.deleteByNickName(user.getNickName());
		users = userRepository.findAll();
		assertThat(users, hasSize(0));
	}

	@Test
	public void saveAndDeleteApplicant() {
		List<Applicant> applicants = applicantService.getAllApplicants();
		assertThat(applicants, hasSize(0));

		Applicant applicant = new Applicant();
		applicant.setNickName("applicantTEST");
		applicant.setName("Name");
		applicant.setSurname("Surname");
		applicant.setPassword("password");

		applicantService.save(applicant);

		applicants = applicantService.getAllApplicants();
		assertThat(applicants, hasSize(1));

		applicantService.deleteByNickName(applicant.getNickName());
		applicants = applicantService.getAllApplicants();
		assertThat(applicants, hasSize(0));
	}

	@Test
	public void saveAndDeleteFaculties() {
		List<Faculty> faculties = facultyService.getAllFuculties();
		assertThat(faculties, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setName("TESTFaculty");
		faculty.setPlaces(111);
		faculty.setGrade(450.0);

		facultyService.save(faculty);

		faculties = facultyService.getAllFuculties();
		assertThat(faculties, hasSize(1));

		facultyService.deleteByName(faculty.getName());
		faculties = facultyService.getAllFuculties();
		assertThat(faculties, hasSize(0));
	}

	@Test
	public void saveAndDeleteSubject() {
		List<Subject> subjects = subjectService.getAllSubjectss();
		assertThat(subjects, hasSize(0));

		Subject subject = new Subject();
		subject.setName("TESTsubject");

		subjectService.save(subject);

		subjects = subjectService.getAllSubjectss();
		assertThat(subjects, hasSize(1));

		subjectService.deleteByName(subject.getName());
		subjects = subjectService.getAllSubjectss();
		assertThat(subjects, hasSize(0));
	}
}