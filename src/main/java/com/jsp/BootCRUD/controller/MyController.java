package com.jsp.BootCRUD.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.BootCRUD.dto.Student;
import com.jsp.BootCRUD.repository.StudentRepository;

@Controller
public class MyController {
	
	@Autowired
	StudentRepository repository;

	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "insert.html";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute Student student,ModelMap map) {
		repository.save(student);
		map.put("msg", "Data inserted successfully");
		return "home.html";
	}
	
	@GetMapping("/fetch")
	public String fetch(ModelMap map) {
		List<Student> list= repository.findAll();
		if(list.isEmpty())
			map.put("fail", "Datas not found");
		else
		    map.put("datas", list);
		return "fetch.html";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,ModelMap map) {
		repository.deleteById(id);
		map.put("msg", "Data Deleted Successfully");
		return fetch(map);
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,ModelMap map) {
		Student student =repository.findById(id).orElseThrow();
		map.put("datas", student);
		return "edit.html";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Student student,ModelMap map) {
		repository.save(student);
		map.put("success", "Data Updated Successfully");
		return fetch(map);
	}
	
	@GetMapping("/fetch/{field}")
	public String fetchBy(@PathVariable String field,ModelMap map) {
		map.put("field", field);
		return "fetchBy.html";
	}
	
	@PostMapping("/fetch/name")
	public String fetchByName(@RequestParam String name,ModelMap map) {
		List<Student> list = repository.findByName(name);
		if (list.isEmpty()) {
			map.put("fail", "No Data Found");
			return "fetchBy.html";
		} else {
			map.put("list", list);
			map.put("success", "Data Found Success");
			return "fetchBy.html";
		}
	}
	
	@PostMapping("/fetch/mobile")
	public String fetchByMobile(@RequestParam long mobile,ModelMap map) {
		List<Student> list = repository.findByMobile(mobile);
		if (list.isEmpty()) {
			map.put("fail", "No Data Found");
			return "fetchBy.html";
		} else {
			map.put("list", list);
			map.put("success", "Data Found Success");
			return "fetchBy.html";
		}
	}
	
	@PostMapping("/fetch/gender")
	public String fetchByGender(@RequestParam String gender,ModelMap map) {
		List<Student> list = repository.findByGender(gender);
		if (list.isEmpty()) {
			map.put("fail", "No Data Found");
			return "fetchBy.html";
		} else {
			map.put("list", list);
			map.put("success", "Data Found Success");
			return "fetchBy.html";
		}
	}
	
	@PostMapping("/fetch/marks")
	public String fetchByMarks(@RequestParam int marks,ModelMap map) {
		List<Student> list = repository.findByMathsGreaterThanAndSciGreaterThanAndEngGreaterThan(marks,marks,marks);
		if (list.isEmpty()) {
			map.put("fail", "No Data Found");
			return "fetchBy.html";
		} else {
			map.put("list", list);
			map.put("success", "Data Found Success");
			return "fetchBy.html";
		}
	}
	
	@PostMapping("/fetch/percentage")
	public String fetchByPercentage(@RequestParam double percentage,ModelMap map) {
		List<Student> list = repository.findAll().stream().filter(student -> student.getPercentage() >= percentage).collect(Collectors.toList());
		if (list.isEmpty()) {
			map.put("fail", "No Data Found");
			return "fetchBy.html";
		} else {
			map.put("list", list);
			map.put("success", "Data Found Success");
			return "fetchBy.html";
		}
	}
}
