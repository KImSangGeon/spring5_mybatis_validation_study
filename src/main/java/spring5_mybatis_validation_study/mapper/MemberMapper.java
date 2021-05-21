package spring5_mybatis_validation_study.mapper;

import spring5_mybatis_validation_study.dto.Member;

public interface MemberMapper {
		
		Member selectByEmail(String email);		
		
		int insert(Member member);
		
		
		
}
