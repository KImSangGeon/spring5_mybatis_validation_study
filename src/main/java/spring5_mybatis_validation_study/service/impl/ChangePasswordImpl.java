package spring5_mybatis_validation_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring5_mybatis_validation_study.dto.Member;
import spring5_mybatis_validation_study.exception.MemberNotFoundException;
import spring5_mybatis_validation_study.mapper.MemberMapper;
import spring5_mybatis_validation_study.service.ChangePasswordService;

@Service
public class ChangePasswordImpl implements ChangePasswordService {
	
	@Autowired
		private MemberMapper memberMapper;

		@Transactional
		public void changePassword(String email, String oldPwd, String newPwd) {
			Member member = memberMapper.selectByEmail(email);
			if(member == null) {
				throw new MemberNotFoundException();
			}
			member.changePassword(oldPwd, newPwd);
			memberMapper.update(member);
		}
		
}
