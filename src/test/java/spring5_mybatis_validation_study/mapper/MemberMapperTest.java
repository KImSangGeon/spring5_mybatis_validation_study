package spring5_mybatis_validation_study.mapper;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_mybatis_validation_study.config.ContextRoot;
import spring5_mybatis_validation_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
@WebAppConfiguration
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

//	@Test
	public void testInsert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member member = new Member("tkdrjs20@naver.com", "tkdrjs", "김유진");
		int res = mapper.insert(member);
		Assert.assertEquals(1, res);		
	}
	
	@Test
	public void testUpdate() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member newMember = new Member("tkdrjs20@naver.com", "tkdrjs", "111111");
		int res =mapper.update(newMember);
		Assert.assertEquals(1, res);
	}

}
