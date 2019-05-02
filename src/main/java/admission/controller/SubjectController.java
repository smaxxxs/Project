package admission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import admission.domain.Subject;
import admission.service.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value="/addSubject",method=RequestMethod.POST)
	public String addNewSubject(@ModelAttribute("newSubject") Subject subject) {
	subjectService.save(subject);
	return "redirect:admin";
	}
	@RequestMapping(value="/addSubject",method=RequestMethod.GET)
	public ModelAndView out() {
		ModelAndView mav =new ModelAndView("admin");
	mav.addObject("subjects",subjectService.getAllSubjectss());
	return mav;
	}
}
