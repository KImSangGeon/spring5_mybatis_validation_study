package spring5_mybatis_validation_study.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring5_mybatis_validation_study.dto.RegisterRequest;
import spring5_mybatis_validation_study.exception.DuplicateMemberException;
import spring5_mybatis_validation_study.service.MemberRegisterService;
import spring5_mybatis_validation_study.service.impl.MemberRegisterImpl;


@Controller
public class RegisterController {
		@Autowired
		private MemberRegisterService memberRegisterService;

		@RequestMapping("/register/step1")
		public String handleStep1() {
			return "register/step1";
		}
		@PostMapping("/register/step2")
		public String handleStep2(@RequestParam(value = "agree", defaultValue = "false" ) 
																Boolean agree, /*Model model , */RegisterRequest registerRequest) {
			if(!agree) {
				return "register/step1";
			}				//이메일이 같아서 되돌아와도 값이 남아있는 이유는 model로 만들어놔서,
//			model.addAttribute("registerRequest", new RegisterRequest());
			return "register/step2";
		}
		
		@GetMapping("/register/step2")
		public String handleStep2Get() {
			return "redirect:/register/step1";
		}
		@PostMapping("/register/step3")
		public String handleStep3(/* @ModelAttribute("formData") */
				                                            @Valid RegisterRequest reqReq, Errors errors) {
		
			if(errors.hasErrors())
				return "register/step2";
		
			if(!reqReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
				return "register/step2";
			}
			
			try {
				memberRegisterService.regist(reqReq);
				return "register/step3";
			}catch (DuplicateMemberException ex) {
				errors.rejectValue("email", "duplicate");
				return "register/step2";
			}
			
		}
}
