package spring5_mybatis_validation_study.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring5_mybatis_validation_study.dto.ListCommand;
import spring5_mybatis_validation_study.dto.Member;
import spring5_mybatis_validation_study.mapper.MemberMapper;
@Controller
public class ListController {

			@Autowired
			private MemberMapper memberMapper;
			
			@RequestMapping("/members")
			public String list(@ModelAttribute("cmd") @Valid ListCommand listCommand,
												Errors errors, Model model) {
				if(errors.hasErrors()) {
					return "member/memberList";
				}
				if(listCommand.getFrom() != null && listCommand.getTo() != null) {
					List<Member>  members = memberMapper.selectByRedate(listCommand);
					model.addAttribute("members", members);
				}
				return "member/memberList";
			}
		
}
