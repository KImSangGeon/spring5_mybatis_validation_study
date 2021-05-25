package spring5_mybatis_validation_study.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring5_mybatis_validation_study.dto.AuthInfo;
import spring5_mybatis_validation_study.dto.ChangePwdCommand;
import spring5_mybatis_validation_study.exception.WrongIdPasswordException;
import spring5_mybatis_validation_study.service.ChangePasswordService;


@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@GetMapping
	public String form(@ModelAttribute("command") ChangePwdCommand	pwdCommand) {
		return "edit/changePwdForm";
	}
	
	@PostMapping
	public String submit(@ModelAttribute("command")
	@Valid ChangePwdCommand pwdCommand, Errors errors, HttpSession session) {
//		new ChangePwdCommandValidator();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		if(errors.hasErrors()) {
			return "edit/changePwdForm";			
			
		}
		try {
			System.out.println();
			changePasswordService.changePassword(				
					authInfo.getEmail(), pwdCommand.getCurrentPassword(),
					pwdCommand.getNewPassword());
			return "edit/changedPwd";
		}catch(WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "edit/changePwdForm";
		}	
			
	}

}
