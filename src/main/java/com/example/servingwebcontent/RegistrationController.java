package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
	@Autowired
	private UserRepo userRepo;

	@GetMapping("/registration")
	public String getRegistration(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "registration";
	}

	@PostMapping("/registration")
	public String postRegistration(
			@RequestParam String username,
			@RequestParam String mail,
			@RequestParam String code_phone,
			@RequestParam String phone,
			@RequestParam String password1,
			@RequestParam String password2,
			Model model
	) {
		String page = "registration";
		UserModel user = userRepo.findByusername(username);
		if (user != null) {
			model.addAttribute("isError", true);
			model.addAttribute("errorMsg", "user with this nickname exists");
			model.addAttribute("url", "registration");
			return page;
		}
		if (!password1.equals(password2)) {
			model.addAttribute("isError", true);
			model.addAttribute("errorMsg", "password1 and password2 dont match");
			model.addAttribute("url", "registration");
			return page;
		}
		UserModel new_user = new UserModel(
				username,
				mail,
				code_phone,
				phone,
				password1
		);
		userRepo.save(new_user);
		return "redirect:/login";
	}
}
