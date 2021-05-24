package spring5_mybatis_validation_study.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring5_mybatis_validation_study.dto.AuthInfo;
import spring5_mybatis_validation_study.dto.LoginCommand;
import spring5_mybatis_validation_study.exception.WrongIdPasswordException;
import spring5_mybatis_validation_study.service.AuthService;

@Controller
@RequestMapping("/login")
public class LoginController {
		
		@Autowired
		private AuthService authService;
		
		@GetMapping
		public String form(LoginCommand loginCommand) {
			return "/login/loginForm";
		}
		
		@PostMapping
		public String submit(@Valid LoginCommand loginCommand, Errors errors, HttpSession ssession) {
//			new LoginCommandValidator().validate(loginCommand, errors);
			System.out.println(loginCommand);
			if(errors.hasErrors()) {
				return "/login/loginForm";
			}
			try {
				//세션에 authInfo 저장해야함
				AuthInfo authInfo = authService.authenicate(loginCommand.getEmail(), loginCommand.getPassword());
				ssession.setAttribute("authInfo", authInfo);			
				return "/login/loginSuccess";
				
			}catch(WrongIdPasswordException ex) {
				errors.reject("idPasswordNotMatching");
				return "/login/loginForm";
			}
			
		}
	
	
	
}
