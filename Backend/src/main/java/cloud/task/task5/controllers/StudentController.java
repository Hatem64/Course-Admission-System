package cloud.task.task5.controllers;

import cloud.task.task5.entities.Course;
import cloud.task.task5.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cloud.task.task5.entities.Student;
import cloud.task.task5.services.StudentService;


import java.util.List;


@RestController
@RequestMapping(path = "api/student")
@CrossOrigin(origins = "*")
public class StudentController {

	private final StudentService studentS;
	private final CourseService courseService;

	@Autowired
	public StudentController(StudentService studentS, CourseService courseService) {
		this.studentS = studentS;
		this.courseService = courseService;
	}

	@PostMapping("/signUp")
	public String addAdmin(@RequestBody Student st) {
		return studentS.addStudent(st);
	}


	@PostMapping("/signIn")
	public  ResponseEntity<Student> signIn(@RequestBody Student st) {
		return studentS.signIn(st);
	}

	@PostMapping("/joinCourse/{id1}/{id2}")
	public String joinCourse(@PathVariable("id1") Long studentId, @PathVariable("id2") Long courseId){
		return studentS.joinCourse(studentId, courseId);
	}

	@GetMapping("/getCourses")
	public List<Course> getCourses(){
		return courseService.getCourses();
	}

	@GetMapping("/getStudent/{data}")
	public Student getStudentbyId(@PathVariable("data") Long id){
		return studentS.getStudentById(id);
	}

	@GetMapping("/getStudents")
	public List<Student> getAllStudents(){
		return studentS.getStudents();
	}

	@DeleteMapping("/deleteCourse/{data}")
	public String deleteCourse(@PathVariable("data") Long num){
		return courseService.deleteCourse(num);
	}
}
