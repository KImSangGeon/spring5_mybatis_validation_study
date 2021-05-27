package spring5_mybatis_validation_study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import spring5_mybatis_validation_study.dto.Member;
import spring5_mybatis_validation_study.dto.RegisterRequest;
@Service
public interface RestMemberService {
		List<Member> showMembers();
		Member showById(Long memId);
		
		Long regist(RegisterRequest req);
}
