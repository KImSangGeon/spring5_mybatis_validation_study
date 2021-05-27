package spring5_mybatis_validation_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_mybatis_validation_study.dto.Member;
import spring5_mybatis_validation_study.mapper.MemberMapper;
import spring5_mybatis_validation_study.service.MemberDetailService;
@Service
public class MemberDetailImpl implements MemberDetailService {
		
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public Member showById(Long memId) {
		return memberMapper.selectById(memId);
	}
	

}
