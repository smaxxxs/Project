package admission.controller;


import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import admission.domain.Applicant;
import admission.domain.ApplicantCard;
import admission.domain.Request;
import admission.service.ApplicantService;
import admission.service.FacultyService;
import admission.service.RequestService;
import admission.service.SubjectService;

@Controller
public class ApplicantController {
	@Autowired
	ApplicantService applicantService;
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private RequestService requestService;
	
	
	@RequestMapping(value = { "/applicant" }, method = {RequestMethod.GET,RequestMethod.POST})
	public String getApplicant(
			@SessionAttribute("appNick") String nickName,
			Model model) {
			model.addAttribute("applicant", applicantService.findByNickName(nickName));
			model.addAttribute("newRequest", new Request());
			model.addAttribute("faculties",facultyService.getAllFuculties());
			model.addAttribute("subjects",subjectService.getAllSubjectss());
			model.addAttribute("applicantScore", new Applicant());
			model.addAttribute("myRequests",requestService.findByApplicantNick(nickName));
			model.addAttribute("command", new ApplicantCard());
		return "applicant";
	}
	
	@RequestMapping(value="/addScore",method=RequestMethod.POST)
	public String addNewRequest(
			@ModelAttribute("applicantScore") Applicant applicant, 
			@SessionAttribute("appNick") String appnick
			) {
		Applicant thisApplicant = applicantService.findByNickName(appnick);
		thisApplicant.setScore(applicant.getScore());
		applicantService.save(thisApplicant);
	return "redirect:applicant";
	}
	@RequestMapping(value = "/deleteApplicant", method = RequestMethod.POST)
	public @ResponseBody
	String deleteApplicant(@RequestParam(value = "val", required = true) String parse) {
	    Integer appId= Integer.parseInt(parse);
	    applicantService.deleteById(appId);
	    return "admin";
}
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String submit(@RequestParam("photo") MultipartFile file, ModelMap modelMap,
			@SessionAttribute("appNick") String appnick, HttpServletRequest  request) throws IllegalStateException, IOException {
	
	    modelMap.addAttribute("photo", file);
	    String filePath =request.getServletContext().getRealPath("/")+"/photos/"+appnick+".jpg";
	    System.out.println(filePath);
	    java.io.File appPhoto = new File(filePath);
	    appPhoto.delete();
	    file.transferTo(appPhoto);
	    System.out.println(file.getOriginalFilename());
	    return "redirect:applicant";
	}
	
	
	
}
