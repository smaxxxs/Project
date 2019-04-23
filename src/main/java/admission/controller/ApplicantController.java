package admission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admission.service.ApplicantService;

@Controller
public class ApplicantController {
	@Autowired
	ApplicantService applicantService;
	
	@RequestMapping(value = { "/applicant" }, method = {RequestMethod.GET,RequestMethod.POST})
	public String getApplicant(
			@ModelAttribute("appNick") String nickName,
			Model model) {
			model.addAttribute("applicant", applicantService.findByNickName(nickName));
		return "applicant";
	}
}
