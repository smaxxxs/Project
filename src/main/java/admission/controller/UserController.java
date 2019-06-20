package admission.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import admission.domain.Applicant;
import admission.domain.Role;
import admission.domain.User;
import admission.service.ApplicantService;
import admission.service.UserService;

@SessionAttributes({ "appNick", "adminNick" })
@Controller
public class UserController {

	@Autowired
	private ApplicantService appService;

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/userlogin", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(@ModelAttribute("userlogin") User user, RedirectAttributes redirAttributes,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login");
		String nickName = user.getNickName();
		User consistUser = userService.findByNickName(nickName);
		if (consistUser != null && (consistUser.getPassword().equals((user.getPassword()))
				|| bCryptPasswordEncoder.matches(user.getPassword(), consistUser.getPassword()))) {
			if (consistUser.getRole() == Role.ADMIN) {
				session.setAttribute("adminNick", nickName);
				mav.setViewName("redirect:admin");
			} else {
				session.setAttribute("appNick", nickName);
				mav.setViewName("redirect:applicant");
			}

		} else if (consistUser == null) {
			redirAttributes.addFlashAttribute("message", "login was incorrect! Try again to login");
		} else
			redirAttributes.addFlashAttribute("message", "password was incorrect! Try again to login");

		System.out.println(mav);
		return mav;
	}

	@RequestMapping(value = "/userregister", method = RequestMethod.GET)
	public String registration() {
		return "redirect:applicant";
	}

	@RequestMapping(value = "/userregister", method = { RequestMethod.POST })
	public String registration(@ModelAttribute("userregister") Applicant newApplicant,
			RedirectAttributes redirAttributes, HttpSession session) {
		// validation only by Nickname
		String nickName = newApplicant.getNickName();
		if (userService.findByNickName(nickName) != null) {
			redirAttributes.addFlashAttribute("message", "This NickName is used. Choose other");
			return "redirect:login";
		}
		session.setAttribute("appNick", nickName);
		appService.save(newApplicant);

		return "redirect:applicant";
	}

	@RequestMapping(value = "/addAdmin", method = { RequestMethod.POST })
	public String newAddmin(@ModelAttribute("newAdmin") User user) {
		user.setRole(Role.ADMIN);
		userService.save(user);
		return "forward:admin";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(@ModelAttribute("message") String string, Model model) {
		model.addAttribute("userlogin", new User());
		model.addAttribute("userregister", new Applicant());
		model.addAttribute("message", string);

		return "login";
	}

}
