package spring5_mybatis_validation_study.service;

import org.springframework.stereotype.Service;

import spring5_mybatis_validation_study.dto.Member;
@Service
public interface MemberDetailService {
		Member showById(Long memId);
}
