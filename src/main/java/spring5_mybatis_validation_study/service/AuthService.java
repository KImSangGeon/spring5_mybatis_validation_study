package spring5_mybatis_validation_study.service;

import org.springframework.stereotype.Service;

import spring5_mybatis_validation_study.dto.AuthInfo;
	@Service
public interface AuthService {
	
	AuthInfo authenicate(String email, String password);
}
