package admission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import admission.domain.Faculty;
import admission.service.FacultyService;
import admission.service.RequestService;
import admission.service.SubjectService;
import admission.service.UserService;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private UserService userService;

	@Autowired
	private RequestService requestService;

	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "/addFaculty", method = RequestMethod.POST)
	public String addNewFaculty(@ModelAttribute("newFaculty") Faculty faculty) {

		facultyService.save(faculty);
		return "redirect:admin#faculty";
	}

	@RequestMapping(value = "/addFaculty", method = RequestMethod.GET)
	public ModelAndView out() {
		ModelAndView mav = new ModelAndView("admin");
		mav.addObject("faculties", facultyService.getAllFuculties());
		return mav;

	}

	@RequestMapping(value = "/editFaculty", method = RequestMethod.POST)
	public ModelAndView editFaculty(@ModelAttribute("thisFaculty") Faculty faculty) {
		ModelAndView mav = new ModelAndView("redirect:faculty");
		mav.addObject("facultyId", faculty.getId());
		Faculty oldFaculty = facultyService.findById(faculty.getId());
		oldFaculty.setName(faculty.getName());
		oldFaculty.setPlaces(faculty.getPlaces());
		oldFaculty.setSubjects(faculty.getSubjects());
		facultyService.save(oldFaculty);
		return mav;

	}

	@RequestMapping("faculty")
	public String getStudent(@RequestParam Integer facultyId, Model model,
			@SessionAttribute("adminNick") String nickName) {
		Faculty faculty = facultyService.findById(facultyId);
		model.addAttribute("faculty", faculty);
		model.addAttribute("thisFaculty", new Faculty());
		model.addAttribute("admin", userService.findByNickName(nickName));
		model.addAttribute("subjects", subjectService.getAllSubjectss());
		return "faculty";
	}

	@RequestMapping(value = "/deleteFaculty", method = RequestMethod.POST)
	public @ResponseBody String deleteFaculty(@RequestParam(value = "val", required = true) String parse) {
		Integer facId = Integer.parseInt(parse);
		requestService.deleteByFaculty(facultyService.findById(facId));
		facultyService.deleteById(facId);

		return "admin";
	}
}