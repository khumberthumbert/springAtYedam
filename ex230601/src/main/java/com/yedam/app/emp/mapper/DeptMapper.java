package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.DeptVO;

public interface DeptMapper {
	//전체조회
	public List<DeptVO> deptList(DeptVO vo);
	//등록
	public int insertDept(DeptVO vo);
}
