package com.bt.guestbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Venkat
 * This is class is used to perform login and logout operations, it has a method login() and based on the parameter values it will perform login and logout.
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * This method is performaing login and logout operations.
     * 
     * @param model
     * @param error
     * @param logout
     * @return
     */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		logger.info("In Login method");
		if (error != null) {
			logger.error("Login Failed, Invalid credentials");
			model.addAttribute("errorMsg", "Your username and password are invalid.");
		}

		if (logout != null) {
			logger.info("In Logout");
			model.addAttribute("msg", "You have been logged out successfully.");
		}

		return "login";
	}
	
}
