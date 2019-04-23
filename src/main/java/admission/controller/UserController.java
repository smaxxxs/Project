package admission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import admission.dao.UserRepository;
import admission.domain.Applicant;
import admission.domain.Role;
import admission.domain.User;
import admission.service.ApplicantService;

@Controller
public class UserController {

	@Autowired
	private ApplicantService appService;

	@Autowired
	private UserRepository userRepo;

	@RequestMapping(value = "/userlogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute("userlogin") User user, RedirectAttributes redirAttributes) {
		String redirect = "redirect:login";
		String nickName = user.getNickName();
		User consistUser = userRepo.findByNickName(nickName);
		if (consistUser != null && consistUser.getPassword().equals(user.getPassword())) {
			if (consistUser.getRole() == Role.ADMIN) {
				redirAttributes.addAttribute("adminNick", nickName);
				redirect = "redirect:admin";
			} else {
				redirAttributes.addAttribute("appNick", nickName);
				redirect = "redirect:applicant";
			}

		}
		redirAttributes.addFlashAttribute("message", "login or password was incorect! Try again to login");
		return redirect;
	}

	@RequestMapping(value = "/userregister", method = RequestMethod.GET)
	public String registration() {
		return "redirect:applicant";
	}

	@RequestMapping(value = "/userregister", method = { RequestMethod.POST })
	public String registration(@ModelAttribute("userregister") Applicant newApplicant,
			RedirectAttributes redirAttributes) {
		//validation only by Nickname
		String nickName = newApplicant.getNickName();
		if (userRepo.findByNickName(nickName) != null) {
			redirAttributes.addFlashAttribute("message", "This NickName is used. Choose other");
			return "redirect:login";
		}
		redirAttributes.addAttribute("appNick", nickName);
		appService.save(newApplicant);

		return "redirect:applicant";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(@ModelAttribute("message") String string, Model model) {
		model.addAttribute("userlogin", new User());
		model.addAttribute("userregister", new Applicant());
		model.addAttribute("message", string);
		
		return "login";
	}

}
