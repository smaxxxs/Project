package admission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import admission.domain.Request;
import admission.service.ApplicantService;
import admission.service.FacultyService;

@Controller
public class ApplicantController {
	@Autowired
	ApplicantService applicantService;
	
	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value = { "/applicant" }, method = {RequestMethod.GET,RequestMethod.POST})
	public String getApplicant(
			@SessionAttribute("appNick") String nickName,
			Model model) {
			model.addAttribute("applicant", applicantService.findByNickName(nickName));
			model.addAttribute("newRequest", new Request());
			model.addAttribute("faculties",facultyService.getAllFuculties());
		
		return "applicant";
	}
}
