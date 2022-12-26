package cloud.task.task5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.task.task5.entities.Course;
import cloud.task.task5.services.CourseService;

@RestController
@RequestMapping(path = "api/course")
@CrossOrigin(origins = "*")
public class CourseController {
	private final CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestBody Course course){
		return courseService.addCourse(course);
	}
}
