package spring5_mybatis_validation_study.mapper;

import java.util.List;

import spring5_mybatis_validation_study.dto.ListCommand;
import spring5_mybatis_validation_study.dto.Member;

public interface MemberMapper {
		
		Member selectByEmail(String email);				
	
		int insert(Member member);
		int update(Member member);
		
		List<Member> selectByRedate(ListCommand listCommand);
		
}
