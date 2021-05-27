package spring5_mybatis_validation_study.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring5_mybatis_validation_study.dto.ErrorResponse;
import spring5_mybatis_validation_study.dto.Member;
import spring5_mybatis_validation_study.dto.RegisterRequest;
import spring5_mybatis_validation_study.exception.DuplicateMemberException;
import spring5_mybatis_validation_study.service.RestMemberService;

@RestController
public class RestMemberController {

	@Autowired
	private RestMemberService restMemberService;

	@GetMapping("/api/members")
	public List<Member> members() {
		return restMemberService.showMembers();
	}

	@GetMapping("/api/members/{id}")
	public Member member(@PathVariable Long id, HttpServletResponse response) throws IOException {
		Member member = restMemberService.showById(id);
		if (member == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return member;
	}

	@PostMapping("/api/members")
	public ResponseEntity<Object> newMember(
																@Valid @RequestBody RegisterRequest regReq, Errors errors,
																HttpServletResponse response) throws IOException {
			try {
				if(errors.hasErrors()) {
					String errorCodes = errors.getAllErrors()
							.stream()
							.map(error -> error.getCodes()[0])
							.collect(Collectors.joining(","));
					return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new ErrorResponse("errorcodes = " + errorCodes));
				}
				Long newMemberId = restMemberService.regist(regReq);
				URI uri = URI.create("/api/members/" + newMemberId);
				return ResponseEntity.created(uri).build();
			}catch (DuplicateMemberException e) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();							
			}
	}
	
}
