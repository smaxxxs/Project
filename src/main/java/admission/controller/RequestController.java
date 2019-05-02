package admission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import admission.domain.Applicant;
import admission.domain.Faculty;
import admission.domain.Request;
import admission.domain.Status;
import admission.service.ApplicantService;
import admission.service.FacultyService;
import admission.service.RequestService;

@Controller
@SessionAttributes("appNick")
public class RequestController {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private ApplicantService applicantService;
	
	@RequestMapping(value="/addRequest",method=RequestMethod.POST)
	public String addNewRequest(
			@ModelAttribute("newRequest") Request newRequest, 
			@SessionAttribute("appNick") String appnick
			) {
		System.out.println(newRequest+"   777777777777 "+appnick);
		newRequest.setApplicant(applicantService.findByNickName(appnick));
		newRequest.setStatus(Status.wait);
		requestService.save(newRequest);
	return "redirect:applicant";
	}
	@RequestMapping(value="/addRequest",method=RequestMethod.GET)
	public ModelAndView out() {
		ModelAndView mav =new ModelAndView("applicant");
	mav.addObject("faculties",facultyService.getAllFuculties());
	return mav;
	}
}
