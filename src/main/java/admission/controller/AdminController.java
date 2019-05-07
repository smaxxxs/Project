package admission.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import admission.dao.UserRepository;
import admission.domain.Faculty;
import admission.domain.Subject;
import admission.domain.User;
import admission.service.ApplicantService;
import admission.service.FacultyService;
import admission.service.RequestService;
import admission.service.SubjectService;

@Controller
public class AdminController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private SubjectService subjectService;
	
	
	@RequestMapping(value = { "/admin" }, method = {RequestMethod.GET,RequestMethod.POST})
	public String getApplicant(
			@SessionAttribute("adminNick") String nickName,
			Model model) {
			System.out.println("22222222"+nickName);
			model.addAttribute("admin", userRepo.findByNickName(nickName));
			model.addAttribute("faculties",facultyService.getAllFuculties());
			model.addAttribute("applicants",applicantService.getAllApplicants());
			model.addAttribute("requests",requestService.getAllRequests());
			model.addAttribute("newFaculty",new Faculty());
			model.addAttribute("newAdmin",new User());
			model.addAttribute("newSubject",new Subject());
			model.addAttribute("subjects",subjectService.getAllSubjectss());
			return "admin";
	}
	@RequestMapping(value="/approve",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getApprove(@RequestParam(value="reqIdApprove", required = false) Object reqId,HttpServletRequest request) {
		System.out.println("aaaaaapppppppproooooved"+request.toString()+reqId);
	//	requestService.findById(reqId).setStatus(Status.approved);
	return "redirect:admin";
	}
	
}


