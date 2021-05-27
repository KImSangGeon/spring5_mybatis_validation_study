package spring5_mybatis_validation_study.service;

import org.springframework.stereotype.Service;

import spring5_mybatis_validation_study.dto.RegisterRequest;
@Service
public interface MemberRegisterService {

	Long regist(RegisterRequest req);
}
