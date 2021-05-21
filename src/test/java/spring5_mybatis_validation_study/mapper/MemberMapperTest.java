package spring5_mybatis_validation_study.mapper;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_validation_study.config.ContextRoot;
import spring5_mybatis_validation_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
public class MemberMapperTest {
	
	private static final Log log = LogFactory.getLog(MemberMapperTest.class);
	
	@Autowired
	private MemberMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testSelectByEmail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member selectMember = mapper.selectByEmail("tkdrjs7@naver.com");
		log.debug(selectMember.toString());
		Assert.assertNotNull(selectMember);
	}

	@Test
	public void testInsert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member member = new Member("tkdrjs9@naver.com", "tkdrjs999", "김유진");
		int res = mapper.insert(member);
		Assert.assertEquals(1, res);
		
	}

}
