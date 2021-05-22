package spring5_mybatis_validation_study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class})
@ComponentScan(basePackages = {
																		  "spring5_mybatis_validation_study.service"
																		, "spring5_mybatis_validation_study.controller"
																		})
public class ContextRoot {}
