package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;

@Service
public class StudentService {
	@Autowired
	StudentMapper studentMapper;
	
	public HashMap<String, Object> getStudentList() {
		HashMap<String, Object> resultMap = new HashMap();
		List<Student> stuList = studentMapper.selectStudentList();
		
		resultMap.put("stuList", stuList);
		resultMap.put("result", "success");
		return resultMap;
	}
	
	public HashMap<String, Object> addStudent(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		int nAffected = studentMapper.insertStudent(map);
		
		if(nAffected == 1) {
			resultMap.put("result", "success");	
		}else {
			resultMap.put("result", "failed");
		}
		
		
		return resultMap;
	}
	
}




