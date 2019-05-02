package admission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import admission.domain.Faculty;
import admission.service.FacultyService;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value = "/addFaculty", method = RequestMethod.POST)
	public String addNewFaculty(@ModelAttribute("newFaculty") Faculty faculty) {
		System.out.println(faculty);
		facultyService.save(faculty);
		return "redirect:admin#faculty";
	}
	@RequestMapping(value = "/addFaculty", method = RequestMethod.GET)
	public ModelAndView out() {
		ModelAndView mav =new ModelAndView("admin");
		mav.addObject("faculties",facultyService.getAllFuculties());
		return mav;
		
	}
}
