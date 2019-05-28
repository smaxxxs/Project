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
import admission.service.UserService;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RequestService requestService;
	
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
	@RequestMapping ("faculty")
    public String getStudent(@RequestParam  Integer facultyId, Model model,
    		@SessionAttribute("adminNick") String nickName){
        Faculty faculty = facultyService.findById(facultyId);
        model.addAttribute("faculty", faculty);
        model.addAttribute("admin", userService.findByNickName(nickName));
        return "faculty";
    }
	@RequestMapping(value = "/deleteFaculty", method = RequestMethod.POST)
	public @ResponseBody
	String deleteFaculty(@RequestParam(value = "val", required = true) String parse) {
	    Integer facId= Integer.parseInt(parse);
	    requestService.deleteByFaculty(facultyService.findById(facId));
	    facultyService.deleteById(facId);
	   
		return "admin";
}
}