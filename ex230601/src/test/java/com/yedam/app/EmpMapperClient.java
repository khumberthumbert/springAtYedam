package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {
	
	@Autowired
	EmpMapper empMapper; //인터페이스를 상속받은 구현클래스 주입받음.
	// 인터페이스 -> 그 모듈만 교체할 수 있게. 하기 위함.
	
	//@Test
	@Ignore
	public void getEmpInfo() {
		EmpVO findEmp = empMapper.selectOne(100);
		assertEquals(findEmp.getFirstName(), "Steven");
		
	}
	

	
	
	//@Test
	public void 전체조회() {
		EmpVO param = new EmpVO();
		param.setDepartmentId("50, 40");
//		param.setFirstName("e"); //e를 포함한 모든 사원이 나올 것임.
		param.setOrderColumn("department_id, first_name");
		//따옴표 없이 그대로 들어감. 달러를 썼기 때문.
		List<EmpVO> list = empMapper.selectList(param);
		int cnt = empMapper.selectCount(param);
		for(EmpVO emp : list) {
			System.out.println(emp);
		}
		//assertEquals(list.get(0).getEmployeeId(), "100");
	}
	
	//@Test
	public void 등록() {
		EmpVO vo = new EmpVO();
		vo.setLastName("Kim");
		vo.setEmail("1aa2@11nate.com");
		vo.setHireDate("23/12/01");
		vo.setJobId("IT_PROG");
		
		//int aa = 
		empMapper.insertEmp(vo);
		//assertEquals(aa, 1);
		//등록 후에 id를 사용할 경우 selectkey 이용
	
		System.out.println(vo.getEmployeeId());
		
		
	}
	
	@Test
	public void selectJobs() {
		List<Map<String, Object>> list = empMapper.selectJobs();
		assertNotNull(list);
	}
	
	
}
