package admission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admission.dao.UserRepository;
import admission.domain.Faculty;
import admission.service.FacultyService;

@Controller
public class AdminController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private FacultyService facultyService;
	
	
	@RequestMapping(value = { "/admin" }, method = {RequestMethod.GET,RequestMethod.POST})
	public String getApplicant(
			@ModelAttribute("adminNick") String nickName,
			Model model) {
			model.addAttribute("admin", userRepo.findByNickName(nickName));
			model.addAttribute("faculties",facultyService.getAllFuculties());
			model.addAttribute("newFaculty",new Faculty());
			return "admin";
	}
	
}


