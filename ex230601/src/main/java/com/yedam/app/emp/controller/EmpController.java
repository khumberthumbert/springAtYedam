package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

/*
 *  command
 *  Pojo : 상속필요 없음.
 */
@Controller       
// 객체 생성해서 컨테이너에 빈등록하고 스프링 디스패쳐서블릿에서 호출할 수 있도록
// 커맨드 타입으로 만들어 줌  
// @Component 상속받음
public class EmpController {
	
	@Autowired EmpMapper empMapper;
	
	@GetMapping("empList")
	public String empList(Model model, @ModelAttribute("emp") EmpVO vo) {
		//@ModelAttribute : 이름 바꿔서 넣고 싶을 때.
		//vo = new EmpVO();
		System.out.println(vo);
		//model.addAttribute("empVO", vo);
		model.addAttribute("empList", empMapper.selectList(vo));
		return "emp/empList";
		//커맨드 객체는 화면에 알아서 전달 됨.
	}
	
	//사원등록 페이지로 이동
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("jobs", empMapper.selectJobs());
		model.addAttribute("depts", empMapper.selectDepartments());
		return "emp/empInsert";
	}
	
	//사원등록 처리
	@PostMapping("empInsert")
	public String empInsert(EmpVO vo) {
		empMapper.insertEmp(vo);
		return "redirect:empList"; //forward redirect 아무것도 안적었을 때 forward
		// return empList는 mapping url을 적어주는 거임
	}
	
	//사원삭제 처리
	@GetMapping("empDelete")
	public String empDelete(@RequestParam int empId) {
		//@RequestParam이 request.getParameter와 같은 역할
		empMapper.deleteEmp(empId);
		return "redirect:empList";
	}
	
	//사원수정페이지로 이동
	@GetMapping("empUpdate")
	public String empUpdateForm(Model model, int empId) {
		model.addAttribute("emp", empMapper.selectOne(empId));
		model.addAttribute("jobs", empMapper.selectJobs());
		model.addAttribute("depts", empMapper.selectDepartments());
		return "emp/empUpdate";
	}
	
	//사원수정 처리
		@PostMapping("empUpdate")
		public String empUpdate(EmpVO vo) {
			empMapper.updateEmp(vo);
			return "redirect:empList"; //forward redirect 아무것도 안적었을 때 forward
			// return empList는 mapping url을 적어주는 거임
		}
	
}
