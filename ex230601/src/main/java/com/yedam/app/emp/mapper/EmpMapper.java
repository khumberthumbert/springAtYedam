package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	public EmpVO selectOne(int empNo);
	public int selectCount(EmpVO vo);
	//목록 구하는거랑 건수 구하는거는 항상 같아야 한다.
	//그래야 페이징 제대로 걸어 줄 수 있다.
	public List<EmpVO> selectList(EmpVO vo); 
	
	// 등록 DB결과의 실행 반환타입은 int나 void 뿐임.
	public int insertEmp(EmpVO vo);
	//삭제
	public int deleteEmp(int empNO);
	//수정
	public int updateEmp(EmpVO vo);
	
	//여러개의 값이라 List. vo대신에 MAP을 쓴거임.
	public List<Map<String, Object>> selectJobs(); 
	public List<Map<String, Object>> selectDepartments(); 
}
