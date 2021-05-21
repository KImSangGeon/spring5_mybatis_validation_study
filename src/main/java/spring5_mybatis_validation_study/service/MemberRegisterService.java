package spring5_mybatis_validation_study.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_mybatis_validation_study.dto.Member;
import spring5_mybatis_validation_study.dto.RegisterRequest;
import spring5_mybatis_validation_study.exception.DuplicateMemberException;
import spring5_mybatis_validation_study.mapper.MemberMapper;

@Service
public class MemberRegisterService {
		@Autowired
		private MemberMapper memberMapper;

//		public MemberRegisterService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//		}
		
		public Long regist(RegisterRequest req) {
			Member member = memberMapper.selectByEmail(req.getEmail());
			if(member != null) {
				throw new DuplicateMemberException("dup email" + req.getEmail());
			}
			Member newMember = new Member(
					req.getEmail(), req.getPassword(), 
					req.getName(), LocalDateTime.now());
			
			//dao 두개면 트렌젝션 써야되는데 셀렉트 사용 update or insert는 안써도 됨.
			memberMapper.insert(newMember);
			return newMember.getId();
		}
		
	
}
