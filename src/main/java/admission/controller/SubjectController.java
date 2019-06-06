package admission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import admission.domain.Applicant;
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
	@RequestMapping(value = "/deleteSubject", method = RequestMethod.POST)
	public @ResponseBody
	String deleteApplicant(@RequestParam(value = "val", required = true) String parse) {
	    Integer subjId= Integer.parseInt(parse);
	    subjectService.deleteById(subjId);
	    return "admin";
	}
	 @RequestMapping(value = "/editSubject", method = RequestMethod.POST)
		public @ResponseBody
		String editApplicant(@RequestParam(value = "id", required = true) String parse,
							@RequestParam(value = "name", required = true) String name
				) {
		    Integer subjId= Integer.parseInt(parse);
		    Subject editSubj = subjectService.findById(subjId);
		    editSubj.setName(name);
		    subjectService.save(editSubj);
		    return "admin";
	 }
}
