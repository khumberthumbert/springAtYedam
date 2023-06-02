package com.yedam.app;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DeptMapperClient {

	@Autowired
	DeptMapper deptMapper;
	
	@Test
	public void 전체조회() {
		DeptVO param = new DeptVO();
		param.setDepartmentId(Integer.parseInt("10"));
		List<DeptVO> list = deptMapper.deptList(param);
		deptMapper.deptList(param);
		for(DeptVO dept : list) {
			System.out.println(dept);
		}
	}
	
	
}
